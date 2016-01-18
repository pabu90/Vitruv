package edu.kit.ipd.sdq.vitruvius.framework.contracts.internal;

import org.eclipse.emf.ecore.resource.Resource;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.CorrespondenceInstance;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI;

public interface InternalCorrespondenceInstance extends CorrespondenceInstance {

    public Resource getResource();

    public boolean changedAfterLastSave();

    public void resetChangedAfterLastSave();

    public VURI getURI();

}