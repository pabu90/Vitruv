package edu.kit.ipd.sdq.xocl4inv.eval.generator

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.ModelFile
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.XbaseOclTest
import edu.kit.ipd.sdq.xocl4inv.extensions.OclCollectionExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.OclFunctionExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.OclIterateExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.PureIterableExtensions
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.ocl.OCL
import org.eclipse.ocl.Query
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory
import org.eclipse.ocl.helper.OCLHelper

import static extension edu.kit.ipd.sdq.xocl4inv.util.XBaseHelper.expressionString


class XoclFromOclGenerator  implements IGenerator {

	private static final char PATH_SEPERATOR = '/';

	private def packageNameToPath(String pkgName) {
		pkgName.replace('.', PATH_SEPERATOR)
	}

	private def type(EClass clazz) {
		clazz.instanceClass.simpleName
	}

	private def imprt(EClass clazz) {
		clazz.instanceClass.canonicalName
	}

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		val model = input.contents.filter(typeof(ModelFile)).get(0)
		val pgk = "edu.kit.ipd.sdq.xocl4inv.eval.generator.ocl2xocl"

		// generate Invs
		model.xbaseocls.forEach [
			fsa.generateFile(
				(pgk + "." + it.name).packageNameToPath + ".xtend",
				'''
					package «pgk»;
							
					import «it.context.imprt»
					
					// JUnit
					import org.junit.Test
					import static org.junit.Assert.assertTrue
							
					// EMF, Ecore, OCL
					//import «EClass.canonicalName»
					//import «EClassifier.canonicalName»
					//import «EObject.canonicalName»
					import «OCL.canonicalName»
					//import «Query.canonicalName»
					//import «OCLHelper.canonicalName»
					import «EcoreEnvironmentFactory.canonicalName»
					
					// Model
					import edu.kit.ipd.sdq.xocl4inv.eval.model.ModelPackage
					import edu.kit.ipd.sdq.xocl4inv.eval.model.util.ModelComparator
					import edu.kit.ipd.sdq.ocl2xocl4inv.generator.XOclTransformer
					
					// static extensions
					import static extension «PureIterableExtensions.canonicalName».*
					import static extension «OclCollectionExtensions.canonicalName».*
					import static extension «OclIterateExtensions.canonicalName».*
					import static extension «OclFunctionExtensions.canonicalName».*
					
					public class «it.name» {								
						«it.inferXBaseExpression»
					
						«it.inferGenerateXBaseExpression»
					
						«it.inferTestMethod»
					}
					
					'''
			)
		]
	}

	def String inferTestMethod(XbaseOclTest test) {
		'''
			@Test
			def void «test.name»Test() {
				val model = «test.input.expressionString»
				
				model.forEach[
					val originalXBaseExpression = it.getXBaseExpression
					val generatedXBaseExpression = it.generateXBaseExpression

					//remove all whitespaces for comparison
					val original = originalXBaseExpression.replaceAll("\\s+","")
					val generated = generatedXBaseExpression.replaceAll("\\s+","")
					
					val message = "\nOriginal XBaseExpression: " + original + "; \nGenerated XBaseExpression: " + generated;
					val check = original.equals(generated)
					
					assertTrue(message, check)
				]
			}
		'''
	}

	def String inferXBaseExpression(XbaseOclTest test) {
		'''
			def String getXBaseExpression(«test.context.type» _self) {
				return "«test.xbase.expressionString»"
			}
		'''
	}

	def String inferGenerateXBaseExpression(XbaseOclTest test) {
		'''
			def String generateXBaseExpression(«test.context.type» _self) {
				val /* OCL<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, Constraint, EClass, EObject> */ ocl = 
					OCL.newInstance(EcoreEnvironmentFactory.INSTANCE)
				
				val /* OCLHelper<EClassifier, ?, ?, Constraint> */ helper = 
					ocl.createOCLHelper()
				
				helper.setContext(ModelPackage.Literals.«test.context.type.toUpperCase»)
				
				val /* OCLExpression<EClassifier> */ query = 
					helper.createQuery("«test.ocl»")
							
				XOclTransformer.createXOclInvariant(query)
			}
		'''
	}
}
