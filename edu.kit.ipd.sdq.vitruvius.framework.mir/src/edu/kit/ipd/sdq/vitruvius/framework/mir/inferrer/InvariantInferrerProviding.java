package edu.kit.ipd.sdq.vitruvius.framework.mir.inferrer;

import com.google.inject.ImplementedBy;

import edu.kit.ipd.sdq.vitruvius.framework.mir.mIR.Invariant;

/**
 * Infers assignment methods from an expression by putting the correct methods
 * in the closures that can be obtained from a {@link ClosureProvider}.
 * @author Dominik Werle
 */
@ImplementedBy(InvariantInferrer.class)
public interface InvariantInferrerProviding {
	public abstract void infer(Invariant inv);
}
