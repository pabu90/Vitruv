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
 * Base class for all operation nodes, including iterate nodes. This class represents any method call.
 * 
 * @author sfiss
 */
abstract class AbstractOperationNode extends Node {
	/**
	 * The target on which the operation is called.
	 */
	@Accessors(PUBLIC_GETTER)
	var Node target

	def void setTarget(Node target) {
		this.target = target
		target.parent = this
	}

	/**
	 * The arguments of the operation.
	 */
	@Accessors(PUBLIC_GETTER)
	var List<Node> arguments = new ArrayList()

	def void setArguments(List<Node> arguments) {
		this.arguments = arguments
		arguments.forEach[it.parent = this]
	}

	/**
	 * Name of the operation.
	 */
	@Accessors
	var String operation

	override def Object clone() {
		var clone = super.clone() as AbstractOperationNode
		clone.target = this.target.clone() as Node
		clone.arguments = this.arguments.map[it.clone() as Node]
		clone.operation = this.operation
		clone
	}
}
