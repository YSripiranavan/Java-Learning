package com.sripiranavan.java.learning.oop.ex4.entities;

import java.util.List;

public interface Cart {
	boolean isEmpty();

	void addProduct(Product productById);

	List<Product> getProducts();

	void clear();
}
