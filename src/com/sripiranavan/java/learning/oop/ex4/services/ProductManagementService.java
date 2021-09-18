package com.sripiranavan.java.learning.oop.ex4.services;

import java.util.List;

import com.sripiranavan.java.learning.oop.ex4.entities.Product;

public interface ProductManagementService {
	List<Product> getProducts();

	Product getProductById(int productIdToAddToCart);
}
