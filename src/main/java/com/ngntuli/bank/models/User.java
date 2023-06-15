package com.ngntuli.bank.models;

import java.util.LinkedList;
import java.util.List;

import com.ngntuli.bank.daos.TransactionDao;
import com.ngntuli.bank.daos.TransactionDaoImpl;
import com.ngntuli.bank.databases.UserIdsGenerator;

public class User {
	private int id;
	private String name;
	private Integer balance;
	private List<TransactionDao> transactions;

	public User(String name, Integer balance) {
		this.transactions = new LinkedList<>();
		this.id = UserIdsGenerator.getInstance().generateId();
		this.name = name;
		setBalance(balance);
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

	public List<TransactionDao> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionDao> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

}
