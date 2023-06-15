package com.ngntuli.bank.daos;

import java.util.ArrayList;

import com.ngntuli.bank.models.User;
import com.ngntuli.bank.validators.UserAlreadyExistsException;
import com.ngntuli.bank.validators.UserNotFoundException;

public class UserDaoImpl implements UserDao {

	private static final ArrayList<User> users = new ArrayList<>();

	@Override
	public void addUser(User user) {
		User userFound = findUserByName(user.getName());
		if (userFound == null) {
			users.add(user);
			System.out.println("User added: " + user.getName());
		} else {
			throw new UserAlreadyExistsException("Exception: User already exist - " + user);
		}

	}

	@Override
	public User findUserByID(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findUserByName(String name) {
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
