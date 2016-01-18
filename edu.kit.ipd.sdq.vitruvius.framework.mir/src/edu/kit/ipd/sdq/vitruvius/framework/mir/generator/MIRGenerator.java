package edu.kit.ipd.sdq.vitruvius.framework.mir.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;

import com.google.inject.Inject;

import edu.kit.ipd.sdq.vitruvius.dsls.mapping.util.EclipseProjectHelper;
import edu.kit.ipd.sdq.vitruvius.dsls.mapping.util.PreProcessingFileSystemAccess;
import edu.kit.ipd.sdq.vitruvius.framework.mir.helpers.MIRHelper;
import edu.kit.ipd.sdq.vitruvius.framework.mir.inferrer.ClosureProvider;

/**
 * A generator that executes multiple IGenerators after each other
 * to support the multiple stages of the compilation process for MIR.
 * @author Dominik Werle
 *
 */
public class MIRGenerator implements IGenerator {

	private JvmModelGenerator jvmModelGenerator;
	private MIRIntermediateLanguageGenerator intermediateLanguageGenerator;
	private MIRCodeGenerator codeGenerator;
	
	private IGeneratorStatus generatorStatus;
	private ClosureProvider closureProvider;
	
	@Inject
	public MIRGenerator(
			JvmModelGenerator jvmModelGenerator,
			MIRIntermediateLanguageGenerator intermediateLanguageGenerator,
			MIRCodeGenerator codeGenerator,
			IGeneratorStatus generatorStatus,
			ClosureProvider closureProvider) {
		
		this.jvmModelGenerator = jvmModelGenerator;
		this.intermediateLanguageGenerator = intermediateLanguageGenerator;
		this.codeGenerator = codeGenerator;
		
		this.generatorStatus = generatorStatus;
		this.closureProvider = closureProvider;
	}
	
	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		// the "compilation state" is reset at this stage
		generatorStatus.reset();
		closureProvider.reset();
		
		String projectName = MIRHelper.getProjectName(MIRHelper.getMIR(input));
		EclipseProjectHelper eclipseHelper = new EclipseProjectHelper(projectName);
		eclipseHelper.reinitializeXtextPluginProject();
		
		IFileSystemAccess rootFSA = PreProcessingFileSystemAccess.createJavaFormattingFSA(eclipseHelper.getRootFSA());
		
		IFileSystemAccess srcgenFSA = eclipseHelper.getSrcGenFSA();
		
		jvmModelGenerator.doGenerate(input, srcgenFSA);
		intermediateLanguageGenerator.doGenerate(input, srcgenFSA);
		codeGenerator.doGenerate(input, rootFSA);
		
		eclipseHelper.synchronizeProject();
	}

}