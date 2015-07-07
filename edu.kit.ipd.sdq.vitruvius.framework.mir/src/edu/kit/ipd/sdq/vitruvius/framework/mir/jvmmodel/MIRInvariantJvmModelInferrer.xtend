package edu.kit.ipd.sdq.vitruvius.framework.mir.jvmmodel

import com.google.inject.Inject
import edu.kit.ipd.sdq.vitruvius.framework.mir.generator.IGeneratorStatus
import edu.kit.ipd.sdq.vitruvius.framework.mir.inferrer.ClosureProvider
import edu.kit.ipd.sdq.vitruvius.framework.mir.mIR.Invariant
import java.util.List
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import edu.kit.ipd.sdq.vitruvius.framework.mir.generator.MIRCodeGenerator

/**
 * Inferrs the Jvm Model for MIR invariants.
 * <p>
 * Is explicitly called by {@link MIRJvmModelInferrer}, and <strong>does not</strong> extend
 * {@link AbstractModelInferrer}.
 * 
 * @author Dominik Werle
 */
class MIRInvariantJvmModelInferrer {
	@Inject private extension JvmTypesBuilder
	@Inject private ClosureProvider closureProvider
	@Inject private IGeneratorStatus generatorStatus
	private extension JvmTypeReferenceBuilder typeReferenceBuilder

	private String pkgName = null

	/**
	 * Sets up the basic structure of the check / parameter return class for
	 * invariant inferring.
	 * <p>
	 * typeReferenceBuilder is set by the framework in {@link AbstractModelInferrer}s, in this case
	 * it is passed on from the main {@link MirJvmModelInferrer}.
	 */
	def dispatch void infer(Invariant invariant, IJvmDeclaredTypeAcceptor acceptor, String pkgName,
		JvmTypeReferenceBuilder typeReferenceBuilder) {
		this.typeReferenceBuilder = typeReferenceBuilder

		val contextType = typeRef(invariant.context.instanceClass)

		// build invariant
		acceptor.accept(
			invariant.toClass(pkgName + "." + MIRCodeGenerator.INV_PKG_NAME + "." + "Inv_" + invariant.name)) [
			members += invariant.toMethod("expression", typeRef(Boolean.TYPE)) [
				parameters += invariant.toParameter("_self", contextType)
				body = invariant.expression
			]
		]

		generatorStatus.addInvariantToInfer(invariant)
	}

	def setPkName(String pkgName) {
		this.pkgName = pkgName
	}

}