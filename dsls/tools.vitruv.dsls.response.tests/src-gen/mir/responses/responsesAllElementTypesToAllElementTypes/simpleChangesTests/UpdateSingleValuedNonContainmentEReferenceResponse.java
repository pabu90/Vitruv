package mir.responses.responsesAllElementTypesToAllElementTypes.simpleChangesTests;

import allElementTypes.NonRoot;
import allElementTypes.Root;
import org.eclipse.emf.ecore.EObject;
import tools.vitruv.extensions.dslsruntime.response.AbstractResponseRealization;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.reference.ReplaceSingleValuedEReference;
import tools.vitruv.framework.userinteraction.UserInteracting;

@SuppressWarnings("all")
class UpdateSingleValuedNonContainmentEReferenceResponse extends AbstractResponseRealization {
  public UpdateSingleValuedNonContainmentEReferenceResponse(final UserInteracting userInteracting) {
    super(userInteracting);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return ReplaceSingleValuedEReference.class;
  }
  
  private boolean checkChangeProperties(final ReplaceSingleValuedEReference<Root, NonRoot> change) {
    EObject changedElement = change.getAffectedEObject();
    // Check model element type
    if (!(changedElement instanceof Root)) {
    	return false;
    }
    
    // Check feature
    if (!change.getAffectedFeature().getName().equals("singleValuedNonContainmentEReference")) {
    	return false;
    }
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof ReplaceSingleValuedEReference<?, ?>)) {
    	return false;
    }
    ReplaceSingleValuedEReference typedChange = (ReplaceSingleValuedEReference)change;
    if (!checkChangeProperties(typedChange)) {
    	return false;
    }
    getLogger().debug("Passed precondition check of response " + this.getClass().getName());
    return true;
  }
  
  public void executeResponse(final EChange change) {
    ReplaceSingleValuedEReference<Root, NonRoot> typedChange = (ReplaceSingleValuedEReference<Root, NonRoot>)change;
    mir.routines.simpleChangesTests.UpdateSingleValuedNonContainmentEReferenceEffect effect = new mir.routines.simpleChangesTests.UpdateSingleValuedNonContainmentEReferenceEffect(this.executionState, this, typedChange);
    effect.applyRoutine();
  }
}
