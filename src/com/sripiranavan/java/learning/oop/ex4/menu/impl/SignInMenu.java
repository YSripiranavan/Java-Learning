package com.sripiranavan.java.learning.oop.ex4.menu.impl;

import java.util.Scanner;

import com.sripiranavan.java.learning.oop.ex4.config.ApplicationContext;
import com.sripiranavan.java.learning.oop.ex4.entities.User;
import com.sripiranavan.java.learning.oop.ex4.menu.Menu;
import com.sripiranavan.java.learning.oop.ex4.services.UserManagementService;
import com.sripiranavan.java.learning.oop.ex4.services.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {
	private ApplicationContext context;
	private UserManagementService userManagementService;

	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();

		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter your email: ");
		String userEmail = sc.next();

		System.out.print("Please, enter your password: ");
		String userPassword = sc.next();

		User user = userManagementService.getUserByEmail(userEmail);
		if (user != null && user.getPassword().equals(userPassword)) {
			System.out.printf("Glad to see you back %s %s", user.getFirstName(),
					user.getLastName() + System.lineSeparator());
			context.setLoggedUser(user);
		} else {
			System.out.println("Unfortunately, such login and password doesn’t exist");
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** Sign In *****");
	}

}
