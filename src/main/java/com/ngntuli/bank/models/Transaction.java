package com.ngntuli.bank.models;

import java.util.UUID;

import com.ngntuli.bank.utilities.TransferCategory;

public class Transaction {

	private UUID id;
	private User sender;
	private User recipient;
	private TransferCategory transferCategory;
	private Integer amount;

	public Transaction(User sender, User recipient, TransferCategory transferCategory, Integer amount) {
		this.id = UUID.randomUUID();
		this.sender = sender;
		this.recipient = recipient;
		setTransferCategory(transferCategory);
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

	public void setTransferCategory(TransferCategory transferCategory) {
		this.transferCategory = transferCategory;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(User sender, User recipient, Integer amount) {
		this.amount = amount;
		if ((this.transferCategory.equals(TransferCategory.DEBIT) && sender.getBalance() < amount)
				|| (this.transferCategory.equals(TransferCategory.CREDIT) && recipient.getBalance() < amount)) {
			System.err.println("Transaction [id=" + this.id + "] Failed!\n");
		} else if (transferCategory.equals(TransferCategory.DEBIT)) {
			sender.setBalance(sender.getBalance() - amount);
			recipient.setBalance(recipient.getBalance() + amount);
		} else {
			recipient.setBalance(recipient.getBalance() - amount);
			sender.setBalance(sender.getBalance() + amount);
		}

	}

	@Override
	public String toString() {
		StringBuilder trans = new StringBuilder();

		if (this.transferCategory.equals(TransferCategory.DEBIT)) {
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

		return trans.toString();
	}

}
