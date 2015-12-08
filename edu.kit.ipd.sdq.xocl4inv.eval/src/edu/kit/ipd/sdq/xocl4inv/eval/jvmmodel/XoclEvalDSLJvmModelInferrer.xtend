package edu.kit.ipd.sdq.xocl4inv.eval.jvmmodel

import com.google.inject.Inject
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.Invariant
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.ModelFile
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.TransformationTest
import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.XbaseOclTest
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class XoclEvalDSLJvmModelInferrer extends AbstractModelInferrer {

    /**
	 * convenience API to build and initialize JVM types and their members.
	 */
	@Inject extension JvmTypesBuilder

	/**
	 * The dispatch method {@code infer} is called for each instance of the
	 * given element's type that is contained in a resource.
	 * 
	 * @param element
	 *            the model to create one or more
	 *            {@link JvmDeclaredType declared
	 *            types} from.
	 * @param acceptor
	 *            each created
	 *            {@link JvmDeclaredType type}
	 *            without a container should be passed to the acceptor in order
	 *            get attached to the current resource. The acceptor's
	 *            {@link IJvmDeclaredTypeAcceptor#accept(org.eclipse.xtext.common.types.JvmDeclaredType)
	 *            accept(..)} method takes the constructed empty type for the
	 *            pre-indexing phase. This one is further initialized in the
	 *            indexing phase using the closure you pass to the returned
	 *            {@link IPostIndexingInitializing#initializeLater(org.eclipse.xtext.xbase.lib.Procedures.Procedure1)
	 *            initializeLater(..)}.
	 * @param isPreIndexingPhase
	 *            whether the method is called in a pre-indexing phase, i.e.
	 *            when the global index is not yet fully updated. You must not
	 *            rely on linking using the index if isPreIndexingPhase is
	 *            <code>true</code>.
	 */
	def dispatch void infer(ModelFile element, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		if (!isPreIndexingPhase) {
			val pkg = "edu.kit.ipd.sdq.xocl4inv.eval.jvmModel."

			println("Generating JVM model")
			EcoreUtil2.resolveAll(element)

			element.xbaseocls.forEach [ test |
				inferXbaseOclModel(test, pkg + "xbaseocl.", acceptor)
			]

			element.invariants.forEach [ inv |
				inferInvariantModel(inv, pkg + "invariants.", acceptor)
			]

			element.transformations.forEach [ transform |
				inferTransformModel(transform, pkg + "transform.", acceptor)
			]
		}
	}

	def dispatch void inferXbaseOclModel(XbaseOclTest test, String pkg, IJvmDeclaredTypeAcceptor acceptor) {
		acceptor.accept(test.toClass(pkg + test.name)) [
			val contextType = typeRef(test.context.instanceClass)
			members += test.xbase.toMethod("xbaseTest", typeRef(Object)) [
				parameters += test.context.toParameter("_self", contextType)
				body = test.xbase
			]
			
			members += test.xbase.toMethod("inputTest", typeRef(Iterable, contextType)) [
				body = test.input
			]

			val oclBody = new Procedure1<ITreeAppendable>() {

				override apply(ITreeAppendable p) {
					p.append("//Insert code")
				}
			}

			members += test.xbase.toMethod("oclTest", typeRef(Void.TYPE)) [
				parameters += test.context.toParameter("_self", contextType)
				body = oclBody
			]
		]
	}

	def dispatch void inferTransformModel(TransformationTest transform, String pkg, IJvmDeclaredTypeAcceptor acceptor) {
		acceptor.accept(transform.toClass(pkg + transform.name)) [
			val contextType = typeRef(transform.invariant.context.instanceClass)
			members += transform.input.toMethod("input", contextType) [
				body = transform.input
			]

			val parameterType = typeRef(Iterable, typeRef(transform.invariant.parameters.get(0).type.instanceClass))
			members += transform.output.toMethod("output", parameterType) [
				body = transform.output
			]
		]
	}

	def void inferInvariantModel(Invariant invariant, String pkg, IJvmDeclaredTypeAcceptor acceptor) {
		acceptor.accept(invariant.toClass(pkg + invariant.name)) [
			val contextType = typeRef(invariant.context.instanceClass)
			members += invariant.toMethod("expression", typeRef(Boolean.TYPE)) [
				parameters += invariant.context.toParameter("_self", contextType)
				body = invariant.expression
			]

//			members += invariant.parameters.map [ param |
//				val paramBody = new Procedure1<ITreeAppendable>() {
//
//					override apply(ITreeAppendable p) {
//						p.append("//Insert code")
//					}
//				}
//				
//				invariant.toMethod(param.name, typeRef(List, typeRef(param.type.instanceClass))) [
//					parameters += invariant.context.toParameter("_self", contextType)
//					body = paramBody
//				]
//			]
		]
	}
}

