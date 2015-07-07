package edu.kit.ipd.sdq.vitruvius.framework.mir.inferrer

import com.google.inject.Inject
import edu.kit.ipd.sdq.vitruvius.framework.mir.mIR.Invariant

class InvariantInferrer implements InvariantInferrerProviding {
	/** 
	 * used to get closures to append to for an XExpression. 
	 */
	@Inject ClosureProvider closureProvider

	override void infer(Invariant inv) {
		var TreeAppendableClosure invariantClosure = closureProvider.getInvariantClosure(inv)

	}

}
