package com.sripiranavan.java.learning.oop.ex4.menu.impl;

import java.util.Scanner;

import com.sripiranavan.java.learning.oop.ex4.config.ApplicationContext;
import com.sripiranavan.java.learning.oop.ex4.entites.impl.DefaultUser;
import com.sripiranavan.java.learning.oop.ex4.entities.User;
import com.sripiranavan.java.learning.oop.ex4.menu.Menu;
import com.sripiranavan.java.learning.oop.ex4.services.UserManagementService;
import com.sripiranavan.java.learning.oop.ex4.services.impl.DefaultUserManagementService;

public class SignUpMenu implements Menu {
	private UserManagementService userManagementService;
	private ApplicationContext context;
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();

		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter your first name: ");
		String firstName = sc.next();
		System.out.print("Please, enter your last name: ");
		String lastName = sc.next();
		System.out.print("Please, enter your password: ");
		String password = sc.next();
		System.out.print("Please, enter your email: ");

		sc = new Scanner(System.in);
		String email = sc.nextLine();

		User user = new DefaultUser(firstName, lastName, password, email);

		String errorMessage = userManagementService.registerUser(user);
		if (errorMessage == null || errorMessage.isEmpty()) {
			context.setLoggedUser(user);
			System.out.println("New user is created");
		} else {
			System.out.println(errorMessage);
		}

		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SIGN UP *****");
	}

}
