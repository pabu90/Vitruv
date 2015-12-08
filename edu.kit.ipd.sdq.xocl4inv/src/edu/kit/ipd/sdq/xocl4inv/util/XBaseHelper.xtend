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

import java.util.ArrayList
import java.util.List
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping

/** 
 * XBase utilities.
 * 
 * @author sfiss
 */
public class XBaseHelper {

	/**
	 * XBase uses map to lazily apply functions (ListExtensions). This method applies given mapping eagerly.
	 */
	public static def <TIn, TOut> List<TOut> mapEager(List<TIn> collection,
		Function1<TIn, TOut> mapping) {
		val result = new ArrayList<TOut>()
		for (TIn item : collection) {
			val mappedItem = mapping.apply(item)
			result.add(mappedItem)
		}
		result
	}

	/**
	 * Get the operation name from a JVMOperation or JVMElement.
	 */
	public static def String featureName(JvmIdentifiableElement feature) {
		val mapping = new OperatorMapping()

		switch (feature) {
			JvmOperation: {
				val mapped = mapping.getOperator(
					QualifiedName.create(feature.simpleName))
				if(mapped != null)
					mapped.toString
				else
					feature.simpleName
			}
			default:
				feature.simpleName
		}
	}

	public static def String expressionString(XExpression expression) {
		NodeModelUtils.getNode(expression).text
	}
}