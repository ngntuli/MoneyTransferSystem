package com.ngntuli.bank.models;

import com.ngntuli.bank.daos.TransactionDao;
import com.ngntuli.bank.daos.TransactionDaoImpl;
import com.ngntuli.bank.databases.UserIdsGenerator;

public class User {
	private int id;
	private String name;
	private Integer balance;
	private TransactionDao transactions;

	public User(String name, Integer balance) {
		this.id = UserIdsGenerator.getInstance().generateId();
		this.name = name;
		setBalance(balance);
		this.setTransactions(new TransactionDaoImpl());
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		if (balance < 0) {
			this.balance = 0;
			System.err.println("Cannot Set Negative Balance: " + balance + " for user: " + this.name);
		} else {
			this.balance = balance;
		}
	}

	public TransactionDao getTransactions() {
		return transactions;
	}

	public void setTransactions(TransactionDao transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

}
