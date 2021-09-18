package com.sripiranavan.java.learning.oop.ex4;

import com.sripiranavan.java.learning.oop.ex4.menu.Menu;
import com.sripiranavan.java.learning.oop.ex4.menu.impl.MainMenu;

public class Main {
	public static final String EXIT_COMMAND = "exit";

	public static void main(String[] args) {
		Menu mainMenu = new MainMenu();
		mainMenu.start();
	}

}
