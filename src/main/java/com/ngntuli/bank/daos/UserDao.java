package com.ngntuli.bank.daos;

import com.ngntuli.bank.models.User;

public interface UserDao {
	void add(User user);

	User find(int id);

	User find(String name);

	int size();
}
