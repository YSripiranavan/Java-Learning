package com.sripiranavan.java.learning.oop.ex4.services;

import com.sripiranavan.java.learning.oop.ex4.entities.Order;

public interface OrderManagementService {
	void addOrder(Order order);

	Order[] getOrdersByUserId(int userId);

	Order[] getOrders();
}
