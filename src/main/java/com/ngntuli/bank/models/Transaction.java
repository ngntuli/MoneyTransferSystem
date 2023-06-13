package com.ngntuli.bank.models;

import java.util.UUID;

import com.ngntuli.bank.utilities.TransferCategory;

public class Transaction {

	private UUID id;
	private User recipient;
	private User sender;
	private TransferCategory transferCategory;
	private Integer amount;

	public Transaction(User sender, User recipient, Integer amount) {
		this.id = UUID.randomUUID();
		this.sender = sender;
		this.recipient = recipient;
		setTransferCategory(amount);
		setAmount(sender, recipient, amount);
	}

	public UUID getId() {
		return id;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public TransferCategory getTransferCategory() {
		return transferCategory;
	}

	public void setTransferCategory(Integer amount) {
		if (amount < 0) {
			this.transferCategory = TransferCategory.DEBIT;
		} else {
			this.transferCategory = TransferCategory.CREDIT;
		}

	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(User sender, User recipient, Integer amount) {
		if (sender.getBalance() < 0 || sender.getBalance() < amount) {
			System.err.println("Transaction Failed! for user: " + sender.getName());
		} else {
			sender.setBalance(sender.getBalance() - amount);
			recipient.setBalance(recipient.getBalance() + amount);
		}
		this.amount = amount;
	}

}
