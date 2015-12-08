package edu.kit.ipd.sdq.xocl4inv.eval.model.util;

import java.util.List;

import com.google.common.collect.Lists;

import edu.kit.ipd.sdq.xocl4inv.eval.model.Book;

@SuppressWarnings("unchecked")
public class ModelHelper {
	public static boolean compare(final Object left, final Object right) {
		// Nulls and Voids
		if (left == null || right == null)
			return left == right;

		// Collections (TODO: check Eferecence equality, Iterable types (ordered
		// etc.) EqualityHelper
		if (left instanceof Iterable && right instanceof Iterable) {
			// Method 1:
			List<Object> coll1 = Lists.newLinkedList((Iterable<Object>) left);
			List<Object> coll2 = Lists.newLinkedList((Iterable<Object>) right);
			return coll1.containsAll(coll2) && coll2.containsAll(coll1);
		}

		// Numbers
		if (left instanceof Long && right instanceof Integer) {
			boolean result = (long) left == (long) (int) right;
			return result;
		}

		if (left instanceof Integer && right instanceof Long) {
			return (long) (int) left == (long) right;
		}

		if (left instanceof Integer && right instanceof Integer) {
			return (int) left == (int) right;
		}

		if (left instanceof Long && right instanceof Long) {
			return (long) left == (long) right;
		}

		// Books
		if (left instanceof Book && right instanceof Book) {
			return ((Book) left).getName() == ((Book) right).getName();
		}

		// Default
		return left.equals(right);
	}
}
