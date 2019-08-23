package ex1.test;

import ex1.model.Author;
import ex1.model.Book;

public class TestGetterSetter {
	public static void main(String[] args) {
		Book book = new Book();

		book.setAuthor(new Author("Hi"));
		System.out.println(book);

		book.setFiction(true);
		System.out.println(book);

		// etc...
		book.setNoOfPages(1000);
		System.out.println(book);

	}
}
