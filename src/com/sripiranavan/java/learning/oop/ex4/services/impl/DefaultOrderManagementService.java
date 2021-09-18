package com.sripiranavan.java.learning.oop.ex4.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.sripiranavan.java.learning.oop.ex4.entities.Order;
import com.sripiranavan.java.learning.oop.ex4.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static DefaultOrderManagementService instance;
	private List<Order> orders;

	{
		orders = new ArrayList<Order>();
	}

	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		if (order == null) {
			return;
		}
		orders.add(order);
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		List<Order> userOrders = new ArrayList<Order>();
		for (Order order : orders) {
			if (order != null && order.getCustomerId() == userId) {
				userOrders.add(order);
			}
		}

		return userOrders;
	}

	@Override
	public List<Order> getOrders() {
		return this.orders;
	}

	void clearServiceState() {
		orders.clear();
	}
}
