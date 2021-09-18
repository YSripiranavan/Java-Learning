package com.sripiranavan.java.learning.oop.ex2;

public class Publisher {
	private int id;
	private String publisherName;

	public Publisher() {
	}

	public Publisher(int id, String publisherName) {
		super();
		this.id = id;
		this.publisherName = publisherName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((publisherName == null) ? 0 : publisherName.hashCode());
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
		Publisher other = (Publisher) obj;
		if (id != other.id)
			return false;
		if (publisherName == null) {
			if (other.publisherName != null)
				return false;
		} else if (!publisherName.equals(other.publisherName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", publisherName=" + publisherName + "]";
	}

}
