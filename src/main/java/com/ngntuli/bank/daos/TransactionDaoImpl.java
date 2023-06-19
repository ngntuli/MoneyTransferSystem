package com.ngntuli.bank.daos;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;
import com.ngntuli.bank.utilities.TransferCategory;
import com.ngntuli.bank.validators.TransactionNotFoundException;

public class TransactionDaoImpl implements TransactionDao {
	private UserDao userDao;
	private List<User> users = new LinkedList<>();

	public TransactionDaoImpl() {
		userDao = new UserDaoImpl();
		users = userDao.findAllUsers();
	}

	@Override
	public boolean addByUserTransaction(User sender, Transaction senderTransaction, User recipient,
			Transaction recipientTransaction) {
		if (senderTransaction != null && recipientTransaction != null) {
			sender.getTransactions().add(senderTransaction);
			recipient.getTransactions().add(recipientTransaction);

			return true;
		}
		return false;
	}

	@Override
	public boolean removeById(UUID id) {
		if (id != null) {
			boolean found = false;
			for (User user : users) {
				List<Transaction> list = user.getTransactions();
				for (Transaction transaction : list) {
					if (transaction.getId().equals(id)) {
						list.remove(transaction);
						found = true;
						break;
					}
				}
			}

			if (found) {
				return true;
			} else {
				throw new TransactionNotFoundException("Transaction with UUID: " + id + " Not Found.");
			}

		}
		return false;
	}

}
