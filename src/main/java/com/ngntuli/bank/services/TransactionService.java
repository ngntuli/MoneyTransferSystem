package com.ngntuli.bank.services;

import java.util.UUID;

import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;

public interface TransactionService {
	boolean addUser(User user);

	int getBalance(User user);

	boolean createTransaction(int senderId, int recipientId, int amount);

	boolean performTransfer(User sender, User recipient, int amount);

	Transaction[] getTransactionsByUserId(int userId);

	boolean removeTransaction(int userId, UUID id);
}
