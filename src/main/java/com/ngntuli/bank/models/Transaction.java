package com.ngntuli.bank.models;

import java.util.UUID;

import com.ngntuli.bank.utilities.TransferCategory;

public class Transaction {

	private UUID id;
	private String recipient;
	private String sender;
	private TransferCategory transferCategory;
	private Integer amount;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
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
