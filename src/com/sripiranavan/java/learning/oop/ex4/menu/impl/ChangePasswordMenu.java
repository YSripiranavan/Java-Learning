package com.sripiranavan.java.learning.oop.ex4.menu.impl;

import java.util.Scanner;

import com.sripiranavan.java.learning.oop.ex4.config.ApplicationContext;
import com.sripiranavan.java.learning.oop.ex4.menu.Menu;

public class ChangePasswordMenu implements Menu {

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		try (Scanner sc = new Scanner(System.in)) {
			String userInput = sc.next();
			context.getLoggedUser().setPassword(userInput);
		}
		System.out.println("Your password has been successfully changed");
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** CHANGE PASSWORD *****");
		System.out.print("Enter new password: ");
	}

}
