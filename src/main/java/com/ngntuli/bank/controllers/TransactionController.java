package com.ngntuli.bank.controllers;

import java.util.List;

import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.services.TransactionService;
import com.ngntuli.bank.services.TransactionServiceImpl;

public class TransactionController {
	private static TransactionService trService = new TransactionServiceImpl();

	public String create(int senderId, int recipientId, int amount) {
		trService.createTransactionByUserId(senderId, recipientId, amount);
		return "Success: transaction is successfully created";
	}

	public List<Transaction> list(int userId) {
		return trService.getTransactionsByUserId(userId);
	}
}
