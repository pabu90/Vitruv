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

import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Container class for block expressions.
 * 
 * @author sfiss
 */
class BlockNode extends Node {
	@Accessors(PUBLIC_GETTER)
	var List<Node> children = new ArrayList()

	def void setChildren(List<Node> children) {
		this.children = children
		children.forEach[it.parent = this]
	}

	override def Object clone() {
		val clone = super.clone() as BlockNode
		clone.children = this.children.map[it.clone() as Node]
		clone
	}
}
