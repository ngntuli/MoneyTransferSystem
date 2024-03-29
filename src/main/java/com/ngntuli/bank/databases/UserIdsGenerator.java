package com.ngntuli.bank.databases;

public class UserIdsGenerator {
	private static int id = 0;
	private static final UserIdsGenerator instance = new UserIdsGenerator();

	private UserIdsGenerator() {
	}

	public int generateId() {
		id++;
		return id;
	}

	public int getId() {
		return id;
	}

	public static UserIdsGenerator getInstance() {
		return instance;
	}

}
