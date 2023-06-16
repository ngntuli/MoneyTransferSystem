package com.ngntuli.bank.services;

import java.util.List;

import com.ngntuli.bank.daos.UserDaoImpl;
import com.ngntuli.bank.models.User;

public class UserServiceImpl implements UserService {
	private UserDaoImpl userDao = new UserDaoImpl();

	@Override
	public boolean createUser(User user) {
		return userDao.addByUser(user);
	}

	@Override
	public User getUser(User user) {
		return userDao.findByUser(user);
	}

	@Override
	public List<User> listAllUser() {
		return userDao.findAllUsers();
	}

}
