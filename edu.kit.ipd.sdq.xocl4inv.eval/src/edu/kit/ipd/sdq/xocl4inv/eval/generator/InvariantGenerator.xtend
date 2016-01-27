package edu.kit.ipd.sdq.xocl4inv.eval.generator;

import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.Invariant
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.InvariantParameter
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.ModelFile
import edu.kit.ipd.sdq.xocl4inv.extensions.OclCollectionExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.OclFunctionExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.OclIterateExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.PureIterableExtensions
import edu.kit.ipd.sdq.xocl4inv.generator.model.IInvariant
import edu.kit.ipd.sdq.xocl4inv.generator.model.IInvariantVO
import edu.kit.ipd.sdq.xocl4inv.util.InvariantTransformator
import java.util.stream.Collectors
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.xbase.XExpression

import static extension edu.kit.ipd.sdq.xocl4inv.util.XBaseHelper.expressionString

/**
 * This class generates the xtend-model for invariants and their value objects.
 * 
 * @author sfiss
 */
 //TODO: check if imports can be somehow generated by using an ImportManager and TypeReferenceSerializer
class InvariantGenerator implements IGenerator {

	// TODO: when integrating into MIR, use that generator's pathseperator and path function
	private static final char PATH_SEPERATOR = '/'

	private def packageNameToPath(String pkgName) {
		pkgName.replace('.', PATH_SEPERATOR)
	}

	/**
	 * Get EClass instanceClass name
	 * @param eclass EClass
	 * @returns instance classname as string
	 */
	private def getInstanceClassSimpleName(EClass eclass) {
		eclass.instanceClass.simpleName
	}

	/**
	 * Get EClass instanceClass canonical name
	 * @param eclass EClass
	 * @returns instance classname as canonical string
	 */
	private def getInstanceClassCanonicalName(EClass eclass) {
		eclass.instanceClass.canonicalName
	}

	/**
	 * Get EClass instanceClass name
	 * @param invariant Invariant
	 * @returns invariant value object name
	 */
	private def getValueObjectClassName(Invariant invariant) {
		invariant.name + "VO"
	}

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		val model = input.contents.filter(typeof(ModelFile)).get(0)
		val packageName = "edu.kit.ipd.sdq.xocl4inv.eval.generator.invariants"

		model.invariants.forEach [
			it.generateInvariant(packageName, fsa)
		]

		model.invariants.forEach [
			it.generateInvariantValueObject(packageName, fsa)
		]
	}

	/**
	 * Generate the xtend file for invariant.
	 * @param invariant Invariant
	 * @param packageName Name of package
	 * @param fsa FileSystemAccess
	 */
	private def void generateInvariant(Invariant invariant, String packageName, IFileSystemAccess fsa) {
		fsa.generateFile(
			(packageName + "." + invariant.name).packageNameToPath +
				".xtend"
			,
			'''
				package «packageName»
				
				import «IInvariant.canonicalName»
				import «invariant.context.instanceClassCanonicalName»
				
				// static extensions
				import static extension «PureIterableExtensions.canonicalName».*
				import static extension «OclCollectionExtensions.canonicalName».*
				import static extension «OclIterateExtensions.canonicalName».*
				import static extension «OclFunctionExtensions.canonicalName».*
				
				public class «invariant.name» implements «IInvariant.simpleName»<«invariant.context.instanceClassSimpleName», «invariant.valueObjectClassName»> {
					«invariant.inferCheckMethod»
					
					«invariant.inferFindViolationsMethod»
				}
				
			'''
		)
	}

	/**
	 * Generate the xtend file for invariant value object.
	 * @param invariant Invariant
	 * @param packageName Name of package
	 * @param fsa FileSystemAccess
	 */
	private def void generateInvariantValueObject(Invariant invariant, String packageName, IFileSystemAccess fsa) {
		fsa.generateFile(
			(packageName + "." + invariant.valueObjectClassName).packageNameToPath +
				".xtend"
			,
			'''
				package «packageName»
				
				import «IInvariantVO.canonicalName»
				import «Data.canonicalName»
				import «invariant.context.instanceClassCanonicalName»
				«FOR paramType : invariant.parameters.map[it.type].stream.distinct.collect(Collectors.toList())»
					import «paramType.instanceClassCanonicalName»
				«ENDFOR»
					
				@«Data.simpleName»
				public class «invariant.valueObjectClassName» implements «IInvariantVO.simpleName»<«invariant.context.instanceClassSimpleName»> {
					«invariant.context.instanceClassSimpleName» context
					
					«FOR param : invariant.parameters»
						«Iterable.simpleName»<«param.type.instanceClassSimpleName»> «param.name»
					«ENDFOR»
				}
			'''
		)
	}

	/**
	 * Infer the check-method for invariant.
	 * @param invariant Invariant
	 * @returns String representation of the method
	 */
	def String inferCheckMethod(Invariant invariant) {
		'''
			override def boolean check(«invariant.context.instanceClassSimpleName» _self) {
				«invariant.expression.expressionString»
			}
		'''
	}

	/**
	 * Infer the findViolations-method for invariant.
	 * @param invariant Invariant
	 * @returns String representation of the method
	 */
	def String inferFindViolationsMethod(Invariant invariant) {
		'''
			override def «invariant.valueObjectClassName» findViolations(«invariant.context.instanceClassSimpleName» _self) {
				«FOR parameter : invariant.parameters»
					val «parameter.name»Transformed = «transformInvariant(invariant.expression, parameter)»
				«ENDFOR»
				
				new «invariant.valueObjectClassName»(_self
				«FOR parameter : invariant.parameters»
					, «parameter.name»Transformed
				«ENDFOR»
				)
			}
		'''
	}

	/**
	 * Transform given invariant into an xtend string
	 * 
	 * @param expression XExpression
	 * @param paramName Name of parameter
	 * @returns String representation of the transformed invariant
	 */
	def String transformInvariant(XExpression expression, InvariantParameter parameter) {
		InvariantTransformator.transformExpressionToString(expression, parameter)
	}

}