package com.ngntuli.bank.daos;

import java.util.List;

import com.ngntuli.bank.models.User;

public interface UserDao {
	boolean addByUser(User user);

	User findById(int id);

	User findByName(String name);

	User findByUser(User user);

	List<User> listAllUsers();

	int size();
}
