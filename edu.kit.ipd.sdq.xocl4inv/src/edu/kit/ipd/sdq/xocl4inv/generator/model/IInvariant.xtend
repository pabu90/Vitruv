/*******************************************************************************
 * Copyright (c) 2015 Sebastian Fiss.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Sebastian Fiss - initial API and implementation and/or initial documentation
 *******************************************************************************/
package edu.kit.ipd.sdq.xocl4inv.generator.model

import org.eclipse.emf.ecore.EObject

/**
 * Interface for the generated invariants. The code generator for XOcl4Inv 
 * provides this interface for all invariants. It allows accessing the 
 * extracted model data.
 * 
 * @author sfiss
 */
public interface IInvariant<E extends EObject, T extends IInvariantVO<E>> {
	/**
	 * Evaluates the invariant constraint expression against the given context
	 * element.
	 * 
	 * @param _self: Context element instance
	 * 
	 * @returns the outcome of the invariant constraint.
	 */
	def boolean check(E _self)

	/**
	 * 
	 */
	def T findViolations(E _self)
}