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

import java.util.HashMap
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmTypeReference

/**
 * Function node that represents an anonymous function (lamda or closure).
 * 
 * @author sfiss
 */
class FunctionNode extends Node {
	/**
	 * Map of parameters (name -> type)
	 */
	@Accessors
	var Map<String, JvmTypeReference> parametersNameAndType = new HashMap()

	@Accessors(PUBLIC_GETTER)
	var Node expression

	def void setExpression(Node expression) {
		this.expression = expression
		expression.parent = this
	}

	override def Object clone() {
		val clone = super.clone() as FunctionNode
		clone.parametersNameAndType = this.parametersNameAndType
		clone.expression = this.expression.clone() as Node
		clone
	}
}
