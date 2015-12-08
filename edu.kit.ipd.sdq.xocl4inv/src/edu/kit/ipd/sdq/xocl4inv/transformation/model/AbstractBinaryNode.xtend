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
package edu.kit.ipd.sdq.xocl4inv.transformation.model

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Base class for all binary nodes.
 * 
 * @author sfiss
 */
abstract class AbstractBinaryNode extends Node {

	@Accessors(PUBLIC_GETTER)
	var Node left

	def void setLeft(Node left) {
		this.left = left
		left.parent = this
	}

	@Accessors(PUBLIC_GETTER)
	var Node right

	def void setRight(Node right) {
		this.right = right
		right.parent = this
	}

	/**
	 * name of operator.
	 */
	@Accessors
	var String operation

	override def Object clone() {
		val clone = super.clone() as AbstractBinaryNode
		clone.left = this.left.clone() as Node
		clone.right = this.right.clone() as Node
		clone.operation = this.operation
		clone
	}
}
