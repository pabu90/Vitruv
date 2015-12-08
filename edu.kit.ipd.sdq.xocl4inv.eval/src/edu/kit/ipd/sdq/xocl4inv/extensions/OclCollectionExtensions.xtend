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

import com.google.common.collect.Lists
import com.google.common.collect.Sets
import java.util.ArrayList
import java.util.Collection
import java.util.HashMap
import java.util.HashSet
import java.util.Map
import java.util.Set

public class OclCollectionExtensions {

	@Pure
	public static def <T, T2> Map<T, T2> product(Iterable<T> coll,
		Iterable<T2> coll2) {
		val result = new HashMap()

		coll.forEach [ e1 |
			coll2.forEach [ e2 |
				result.put(e1, e2)
			]
		]

		result
	}

	@Pure
	public static def <T, T2> Map<T, T2> cartesianProduct(Iterable<T> coll,
		Iterable<T2> coll2) {
		val result = new HashMap()

		coll.forEach [ e1 |
			coll2.forEach [ e2 |
				result.put(e1, e2)
			]
		]

		result
	}

	@Pure
	public static def <T> Iterable<T> including(Iterable<T> coll, T element) {
		val result = if(coll instanceof Set<?>)
				Sets.<T>newHashSet(coll)
			else
				Lists.<T>newArrayList(coll)
		result.add(element)
		result
	}

	@Pure
	public static def <T> Iterable<T> includingAll(Iterable<T> coll,
		Collection<? extends T> element) {
		val result = if(coll instanceof Set<?>)
				Sets.<T>newHashSet(coll)
			else
				Lists.<T>newArrayList(coll)
		result.addAll(element)
		result
	}

	@Pure
	public static def <T> Iterable<T> excluding(Iterable<T> coll,
		Object element) {
		val result = if(coll instanceof Set<?>)
				Sets.<T>newHashSet(coll)
			else
				Lists.<T>newArrayList(coll)
		result.remove(element)
		result
	}

	@Pure
	public static def <T> Iterable<T> excludingAll(Iterable<T> coll,
		Collection<?> element) {
		val result = if(coll instanceof Set<?>)
				Sets.<T>newHashSet(coll)
			else
				Lists.<T>newArrayList(coll)
		result.removeAll(element)
		result
	}

	@Pure
	public static def <T> boolean includes(Iterable<T> coll, Object element) {
		coll.toList.contains(element)
	}

	@Pure
	public static def <T> boolean includesAll(Iterable<T> coll,
		Collection<?> element) {
		coll.toList.containsAll(element)
	}

	@Pure
	public static def <T> boolean excludes(Iterable<T> coll, Object element) {
		!coll.toList.contains(element)
	}

	@Pure
	public static def <T> boolean excludesAll(Iterable<T> coll,
		Collection<?> element) {
		element.map[coll.excludes(it)].forall[it]
	}

	@Pure
	public static def <T> Iterable<T> union(Iterable<T> list1,
		Iterable<T> list2) {
		val set = new HashSet

		set.addAll(list1)
		set.addAll(list2)

		set
	}

	@Pure
	public static def <T> Iterable<T> intersection(Iterable<T> list1,
		Iterable<T> list2) {
		val list = new ArrayList

		for (T t : list1) {
			if(list2.includes(t)) {
				list.add(t);
			}
		}

		list
	}

	@Pure
	public static def <T> Iterable<T> subtract(Iterable<T> list1,
		Iterable<T> list2) {
		val list = new ArrayList

		for (T t : list1) {
			if(!list2.includes(t)) {
				list.add(t);
			}
		}

		list
	}
}