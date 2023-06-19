package com.ngntuli.bank.daos;

import java.util.List;
import java.util.UUID;

import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;
import com.ngntuli.bank.validators.TransactionNotFoundException;

public class TransactionDaoImpl implements TransactionDao {
	private UserDao userDao = new UserDaoImpl();

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

			List<User> users = userDao.findAllUsers();
			for (User user : users) {

				List<Transaction> transactions = user.getTransactions();
				for (Transaction transaction : transactions) {

					UUID id2 = transaction.getId();
					if (id2.equals(id)) {
						transactions.remove(transaction);
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
