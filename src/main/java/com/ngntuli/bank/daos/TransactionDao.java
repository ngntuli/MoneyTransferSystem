package com.ngntuli.bank.daos;

import java.util.UUID;

import com.ngntuli.bank.models.Transaction;

public interface TransactionDao {
	boolean addByTransaction(Transaction transaction);

	boolean removeById(UUID id);

}
