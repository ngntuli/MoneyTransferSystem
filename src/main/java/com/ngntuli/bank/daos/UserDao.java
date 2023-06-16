package com.ngntuli.bank.daos;

import java.util.List;

import com.ngntuli.bank.models.User;

public interface UserDao {
	boolean add(User user);

	User find(int id);

	User find(String name);

	User find(User user);

	List<User> findAll();

	int size();
}
