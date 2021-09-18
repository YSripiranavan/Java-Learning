package com.sripiranavan.java.learning.oop.ex2;

public class BookService {
	public Book[] filterBooksByAuthor(Author author, Book[] books) {
		if (author == null || books == null) {
			return new Book[0];
		}
		int matchBookAmount = 0;
		for (Book book : books) {
			if (book.hasAuthor(author)) {
				matchBookAmount++;
			}
		}

		Book[] filteredBooks = new Book[matchBookAmount];
		int index = 0;
		for (Book book : books) {
			if (book.hasAuthor(author)) {
				filteredBooks[index++] = book;
			}
		}

		return filteredBooks;
	}

	public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
		if (publisher == null || books == null) {
			return new Book[0];
		}

		int matchBookAmount = 0;
		for (Book book : books) {
			if (book.getPublisher().equals(publisher)) {
				matchBookAmount++;
			}
		}

		Book[] filteredBooks = new Book[matchBookAmount];
		int index = 0;
		for (Book book : books) {
			if (book.getPublisher().equals(publisher)) {
				filteredBooks[index++] = book;
			}
		}
		return filteredBooks;
	}

	public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
		if (books == null) {
			return new Book[0];
		}

		int matchBookAmount = 0;
		for (Book book : books) {
			if (book.getPublishingYear() >= yearFromInclusively) {
				matchBookAmount++;
			}
		}

		Book[] filterBooks = new Book[matchBookAmount];
		int index = 0;
		for (Book book : books) {
			if (book.getPublishingYear() >= yearFromInclusively) {
				filterBooks[index++] = book;
			}
		}

		return filterBooks;
	}
}
