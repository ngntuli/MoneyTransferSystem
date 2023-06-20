package com.ngntuli.bank.controllers;

import com.ngntuli.bank.models.User;
import com.ngntuli.bank.services.UserService;
import com.ngntuli.bank.services.UserServiceImpl;
import com.ngntuli.bank.validators.UserNotFoundException;

public class UserController {
	private static UserService userService = new UserServiceImpl();

	public String create(String name, int balance) {
		boolean isCreated = userService.createUser(name, balance);
		if (isCreated) {
			return "Success: user is created successful";
		} else {
			return "Failed: failed to create user";
		}
	}

	public String getBalance(int userId) {
		User user = userService.getUserById(userId);
		if (user != null) {
			return (user.getName() + " - " + user.getBalance());
		} else {
			throw new UserNotFoundException("Error: user with ID: " + userId + " does not exists: ");
		}
	}

}
