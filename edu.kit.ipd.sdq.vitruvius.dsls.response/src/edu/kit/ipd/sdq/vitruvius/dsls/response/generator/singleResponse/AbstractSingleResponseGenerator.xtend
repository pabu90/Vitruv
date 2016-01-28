package edu.kit.ipd.sdq.vitruvius.dsls.response.generator.singleResponse

import edu.kit.ipd.sdq.vitruvius.dsls.response.generator.singleResponse.ISingleResponseGenerator
import org.apache.log4j.Logger
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.Response
import edu.kit.ipd.sdq.vitruvius.dsls.response.helper.XtendImportHelper
import org.apache.log4j.Level
import static edu.kit.ipd.sdq.vitruvius.dsls.response.generator.ResponseLanguageGeneratorConstants.*;
import static extension edu.kit.ipd.sdq.vitruvius.dsls.response.generator.ResponseLanguageGeneratorUtils.*;
import org.eclipse.emf.ecore.EClass
import edu.kit.ipd.sdq.vitruvius.dsls.response.generator.ResponseRealization
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.EChange
import java.util.List
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Blackboard
import edu.kit.ipd.sdq.vitruvius.dsls.response.executor.ResponseRuntimeHelper
import java.util.ArrayList
import static extension edu.kit.ipd.sdq.vitruvius.dsls.response.helper.EChangeHelper.*;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import edu.kit.ipd.sdq.vitruvius.framework.util.bridges.EcoreResourceBridge
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ConcreteModelElementUpdate
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ConcreteTargetModelRootCreate
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ConcreteTargetModelRootUpdate

abstract class AbstractSingleResponseGenerator implements ISingleResponseGenerator {
	protected final Response response;
	protected final XtendImportHelper ih;
	protected final boolean hasTargetChange;
	protected final boolean hasPreconditionBlock;
	protected final boolean hasExecutionBlock;
	protected final boolean isTargetUpdated;
	protected final EClass change;
	
	protected new(Response response) {
		this.response = response;
		this.ih = new XtendImportHelper();
		this.hasTargetChange = response.effects.targetChange != null;
		this.isTargetUpdated = this.hasTargetChange && response.effects.targetChange instanceof ConcreteModelElementUpdate;
		this.hasPreconditionBlock = response.trigger.precondition != null;
		this.hasExecutionBlock = response.effects.codeBlock != null;
		this.change = calculateEChange();
	}
	
	
	public override generateResponseClass(String packageName, String className) {
		val generatedMethods = getGeneratedMethods() + 
					#[generateLoggerInitialization(className), generateMethodGetTrigger()]
		val classImplementation = '''
		«IF response.documentation != null»«response.documentation»«ENDIF»
		public class «className» implements «ih.typeRef(ResponseRealization)» {
			«FOR method : generatedMethods»
				«method»
				
			«ENDFOR»
		}
		'''
		
		return generateClass(packageName, ih, classImplementation);
	}
		
	
	private def generateLoggerInitialization(String className) '''
		private static val «ih.typeRef(Logger)» LOGGER = {
			val initializedLogger = «ih.typeRef(Logger)».getLogger(«className»);
			initializedLogger.setLevel(«ih.typeRef(Level)».DEBUG);
			return initializedLogger;
		}
	'''
	
	private def generateMethodGetTrigger() '''
		public static def Class<? extends EChange> getTrigger() {
			return «ih.typeRef(change)»;
		}
	'''
	
	/** 
	 * Generated method: checkPrecondition : boolean
	 * 
	 * <p>Evaluates the precondition specified in the response
	 * 
	 * <p>Methods parameters are: 
	 * 	<li>1. change: the change event ({@link EChange})</li>
	 * 
	 * <p>Precondition: precondition code block must exist.
	 */
	protected def generateMethodCheckPrecondition() '''
		private def boolean checkPrecondition(«changeEventTypeString» «CHANGE_PARAMETER_NAME»)«
		response.trigger.precondition.xtendCode»
	'''
		
