package edu.kit.ipd.sdq.vitruvius.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import edu.kit.ipd.sdq.vitruvius.framework.change2commandtransformingprovider.Change2CommandTransformingProvidingImpl;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.CorrespondenceInstance;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.Change2CommandTransforming;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.Change2CommandTransformingProviding;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.UserInteracting;
import edu.kit.ipd.sdq.vitruvius.framework.run.changesynchronizer.ChangeSynchronizerImpl;
import edu.kit.ipd.sdq.vitruvius.framework.run.transformationexecuter.TransformationExecuter;
import edu.kit.ipd.sdq.vitruvius.framework.util.bridges.JavaBridge;
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.ClaimableMap;
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.Pair;
import edu.kit.ipd.sdq.vitruvius.tests.util.TestUtil;

/**
 * Base class for all Vitruvius case study tests
 *
 * @author langhamm
 *
 */
public abstract class VitruviusCasestudyTest {

    protected ResourceSet resourceSet;

    protected TestUserInteractor testUserInteractor;

    protected String currentTestProjectName;

    protected IProject currentTestProject;

    protected abstract void afterTest(Description description);

    protected abstract CorrespondenceInstance getCorrespondenceInstance() throws Throwable;

    protected void beforeTest(final Description description) throws Throwable {
        // ensure that MockupProject is existing
        this.currentTestProjectName = TestUtil.PROJECT_URI + "_" + description.getMethodName();
        this.currentTestProject = TestUtil.getProjectByName(this.currentTestProjectName);
        if (!this.currentTestProject.exists()) {
            this.createProject(this.currentTestProject);
        }
    }

    @BeforeClass
    public static void setUpAllTests() {
        TestUtil.initializeLogger();
    }

    /**
     * Test watcher that moves src and model files as well as the VSUM project (which are created
     * during the previous test) to own folders and removes the PCMJavaBuilder from the project
     */
    @Rule
    public TestWatcher watchmen = new TestWatcher() {
        @Override
        protected void finished(final org.junit.runner.Description description) {
            VitruviusCasestudyTest.this.afterTest(description);
            VitruviusCasestudyTest.this.resourceSet = null;
            final String previousMethodName = description.getMethodName();
            TestUtil.moveSrcFilesFromMockupProjectToPathWithTimestamp(previousMethodName);
            TestUtil.moveModelFilesFromMockupProjectToPathWithTimestamp(previousMethodName);
            TestUtil.moveVSUMProjectToOwnFolderWithTimepstamp(previousMethodName);
        };

        @Override
        protected void starting(final Description description) {
            try {
                VitruviusCasestudyTest.this.beforeTest(description);
            } catch (final Throwable e) {
                if (e instanceof RuntimeException) {
                    throw (RuntimeException) e;
                }
                throw new RuntimeException(e);
            }
        }
    };

    protected String getProjectPath() {
        return this.currentTestProjectName + "/";
    }

    protected void setUserInteractor(final UserInteracting newUserInteracting,
            final ChangeSynchronizerImpl changeSynchronizerImpl) throws Throwable {
        final Change2CommandTransformingProviding change2CommandProviding = JavaBridge.getFieldFromClass(
                ChangeSynchronizerImpl.class, "change2CommandTransformingProviding", changeSynchronizerImpl);
        final ClaimableMap<Pair<VURI, VURI>, Change2CommandTransforming> transformationExecuterMap = JavaBridge
                .getFieldFromClass(Change2CommandTransformingProvidingImpl.class, "transformationExecuterMap",
                        change2CommandProviding);
        final Class<?> change2CommandTransformerClass = this.getChange2CommandTransformerClass();
        final String nameOfChangeSynchronizerField = this.getNameOfChangeSynchronizerField();
        Change2CommandTransforming change2CommandTransforming = null;
        for (final Change2CommandTransforming currentChange2CommandTransforming : transformationExecuterMap.values()) {
            if (change2CommandTransformerClass.isInstance(currentChange2CommandTransforming)) {
                change2CommandTransforming = currentChange2CommandTransforming;
                break;
            }
        }
        if (null == change2CommandTransforming) {
            throw new RuntimeException("Could not find a Change2CommandTransforming that is currently active.");
        }
        final TransformationExecuter transformationExecuter = JavaBridge.getFieldFromClass(
                change2CommandTransformerClass, nameOfChangeSynchronizerField, change2CommandTransforming);
        transformationExecuter.setUserInteracting(newUserInteracting);
    }

    protected abstract Class<?> getChange2CommandTransformerClass();

    protected String getNameOfChangeSynchronizerField() {
        return "transformationExecuter";
    }

    /**
     * copied from:
     * https://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Creating_Eclipse_Java_Projects_Programmatically
     * :)
     *
     * @param testProject
     * @throws CoreException
     */
    private void createProject(final IProject testProject) throws CoreException {
        testProject.create(new NullProgressMonitor());
        testProject.open(new NullProgressMonitor());
        final IProjectDescription description = testProject.getDescription();
        description.setNatureIds(new String[] { JavaCore.NATURE_ID });
        testProject.setDescription(description, null);
        final IJavaProject javaProject = JavaCore.create(testProject);
        final IFolder binFolder = testProject.getFolder("bin");
        binFolder.create(false, true, null);
        javaProject.setOutputLocation(binFolder.getFullPath(), null);
        final List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
        final IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
        if (null != vmInstall) {
            final LibraryLocation[] locations = JavaRuntime.getLibraryLocations(vmInstall);
            for (final LibraryLocation element : locations) {
                entries.add(JavaCore.newLibraryEntry(element.getSystemLibraryPath(), null, null));
            }
        }
        // add libs to project class path
        javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
        final IFolder sourceFolder = testProject.getFolder("src");
        sourceFolder.create(false, true, null);
        final IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(sourceFolder);
        final IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
        final IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
        java.lang.System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
        newEntries[oldEntries.length] = JavaCore.newSourceEntry(root.getPath());
        javaProject.setRawClasspath(newEntries, null);
    }

}