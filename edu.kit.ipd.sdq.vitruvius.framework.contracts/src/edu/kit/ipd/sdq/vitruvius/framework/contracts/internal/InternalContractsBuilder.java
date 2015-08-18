package edu.kit.ipd.sdq.vitruvius.framework.contracts.internal;

import org.eclipse.emf.ecore.resource.Resource;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Mapping;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.ModelProviding;

public class InternalContractsBuilder {
    public static InternalCorrespondenceInstance createCorrespondenceInstance(final Mapping mapping,
            final ModelProviding modelProviding, final VURI correspondencesVURI,
            final Resource correspondencesResource) {
        return new CorrespondenceInstanceImpl(mapping, modelProviding, correspondencesVURI, correspondencesResource);
    };
}