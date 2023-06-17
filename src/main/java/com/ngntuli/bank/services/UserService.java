package com.ngntuli.bank.services;

import java.util.List;

import com.ngntuli.bank.models.User;

public interface UserService {
	boolean createUser(User user);

	User getUser(User user);

	User getUserById(User user);

	List<User> listAllUser();

}
