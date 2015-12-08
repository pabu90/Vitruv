package edu.kit.ipd.sdq.xocl4inv.eval.model.util

import edu.kit.ipd.sdq.xocl4inv.eval.model.Book
import edu.kit.ipd.sdq.xocl4inv.eval.model.Library
import edu.kit.ipd.sdq.xocl4inv.eval.model.Loan
import edu.kit.ipd.sdq.xocl4inv.eval.model.Member

final class LibraryBuilder extends ModelBuilder<Library> {
	new(String name) {
		this.root = factory.createLibrary()
		root.setName(name)
	}

	def LibraryBuilder addBook(Book book) {
		root.books.add(book)
		this
	}

	def LibraryBuilder addMember(Member member) {
		root.members.add(member)
		this
	}

	def LibraryBuilder addLoan(String memberName, String bookName, int weeks) {
		val Loan loan = factory.createLoan()
		loan.weeks = weeks
		loan.member = root.members.findFirst[it.name == memberName]
		loan.book = root.books.findFirst[it.name == bookName]
		root.loans.add(loan)
		this
	}

}
