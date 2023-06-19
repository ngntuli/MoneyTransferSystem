package com.ngntuli.bank.daos;

import java.util.UUID;

import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;

public interface TransactionDao {
	boolean addByUserTransaction(User sender, Transaction senderTransaction, User recipient,
			Transaction recipientTransaction);

	boolean removeById(UUID id);

}
