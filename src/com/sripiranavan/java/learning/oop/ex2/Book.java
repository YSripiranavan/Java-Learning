package com.sripiranavan.java.learning.oop.ex2;

import java.math.BigDecimal;
import java.util.Arrays;

public class Book {
	private int id;
	private String name;
	private Author[] authors;
	private Publisher publisher;
	private int publishingYear;
	private int amountOfPages;
	private BigDecimal price;
	private CoverType coverType;

	public Book() {
	}

	public Book(int id, String name, Author[] authors, Publisher publisher, int publishingYear, int amountOfPages,
			BigDecimal price, CoverType coverType) {
		super();
		this.id = id;
		this.name = name;
		this.authors = authors;
		this.publisher = publisher;
		this.publishingYear = publishingYear;
		this.amountOfPages = amountOfPages;
		this.price = price;
		this.coverType = coverType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author[] getAuthors() {
		return authors;
	}

	public void setAuthors(Author[] authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public int getPublishingYear() {
		return publishingYear;
	}

	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	public int getAmountOfPages() {
		return amountOfPages;
	}

	public void setAmountOfPages(int amountOfPages) {
		this.amountOfPages = amountOfPages;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public CoverType getCoverType() {
		return coverType;
	}

	public void setCoverType(CoverType coverType) {
		this.coverType = coverType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amountOfPages;
		result = prime * result + Arrays.hashCode(authors);
		result = prime * result + ((coverType == null) ? 0 : coverType.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + publishingYear;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (amountOfPages != other.amountOfPages)
			return false;
		if (!Arrays.equals(authors, other.authors))
			return false;
		if (coverType != other.coverType)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (publishingYear != other.publishingYear)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", authors=" + Arrays.toString(authors) + ", publisher="
				+ publisher + ", publishingYear=" + publishingYear + ", amountOfPages=" + amountOfPages + ", price="
				+ price + ", coverType=" + coverType + "]";
	}

	public boolean hasAuthor(Author authorCriteria) {
		for (Author author : authors) {
			if (author.equals(authorCriteria)) {
				return true;
			}
		}
		return false;
	}
}
