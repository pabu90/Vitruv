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
package edu.kit.ipd.sdq.xocl4inv.util

import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.InvariantParameter
import org.eclipse.xtext.xbase.XExpression

import static extension edu.kit.ipd.sdq.xocl4inv.transformation.algorithm.NodeTreeConverter.convertToSelect
import static extension edu.kit.ipd.sdq.xocl4inv.transformation.algorithm.ParameterizedNodeFinder.findParameterizedIterateNode
import static extension edu.kit.ipd.sdq.xocl4inv.transformation.algorithm.XBaseTreeReader.readXBaseString
import static extension edu.kit.ipd.sdq.xocl4inv.transformation.algorithm.XbaseTreeBuilder.buildTree

/**
 * Represents the transformation algorithm for xexpressions.
 * 
 * @author sfiss
 */
class InvariantTransformator {
	/**
	 * Transforms the given expression by obeying the param into a xtend-expression-string.
	 * @param expression XExpression
	 * @param parameter InvariantParameter
	 * @returns xbase expression as string
	 */
	static def String transformExpressionToString(XExpression expression,
		InvariantParameter parameter) {
		// TODO: add possible extensions, such as simplifier
		expression.buildTree.findParameterizedIterateNode(parameter).
			convertToSelect.readXBaseString
	}
}