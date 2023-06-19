package com.ngntuli.bank.services;

import java.util.List;
import java.util.UUID;

import com.ngntuli.bank.models.User;

public interface UserService {
	boolean createUser(User user);

	User getUser(User user);

	User getUserById(int id);

	List<User> listAllUser();

	boolean removeTransactionById(UUID id);

}
