package com.sripiranavan.java.learning.oop.ex4.config;

import com.sripiranavan.java.learning.oop.ex4.entites.impl.DefaultCart;
import com.sripiranavan.java.learning.oop.ex4.entities.Cart;
import com.sripiranavan.java.learning.oop.ex4.entities.User;
import com.sripiranavan.java.learning.oop.ex4.menu.Menu;

public class ApplicationContext {
	private static ApplicationContext instance;

	private User loggedUser;
	private Menu mainMenu;
	private Cart sessionCart;

	public ApplicationContext() {
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		if (this.sessionCart != null) {
			this.sessionCart.clear();
		}
		this.loggedUser = loggedUser;
	}

	public Menu getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(Menu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public static ApplicationContext getInstance() {
		if (instance == null) {
			instance = new ApplicationContext();
		}
		return instance;
	}

	public Cart getSessionCart() {
		if (this.sessionCart == null) {
			this.sessionCart = new DefaultCart();
		}
		return sessionCart;
	}

}
