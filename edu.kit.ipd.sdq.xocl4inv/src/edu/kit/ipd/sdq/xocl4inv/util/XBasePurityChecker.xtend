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

import java.util.List
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
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
import org.eclipse.xtext.xbase.XVariableDeclaration

/**
 * Checks if XExpressions use only pure or whitelisted methods
 */
class XBasePurityChecker {

	private static def List<String> getWhitelistedMethods() {
		// TODO: fetch whitelisted methods from config
		#["java.util.List.empty", "java.util.List.size"]
	}

	private static def boolean isPureFeature(JvmIdentifiableElement feature) {
		switch (feature) {
			JvmOperation: {
				// TODO: remove setters from eobject whitelist (make it configurable, which pure-filter is applied)
				// getters are ok
				val isGetter = feature.simpleName.startsWith("get") ||
					feature.simpleName.startsWith("is")
				// whitelisted methods are ok
				val isWhitelisted = whitelistedMethods.contains(
					feature.qualifiedName)
				// check that feature as @Pure annotation
				val isPure = !feature.annotations.filter [ a |
					a.annotation.simpleName == Pure.simpleName
				].empty
				isGetter || isWhitelisted || isPure
			}
			default:
				// non-operations are considered pure
				true
		}
	}

	static def dispatch boolean isPure(XExpression expression) {
		throw new IllegalArgumentException(
			"Illegal expression encountered while checking purity")
	}

	static def dispatch boolean isPure(XUnaryOperation expression) {
		return expression.feature.isPureFeature && expression.operand.pure
	}

	static def dispatch boolean isPure(XBinaryOperation expression) {
		return expression.feature.isPureFeature &&
			expression.leftOperand.pure && expression.rightOperand.pure
	}

	static def dispatch boolean isPure(XMemberFeatureCall expression) {
		return expression.memberCallTarget.pure &&
			expression.feature.isPureFeature &&
			expression.memberCallArguments.forall[it.pure]
	}

	static def dispatch boolean isPure(XFeatureCall expression) {
		return expression.feature.isPureFeature &&
			expression.featureCallArguments.forall[it.pure]
	}

	static def dispatch boolean isPure(XClosure expression) {
		return expression.expression.pure
	}

	static def dispatch boolean isPure(XBlockExpression expression) {
		return expression.expressions.forall[it.pure]
	}

	static def dispatch boolean isPure(XVariableDeclaration expression) {
		return false
	}

	static def dispatch boolean isPure(XNullLiteral expression) {
		return true
	}

	static def dispatch boolean isPure(XBooleanLiteral expression) {
		return true
	}

	static def dispatch boolean isPure(XStringLiteral expression) {
		return true
	}

	static def dispatch boolean isPure(XNumberLiteral expression) {
		return true
	}

	static def dispatch boolean isPure(XTypeLiteral expression) {
		return true
	}
}