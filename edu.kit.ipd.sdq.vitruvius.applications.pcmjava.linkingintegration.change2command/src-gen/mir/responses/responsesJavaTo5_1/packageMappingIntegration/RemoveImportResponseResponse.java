package mir.responses.responsesJavaTo5_1.packageMappingIntegration;

import edu.kit.ipd.sdq.vitruvius.extensions.dslsruntime.response.AbstractResponseRealization;
import edu.kit.ipd.sdq.vitruvius.framework.change.echange.EChange;
import edu.kit.ipd.sdq.vitruvius.framework.change.echange.feature.reference.RemoveEReference;
import edu.kit.ipd.sdq.vitruvius.framework.userinteraction.UserInteracting;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.containers.JavaRoot;
import org.emftext.language.java.imports.Import;

@SuppressWarnings("all")
class RemoveImportResponseResponse extends AbstractResponseRealization {
  public RemoveImportResponseResponse(final UserInteracting userInteracting) {
    super(userInteracting);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return RemoveEReference.class;
  }
  
  private boolean checkChangeProperties(final RemoveEReference<JavaRoot, Import> change) {
    EObject changedElement = change.getAffectedEObject();
    // Check model element type
    if (!(changedElement instanceof JavaRoot)) {
    	return false;
    }
    
    // Check feature
    if (!change.getAffectedFeature().getName().equals("imports")) {
    	return false;
    }
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof RemoveEReference<?, ?>)) {
    	return false;
    }
    RemoveEReference typedChange = (RemoveEReference)change;
    if (!checkChangeProperties(typedChange)) {
    	return false;
    }
    getLogger().debug("Passed precondition check of response " + this.getClass().getName());
    return true;
  }
  
  public void executeResponse(final EChange change) {
    RemoveEReference<JavaRoot, Import> typedChange = (RemoveEReference<JavaRoot, Import>)change;
    mir.routines.packageMappingIntegration.RemoveImportResponseEffect effect = new mir.routines.packageMappingIntegration.RemoveImportResponseEffect(this.executionState, this, typedChange);
    effect.applyRoutine();
  }
}