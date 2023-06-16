package com.ngntuli.bank.services;

import com.ngntuli.bank.models.User;

public interface UserService {
	boolean createUser(User user);

	int getBalance(User user);
}
