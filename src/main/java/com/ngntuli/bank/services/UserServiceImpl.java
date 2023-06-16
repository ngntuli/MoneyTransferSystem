package com.ngntuli.bank.services;

import com.ngntuli.bank.daos.UserDaoImpl;
import com.ngntuli.bank.models.User;

public class UserServiceImpl implements UserService {
	private UserDaoImpl userDao = new UserDaoImpl();

	@Override
	public boolean createUser(User user) {
		return userDao.addByUser(user);
	}

	@Override
	public int getBalance(User user) {
		User userFound = userDao.findByUser(user);
		if (userFound != null) {
			return userFound.getBalance();
		}
		return Integer.MIN_VALUE;
	}

}
