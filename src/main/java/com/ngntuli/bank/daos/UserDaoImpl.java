package com.ngntuli.bank.daos;

import java.util.ArrayList;
import java.util.List;

import com.ngntuli.bank.models.User;
import com.ngntuli.bank.validators.UserAlreadyExistsException;

public class UserDaoImpl implements UserDao {

	private static final List<User> users = new ArrayList<>();

	@Override
	public void add(User user) {
		User userFound = find(user.getName());
		if (userFound == null) {
			users.add(user);
			System.out.println("User added: " + user.getName());
		} else {
			throw new UserAlreadyExistsException("Exception: User already exist - " + user);
		}

	}

	@Override
	public User find(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User find(String name) {
		for (User user : users) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return users.size();
	}

}
