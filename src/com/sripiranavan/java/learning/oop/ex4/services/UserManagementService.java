package com.sripiranavan.java.learning.oop.ex4.services;

import com.sripiranavan.java.learning.oop.ex4.entities.User;

public interface UserManagementService {
	String registerUser(User user);

	User[] getUsers();

	User getUserByEmail(String userEmail);
}
