package com.ngntuli.bank;

import java.util.List;
import java.util.UUID;

import com.ngntuli.bank.daos.TransactionDao;
import com.ngntuli.bank.daos.TransactionDaoImpl;
import com.ngntuli.bank.daos.UserDao;
import com.ngntuli.bank.daos.UserDaoImpl;
import com.ngntuli.bank.databases.DataStore;
import com.ngntuli.bank.databases.UserIdsGenerator;
import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;
import com.ngntuli.bank.services.TransactionService;
import com.ngntuli.bank.services.TransactionServiceImpl;
import com.ngntuli.bank.services.UserService;
import com.ngntuli.bank.services.UserServiceImpl;
import com.ngntuli.bank.utilities.TransferCategory;
import com.ngntuli.bank.validators.UserAlreadyExistsException;
import com.ngntuli.bank.validators.UserNotFoundException;

public class AppLauncher {
	private static UserService userService = new UserServiceImpl();
	private static TransactionService trService = new TransactionServiceImpl();

	private static void printBalance() {

		List<User> users = userService.listAllUser();
		for (User user : users) {
			System.out.println(user.getName() + " balance: " + user.getBalance());
		}
	}

	private static void printTransPerUser() {
		List<User> users = userService.listAllUser();
		for (User user : users) {
			System.out.println(
					user.getName() + ": " + user + "\n" + user.getName() + " list: \n" + user.getTransactions());
			System.out.println();
		}

	}

	public static void main(String[] args) {
		System.out.println("\n1. Loading data ...");
		DataStore.getInstance().loadData();

		System.out.println("\n2. Print Balance ...");
		printBalance();

		System.out.println("\n3. Print balance by user ID: 1");
		System.out.println(userService.getUserById(1).getName() + " balance: " + userService.getBalanceByUserId(1));

		System.out.println("\n4. Print number of users exist: " + userService.countUsers());

		System.out.println("\n5. Create Transactions ...");
		trService.createTransactionByUserId(1, 2, 200);
		trService.createTransactionByUserId(2, 1, 100);
		trService.createTransactionByUserId(2, 1, 150);
		trService.createTransactionByUserId(2, 1, 50);
		trService.createTransactionByUserId(1, 3, 150);
		trService.createTransactionByUserId(1, 4, 500);
		trService.createTransactionByUserId(3, 4, 110);
		trService.createTransactionByUserId(2, 4, 120);
		trService.createTransactionByUserId(1, 4, 150);

		System.out.println("\n6. Print Transactions Per User ...");
		printTransPerUser();

		System.out.println("\n7. Remove Transactions ...");
		UUID id1 = userService.getUserById(1).getTransactions().get(0).getId();
		UUID id2 = userService.getUserById(1).getTransactions().get(1).getId();
		UUID id3 = userService.getUserById(1).getTransactions().get(2).getId();
		trService.removeTransactionById(id1);
		trService.removeTransactionById(id2);
		trService.removeTransactionById(id3);

		System.out.println("\n8. Print Transactions Per User ...");
		printTransPerUser();

		System.out.println("\n9. Wrong Case ...");
		trService.createTransactionByUserId(1, 2, 5600);
	}
}
