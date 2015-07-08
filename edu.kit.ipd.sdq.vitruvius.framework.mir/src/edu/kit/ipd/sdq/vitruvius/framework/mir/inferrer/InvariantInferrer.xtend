package edu.kit.ipd.sdq.vitruvius.framework.mir.inferrer

import com.google.inject.Inject
import org.eclipse.xtext.xbase.XExpression

class InvariantInferrer implements InvariantInferrerProviding {
	/** 
	 * used to get closures to append to for an XExpression. 
	 */
	@Inject ClosureProvider closureProvider

	override void infer(XExpression inv) {
		var TreeAppendableClosure invariantClosure = closureProvider.getInvariantClosure(inv)

		invariantClosure.addXExpression(inv)
	}

}
