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

import edu.kit.ipd.sdq.xocl4inv.eval.xoclEvalDSL.InvariantParameter
import edu.kit.ipd.sdq.xocl4inv.transformation.exceptions.IllegalNodeException
import edu.kit.ipd.sdq.xocl4inv.transformation.exceptions.InvalidParameterException
import edu.kit.ipd.sdq.xocl4inv.transformation.model.AbstractBinaryNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.AbstractOperationNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.BlockNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.FeatureNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.FunctionNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.IterateNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.Node
import edu.kit.ipd.sdq.xocl4inv.transformation.model.NotNode

import static extension edu.kit.ipd.sdq.xocl4inv.util.XBaseHelper.mapEager

/**
 * Algorithm to find parameterized node.
 * 
 * @author sfiss
 */
class ParameterizedNodeFinder {
	/**
	 * Retrieve iterate node containing parameter from provided tree.
	 * @param rootNode Node
	 * @param invariantParameter InvariantParameter
	 * @returns IterateNode that contains the parameter
	 */
	static def IterateNode findParameterizedIterateNode(Node rootNode,
		InvariantParameter invariantParameter) {
		val parameterName = invariantParameter.name
		val functionNode = findParameter(rootNode, parameterName)

		// error if no node/parameter found
		if(functionNode == null)
			throw new InvalidParameterException(parameterName)

		// error if it is not of type iterate node
		if(!(functionNode.parent instanceof IterateNode))
			throw new InvalidParameterException(parameterName)

		val iterateNode = functionNode.parent as IterateNode

		// error if illegal type (named parameter must be explicitly typed)
		if(functionNode.parametersNameAndType.get(parameterName) == null ||
			functionNode.parametersNameAndType.get(parameterName).
				qualifiedName !=
				invariantParameter.type.instanceClass.canonicalName)
					throw new InvalidParameterException(parameterName)

				iterateNode
			}

			/**
			 * Undefined nodes throw exception.
			 */
			private static def dispatch FunctionNode findParameter(Node node,
				String parameterName) {
				throw new IllegalNodeException(node)
			}

			/**
			 * Features do not have parameters.
			 */
			private static def dispatch FunctionNode findParameter(
				FeatureNode node, String parameterName) {
				null
			}

			/**
			 * Block nodes must find param in children, but not more than one.
			 */
			private static def dispatch FunctionNode findParameter(
				BlockNode node, String parameterName) {
				val childParameterizedNodes = node.children.mapEager [
					it.findParameter(parameterName)
				]

				// too many params found (should not happen)
				if(childParameterizedNodes.filterNull.size > 1)
					throw new InvalidParameterException(parameterName)

				childParameterizedNodes.findFirst[it != null]
			}

			/**
			 * Not node looks into child.
			 */
			private static def dispatch FunctionNode findParameter(NotNode node,
				String parameterName) {
				node.child.findParameter(parameterName)
			}

			/**
			 * Binary node checks left and right operand (max one param allowed).
			 */
			private static def dispatch FunctionNode findParameter(
				AbstractBinaryNode node, String parameterName) {
				val left = node.left.findParameter(parameterName)
				val right = node.right.findParameter(parameterName)

				// two params (illegal)
				if(left != null && right != null)
					throw new InvalidParameterException(parameterName)

				left ?: right
			}

			/**
			 * Operation nodes looks into children.
			 */
			private static def dispatch FunctionNode findParameter(
				AbstractOperationNode node, String parameterName) {
				val target = node.target.findParameter(parameterName)
				val arguments = node.arguments.mapEager [
					it.findParameter(parameterName)
				].filterNull

				// zero params
				if(target == null && arguments.size == 0)
					return null

				// mutliple params
				if((target != null && arguments.size != 0) ||
					arguments.size > 1)
					throw new InvalidParameterException(parameterName)

				// one param
				target ?: arguments.get(0)
			}

			/**
			 * Function node can contain param, else child might.
			 */
			private static def dispatch FunctionNode findParameter(
				FunctionNode node, String parameterName) {
				if(node.parametersNameAndType.keySet.
					exists[it == parameterName])
					node
				else
					node.expression.findParameter(parameterName)
			}
		}