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
package edu.kit.ipd.sdq.xocl4inv.transformation.algorithm

import edu.kit.ipd.sdq.xocl4inv.transformation.exceptions.IllegalNodeException
import edu.kit.ipd.sdq.xocl4inv.transformation.model.AbstractBinaryNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.AbstractOperationNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.BlockNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.FeatureNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.FunctionNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.Node
import edu.kit.ipd.sdq.xocl4inv.transformation.model.NotNode

/**
 * Converts the tree into an expression.
 * 
 * @author sfiss
 */
public class XBaseTreeReader {

	/**
	 * Reads the xexpression as string from given tree.
	 * @param rootNode Node
	 * @returns expression as string
	 */
	static def String readXBaseString(Node rootNode) {
		rootNode.readExpressionString
	}

	private static def dispatch String readExpressionString(NotNode node) {
		'''!(«node.child.readExpressionString»)'''
	}

	private static def dispatch String readExpressionString(
		AbstractBinaryNode node) {
		'''(«node.left.readExpressionString») «node.operation» («node.right.readExpressionString»)'''
	}

	private static def dispatch String readExpressionString(
		AbstractOperationNode node) {
		'''«node.target.readExpressionString».«node.operation»(«if(node.arguments.empty) "" else node.arguments.map[it.readExpressionString].toList.join(", ")»)'''
	}

	private static def dispatch String readExpressionString(FeatureNode node) {
		'''«node.feature»'''
	}

	private static def dispatch String readExpressionString(FunctionNode node) {
		val parameters = new StringBuilder()
		if(node.parametersNameAndType.size > 0) {
			parameters.append(node.parametersNameAndType.keySet.join(", "))
			parameters.append("|")
		}

		'''[«parameters.toString» «node.expression.readExpressionString»]'''
	}

	private static def dispatch String readExpressionString(BlockNode node) {
		'''
			{
				«FOR e : node.children»
					«e.readExpressionString»
				«ENDFOR»
			}
		'''
	}

	// catches defaults
	private static def dispatch String readExpressionString(Node node) {
		throw new IllegalNodeException(node)
	}

}