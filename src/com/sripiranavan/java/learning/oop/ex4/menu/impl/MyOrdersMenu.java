package com.sripiranavan.java.learning.oop.ex4.menu.impl;

import com.sripiranavan.java.learning.oop.ex4.config.ApplicationContext;
import com.sripiranavan.java.learning.oop.ex4.entities.Order;
import com.sripiranavan.java.learning.oop.ex4.menu.Menu;
import com.sripiranavan.java.learning.oop.ex4.services.OrderManagementService;
import com.sripiranavan.java.learning.oop.ex4.services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {
	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		if (context.getLoggedUser() == null) {
			System.out.println("Please, log in or create new account to see list of your orders");
			new MainMenu().start();
			return;
		} else {
			printUserOrdersToConsole();
		}
		new MainMenu().start();
	}

	private void printUserOrdersToConsole() {
		Order[] loggedInUserOrders = orderManagementService.getOrdersByUserId(context.getLoggedUser().getId());
		if (loggedInUserOrders == null || loggedInUserOrders.length == 0) {
			System.out.println("Unfortunately, you don't have any orders yet. "
					+ "Navigate back to main menu to place a new order");
		} else {
			for (Order order : loggedInUserOrders) {
				System.out.println(order);
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** MY ORDERS *****");
	}

}
