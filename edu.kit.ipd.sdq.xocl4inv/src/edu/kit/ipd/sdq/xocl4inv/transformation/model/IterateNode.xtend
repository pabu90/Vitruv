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

import edu.kit.ipd.sdq.xocl4inv.transformation.exceptions.IllegalNodeException
import java.util.Arrays
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Base class for all iterate nodes, which is a specialized operation.
 * 
 * @author sfiss
 */
abstract class IterateNode extends AbstractOperationNode {
	/**
	 * Each iterate node has a function node.
	 */
	@Accessors(PUBLIC_GETTER)
	var FunctionNode functionNode

	def void setFunctionNode(FunctionNode functionNode) {
		this.functionNode = functionNode
		functionNode.parent = this
	}

	/**
	 * Iterate nodes are only allowed to have exactly one argument: a function node.
	 */
	override setArguments(List<Node> arguments) {
		// Only one functionNode as argument allowed
		if(arguments.size != 1 && !(arguments.get(0) instanceof FunctionNode))
			throw new IllegalNodeException(this)
		this.functionNode = arguments.get(0) as FunctionNode
	}

	/**
	 * Returns the function node.
	 */
	override getArguments() {
		Arrays.asList(functionNode)
	}

	override def Object clone() {
		val clone = super.clone() as IterateNode
		clone.functionNode = this.functionNode.clone() as FunctionNode
		clone
	}
}
