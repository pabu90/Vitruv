package edu.kit.ipd.sdq.xocl4inv.eval.generator

import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.ModelFile
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.XbaseOclTest
import edu.kit.ipd.sdq.xocl4inv.extensions.OclCollectionExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.OclFunctionExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.OclIterateExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.PureIterableExtensions
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.ocl.OCL
import org.eclipse.ocl.Query
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory
import org.eclipse.ocl.helper.OCLHelper
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

import static extension edu.kit.ipd.sdq.xocl4inv.util.XBaseHelper.expressionString

class XbaseOclGenerator implements IGenerator {

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
		val pgk = "edu.kit.ipd.sdq.xocl4inv.eval.generator.xbaseocl"

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
					
					// static extensions
					import static extension «PureIterableExtensions.canonicalName».*
					import static extension «OclCollectionExtensions.canonicalName».*
					import static extension «OclIterateExtensions.canonicalName».*
					import static extension «OclFunctionExtensions.canonicalName».*
					
					public class «it.name» {								
						«it.inferXBaseMethod»
					
						«it.inferOCLMethod»
					
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
					val xbaseObj = it.evalXBase
					val oclObj = it.evalOCL
					val check = ModelComparator.compare(xbaseObj, oclObj)
					assertTrue(check)
				]
			}
		'''
	}

	def String inferXBaseMethod(XbaseOclTest test) {
		'''
			def Object evalXBase(«test.context.type» _self) {
				«test.xbase.expressionString»
			}
		'''
	}

	def String inferOCLMethod(XbaseOclTest test) {
		'''
			def «Object.simpleName» evalOCL(«test.context.type» _self) {
				val /* OCL<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, Constraint, EClass, EObject> */ ocl = 
					OCL.newInstance(EcoreEnvironmentFactory.INSTANCE)
				
				val /* OCLHelper<EClassifier, ?, ?, Constraint> */ helper = 
					ocl.createOCLHelper()
				
				helper.setContext(ModelPackage.Literals.«test.context.type.toUpperCase»)
				
				val /* OCLExpression<EClassifier> */ query = 
					helper.createQuery("«test.ocl»")
							
				val /* Query<EClassifier, EClass, EObject> */ eval = ocl.createQuery(query);
				
				eval.evaluate(_self)
			}
		'''
	}
}