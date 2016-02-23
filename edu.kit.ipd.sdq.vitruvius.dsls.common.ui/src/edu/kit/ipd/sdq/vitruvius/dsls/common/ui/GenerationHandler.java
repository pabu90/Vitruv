package edu.kit.ipd.sdq.vitruvius.dsls.common.ui;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.common.base.Function;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import edu.kit.ipd.sdq.vitruvius.dsls.mapping.generator.IMappingLanguageGenerator;
import edu.kit.ipd.sdq.vitruvius.dsls.mapping.generator.MappingLanguageGeneratorNameProvider;
import edu.kit.ipd.sdq.vitruvius.dsls.response.api.generator.IResponseEnvironmentGenerator;
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.Response;

import static com.google.common.collect.Maps.uniqueIndex;


public class GenerationHandler extends AbstractHandler {
	private static class LanguageScope {
		@Inject
		public IResourceSetProvider resourceSetProvider;

		@Inject
		@Named(Constants.FILE_EXTENSIONS)
		public String fileExtension;
	}

	private static class ResponseScope extends LanguageScope {
		@Inject
		public IResponseEnvironmentGenerator responseEnvironmentGenerator;
		
		@Inject
		private Provider<EclipseResourceFileSystemAccess2> fileSystemAccessProvider;

		@Inject
		private EclipseOutputConfigurationProvider outputConfigurationProvider;
	}

	private static class MappingScope extends LanguageScope {
		@Inject
		public IMappingLanguageGenerator mappingLanguageGenerator;
		
		@Inject
		public MappingLanguageGeneratorNameProvider nameProvider;
	}

	private static class MIRResourceCollectionVisitor implements IResourceVisitor {
		private final ResourceSet mappingResourceSet;
		private final ResourceSet responseResourceSet;

		private final Collection<Resource> mappingResources;
		private final Collection<Resource> responseResources;

		private final MappingScope mappingScope;
		private final ResponseScope responseScope;

		public MIRResourceCollectionVisitor(IProject project, MappingScope mappingScope, ResponseScope responseScope) {
			this.mappingScope = mappingScope;
			this.responseScope = responseScope;

			mappingResourceSet = mappingScope.resourceSetProvider.get(project);
			responseResourceSet = responseScope.resourceSetProvider.get(project);

			mappingResources = new HashSet<>();
			responseResources = new HashSet<>();
		}

		@Override
		public boolean visit(IResource resource) throws CoreException {
			if (resource instanceof IFile) {
				IFile file = (IFile) resource;
				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				System.out.println(uri.toString());
				if (resource.getFileExtension().equals(responseScope.fileExtension)) {
					responseResources.add(responseResourceSet.getResource(uri, true));
				} else if (resource.getFileExtension().equals(mappingScope.fileExtension)) {
					mappingResources.add(mappingResourceSet.getResource(uri, true));
				}
			}

			return true;
		}

		public Collection<Resource> getMappingResources() {
			return mappingResources;
		}

		public Collection<Resource> getResponseResources() {
			return responseResources;
		}
	}

	public final MappingScope mappingScope = new MappingScope();
	public final ResponseScope responseScope = new ResponseScope();

	public static void acceptForEachSourceClassPathEntry(IJavaProject javaProject, IResourceVisitor resourceVisitor) {
		final IProject project = javaProject.getProject();
		final IPath rawLocation = project.getFullPath();
		try {
			for (IClasspathEntry classPathEntry : javaProject.getRawClasspath()) {
				if (classPathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
					final IPath relativePath = classPathEntry.getPath().makeRelativeTo(rawLocation);
					final IFolder folder = project.getFolder(relativePath);
					folder.accept(resourceVisitor);
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		MIRCommonActivator.getDefault().mappingInjector.injectMembers(mappingScope);
		MIRCommonActivator.getDefault().responseInjector.injectMembers(responseScope);
		
		mappingScope.nameProvider.initialize();
		
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			final Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof IJavaProject) {
				final IJavaProject javaProject = (IJavaProject) firstElement;
				final IProject project = javaProject.getProject();
				final EclipseResourceFileSystemAccess2 srcGenFSA = generateFSA(project);
				final IResponseEnvironmentGenerator responseEnvironmentGenerator = responseScope.responseEnvironmentGenerator;
				
				MIRResourceCollectionVisitor resourceVisitor = new MIRResourceCollectionVisitor(project, mappingScope,
						responseScope);
				acceptForEachSourceClassPathEntry(javaProject, resourceVisitor);

				for (Resource mappingResource : resourceVisitor.getMappingResources()) {
					final Collection<Response> generatedResponses = mappingScope.mappingLanguageGenerator.generateAndCreateResponses(mappingResource, srcGenFSA);
					responseEnvironmentGenerator.addResponses(generatedResponses);
				}
				
				for (Resource responseResource : resourceVisitor.getResponseResources()) {
					responseEnvironmentGenerator.addResponses(responseResource);
				}
				
				responseEnvironmentGenerator.generateEnvironment(srcGenFSA, project);
			}
		}
		return null;
	}
	
	
	private EclipseResourceFileSystemAccess2 generateFSA(IProject project) {
		EclipseResourceFileSystemAccess2 fsa = responseScope.fileSystemAccessProvider.get();
		fsa.setMonitor(new NullProgressMonitor());
		Map<String, OutputConfiguration> outputConfigurations = getOutputConfigurations(project);
		fsa.setOutputConfigurations(outputConfigurations);
		fsa.setProject(project);
		return fsa;
	}
	
	protected Map<String, OutputConfiguration> getOutputConfigurations(IProject project) {
		Set<OutputConfiguration> configurations = responseScope.outputConfigurationProvider.getOutputConfigurations(project);
		return uniqueIndex(configurations, new Function<OutputConfiguration, String>() {
			@Override
			public String apply(OutputConfiguration from) {
				return from.getName();
			}
		});
	}
}