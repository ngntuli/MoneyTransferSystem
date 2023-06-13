package com.ngntuli.bank.models;

import java.util.UUID;

import com.ngntuli.bank.utilities.TransferCategory;

public class Transaction {

	private UUID id;
	private User recipient;
	private User sender;
	private TransferCategory transferCategory;
	private Integer amount;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public void setTransferCategory(TransferCategory transferCategory) {
		this.transferCategory = transferCategory;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
