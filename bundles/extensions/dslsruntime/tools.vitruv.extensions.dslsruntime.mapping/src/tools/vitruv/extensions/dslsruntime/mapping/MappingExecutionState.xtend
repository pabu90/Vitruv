package tools.vitruv.extensions.dslsruntime.mapping

import tools.vitruv.framework.modelsynchronization.blackboard.Blackboard
import tools.vitruv.framework.tuid.TUID
import tools.vitruv.framework.util.datatypes.VURI
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors

import static extension tools.vitruv.framework.util.bridges.JavaHelper.*
import tools.vitruv.framework.userinteraction.UserInteracting
import tools.vitruv.framework.correspondence.CorrespondenceModel
import tools.vitruv.framework.metamodel.ModelRepository
import tools.vitruv.framework.correspondence.Correspondence
import tools.vitruv.framework.util.command.ChangePropagationResult

@Accessors(PUBLIC_GETTER)
class MappingExecutionState {
	private final ChangePropagationResult transformationResult
	private final UserInteracting userInteracting
	
	private Map<EObject, Map<CorrespondenceModel, List<TUID>>> oldTUIDMap = newHashMap
	
	private final List<EObject> createdEObjects = newArrayList
	private final List<EObject> changedEObjects = newArrayList
	private final List<EObject> deletedEObjects = newArrayList
	private final List<Correspondence> createdCorrespondences = newArrayList
	
	private final MappedCorrespondenceModel mci;
	private final Blackboard bb
	
	private final List<Resource> resourcesToSave = newArrayList
	
	new(ChangePropagationResult transformationResult, UserInteracting userInteracting, Blackboard bb) {
		super()
		this.transformationResult = transformationResult
		this.userInteracting = userInteracting
		this.mci = bb.correspondenceModel as MappedCorrespondenceModel;
		this.bb = bb;
	}
	
	public def addObjectForTuidUpdate(EObject eObject) {
		oldTUIDMap
			.getOrPut(eObject, [newHashMap])
			.getOrPut(mci, [newArrayList])
			.add(mci.calculateTUIDFromEObject(eObject))
	}
	
	public def updateTuidOfCachedObject(EObject eObject) {
		if (!oldTUIDMap.containsKey(eObject)) {
//			LOGGER.info("EObject " + eObject.toString() + " not in old tuid map")
		} else {
			val ciToTUIDs = oldTUIDMap.get(eObject)
			for (tuid : (ciToTUIDs.get(mci) ?: #[])) {
				tuid.updateTuid(eObject)
			}
			oldTUIDMap.get(eObject)?.remove(eObject)
		}
	}
	
	public def updateAllTuidsOfCachedObjects() {
		for (entry : oldTUIDMap.entrySet) {
			val eObject = entry.key
			if (eObject != null) { // TODO: do this correctly
				val ciToTUIDs = entry.value
				for (ciAndTUIDs : ciToTUIDs.entrySet) {
					for (tuid : ciAndTUIDs.value) {
						tuid.updateTuid(eObject)
					}
				}
			}
		}
		oldTUIDMap.clear
	}
	
	public def addCreatedEObject(EObject eObject) {
		this.createdEObjects.add(eObject)
	}
	
	public def addChangedEObject(EObject eObject) {
		this.changedEObjects.add(eObject);
	}
	
	public def addResourceToSave(EObject eObject) {
		if (eObject.eResource != null) {
			this.resourcesToSave.add(eObject.eResource)
		}
	}
	
	public def addCreatedCorrespondence(Correspondence correspondence) {
		this.createdCorrespondences.add(correspondence);
	}
	
	public def record(EObject... eObjects) {
		eObjects.forEach[addObjectForTuidUpdate]
		eObjects.forEach[addChangedEObject]
	}
	
	public def getAllAffectedEObjects() {
		return (createdEObjects + changedEObjects).toSet
	}
	
	public def persistAll() {
		saveAffectedEObjects(changedEObjects, bb.modelProviding)
		
		for (res : resourcesToSave) {
			// TODO Is this correct?
			bb.modelProviding.saveAllModels()//(VURI::getInstance(res))
			bb.modelProviding.forceReloadModelIfExisting(VURI::getInstance(res))
			println("Saved: " + VURI::getInstance(res).toString)
		}
		
		resourcesToSave.clear
		changedEObjects.clear // TODO: correct?
	}
	
	// temporarily from CommandExecutingImpl
	def private void saveAffectedEObjects(List<? extends Object> affectedObjects, ModelRepository modelProviding) {
		val Set<VURI> vurisToSave = new HashSet<VURI>()
		for (Object object : affectedObjects) {
			if (object instanceof EObject) {
				val EObject eObject = object as EObject
				if ((null !== eObject) && (null !== eObject.eResource())) {
					vurisToSave.add(VURI::getInstance(eObject.eResource()))
				}

			}

		}
		for (VURI vuri : vurisToSave) {
			println("Saving: " + vuri.toString)
			// TODO Is this correct?
			modelProviding.saveAllModels() //(vuri)
		}

	}
}