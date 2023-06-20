package com.ngntuli.bank.models;

import java.util.LinkedList;
import java.util.List;

import com.ngntuli.bank.databases.UserIdsGenerator;

public class User {
	private int id;
	private String name;
	private int balance;
	private final List<Transaction> transactions = new LinkedList<>();

	public User(String name, int balance) {
		this.id = UserIdsGenerator.getInstance().generateId();
		this.name = name;
		this.balance = balance;
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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

}
