package com.ngntuli.bank.controllers;

import com.ngntuli.bank.services.UserService;
import com.ngntuli.bank.services.UserServiceImpl;

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

	public String getBalance(int UserId) {
		int isBalanced = userService.getBalanceByUserId(UserId);
		if (isBalanced != Integer.MIN_VALUE) {
			return ("Success: your balance is: " + isBalanced);
		} else {
			return "Failed: failed to get balance user";
		}
	}

}
