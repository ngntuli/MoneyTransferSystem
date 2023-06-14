package com.ngntuli.bank.daos;

import java.util.ArrayList;

import com.ngntuli.bank.models.User;
import com.ngntuli.bank.validators.UserAlreadyExistsException;
import com.ngntuli.bank.validators.UserNotFoundException;

public class UserDaoImpl implements UserDao {

	private static final ArrayList<User> users = new ArrayList<>();

	@Override
	public void addUser(User user) {
		if (users.contains(user)) {
			throw new UserAlreadyExistsException("Exception: User already exist - " + user);
		} else {
			users.add(user);
			System.out.println("User added: " + user.getName());
		}
	}

	@Override
	public User findUserByID(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		throw new UserNotFoundException("Exception: User Not Found by ID: " + id);
	}

	@Override
	public User findUserByName(String name) {
		for (User user : users) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		throw new UserNotFoundException("Exception: User Not Found by Name: " + name);
	}

	@Override
	public int size() {
		return users.size();
	}

}
