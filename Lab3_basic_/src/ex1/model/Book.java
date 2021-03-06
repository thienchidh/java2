package ex1.model;

public class Book {
	private Author author;
	private String title;
	private int noOfPages;
	private boolean fiction;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author getAuthor() {
		return author;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public String getTitle() {
		return title;
	}

	public boolean isFiction() {
		return fiction;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setFiction(boolean fiction) {
		this.fiction = fiction;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", noOfPages=" + noOfPages + ", fiction=" + fiction
				+ "]";
	}

}
