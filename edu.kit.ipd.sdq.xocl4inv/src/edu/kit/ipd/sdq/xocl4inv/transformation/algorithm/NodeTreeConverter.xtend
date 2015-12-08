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
import edu.kit.ipd.sdq.xocl4inv.transformation.exceptions.TransformationException
import edu.kit.ipd.sdq.xocl4inv.transformation.model.AbstractBinaryNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.AbstractOperationNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.AndNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.BlockNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.ExistsNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.FeatureNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.ForallNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.FunctionNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.IterateNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.MapNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.Node
import edu.kit.ipd.sdq.xocl4inv.transformation.model.NotNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.OrNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.SelectNode
import java.util.HashMap

import static extension edu.kit.ipd.sdq.xocl4inv.util.XBaseHelper.mapEager

/**
 * Core of the transformation algorithm. Provides transformation for all node types.
 * 
 * @author sfiss
 */
class NodeTreeConverter {

	/**
	 * Substitution algorithm.
	 */
	private static def Node substituteFeatureNode(Node node, String featureName,
		Node replacement) {
		// check nodes for featurenode that can be replaced
		switch (node) {
			// possible substitution
			FeatureNode: {
				// replace feature with replacement if matching param found
				if(node.feature == featureName) {
					// use clone (so that parent hierarchy remains intact)
					val clone = (replacement.clone() as Node)
					clone.setParent(node.parent)
					return clone
				}
				node
			}
			// for the rest: return node with possibly substituted children
			AbstractOperationNode: {
				node.target = node.target.substituteFeatureNode(featureName,
					replacement)
				node.arguments = node.arguments.mapEager [
					it.substituteFeatureNode(featureName, replacement)
				]
				node
			}
			NotNode: {
				node.child = node.child.substituteFeatureNode(featureName,
					replacement)
				node
			}
			FunctionNode: {
				// if replacement is null => rename all features with unique name (workaround)
				if(replacement == null) {
					val newNamesAndTypes = new HashMap()
					node.parametersNameAndType.forEach [ name, type |
						val newName = name + "__new"
						val uniqueFeature = new FeatureNode()
						uniqueFeature.feature = newName
						node.expression.
							substituteFeatureNode(name, uniqueFeature)
						newNamesAndTypes.put(newName, type)
					]
					node.parametersNameAndType = newNamesAndTypes
				}

				// Skip if variable is shadowed within inner scope (Illegal)
				if(node.parametersNameAndType.keySet.contains(featureName))
					return node

				node.expression = node.expression.
					substituteFeatureNode(featureName, replacement)
				node
			}
			AbstractBinaryNode: {
				node.left = node.left.substituteFeatureNode(featureName,
					replacement)
				node.right = node.right.substituteFeatureNode(featureName,
					replacement)
				node
			}
			BlockNode: {
				node.children = node.children.map [
					it.substituteFeatureNode(featureName, replacement)
				].toList
				node
			}
		}
	}

	/**
	 * Convert iterate node into select node.
	 * @param node IterateNode
	 * @returns the converted SelectNode
	 */
	static def SelectNode convertToSelect(IterateNode node) {
		// if nested node must be converted, move all the way to top
		var Node result = convertNode(node, node.target)
		while(result.parent != null)
			result = result.parent
		if(!(result instanceof SelectNode))
			throw new TransformationException()
		result as SelectNode
	}

	/**
	 * Catch all illegal nodes.
	 */
	private static def dispatch SelectNode convertNode(Node node, Node child) {
		throw new IllegalNodeException(node)
	}

	/**
	 * OR: otherExpr || child
	 */
	private static def dispatch SelectNode convertNode(OrNode node,
		Node child) {
		// no parent
		if(node.parent == null)
			convertOrNodeNullParent(node, child)
		else {
			// convert parent
			convertNode(node.parent, node)

			switch (node.parent) {
				NotNode:
					convertOrNodeNotParent(node, child)
				SelectNode:
					convertOrNodeSelectParent(node, child)
				default:
					throw new TransformationException()
			}
		}
	}

	private static def convertOrNodeSelectParent(OrNode node, Node child) {
		val otherExpression = if(node.left == child) node.right else node.left

		// parent is SELECT
		val parent = (node.parent as SelectNode)

		// build function:  !otherExpr
		val notNode = new NotNode()
		notNode.child = otherExpression

		// parent is SELECT => combine predicates (no substitution required)
		val andNode = new AndNode()
		andNode.right = parent.functionNode.expression
		andNode.left = notNode

		val functionNode = new FunctionNode()
		functionNode.expression = andNode

		// result node: child.select[...] (implicit param)
		val selectNode = new SelectNode()
		selectNode.functionNode = functionNode
		selectNode.target = child
		selectNode
	}

	private static def convertOrNodeNotParent(OrNode node, Node child) {
		// convert to AND using "!(a || b) <=> !a && !b"
		// build negated children
		val notLeft = new NotNode()
		notLeft.child = node.left

		val notRight = new NotNode()
		notRight.child = node.right

		// build AND
		val andNode = new AndNode()
		andNode.parent = node.parent.parent // so NOT's parent, possible null
		andNode.left = notLeft
		andNode.right = notRight

		// Convert AND instead
		convertNode(andNode, child.parent)
	}

