package com.ngntuli.bank.services;

import java.util.List;
import java.util.UUID;

import com.ngntuli.bank.daos.UserDaoImpl;
import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;
import com.ngntuli.bank.validators.IllegalUserException;

public class UserServiceImpl implements UserService {
	private final UserDaoImpl userDao = new UserDaoImpl();

	@Override
	public boolean createUser(String name, int balance) {
		if (name.length() < 3 || balance < 50) {
			throw new IllegalUserException(
					"Error: cannot create user,\n name must be more than 3 characters, \nand balance must be > 50");
		} else {
			return userDao.addByUser(new User(name, balance));
		}

	}

	@Override
	public User getUser(User user) {
		return userDao.findByUser(user);
	}

	@Override
	public User getUserById(int id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> listAllUser() {
		return userDao.findAllUsers();
	}

	@Override
	public boolean removeTransactionById(UUID id) {
		if (id != null) {

			List<User> users = userDao.findAllUsers();
			for (User user : users) {

				List<Transaction> transactions = user.getTransactions();
				for (Transaction transaction : transactions) {

					UUID id2 = transaction.getId();
					if (id2.equals(id)) {
						user.getTransactions().remove(transaction);
						break;
					}
				}
			}

			return true;
		}
		return false;
	}

	@Override
	public int countUsers() {
		return userDao.countsAllUsers();
	}

}
