package tools.vitruv.dsls.mapping.helpers

import tools.vitruv.framework.tuid.TUID
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.apache.log4j.Logger
import static extension tools.vitruv.framework.util.bridges.JavaHelper.*
import tools.vitruv.framework.correspondence.CorrespondenceModel

class TUIDUpdateHelper {
	private static final Logger LOGGER = Logger.getLogger(TUIDUpdateHelper)
	private Map<EObject, Map<CorrespondenceModel, List<TUID>>> oldTUIDMap = newHashMap
	
	public def addObjectToUpdate(CorrespondenceModel ci, EObject eObject) {
		oldTUIDMap
			.getOrPut(eObject, [newHashMap])
			.getOrPut(ci, [newArrayList])
			.add(ci.calculateTUIDFromEObject(eObject))
	}
	
	public def updateObject(CorrespondenceModel ci, EObject eObject) {
		if (!oldTUIDMap.containsKey(eObject)) {
			LOGGER.info("EObject " + eObject.toString() + " not in old tuid map")
		} else {
			val ciToTUIDs = oldTUIDMap.get(eObject)
			for (tuid : (ciToTUIDs.get(ci) ?: #[])) {
				tuid.updateTuid(eObject)
			}
			oldTUIDMap.get(eObject)?.remove(eObject)
		}
	}
	
	public def updateAll() {
		for (entry : oldTUIDMap.entrySet) {
			val eObject = entry.key
			val ciToTUIDs = entry.value
			for (ciAndTUIDs : ciToTUIDs.entrySet) {
				for (tuid : ciAndTUIDs.value) {
					tuid.updateTuid(eObject)
				}
			}			
		}
	}

}