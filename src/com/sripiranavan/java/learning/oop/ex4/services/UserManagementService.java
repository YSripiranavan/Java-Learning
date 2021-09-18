package com.sripiranavan.java.learning.oop.ex4.services;

import java.util.List;

import com.sripiranavan.java.learning.oop.ex4.entities.User;

public interface UserManagementService {
	String registerUser(User user);

	List<User> getUsers();

	User getUserByEmail(String userEmail);
}
