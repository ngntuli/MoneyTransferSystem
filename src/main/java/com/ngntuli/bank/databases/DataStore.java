package com.ngntuli.bank.databases;

import java.util.ArrayList;
import java.util.List;

import com.ngntuli.bank.models.User;

public class DataStore {
	private static final List<User> USERS = new ArrayList();
	private static final DataStore instance = new DataStore();

	private DataStore() {
	}

	public static DataStore getInstance() {
		return instance;
	}

	public List<User> getUsers() {
		return USERS;
	}

	public void loadData() {
		loadUsers();
	}

	private void loadUsers() {
		USERS.add(new User("Charlotte", 1000));
		USERS.add(new User("Nkosinathi", 1000));
		USERS.add(new User("Prince", 1500));
		USERS.add(new User("Princess", 2000));
	}

	public static int size() {
		return USERS.size();
	}
}
