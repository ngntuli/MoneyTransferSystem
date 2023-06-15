package com.ngntuli.bank;

import com.ngntuli.bank.daos.UserDao;
import com.ngntuli.bank.daos.UserDaoImpl;
import com.ngntuli.bank.databases.UserIdsGenerator;
import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;
import com.ngntuli.bank.utilities.TransferCategory;
import com.ngntuli.bank.validators.UserNotFoundException;

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

	private static void printUsersByIds(UserDao users) {
		System.out.println("-".repeat(66));
		System.out.println("User by ID");
		System.out.println("-".repeat(66));
		for (int i = 1; i <= users.size(); i++) {
			System.out.println(users.findUserByID(i));
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
		UserDao users = new UserDaoImpl();
		System.out.println("Number of users - " + users.size());

		users.addUser(new User("A", 100));
		users.addUser(new User("B", 100));
		users.addUser(new User("C", 100));
		users.addUser(new User("D", 100));
		users.addUser(new User("E", 100));

		System.out.println("Number of users - " + users.size());

		users.addUser(new User("F", 100));
		users.addUser(new User("G", 100));
		users.addUser(new User("H", 100));
		users.addUser(new User("I", 100));
		users.addUser(new User("J", 100));
		users.addUser(new User("K", 100));
		users.addUser(new User("L", 100));
		users.addUser(new User("M", 100));

		System.out.println("Number of users - " + users.size());

		users.addUser(new User("N", 100));
		users.addUser(new User("O", 100));
		users.addUser(new User("P", 100));
		users.addUser(new User("Q", 100));
		users.addUser(new User("R", 100));
		users.addUser(new User("S", 100));
		users.addUser(new User("T", 100));
		users.addUser(new User("U", 100));
		users.addUser(new User("V", 100));
		users.addUser(new User("W", 100));
		users.addUser(new User("X", 100));
		users.addUser(new User("Y", 100));
		users.addUser(new User("Z", 100));

		System.out.println("Number of users - " + users.size());
		printUsersByIds(users);

		System.out.println("Try to get User with non existing Name: SS");
		if (users.findUserByName("SS") == null) {
			throw new UserNotFoundException("Exception: User Not Found by Name: SS");
		} else {
			System.out.println("Get by name S - " + users.findUserByName("SS"));
		}

		System.out.println("Try to get User with non existing ID: 150");
		if (users.findUserByID(150) == null) {
			throw new UserNotFoundException("Exception: User Not Found by ID: 150");
		} else {
			System.out.println(users.findUserByID(150));
		}

		System.out.println("Try to add existing User: N");
		users.addUser(new User("N", 100));
		System.out.println("Number of users - " + users.size());

//		Transaction[] transactions = new Transaction[3];
//		transactions[0] = new Transaction(users.findUserByName("S"), users.findUserByName("P"), TransferCategory.DEBIT,
//				50);
//		transactions[1] = new Transaction(users.findUserByName("L"), users.findUserByName("P"), TransferCategory.CREDIT,
//				40);
//		transactions[2] = new Transaction(users.findUserByName("A"), users.findUserByName("E"), TransferCategory.DEBIT,
//				10);
//		printTransactions(transactions);

	}

}
