package com.sripiranavan.java.learning.oop.ex4.menu.impl;

import com.sripiranavan.java.learning.oop.ex4.config.ApplicationContext;
import com.sripiranavan.java.learning.oop.ex4.entities.User;
import com.sripiranavan.java.learning.oop.ex4.menu.Menu;
import com.sripiranavan.java.learning.oop.ex4.services.UserManagementService;
import com.sripiranavan.java.learning.oop.ex4.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {
	private ApplicationContext context;
	private UserManagementService userManagementService;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		User[] users = userManagementService.getUsers();
		if (users.length == 0) {
			System.out.println("Unfortunately, there are no customers");
		} else {
			for (User user : users) {
				System.out.println(user);
			}
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** USERS *****");
	}

}
