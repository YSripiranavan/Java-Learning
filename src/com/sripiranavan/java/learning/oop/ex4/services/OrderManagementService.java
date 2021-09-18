package com.sripiranavan.java.learning.oop.ex4.services;

import java.util.List;

import com.sripiranavan.java.learning.oop.ex4.entities.Order;

public interface OrderManagementService {
	void addOrder(Order order);

	List<Order> getOrdersByUserId(int userId);

	List<Order> getOrders();
}
