package com.sripiranavan.java.learning.oop.ex4.services;

import com.sripiranavan.java.learning.oop.ex4.entities.Product;

public interface ProductManagementService {
	Product[] getProducts();

	Product getProductById(int productIdToAddToCart);
}
