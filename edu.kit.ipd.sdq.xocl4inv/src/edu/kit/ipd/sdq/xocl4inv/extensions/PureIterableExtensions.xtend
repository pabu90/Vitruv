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

import java.util.ArrayList
import java.util.List
import java.util.Map
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.Functions.Function2

public class PureIterableExtensions {
	@Pure
	public static def <T, E> Iterable<E> selectAll(Iterable<T> coll,
		Function1<T, Iterable<E>> selection) {
		val result = new ArrayList()
		for (T item : coll) {
			result.addAll(selection.apply(item))
		}
		result
	}

	@Pure
	public static def <K, V> Map<K, List<V>> groupBy(Iterable<V> coll,
		Function1<V, K> func) {
		IterableExtensions.groupBy(coll, func);
	}

	@Pure
	public static def <V> V findFirst(Iterable<V> coll,
		Function1<V, Boolean> func) {
		IterableExtensions.findFirst(coll, func);
	}

	@Pure
	public static def <T> boolean exists(Iterable<T> coll,
		Function1<T, Boolean> predicate) {
		IterableExtensions.exists(coll, predicate);
	}

	@Pure
	public static def <T extends Comparable<? super T>> T min(
		Iterable<T> coll) {
		IterableExtensions.min(coll)
	}

	@Pure
	public static def <T extends Comparable<? super T>> T max(
		Iterable<T> coll) {
		IterableExtensions.max(coll)
	}

	@Pure
	public static def <T> Iterable<T> flatten(
		Iterable<? extends Iterable<T>> coll) {
		IterableExtensions.flatten(coll)
	}

	@Pure
	public static def <T, R> Iterable<R> map(Iterable<T> coll,
		Function1<T, R> func) {
		IterableExtensions.map(coll, func)
	}

	@Pure
	public static def <T> T reduce(Iterable<T> coll, Function2<T, T, T> func) {
		IterableExtensions.reduce(coll, func)
	}

	@Pure
	public static def <T, R> R fold(Iterable<T> coll, R seed,
		Function2<R, T, R> func) {
		IterableExtensions.fold(coll, seed, func);
	}

	@Pure
	public static def <T> Iterable<T> filter(Iterable<T> coll,
		Function1<T, Boolean> predicate) {
		IterableExtensions.filter(coll, predicate)
	}

	@Pure
	public static def <T> Iterable<T> filterType(Iterable<?> coll,
		Class<T> type) {
		IterableExtensions.filter(coll, type);
	}

	@Pure
	public static def <T> boolean forall(Iterable<T> coll,
		Function1<T, Boolean> predicate) {
		IterableExtensions.forall(coll, predicate)
	}

	@Pure
	public static def <T> int size(Iterable<T> coll) {
		IterableExtensions.size(coll)
	}

}