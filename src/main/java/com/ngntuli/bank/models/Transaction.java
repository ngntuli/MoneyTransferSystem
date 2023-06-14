package com.ngntuli.bank.models;

import java.util.UUID;

import com.ngntuli.bank.utilities.TransferCategory;

public class Transaction {

	private UUID id;
	private User sender;
	private User recipient;
	private TransferCategory transferCategory;
	private Integer amount;
	private boolean transferStatus = false;

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

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public TransferCategory getTransferCategory() {
		return transferCategory;
	}

	public void setTransferCategory(Integer amount) {
		if (amount > 0) {
			this.transferCategory = TransferCategory.DEBIT;
		} else {
			this.transferCategory = TransferCategory.CREDIT;
		}
		this.amount = Math.abs(amount);
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(User sender, User recipient, Integer amount) {
		if ((this.transferCategory == TransferCategory.DEBIT && sender.getBalance() < amount)
				|| (this.transferCategory == TransferCategory.CREDIT && sender.getBalance() < amount)) {
			System.err.println("Transaction [id=" + this.id + "] Failed!\n");
		} else {
			transferStatus = true;
			sender.setBalance(sender.getBalance() - amount);
			recipient.setBalance(recipient.getBalance() + amount);
		}

	}

	@Override
	public String toString() {
		StringBuilder trans = new StringBuilder();
		if (transferStatus) {
			if (this.transferCategory == TransferCategory.DEBIT) {
				trans.append("Transaction [");
				trans.append(sender.getName());
				trans.append(" -> ");
				trans.append(recipient.getName());
				trans.append(", -");
				trans.append(this.amount);
				trans.append(", OUTCOME, ");
				trans.append(this.id);
				trans.append("]\n");

				trans.append("Transaction [");
				trans.append(recipient.getName());
				trans.append(" -> ");
				trans.append(sender.getName());
				trans.append(", +");
				trans.append(this.amount);
				trans.append(", INCOME, ");
				trans.append(this.id);
				trans.append("]\n");
			} else {
				trans.append("Transaction [");
				trans.append(recipient.getName());
				trans.append(" -> ");
				trans.append(sender.getName());
				trans.append(", -");
				trans.append(this.amount);
				trans.append(", OUTCOME, ");
				trans.append(this.id);
				trans.append("]\n");

				trans.append("Transaction [");
				trans.append(sender.getName());
				trans.append(" -> ");
				trans.append(recipient.getName());
				trans.append(", +");
				trans.append(this.amount);
				trans.append(", INCOME, ");
				trans.append(this.id);
				trans.append("]\n");
			}
		}

		return trans.toString();
	}

}