	/**
	 * Generates method: determineTargetModels
	 * 
	 * <p>Checks the CorrespondenceInstance in the specified blackboard for corresponding objects
	 * according to the type and constraints specified in the response.
	 * 
	 * <p>Method parameters are:
	 * 	<li>1. change: the change event ({@link EChange})</li>
	 *  <li>2. blackboard: the blackboard ({@link Blackboard})</li>
	 * 
	 * <p>Precondition: a metamodel element for the target models is specified in the response
	 */	
	protected def generateMethodDetermineTargetModels(ConcreteTargetModelRootUpdate updatedModel) '''
		«val affectedElementClass = updatedModel.rootModelElement.modelElement»
		private def «ih.typeRef(List)»<«ih.typeRef(affectedElementClass)»> determineTargetModels(«
			changeEventTypeString» «CHANGE_PARAMETER_NAME», «ih.typeRef(Blackboard)» blackboard) {
			val targetModels = new «ih.typeRef(ArrayList)»<«ih.typeRef(affectedElementClass)»>();
			val objectToGetCorrespondencesFor =«updatedModel.correspondenceSource.object.xtendCode»
			targetModels += blackboard.correspondenceInstance.«ih.callExtensionMethod(ResponseRuntimeHelper,
				'''getCorrespondingObjectsOfType(objectToGetCorrespondencesFor, «ih.typeRef(affectedElementClass)»)''')»;
			return targetModels;
		}
	'''	
	
	/**
	 * Generates method: generateTargetModel
	 * 
	 * <p>Generates a new target model as specified in the response
	 * 
	 * <p>Method parameters are:
	 * 	<li>1. change: the change event ({@link EChange})</li>
	 *  <li>2. blackboard: the blackboard ({@link Blackboard})</li>
	 * 
	 * <p>Precondition: a metamodel element to be the root of the new model is specified in the response
	 */	
	protected def generateMethodGenerateTargetModel(ConcreteTargetModelRootCreate createdModel) '''
		«val affectedElementClass = createdModel.rootModelElement.modelElement»
		private def «ih.typeRef(affectedElementClass)» generateTargetModel(«
			changeEventTypeString» «CHANGE_PARAMETER_NAME», «ih.typeRef(Blackboard)» blackboard) {
			«val createdQNClassName = affectedElementClass.instanceTypeName»
			«var createdClassPackage = createdQNClassName.substring(0, createdQNClassName.length - affectedElementClass.name.length - 1)»
			«var createdClassFactoryName = createdClassPackage + ".impl." + createdClassPackage.split("\\.").last.toFirstUpper + "FactoryImpl"»
			val newRoot = «ih.typeRef(createdClassFactoryName)».eINSTANCE.create«affectedElementClass.name»();
			val sourceElement = «CHANGE_PARAMETER_NAME».«change.EChangeFeatureNameOfChangedObject»;
			val newModelFileSegments = "«createdModel.name»".split("/")
			«val newModelFileSegments = createdModel.name.split("/")»
			«IF !newModelFileSegments.last.contains(".")»
				// No file extension was specified, add the first one that is the valid for the metamodel
				newModelFileSegments.set(newModelFileSegments.size - 1, newModelFileSegments.last 
					+ "." + blackboard.correspondenceInstance.mapping.metamodelB.fileExtensions.get(0));
			«ENDIF»
			val newResourceURI = sourceElement.eResource.URI.trimSegments(1).appendSegments(newModelFileSegments);
			
			val newModelResource = new «ih.typeRef(ResourceSetImpl)»().createResource(newResourceURI);
			newRoot.id = sourceElement.id;
			newModelResource.contents.add(newRoot);
			blackboard.correspondenceInstance.createAndAddCorrespondence(#[sourceElement], #[newRoot]);
			«ih.typeRef(EcoreResourceBridge)».saveResource(newModelResource);
			return newRoot;
		}
	'''
	
	protected abstract def CharSequence generateMethodApplyChange();
	protected abstract def String getChangeEventTypeString();
	protected abstract def EClass calculateEChange();
	protected abstract def Iterable<CharSequence> getGeneratedMethods();
}