package tools.vitruv.extensions.dslsruntime.reactions

import org.eclipse.emf.ecore.EObject

interface ReactionElementStatesHandler {
	public def void addCorrespondenceBetween(EObject firstElement, EObject secondElement, String tag);
	public def void removeCorrespondenceBetween(EObject firstElement, EObject secondElement);
	public def void deleteObject(EObject element);
	public def void initializeCreateElementState(EObject element);
	public def void initializeRetrieveElementState(EObject element);
	public def void postprocessElementStates();
}