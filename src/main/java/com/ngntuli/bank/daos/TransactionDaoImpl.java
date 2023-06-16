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
		users = userDao.findAll();
	}

	@Override
	public boolean add(Transaction transaction) {
		if (transaction != null) {

			Transaction trans1 = new Transaction(transaction.getId());
			Transaction trans2 = new Transaction(transaction.getId());

			if ((transaction.getTransferCategory().equals(TransferCategory.DEBIT)
					&& transaction.getSender().getBalance() < transaction.getAmount())
					|| (transaction.getTransferCategory().equals(TransferCategory.CREDIT)
							&& transaction.getRecipient().getBalance() < transaction.getAmount())) {
				System.err.println("Transaction [id=" + transaction.getId() + "] Failed!\n");

			} else if (transaction.getTransferCategory().equals(TransferCategory.DEBIT)) {

				trans1.setSender(transaction.getSender());
				trans1.setRecipient(transaction.getRecipient());
				trans1.setAmount(transaction.getAmount());
				trans1.setTransferCategory(TransferCategory.DEBIT);

				trans2.setSender(transaction.getSender());
				trans2.setRecipient(transaction.getRecipient());
				trans2.setAmount(transaction.getAmount());
				trans2.setTransferCategory(TransferCategory.CREDIT);

				trans1.getSender().setBalance(trans1.getSender().getBalance() - trans1.getAmount());
				trans1.getSender().getTransactions().add(trans1);

				trans2.getRecipient().setBalance(trans2.getRecipient().getBalance() + trans2.getAmount());
				trans2.getRecipient().getTransactions().add(trans2);

			} else {
				trans1.setSender(transaction.getSender());
				trans1.setRecipient(transaction.getRecipient());
				trans1.setAmount(transaction.getAmount());
				trans1.setTransferCategory(TransferCategory.CREDIT);

				trans2.setSender(transaction.getSender());
				trans2.setRecipient(transaction.getRecipient());
				trans2.setAmount(transaction.getAmount());
				trans2.setTransferCategory(TransferCategory.DEBIT);

				trans1.getSender().setBalance(trans1.getSender().getBalance() + trans1.getAmount());
				trans1.getSender().getTransactions().add(trans1);

				trans2.getRecipient().setBalance(trans2.getRecipient().getBalance() - trans2.getAmount());
				trans2.getRecipient().getTransactions().add(trans2);

			}

			return true;
		}

		return false;

	}

	@Override
	public boolean remove(UUID id) {
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
