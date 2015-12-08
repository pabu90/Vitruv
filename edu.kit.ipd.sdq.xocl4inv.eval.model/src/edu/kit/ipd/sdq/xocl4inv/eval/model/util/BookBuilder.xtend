package edu.kit.ipd.sdq.xocl4inv.eval.model.util

import edu.kit.ipd.sdq.xocl4inv.eval.model.Book

class BookBuilder extends ModelBuilder<Book> {
	new(String name, int copies) {
		this.root = factory.createBook()
		root.name = name
		root.copies = copies
	}
}
