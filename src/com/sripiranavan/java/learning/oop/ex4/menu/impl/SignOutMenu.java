package com.sripiranavan.java.learning.oop.ex4.menu.impl;

import com.sripiranavan.java.learning.oop.ex4.config.ApplicationContext;
import com.sripiranavan.java.learning.oop.ex4.menu.Menu;

public class SignOutMenu implements Menu {
	private ApplicationContext context;
	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		context.setLoggedUser(null);
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** Sign Out *****");
		System.out.println("Have a nice day! Look forward to welcoming back!");
	}

}
