package com.ngntuli.bank;

import java.util.UUID;

import com.ngntuli.bank.daos.TransactionDao;
import com.ngntuli.bank.daos.TransactionDaoImpl;
import com.ngntuli.bank.daos.UserDao;
import com.ngntuli.bank.daos.UserDaoImpl;
import com.ngntuli.bank.databases.UserIdsGenerator;
import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;
import com.ngntuli.bank.utilities.TransferCategory;
import com.ngntuli.bank.validators.UserAlreadyExistsException;
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
			System.out.println(users.find(i));
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
//		UserDao users = new UserDaoImpl();
//		System.out.println("Number of users - " + users.size());
//
//		users.addUser(new User("A", 100));
//		users.addUser(new User("B", 100));
//		users.addUser(new User("C", 100));
//		users.addUser(new User("D", 100));
//		users.addUser(new User("E", 100));
//
//		System.out.println("Number of users - " + users.size());
//
//		users.addUser(new User("F", 100));
//		users.addUser(new User("G", 100));
//		users.addUser(new User("H", 100));
//		users.addUser(new User("I", 100));
//		users.addUser(new User("J", 100));
//		users.addUser(new User("K", 100));
//		users.addUser(new User("L", 100));
//		users.addUser(new User("M", 100));
//
//		System.out.println("Number of users - " + users.size());
//
//		users.addUser(new User("N", 100));
//		users.addUser(new User("O", 100));
//		users.addUser(new User("P", 100));
//		users.addUser(new User("Q", 100));
//		users.addUser(new User("R", 100));
//		users.addUser(new User("S", 100));
//		users.addUser(new User("T", 100));
//		users.addUser(new User("U", 100));
//		users.addUser(new User("V", 100));
//		users.addUser(new User("W", 100));
//		users.addUser(new User("X", 100));
//		users.addUser(new User("Y", 100));
//		users.addUser(new User("Z", 100));
//
//		System.out.println("Number of users - " + users.size());
//		printUsersByIds(users);
//
//		System.out.println("Try to get User with non existing Name: SS");
//		if (users.findUserByName("SS") == null) {
//			throw new UserNotFoundException("Exception: User Not Found by Name: SS");
//		} else {
//			System.out.println("Get by name S - " + users.findUserByName("SS"));
//		}
//
//		System.out.println("Try to get User with non existing ID: 150");
//		if (users.findUserByID(150) == null) {
//			throw new UserNotFoundException("Exception: User Not Found by ID: 150");
//		} else {
//			System.out.println(users.findUserByID(150));
//		}
//
//		System.out.println("Try to add existing User: N");
//		users.addUser(new User("N", 100));
//		System.out.println("Number of users - " + users.size());

//		Transaction[] transactions = new Transaction[3];
//		transactions[0] = new Transaction(users.findUserByName("S"), users.findUserByName("P"), TransferCategory.DEBIT,
//				50);
//		transactions[1] = new Transaction(users.findUserByName("L"), users.findUserByName("P"), TransferCategory.CREDIT,
//				40);
//		transactions[2] = new Transaction(users.findUserByName("A"), users.findUserByName("E"), TransferCategory.DEBIT,
//				10);
//		printTransactions(transactions);
//		System.out.println("User added: " + user.getName());
//		throw new UserAlreadyExistsException("Exception: User already exist - " + user);

		User user1 = new User("Charlotte", 1000);
		User user2 = new User("Nkosinathi", 1000);

		UserDao users = new UserDaoImpl();
		users.add(user1);
		users.add(user2);

		System.out.println("-".repeat(66));
		System.out.println("USERS: ");
		System.out.println("-".repeat(66));
		System.out.println("Charlotte: " + user1 + "\nCharlotte list: \n" + user1.getTransactions());
		System.out.println("Nkosinathi: " + user2 + "\nNkosinathi list: \n" + user2.getTransactions());
		System.out.println("-".repeat(66));

		System.out.println("\nLET'S CREATE TRANSACTIONS:");
		System.out.println("-".repeat(66));
		TransactionDao transactionDao = new TransactionDaoImpl();
		transactionDao.add(new Transaction(user1, user2, TransferCategory.DEBIT, 200));
		transactionDao.add(new Transaction(user1, user2, TransferCategory.CREDIT, 100));
		transactionDao.add(new Transaction(user1, user2, TransferCategory.CREDIT, 150));
		transactionDao.add(new Transaction(user1, user2, TransferCategory.CREDIT, 500));

		System.out.println("Charlotte: " + user1 + "\nCharlotte list: \n" + user1.getTransactions());
		System.out.println("-".repeat(166));
		System.out.println("Nkosinathi: " + user2 + "\nNkosinathi list: \n" + user2.getTransactions());
		System.out.println("-".repeat(166));

		System.out.println("\nREMOVE TRANSACTION:");
		System.out.println("-".repeat(66));
//        Transaction[] transactions = user1.getList().toArray();
		UUID transToRemove = user1.getTransactions().get(0).getId();

		boolean removed = transactionDao.remove(transToRemove);
		if (removed) {
			System.out.println("RemovedTransaction ID: " + transToRemove);
		} else {
			System.out.println("Failed");
		}

		System.out.println("-".repeat(66));
//        
		System.out.println("Charlotte: " + user1 + "\nCharlotte list: \n" + user1.getTransactions());
		System.out.println("-".repeat(166));
		System.out.println("Nkosinathi: " + user2 + "\nNkosinathi list: \n" + user2.getTransactions());
		System.out.println("-".repeat(166));

		try {
			System.out.println("\nTRY TO REMOVE TRANSACTION WITH WRONG UUID:");
			System.out.println("-".repeat(66));
			transactionDao.remove(UUID.randomUUID());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

}
