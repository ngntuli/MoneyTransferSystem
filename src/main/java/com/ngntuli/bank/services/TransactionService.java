package com.ngntuli.bank.services;

import java.util.UUID;

import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;

public interface TransactionService {
	boolean createTransactionById(int senderId, int recipientId, int amount);

	Transaction[] getTransactionsByUserId(int userId);

	boolean removeTransactionByUserId(int userId, UUID id);
}
