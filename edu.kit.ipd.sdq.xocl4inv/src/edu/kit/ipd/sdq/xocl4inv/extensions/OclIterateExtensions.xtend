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

import java.util.List
import java.util.Set
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.Functions.Function2

import static extension edu.kit.ipd.sdq.xocl4inv.extensions.OclCollectionExtensions.product

public class OclIterateExtensions {
	@Pure
	public static def <T> boolean forAll(Iterable<T> coll,
		Function2<T, T, Boolean> predicate) {
		coll.product(coll).filter[p1, p2|predicate.apply(p1, p2)].size ==
			coll.size
	}

	@Pure
	public static def <T> boolean forAllTest(Iterable<T> coll,
		Function2<T, T, Boolean> predicate) {
		coll.product(coll).filter[p1, p2|predicate.apply(p1, p2)].size ==
			coll.size
	}

	@Pure
	public static def <T> boolean forAll(Iterable<T> coll,
		Function1<T, Boolean> predicate) {
		coll.forall(predicate)
	}

	@Pure
	public static def <T> boolean one(Iterable<T> coll,
		Function1<T, Boolean> predicate) {
		coll.filter(predicate).size == 1
	}

	@Pure
	public static def <T> boolean unique(Iterable<T> coll,
		Function1<T, ?> func) {
		coll.groupBy[func.apply(it)].values.forall[it.size == 1]
	}

	@Pure
	public static def <T> T any(Iterable<T> coll,
		Function1<? super T, Boolean> predicate) {
		coll.findFirst(predicate)
	}

	@Pure
	public static def <T> int count(Iterable<T> coll, Object element) {
		coll.map[if(it == element) 1 else 0].reduce[p1, p2|p1 + p2]
	}

	@Pure
	public static def <T, R> Iterable<R> collectNested(Iterable<T> coll,
		Function1<T, R> func) {
		coll.map(func)
	}

	@Pure
	public static def <T, R> Iterable<R> collect(Iterable<T> coll,
		Function1<T, R> func) {
		// does not flatten, like OCL does
		coll.map(func)
	}

	@Pure
	public static def <T> Iterable<T> select(Iterable<T> coll,
		Function1<T, Boolean> predicate) {
		coll.filter(predicate)
	}

	@Pure
	public static def <T> Iterable<T> reject(Iterable<T> coll,
		Function1<T, Boolean> predicate) {
		coll.filter[e|!predicate.apply(e)]
	}

	@Pure
	public static def <T, R> R iterate(Iterable<T> coll, R seed,
		Function2<R, T, R> func) {
		coll.fold(seed, func)
	}

	@Pure
	public static def <T> Iterable<T> selectByType(Iterable<?> coll,
		Class<T> type) {
		coll.filter(type)
	}

	@Pure
	public static def <T, C extends Comparable<? super C>> List<T> sortedBy(
		Iterable<T> coll, Function1<T, C> key) {
		coll.sortBy(key)
	}

	@Pure
	public static def <T> boolean isEmpty(Iterable<T> coll) {
		coll.empty
	}

	@Pure
	public static def <T> boolean notEmpty(Iterable<T> coll) {
		! coll.empty
	}

	@Pure
	public static def <T> Set<T> asSet(Iterable<T> coll) {
		coll.toSet
	}

	@Pure
	public static def <T> List<T> asList(Iterable<T> coll) {
		coll.toList
	}

	@Pure
	public static def <T> T at(Iterable<T> coll, int index) {
		if(index < coll.size)
			coll.get(index)
		else
			null
	}
}