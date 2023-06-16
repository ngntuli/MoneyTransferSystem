package com.ngntuli.bank.daos;

import java.util.ArrayList;
import java.util.List;

import com.ngntuli.bank.models.User;
import com.ngntuli.bank.validators.UserAlreadyExistsException;

public class UserDaoImpl implements UserDao {

	private static final List<User> users = new ArrayList<>();

	@Override
	public boolean addByUser(User user) {
		User userFound = findByName(user.getName());
		if (userFound == null) {
			users.add(user);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public User findById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByName(String name) {
		for (User user : users) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByUser(User user) {
		for (User user2 : users) {
			if (user2.equals(user)) {
				return user2;
			}
		}
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		if (users.isEmpty()) {
			return null;
		}
		return users;
	}

	@Override
	public int countsAllUsers() {
		return users.size();
	}

}
