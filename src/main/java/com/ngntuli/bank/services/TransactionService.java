package com.ngntuli.bank.services;

import java.util.List;
import java.util.UUID;

import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;

public interface TransactionService {
	void createTransactionByUserId(int senderId, int recipientId, int amount);

	List<Transaction> getTransactionsByUserId(int userId);

	boolean removeTransactionById(UUID id);
}
