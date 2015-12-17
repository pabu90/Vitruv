package edu.kit.ipd.sdq.vitruvius.framework.mir.inferrer;

import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.ImplementedBy;

/**
 * Infers assignment methods from an expression by putting the correct methods
 * in the closures that can be obtained from a {@link ClosureProvider}.
 * @author Dominik Werle
 */
@ImplementedBy(InvariantInferrer.class)
public interface InvariantInferrerProviding {
	public abstract void infer(XExpression expression);
}