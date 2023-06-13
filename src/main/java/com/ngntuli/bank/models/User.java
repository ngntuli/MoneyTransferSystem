package com.ngntuli.bank.models;

public class User {
	private Integer id;
	private String name;
	private Integer balance;

	public User(Integer id, String name, Integer balance) {
		this.id = id;
		this.name = name;
		setBalance(balance);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
			System.err.println("Cannot Set Negative Balance:R" + balance + " for user: " + this.name);
		} else {
			this.balance = balance;
		}
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

}
