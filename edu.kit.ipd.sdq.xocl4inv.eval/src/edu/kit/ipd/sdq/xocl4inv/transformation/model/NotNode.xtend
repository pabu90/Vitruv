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
 * Only unary node, represents a negation.
 * 
 * @author sfiss
 */
class NotNode extends Node {

	@Accessors(PUBLIC_GETTER)
	var Node child

	def void setChild(Node child) {
		this.child = child
		child.parent = this
	}

	override def Object clone() {
		val clone = super.clone() as NotNode
		clone.child = this.child.clone() as Node
		clone
	}
}
