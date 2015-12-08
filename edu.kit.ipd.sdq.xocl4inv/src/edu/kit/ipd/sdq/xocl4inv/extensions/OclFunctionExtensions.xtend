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
package edu.kit.ipd.sdq.xocl4inv.extensions

import com.google.common.collect.Sets
import java.util.Set
import javax.naming.OperationNotSupportedException

public class OclFunctionExtensions {
	@Pure
	public static def <T> Set<T> oclAsSet(T element) {
		Sets.newHashSet(element)
	}

	@Pure
	public static def boolean oclIsKindOf(Object element, Class<?> type) {
		type.isInstance(element)
	}

	@Pure
	public static def <T> T oclAsType(Object element, Class<T> type) {
		element as T
	}

	@Pure
	public static def <T> Set<T> oclAllInstances(Class<?> type) {
		throw new OperationNotSupportedException("Can not use allInstances")
	}

	@Pure
	public static def boolean implies(boolean left, boolean right) {
		!left || right
	}
}