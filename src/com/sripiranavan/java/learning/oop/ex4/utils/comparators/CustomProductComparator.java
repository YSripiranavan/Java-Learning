package com.sripiranavan.java.learning.oop.ex4.utils.comparators;

import java.util.Comparator;

import com.sripiranavan.java.learning.oop.ex4.entities.Product;

public class CustomProductComparator implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
		int result = product1.getCategoryName().compareTo(product2.getCategoryName());
		if (result == 0) {
			double priceDelta = product1.getPrice() - product2.getPrice();
			result = priceDelta < 0 ? -1 : (priceDelta == 0) ? 0 : 1;
		}
		return result;
	}

}
