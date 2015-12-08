package edu.kit.ipd.sdq.xocl4inv.eval.generator

import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.ModelFile
import edu.kit.ipd.sdq.xocl4inv.extensions.OclCollectionExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.OclFunctionExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.OclIterateExtensions
import edu.kit.ipd.sdq.xocl4inv.extensions.PureIterableExtensions
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

import static extension edu.kit.ipd.sdq.xocl4inv.util.XBaseHelper.expressionString

class TransformationGenerator implements IGenerator {

	private static final char PATH_SEPERATOR = '/';

	private def packageNameToPath(String pkgName) {
		pkgName.replace('.', PATH_SEPERATOR)
	}

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		val model = input.contents.filter(typeof(ModelFile)).get(0)
		val pgk = "edu.kit.ipd.sdq.xocl4inv.eval.generator.transformation"

		// generate Invs
		model.transformations.forEach [
			fsa.generateFile(
				(pgk + "." + it.name).packageNameToPath + ".xtend",
				'''
					package «pgk»;
					
					// Invariant
					import edu.kit.ipd.sdq.xocl4inv.eval.generator.invariants.«it.invariant.name»
						
					// JUnit (must be included in classpath)
					import org.junit.Test
					import static org.junit.Assert.assertTrue
					
					// Model
					import edu.kit.ipd.sdq.xocl4inv.eval.model.util.*
					
					// static extensions
					import static extension «PureIterableExtensions.canonicalName».*
					import static extension «OclCollectionExtensions.canonicalName».*
					import static extension «OclIterateExtensions.canonicalName».*
					import static extension «OclFunctionExtensions.canonicalName».*
					
					public class «it.name» {
						@Test
						def void checkTransformation(){
							val input = «it.input.expressionString»
							val output = «it.output.expressionString»
							
							val inv = new «it.invariant.name»()
							val dto = inv.findViolations(input)
							
							assertTrue(ModelComparator.compare(dto.«it.parameter», output))
						}
					}
					
				'''
			)
		]
	}
}