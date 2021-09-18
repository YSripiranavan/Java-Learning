package com.sripiranavan.java.learning.oop.ex4.entities;

public interface Product {
	int getId();

	String getProductName();

	String getCategoryName();

	double getPrice();

	void setPrice(double price);
}
