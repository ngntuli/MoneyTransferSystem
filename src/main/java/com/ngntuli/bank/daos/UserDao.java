package com.ngntuli.bank.daos;

import com.ngntuli.bank.models.User;

public interface UserDao {
	void addUser(User user);

	User findUserByID(int id);

	User findUserByName(String name);

	int size();
}
