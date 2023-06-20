package com.ngntuli.bank.daos;

import java.util.List;

import com.ngntuli.bank.databases.DataStore;
import com.ngntuli.bank.models.User;

public class UserDaoImpl implements UserDao {

	private static final List<User> USERS = DataStore.getInstance().getUsers();

	@Override
	public boolean addByUser(User user) {
		if (user != null) {
			USERS.add(user);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public User findById(int id) {
		for (User user : USERS) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByName(String name) {
		for (User user : USERS) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByUser(User user) {
		for (User user2 : USERS) {
			if (user2.equals(user)) {
				return user2;
			}
		}
		return null;
	}

	@Override
	public List<User> findAllUsers() {
		if (USERS.isEmpty()) {
			return null;
		}
		return USERS;
	}

	@Override
	public int countsAllUsers() {
		return USERS.size();
	}

}
