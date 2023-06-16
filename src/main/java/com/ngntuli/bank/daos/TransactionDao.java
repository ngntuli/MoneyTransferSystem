package com.ngntuli.bank.daos;

import java.util.UUID;

import com.ngntuli.bank.models.Transaction;

public interface TransactionDao {
	boolean add(Transaction transaction);

	boolean remove(UUID id);

}