	private static def convertOrNodeNullParent(OrNode node, Node child) {
		val otherExpression = if(node.left == child) node.right else node.left

		// build function:  [!otherExpr]
		val notNode = new NotNode()
		notNode.child = otherExpression

		val functionNode = new FunctionNode()
		functionNode.expression = notNode

		// result node: child.select[...] (implicit param)
		val selectNode = new SelectNode()
		selectNode.functionNode = functionNode
		selectNode.target = child
		selectNode
	}

	/**
	 * AND: otherExpr && child
	 */
	private static def dispatch SelectNode convertNode(AndNode node,
		Node child) {
		if(node.parent == null)
			convertAndNodeNullParent(node, child)
		else {
			// convert parent
			convertNode(node.parent, node)

			switch (node.parent) {
				NotNode:
					convertAndNodeNotParent(node, child)
				SelectNode:
					convertAndNodeSelectParent(node, child)
				default:
					throw new TransformationException()
			}
		}
	}

	private static def convertAndNodeSelectParent(AndNode node, Node child) {
		// parent is SELECT
		val parent = (node.parent as SelectNode)

		// parent is SELECT => use predicate (no substitution required)
		// result node: child.select[...] (implicit param)
		val selectNode = new SelectNode()
		selectNode.functionNode = parent.functionNode
		selectNode.target = child
		selectNode
	}

	private static def convertAndNodeNotParent(AndNode node, Node child) {
		// convert to Or using "!(a && b) <=> !a || !b"
		// build negated children
		val notLeft = new NotNode()
		notLeft.child = node.left
		val notRight = new NotNode()
		notRight.child = node.right

		// build OR
		val orNode = new OrNode()
		orNode.parent = node.parent.parent // so NOT's parent, possible null
		orNode.left = notLeft
		orNode.right = notRight

		// Convert AND instead
		convertNode(orNode, child.parent)
	}

	private static def convertAndNodeNullParent(AndNode node, Node child) {
		// build function:  [true]
		val trueNode = new FeatureNode()
		trueNode.feature = "true"
		val functionNode = new FunctionNode()
		functionNode.expression = trueNode

		// result node: child.select[...] (implicit param)
		val selectNode = new SelectNode()
		selectNode.functionNode = functionNode
		selectNode.target = child

		selectNode
	}

	/**
	 * NOT: !child
	 */
	private static def dispatch SelectNode convertNode(NotNode node,
		Node child) {
		// only convert parent if exists, else no select possible => child will handle node as NOT parent
		if(node.parent != null)
			convertNode(node.parent, node)
		else
			null
	}

	/**
	 * SELECT: child.select[p|pred(p)]
	 */
	private static def dispatch SelectNode convertNode(SelectNode node,
		Node child) {
		// SELECT without a parent just returns the node (already transformed)
		if(node.parent == null)
			node
		else {
			// convert parent
			convertNode(node.parent, node)

			switch (node.parent) {
				NotNode:
					throw new TransformationException()
				SelectNode:
					convertSelectNodeSelectParent(node, child)
				default:
					throw new TransformationException()
			}

		}
	}

	private static def convertSelectNodeSelectParent(SelectNode node,
		Node child) {
		// parent is SELECT
		val parent = (node.parent as SelectNode)

		// substitute parent select's parameter with this node's parameter (as feature node)
		val substituted = if(node.functionNode.parametersNameAndType.size ==
				1) {
				val replacement = new FeatureNode()
				replacement.feature = node.functionNode.parametersNameAndType.
					keySet().get(0)
				val parameterName = parent.functionNode.parametersNameAndType.
					keySet().get(0)
				parent.functionNode.expression.
					substituteFeatureNode(parameterName, replacement)
			} else
				throw new IllegalNodeException(node)

		// parent is SELECT => combine predicate (substitution required)
		val andNode = new AndNode()
		andNode.left = node.functionNode.expression
		andNode.right = substituted

		node.functionNode.expression = andNode

		// result node: child.select[...]
		val selectNode = new SelectNode()
		selectNode.functionNode = node.functionNode
		selectNode.target = child
		selectNode
	}

	/**
	 * MAP: child.map[p|func(p)]
	 */
	private static def dispatch SelectNode convertNode(MapNode node,
		Node child) {
		// MAP should have parent, as it does not evaluate to bool
		if(node.parent == null)
			throw new IllegalNodeException(node)
		else {

			// convert parent
			convertNode(node.parent, node)

			switch (node.parent) {
				NotNode:
					throw new TransformationException()
				SelectNode:
					convertMapNodeSelectParent(node, child)
				default:
					throw new TransformationException()
			}
		}
	}

	private static def convertMapNodeSelectParent(MapNode node, Node child) {
		// parent is SELECT
		val parent = (node.parent as SelectNode)

		// substitute parent select's parameter with this node's expression
		val substituted = if(node.functionNode.parametersNameAndType.size ==
				1) {
				val replacement = node.functionNode.expression
				val parameterName = parent.functionNode.parametersNameAndType.
					keySet.get(0)
				parent.functionNode.expression.
					substituteFeatureNode(parameterName, replacement)
			} else
				throw new IllegalNodeException(node)

		// parent is SELECT => used substituted predicate (substitution required)
		node.functionNode.expression = substituted

		// result node: child.select[...]
		val selectNode = new SelectNode()
		selectNode.functionNode = node.functionNode
		selectNode.target = child
		selectNode
	}

