package com.ngntuli.bank.services;

import java.util.UUID;

import com.ngntuli.bank.daos.TransactionDao;
import com.ngntuli.bank.daos.TransactionDaoImpl;
import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;
import com.ngntuli.bank.utilities.TransferCategory;
import com.ngntuli.bank.validators.IllegalTransactionException;

public class TransactionServiceImpl implements TransactionService {
	private UserService userService = new UserServiceImpl();
	private TransactionDao transactionDao = new TransactionDaoImpl();

	@Override
	public void createTransactionByUserId(int senderId, int recipientId, int amount) {
		if (amount <= 0) {
			throw new IllegalTransactionException("Amount cannot be zero");
		}

		User sender = userService.getUserById(senderId);
		User recipient = userService.getUserById(recipientId);

		if (sender.getBalance() >= amount) {
			UUID id = UUID.randomUUID();
			Transaction trans1 = new Transaction(id, sender, recipient, TransferCategory.DEBIT, amount);
			Transaction trans2 = new Transaction(id, sender, recipient, TransferCategory.CREDIT, amount);

			sender.setBalance(sender.getBalance() - amount);
			recipient.setBalance(recipient.getBalance() + amount);

			transactionDao.addByUserTransaction(sender, trans1, recipient, trans2);

		} else {
			throw new IllegalTransactionException(
					"Insufficient balance for user: " + sender.getName() + ", balance: " + sender.getBalance());
		}
	}

	@Override
	public Transaction[] getTransactionsByUserId(int userId) {
		return (Transaction[]) userService.getUserById(userId).getTransactions().toArray();
	}

	@Override
	public boolean removeTransactionById(UUID id) {
		return userService.removeTransactionById(id);
	}

}
