package com.sripiranavan.java.learning.oop.ex4.entites.impl;

import java.util.Arrays;

import com.sripiranavan.java.learning.oop.ex4.entities.Cart;
import com.sripiranavan.java.learning.oop.ex4.entities.Product;

public class DefaultCart implements Cart {
	private static final int DEFAULT_PRODUCT_CAPACITY = 10;
	private Product[] products;
	private int lastIndex;

	{
		products = new Product[DEFAULT_PRODUCT_CAPACITY];
	}

	@Override
	public boolean isEmpty() {
		if (products == null || products.length == 0) {
			return true;
		}
		for (Product product : products) {
			if (product != null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void addProduct(Product productById) {
		if (productById == null) {
			return;
		}
		if (products.length <= lastIndex) {
			products = Arrays.copyOf(products, products.length << 1);
		}
		products[lastIndex++] = productById;
	}

	@Override
	public Product[] getProducts() {
		int nonNullProductAmount = 0;
		for (Product product : products) {
			if (product != null) {
				nonNullProductAmount++;
			}
		}
		Product[] nonNullProducts = new Product[nonNullProductAmount];
		int index = 0;
		for (Product product : products) {
			if (product != null) {
				nonNullProducts[index++] = product;
			}
		}
		return nonNullProducts;
	}

	@Override
	public void clear() {
		products = new Product[DEFAULT_PRODUCT_CAPACITY];
	}

}
