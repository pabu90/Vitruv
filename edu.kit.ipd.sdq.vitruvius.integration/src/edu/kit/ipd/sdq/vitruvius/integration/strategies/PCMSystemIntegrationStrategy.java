package edu.kit.ipd.sdq.vitruvius.integration.strategies;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import org.palladiosimulator.pcm.system.System;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Change;
import edu.kit.ipd.sdq.vitruvius.integration.invariantcheckers.IMModelImplExtractor;
import edu.kit.ipd.sdq.vitruvius.integration.invariantcheckers.InvariantEnforcer;
import edu.kit.ipd.sdq.vitruvius.integration.invariantcheckers.InvariantEnforcerFacadeBuilder;
import edu.kit.ipd.sdq.vitruvius.integration.invariantcheckers.PCMSystemElementSelector;
import edu.kit.ipd.sdq.vitruvius.integration.invariantcheckers.PCMSystemExtractor;
import edu.kit.ipd.sdq.vitruvius.integration.invariantcheckers.pcmjamoppenforcer.PCMtoJaMoPPBeginChar;
import edu.kit.ipd.sdq.vitruvius.integration.invariantcheckers.pcmjamoppenforcer.PCMtoJaMoPPJavaKeywords;
import edu.kit.ipd.sdq.vitruvius.integration.invariantcheckers.pcmjamoppenforcer.PCMtoJaMoPPSpecialChars;
import edu.kit.ipd.sdq.vitruvius.integration.invariantcheckers.pcmjamoppenforcer.PCMtoJaMoPPVitruviusKeywords;
import edu.kit.ipd.sdq.vitruvius.integration.invariantcheckers.pcmjamoppenforcer.PCMtoJaMoPPWhiteSpace;
import edu.kit.ipd.sdq.vitruvius.integration.traversal.ITraversalStrategy;
import edu.kit.ipd.sdq.vitruvius.integration.traversal.composite.SystemTraversalStrategy;
import edu.kit.ipd.sdq.vitruvius.integration.util.RepositoryModelLoader;

/**
 * This integration strategy is used for PCM system models. It checks only JaMoPP invariants as
 * "target" meta model.
 *
 * @author Sven Leonhardt
 */
public class PCMSystemIntegrationStrategy extends PCMIntegrationStrategy {

    /**
     * Instantiates a new PCM system integration strategy.
     */
    public PCMSystemIntegrationStrategy() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.kit.ipd.sdq.vitruvius.integration.strategies.IntegrationStategy#loadModel(java.lang.String
     * )
     */
    @Override
    protected Resource loadModel(final String path) {

        return RepositoryModelLoader.loadPCMResource(path);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.kit.ipd.sdq.vitruvius.integration.strategies.IntegrationStategy#checkAndEnforceInvariants
     * (org.eclipse.emf.ecore.resource.Resource)
     */
    @Override
    protected Resource checkAndEnforceInvariants(Resource model) {

        final List<InvariantEnforcer> enforcers = new ArrayList<>();

        enforcers.add(InvariantEnforcerFacadeBuilder.buildInvariantEnforcerFacade(new PCMSystemElementSelector(),
                new PCMtoJaMoPPJavaKeywords()));

        enforcers.add(InvariantEnforcerFacadeBuilder.buildInvariantEnforcerFacade(new PCMSystemElementSelector(),
                new PCMtoJaMoPPSpecialChars()));

        enforcers.add(InvariantEnforcerFacadeBuilder.buildInvariantEnforcerFacade(new PCMSystemElementSelector(),
                new PCMtoJaMoPPVitruviusKeywords()));

        enforcers.add(InvariantEnforcerFacadeBuilder.buildInvariantEnforcerFacade(new PCMSystemElementSelector(),
                new PCMtoJaMoPPWhiteSpace()));

        enforcers.add(InvariantEnforcerFacadeBuilder.buildInvariantEnforcerFacade(new PCMSystemElementSelector(),
                new PCMtoJaMoPPBeginChar()));

        for (final InvariantEnforcer enf : enforcers) {
            model = enf.loadEnforceReturn(model);
        }

        return model;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.kit.ipd.sdq.vitruvius.integration.strategies.IntegrationStategy#createChangeModels(org
     * .eclipse.core.resources.IResource, org.eclipse.emf.ecore.resource.Resource)
     */
    @Override
    protected EList<Change> createChangeModels(final IResource resource, final Resource validModel) {

        // create correct URI for valid model
        final IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IPath workspaceDir = workspace.getRoot().getLocation();
        String workspaceString = workspaceDir.toString();
        workspaceString = workspaceString.replace("/", File.separator);

        final String platRelativeModelLoc = validModel.getURI().toFileString().replace(workspaceString, "");
        final URI modelUri = URI.createPlatformResourceURI(platRelativeModelLoc, true);

        // traverse model and get ordered list of changes
        EList<Change> changes = null;

        final IMModelImplExtractor extractor = new PCMSystemExtractor();
        final System system = (System) extractor.getImpl(validModel);

        final ITraversalStrategy<System> systemTraversal = new SystemTraversalStrategy();

        try {
            changes = systemTraversal.traverse(system, modelUri, null);
        } catch (final UnsupportedOperationException e) {
            this.logger.error(e.getMessage());
        }
        return changes;

    }

}