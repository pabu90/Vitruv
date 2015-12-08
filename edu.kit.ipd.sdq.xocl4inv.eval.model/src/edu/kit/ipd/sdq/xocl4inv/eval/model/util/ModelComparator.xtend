package edu.kit.ipd.sdq.xocl4inv.eval.model.util

import java.util.List
import java.util.Set
import edu.kit.ipd.sdq.xocl4inv.eval.model.Book
import edu.kit.ipd.sdq.xocl4inv.eval.model.Member

class ModelComparator {

	private static def boolean compareSequences(Iterable<?> left, Iterable<?> right) {
		if (left.size != right.size)
			return false
		val valsIter = right.iterator
		val paired = left.map[k|k -> valsIter.next]
		paired.forall[compare(it.key, it.value)]
	}

	private static def boolean compareCollections(Iterable<?> left, Iterable<?> right) {
		if (left.size != right.size)
			return false
		left.forall[l|right.exists[r|compare(l, r)]] && right.forall[l|left.exists[r|compare(l, r)]]
	}

	static def boolean compare(Object left, Object right) {
		// Nulls and Voids
		if (left === null || right === null)
			return left === right

		switch (left) {
			Set<?>: {
				compareCollections(left, right as Iterable<?>)
			}
			List<?>: {
				compareSequences(left, right as Iterable<?>)
			}
			Iterable<?>: {
				// assume that other collections are ordered
				compareSequences(left, right as Iterable<?>)
			}
			Book: {
				if (!(right instanceof Book))
					return false
				var other = right as Book
				left.name == other.name
			}
			Member: {
				if (!(right instanceof Member))
					return false
				var other = right as Member
				left.name == other.name
			}
			default: {
				// compare objects
				left.equals(right)
			}
		}
	}

}
