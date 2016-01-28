package edu.kit.ipd.sdq.vitruvius.dsls.response.generator

import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.Pair
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ResponseFile
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.Response
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.Trigger
import edu.kit.ipd.sdq.vitruvius.dsls.response.helper.XtendImportHelper
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.CodeBlock
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.xbase.XExpression
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ConcreteModelElementChange
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ArbitraryModelElementChange
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.PreconditionBlock
import java.util.HashMap
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ConcreteTargetModelRootChange
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ArbitraryTargetMetamodelInstanceUpdate

final class ResponseLanguageGeneratorUtils {
	private static val FSA_SEPARATOR = "/";
	private static val XTEND_FILE_EXTENSION = ".xtend";
	private static val RESPONSES_PACKAGE = "responses";
	
	private new() {}
	
	private static def getFilePath(String qualifiedClassName) '''
		«qualifiedClassName.replace('.', FSA_SEPARATOR)»«XTEND_FILE_EXTENSION»'''
	
	static def String getBasicResponsesPackageQualifiedName() '''
		«RESPONSES_PACKAGE»'''
	
	static def String getMetamodelPairName(Pair<VURI, VURI> modelPair) '''
		«IF modelPair.first.lastSegment.nullOrEmpty»«modelPair.first.EMFUri.toString.split("\\.").last.toFirstUpper»«ELSE»«modelPair.first.lastSegment.toFirstUpper»«ENDIF»To«
		IF modelPair.second.lastSegment.nullOrEmpty»«modelPair.second.EMFUri.toString.split("\\.").last.toFirstUpper»«ELSE»«modelPair.second.lastSegment.toFirstUpper»«ENDIF»'''
	
	static def String getPackageName(Pair<VURI, VURI> modelPair) '''
		responses«modelPair.metamodelPairName»'''
	
	static def String getPackageQualifiedName(Pair<VURI, VURI> modelPair) '''
		«RESPONSES_PACKAGE».«modelPair.packageName»'''
		
	static def String getChange2CommandTransformingProvidingName() '''
		ResponseChange2CommandTransformingProviding'''
		
	static def String getChange2CommandTransformingProvidingQualifiedName() '''
		«RESPONSES_PACKAGE».«change2CommandTransformingProvidingName»'''
		
	static def String getChange2CommandTransformingProvidingFilePath() '''
		«change2CommandTransformingProvidingQualifiedName.filePath»'''
			
	static def String getExecutorName(Pair<VURI, VURI> modelPair) '''
		Response«modelPair.metamodelPairName»Executor'''
		
	static def String getExecutorQualifiedName(Pair<VURI, VURI> modelPair) '''
		«modelPair.packageQualifiedName».«modelPair.executorName»'''
	
	static def String getExecutorFilePath(Pair<VURI, VURI> modelPair) '''
		«modelPair.executorQualifiedName.filePath»'''
	
	static def String getChange2CommandTransformingName(Pair<VURI, VURI> modelPair) '''
		Response«modelPair.metamodelPairName»Change2CommandTransforming'''
		
	static def String getChange2CommandTransformingQualifiedName(Pair<VURI, VURI> modelPair) '''
		«modelPair.packageQualifiedName».«modelPair.change2CommandTransformingName»'''
	
	static def String getChange2CommandTransformingFilePath(Pair<VURI, VURI> modelPair) '''
		«modelPair.change2CommandTransformingQualifiedName.filePath»'''
	
	static def String getResponseQualifiedName(Pair<VURI, VURI> modelPair, String responseName) '''
		«modelPair.packageQualifiedName».«responseName»'''
	
	static def String getResponseFilePath(Pair<VURI, VURI> modelPair, String responseName) '''
		«modelPair.getResponseQualifiedName(responseName).filePath»'''
	
	static def generateClass(String packageName, XtendImportHelper importHelper, CharSequence classImplementation) '''
		package «packageName»;
		
		«importHelper.generateImportCode»
		
		«classImplementation»
		'''

	static def Pair<VURI, VURI> getSourceTargetPair(ResponseFile responseFile, Response response) {
		val event = response.trigger;
		var EPackage sourceMetamodel;
		
		if (event instanceof ConcreteModelElementChange) {
			sourceMetamodel = event.changedObject.element.EPackage;
		} else if (event instanceof ArbitraryModelElementChange) {
			sourceMetamodel = event.changedModel.model.package;
		}
		if (sourceMetamodel != null) {
			val sourceURI = sourceMetamodel.nsURI;
			val targetChange = response.effects.targetChange;
			var targetURI = sourceMetamodel.nsURI;
			if (targetChange instanceof ConcreteTargetModelRootChange) {
				targetURI = targetChange.rootModelElement?.modelElement?.EPackage?.nsURI?:sourceMetamodel.nsURI;
			} else if (targetChange instanceof ArbitraryTargetMetamodelInstanceUpdate) {
				targetURI = targetChange.metamodelReference?.model?.package?.nsURI?:sourceMetamodel.nsURI;
			}
			val source = VURI.getInstance(sourceURI);
			var target = VURI.getInstance(targetURI);
			val sourceTargetPair = new Pair<VURI, VURI>(source, target);
			return sourceTargetPair
		}
		return null;		
	}
	
	static def String getResponseName(Response response) '''
		ResponseTo«response.trigger.responseNameForEvent»'''
	
	private static val eventToNameMap = new HashMap<Trigger, String>();
	public static def void cleanEventToNameMap() {
		eventToNameMap.clear();
	}
	
	static def dispatch String getResponseNameForEvent(Trigger trigger) {
		throw new UnsupportedOperationException("Response name fragment is not defined for this event type.")
	}
	
	static def dispatch String getResponseNameForEvent(ConcreteModelElementChange event) {
		if (!eventToNameMap.containsKey(event)) {
			val name = '''«event.class.simpleName»Of«IF event.changedObject?.feature != null»«event.changedObject.feature.name.toFirstUpper»In«ENDIF»«
			event.changedObject?.element?.name?.toFirstUpper»'''
			var index = 0;
			var indexString = "";
			while (eventToNameMap.containsValue(name + indexString)) {
				index++;
				indexString = index.toString;
			}
			eventToNameMap.put(event, name + indexString);
		} 
		return eventToNameMap.get(event);
	}
	
	static def dispatch String getResponseNameForEvent(ArbitraryModelElementChange event) '''
		«event.class.simpleName»In«IF event.changedModel?.model?.name != null»«event.changedModel.model.name.toFirstUpper»«ENDIF»'''
	
	
	static def getXtendCode(PreconditionBlock preconditionBlock) {
		NodeModelUtils.getNode(preconditionBlock.code).text
	}
	
	static def getXtendCode(CodeBlock codeBlock) {
		NodeModelUtils.getNode(codeBlock.code).text
	}
	
	static def getXtendCode(XExpression expression) {
		NodeModelUtils.getNode(expression).text
	}
}