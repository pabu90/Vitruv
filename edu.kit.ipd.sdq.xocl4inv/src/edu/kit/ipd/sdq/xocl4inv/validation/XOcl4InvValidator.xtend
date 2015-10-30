/*
 *  /*******************************************************************************
 * Copyright (c) 2015 Sebastian Fiss.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Sebastian Fiss - initial API and implementation and/or initial documentation
 *******************************************************************************/
package edu.kit.ipd.sdq.xocl4inv.validation

import edu.kit.ipd.sdq.xocl4inv.transformation.exceptions.IllegalExpressionException
import edu.kit.ipd.sdq.xocl4inv.transformation.exceptions.IllegalNodeException
import edu.kit.ipd.sdq.xocl4inv.transformation.exceptions.InvalidParameterException
import edu.kit.ipd.sdq.xocl4inv.transformation.exceptions.TransformationException
import edu.kit.ipd.sdq.xocl4inv.util.InvariantTransformator
import edu.kit.ipd.sdq.xocl4inv.xOcl4InvDSL.Invariant
import edu.kit.ipd.sdq.xocl4inv.xOcl4InvDSL.XOcl4InvDSLPackage
import org.eclipse.xtext.validation.Check

import static extension edu.kit.ipd.sdq.xocl4inv.util.XBasePurityChecker.isPure

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class XOcl4InvValidator extends AbstractXOcl4InvValidator {

	@Check
	def checkInvariantPureExpression(Invariant invariant) {
		// check that only pure methods are used in invariant expression
		if(invariant.expression != null && !invariant.expression.pure) {
			warning(
				"Only pure methods are allowed in the expression, make sure that the expression is safe",
				XOcl4InvDSLPackage.Literals.INVARIANT__EXPRESSION)
		}
	}

	@Check
	def checkInvariantTransformation(Invariant invariant) {
		// actually perfoms transformation and catches exceptions
		// check that all parameters can be obtained with transformation
		invariant.parameters.forEach [
			try {
				InvariantTransformator.
					transformExpressionToString(invariant.expression, it)
			} catch(IllegalExpressionException e) {
				error(
					"Can not transform invariant, found illegal expression: " +
						e.expression,
					XOcl4InvDSLPackage.Literals.INVARIANT__EXPRESSION)
				} catch(InvalidParameterException e) {
					error(
						"Can not transform invariant, found illegal parameter: " +
							e.param,
						XOcl4InvDSLPackage.Literals.INVARIANT__EXPRESSION)
					} catch(IllegalNodeException e) {
						error(
							"Can not transform invariant, found illegal node: " +
								e.node, XOcl4InvDSLPackage.Literals.
								INVARIANT__EXPRESSION)
							} catch(TransformationException e) {
								error("Can not transform invariant",
									XOcl4InvDSLPackage.Literals.
										INVARIANT__EXPRESSION)
									} catch(Exception e) {
										error(
											"An unknown error occurred during transformation: " +
												e.message,
											XOcl4InvDSLPackage.Literals.
												INVARIANT__EXPRESSION)
											}
										]
									}
								}
