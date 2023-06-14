package com.ngntuli.bank;

import com.ngntuli.bank.databases.UserIdsGenerator;
import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;
import com.ngntuli.bank.utilities.TransferCategory;

public class AppLauncher {

	private static void printUsers(User[] users) {
		System.out.println("-".repeat(66));
		System.out.println("Users");
		System.out.println("-".repeat(66));
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println("Last generated Id: " + UserIdsGenerator.getInstance().getId());
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
		users[0] = new User("Charlotte", 100);
		users[1] = new User("Nkosinathi", 1_000);
		users[2] = new User("HackerOne", -1_000);
		printUsers(users);

		Transaction[] transactions = new Transaction[3];
		transactions[0] = new Transaction(users[1], users[0], TransferCategory.DEBIT, 500);
		transactions[1] = new Transaction(users[2], users[0], TransferCategory.CREDIT, 40);
		transactions[2] = new Transaction(users[2], users[0], TransferCategory.DEBIT, 100);
		printTransactions(transactions);
		printUsers(users);

	}

}
