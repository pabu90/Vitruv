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
 * This is the base interface for all invariant value objects. The code
 * generator applies it to all generated value objects so that a common
 * interface can be used within the invariant itself.
 * 
 * @author sfiss
 */
public interface IInvariantVO<E extends EObject> {
	/**
	 * Get the context element.
	 * 
	 * @returns the context element.
	 */
	def E getContext()
}