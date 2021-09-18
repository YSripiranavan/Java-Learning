package com.sripiranavan.java.learning.oop.ex4.entities;

public interface Cart {
	boolean isEmpty();

	void addProduct(Product productById);

	Product[] getProducts();

	void clear();
}
