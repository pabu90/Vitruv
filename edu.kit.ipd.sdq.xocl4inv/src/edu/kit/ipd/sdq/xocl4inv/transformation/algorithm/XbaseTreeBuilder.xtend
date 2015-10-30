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

import edu.kit.ipd.sdq.xocl4inv.transformation.exceptions.IllegalExpressionException
import edu.kit.ipd.sdq.xocl4inv.transformation.exceptions.InvalidParameterException
import edu.kit.ipd.sdq.xocl4inv.transformation.model.AbstractBinaryNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.AndNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.BinaryNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.BlockNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.ExistsNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.FeatureNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.ForallNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.FunctionNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.IterateNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.MapNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.Node
import edu.kit.ipd.sdq.xocl4inv.transformation.model.NotNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.OperationNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.OrNode
import edu.kit.ipd.sdq.xocl4inv.transformation.model.SelectNode
import java.util.HashSet
import java.util.Set
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XNullLiteral
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.XUnaryOperation

import static extension edu.kit.ipd.sdq.xocl4inv.util.XBaseHelper.featureName
import static extension edu.kit.ipd.sdq.xocl4inv.util.XBaseHelper.mapEager

/**
 * Implementation of NodeTreeBuilder for XExpressions.
 * 
 * @author sfiss
 */
public class XbaseTreeBuilder {

	/**
	 * Build the expression tree for given expression.
	 * @param rootExpression XExpression
	 * @returns rootNode of the tree
	 */
	static def Node buildTree(XExpression rootExpression) {
		val usedParameters = new HashSet()
		rootExpression.buildExpressionTree(usedParameters)
	}

	/**
	 * Catches all unimplemented XExpression and throws exception.
	 */
	private def static dispatch Node buildExpressionTree(XExpression expression,
		Set<String> usedParameters) {
		throw new IllegalExpressionException(expression)
	}

	/**
	 * Unary Operation. Only NOT allowed so far.
	 */
	private def static dispatch Node buildExpressionTree(
		XUnaryOperation expression, Set<String> usedParameters) {
		// skip if other operation than NOT
		if(expression.feature.simpleName != "operator_not")
			throw new IllegalExpressionException(expression)

		// create NOT
		val node = new NotNode()
		node.child = expression.operand.buildExpressionTree(usedParameters)
		node
	}

	/**
	 * Binary Operation. Distinquishes AND, OR, and other BinOps.
	 */
	private def static dispatch Node buildExpressionTree(
		XBinaryOperation expression, Set<String> usedParameters) {
		// create node based on feature
		val AbstractBinaryNode node = switch (expression.feature.simpleName) {
			case "operator_and": new AndNode()
			case "operator_or": new OrNode()
			default: new BinaryNode()
		}

		node.operation = expression.feature.featureName
		node.left = expression.leftOperand.buildExpressionTree(usedParameters)
		node.right = expression.rightOperand.buildExpressionTree(usedParameters)
		node
	}

	/**
	 * Method Call/Operation. Distinguishes ITERATE and other Operations.
	 */
	private def static dispatch Node buildExpressionTree(
		XMemberFeatureCall expression, Set<String> usedParameters) {
		// create iterate node based on expression name
		val IterateNode node = switch (expression.feature.featureName) {
			// both methods map to the same node, as forAll is just a delegate to forall
			case "forall",
			case "forAll":
				new ForallNode()
			case "exists":
				new ExistsNode()
			// both methods map to the same node, as select is just a delegate to filter
			case "select",
			case "filter":
				new SelectNode()
			case "map":
				new MapNode()
			default: {
				// in case of normal method call instead of iterate function, return Operation Node
				val result = new OperationNode()
				result.operation = expression.feature.featureName
				result.arguments = expression.memberCallArguments.mapEager [
					it.buildExpressionTree(usedParameters)
				]
				result.target = expression.memberCallTarget.
					buildExpressionTree(usedParameters)
				return result
			}
		}

		// only one argument as function expression
		if(expression.memberCallArguments.size != 1)
			throw new IllegalExpressionException(expression)

		// iterate must have function expression
		val functionNode = expression.memberCallArguments.get(0).
			buildExpressionTree(usedParameters)
		if(!(functionNode instanceof FunctionNode))
			throw new IllegalExpressionException(expression)

		// feature name set within node constructor, rest here
		node.functionNode = functionNode as FunctionNode
		node.target = expression.memberCallTarget.
			buildExpressionTree(usedParameters)
		node
	}

	/**
	 * Element reference (such as parameter, variables, objects).
	 */
	private def static dispatch Node buildExpressionTree(
		XFeatureCall expression, Set<String> usedParameters) {
		// should not have any arguments
		if(expression.featureCallArguments.size != 0)
			throw new IllegalExpressionException(expression)

		// create feature
		val result = new FeatureNode()
		result.feature = expression.feature.featureName
		result
	}

	/**
	 * Lambda Function / Closure. Checks that parameter is unique and explicit.
	 */
	private def static dispatch Node buildExpressionTree(XClosure expression,
		Set<String> usedParameters) {
		// create node
		val node = new FunctionNode()
		node.parametersNameAndType = expression.declaredFormalParameters.toMap [
			it.name
		].mapValues[it.parameterType]

		// check params are explicit (i.e. no "it")
		if(node.parametersNameAndType.size == 0)
			throw new InvalidParameterException("it")

		// check params are unused
		if(node.parametersNameAndType.keySet.
			exists[usedParameters.contains(it)])
			throw new InvalidParameterException(node.parametersNameAndType.
				keySet.findFirst[usedParameters.contains(it)])

		usedParameters.addAll(node.parametersNameAndType.keySet)

		// create child
		node.expression = expression.expression.
			buildExpressionTree(usedParameters)
		node
	}

	/**
	 * Block Expression.
	 */
	private def static dispatch Node buildExpressionTree(
		XBlockExpression expression, Set<String> usedParameters) {
		// if there is only one child, no need to build block node
		// this is important for iterate nodes, as their functions (XClosure) usually contains a XBlockExpression
		// FunctionNodes of IterateNodes must not have BlockNodes as children
		if(expression.expressions.size == 1)
			return expression.expressions.get(0).
				buildExpressionTree(usedParameters)

		val node = new BlockNode()
		node.children = expression.expressions.mapEager [
			it.buildExpressionTree(usedParameters)
		]
		node
	}

	/**
	 * Literal
	 */
	private def static dispatch Node buildExpressionTree(
		XNullLiteral expression, Set<String> usedParameters) {
		val result = new FeatureNode()
		result.feature = "null"
		result
	}

	/**
	 * Literal
	 */
	private def static dispatch Node buildExpressionTree(
		XBooleanLiteral expression, Set<String> usedParameters) {
		val result = new FeatureNode()
		result.feature = expression.isIsTrue.toString
		result
	}

	/**
	 * Literal
	 */
	private def static dispatch Node buildExpressionTree(
		XStringLiteral expression, Set<String> usedParameters) {
		val result = new FeatureNode()
		result.feature = "\"" + expression.value + "\""
		result
	}

	/**
	 * Literal
	 */
	private def static dispatch Node buildExpressionTree(
		XNumberLiteral expression, Set<String> usedParameters) {
		val result = new FeatureNode()
		result.feature = expression.value
		result
	}

	/**
	 * Literal
	 */
	private def static dispatch Node buildExpressionTree(
		XTypeLiteral expression, Set<String> usedParameters) {
		val result = new FeatureNode()
		result.feature = expression.type.qualifiedName
		result
	}
}