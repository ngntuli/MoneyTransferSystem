package com.ngntuli.bank;

import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;

public class AppLauncher {
	private static int userId = 1;

	private static void printUsers(User[] users) {
		System.out.println("-".repeat(66));
		System.out.println("Users");
		System.out.println("-".repeat(66));
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println("-".repeat(66));
	}

	private static void printTransactions(Transaction[] transactions) {
		System.out.println("-".repeat(66));
		System.out.println("Transactions");
		System.out.println("-".repeat(66));
		for (Transaction transaction : transactions) {
			System.out.println(transaction);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		User[] users = new User[3];
		users[0] = new User(userId++, "Charlotte", 100);
		users[1] = new User(userId++, "Nkosinathi", 1_000);
		users[2] = new User(userId++, "HackerOne", -1_000);
		printUsers(users);

		Transaction[] transactions = new Transaction[2];
		transactions[0] = new Transaction(users[1], users[0], 500);
		transactions[1] = new Transaction(users[2], users[0], 100);
		printTransactions(transactions);
		printUsers(users);

	}

}