	/**
	 * FORALL: child.forall[p|pred(p)]
	 */
	private static def dispatch SelectNode convertNode(ForallNode node,
		Node child) {
		if(node.parent == null)
			convertForallNodeNullParent(node, child)
		else {
			// convert parent
			convertNode(node.parent, node)

			switch (node.parent) {
				NotNode:
					convertForallNodeNotParent(node, child)
				SelectNode:
					convertForallNodeSelectParent(node, child)
				default:
					throw new TransformationException()
			}
		}
	}

	private static def convertForallNodeSelectParent(ForallNode node,
		Node child) {
		// parent is SELECT
		val parent = (node.parent as SelectNode)

		// parent is SELECT => combine predicate (no substitution required, parent should have implicit param)
		// TODO: check if this is really the case, or if parent's param needs to be substituted
		// build function:  [!pred] (same param)
		val notNode = new NotNode()
		notNode.child = node.functionNode.expression

		val andNode = new AndNode()
		andNode.left = notNode
		andNode.right = parent.functionNode.expression

		val functionNode = new FunctionNode()
		functionNode.parametersNameAndType = node.functionNode.
			parametersNameAndType
		functionNode.expression = andNode

		// result node: child.select[...]
		val selectNode = new SelectNode()
		selectNode.functionNode = functionNode
		selectNode.target = child
		selectNode
	}

	private static def convertForallNodeNotParent(ForallNode node, Node child) {
		// convert to Exists using "!forall[pred] <=> exists[!pred]"
		// build function:  [!pred] (same param)
		val notNode = new NotNode()
		notNode.child = node.functionNode.expression
		val functionNode = node.functionNode
		functionNode.expression = notNode

		// build Exists
		val existsNode = new ExistsNode()
		existsNode.parent = node.parent.parent // so NOT's parent, possible null
		existsNode.target = node.target

		existsNode.functionNode = functionNode

		// Convert Exists instead
		convertNode(existsNode, child)
	}

	private static def convertForallNodeNullParent(ForallNode node,
		Node child) {
		// build function:  [!pred]
		val notNode = new NotNode()
		notNode.child = node.functionNode.expression
		val functionNode = node.functionNode
		functionNode.expression = notNode

		// result node: child.select[...] (same param)
		val selectNode = new SelectNode()
		selectNode.functionNode = functionNode
		selectNode.target = child
		selectNode
	}

	/**
	 * EXISTS: child.exists[p|pred(p)]
	 */
	private static def dispatch SelectNode convertNode(ExistsNode node,
		Node child) {
		if(node.parent == null)
			convertExistsNodeNullParent(node, child)
		else {
			// convert parent
			convertNode(node.parent, node)

			switch (node.parent) {
				NotNode:
					convertExistsNodeNotParent(node, child)
				SelectNode:
					convertExistsNodeSelectParent(node, child)
				default:
					throw new TransformationException()
			}
		}
	}

	private static def convertExistsNodeSelectParent(ExistsNode node,
		Node child) {
		// parent is SELECT
		val parent = (node.parent as SelectNode)

		// parent is SELECT => combine predicate (no substitution required, parent should have implicit param)
		// TODO: check if this is really the case, or if parent's param needs to be substituted
		// build function:  [!pred] (same param)
		val notNode = new NotNode()
		val clone = node.clone() as Node
		notNode.child = clone

		val andNode = new AndNode()
		andNode.left = notNode
		andNode.right = parent.functionNode.expression

		val functionNode = new FunctionNode() // implicit param ok
		functionNode.expression = andNode

		// result node: child.select[...]
		val selectNode = new SelectNode()
		selectNode.functionNode = functionNode
		selectNode.target = child
		selectNode
	}

	private static def convertExistsNodeNotParent(ExistsNode node, Node child) {
		// convert to Forall using "!exists[pred] <=> forall[!pred]"
		// build function:  [!pred]
		val notNode = new NotNode()
		notNode.child = node.functionNode.expression
		val functionNode = node.functionNode
		functionNode.expression = notNode

		// build Forall
		val forallNode = new ForallNode()
		forallNode.parent = node.parent.parent // so NOT's parent, possible null
		forallNode.target = node.target

		forallNode.functionNode = functionNode

		// Convert Forall instead
		convertNode(forallNode, child)
	}

	private static def convertExistsNodeNullParent(ExistsNode node,
		Node child) {
		// build function:  [!node]
		val notNode = new NotNode()
		val clone = node.clone() as Node
		clone.substituteFeatureNode(null, null)
		notNode.child = clone

		val functionNode = node.functionNode
		functionNode.expression = notNode

		// result node: child.select[...]
		val selectNode = new SelectNode()
		selectNode.functionNode = functionNode
		selectNode.target = child
		selectNode
	}
}