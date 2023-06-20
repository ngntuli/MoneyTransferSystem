package com.ngntuli.bank.views;

import java.util.List;
import java.util.Scanner;

import com.ngntuli.bank.controllers.TransactionController;
import com.ngntuli.bank.controllers.UserController;
import com.ngntuli.bank.models.Transaction;
import com.ngntuli.bank.models.User;
import com.ngntuli.bank.services.UserService;
import com.ngntuli.bank.validators.IllegalInputDataException;
import com.ngntuli.bank.validators.IllegalTransactionException;
import com.ngntuli.bank.validators.IllegalUserException;

public class View {
	private UserController userController = new UserController();
	private TransactionController trController = new TransactionController();

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		char input;
		do {
			System.out.println("-".repeat(66));
			System.out.println("1. Add a user");
			System.out.println("2. View user balances");
			System.out.println("3. Perform a transfer");
			System.out.println("4. View all transactions for a specific user");
			System.out.println("5. EXIT");

			input = scanner.next().charAt(0);
			switch (input) {
			case '1':
				option1();
				break;
			case '2':
				option2();
				break;
			case '3':
				option3();
				break;
			case '4':
				option4();
				break;
			case '5':
				option5();
				break;

			default:
				defaultOption();
				break;
			}
		} while (input != '5');

	}

	private void option1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a user name and a balance\n");
		String input = scanner.nextLine();

		try {
			String[] inputs = input.split("\\s+");

			if (inputs.length != 2) {
				throw new IllegalInputDataException("Error: Invalid input data");
			}

			String name = inputs[0];
			int balance = checkBalance(inputs[1]);
			String created = userController.create(name, balance);
			System.out.println(created);

		} catch (NumberFormatException e) {
			System.err.println("Error: Invalid number in: " + input);
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}

	private void option2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a user ID\n");
		String input = scanner.nextLine();

		try {
			int id = Integer.parseInt(input);
			System.out.println(userController.getBalance(id));

		} catch (NumberFormatException e) {
			System.err.println("Error: Invalid number in: " + input);
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}

	private void option3() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a sender ID, a recipient ID, and a transfer amount\n");
		String input = scanner.nextLine();

		try {
			String[] inputs = input.split("\\s");
			if (inputs.length != 3) {
				throw new IllegalTransactionException("Error: invalid input, please try again");
			}
			int senderId = Integer.parseInt(inputs[0]);
			int recipientId = Integer.parseInt(inputs[1]);
			int amount = Integer.parseInt(inputs[2]);
			trController.create(senderId, recipientId, amount);
			System.out.println("The transfer is completed");

		} catch (NumberFormatException e) {
			System.err.println("Error: Invalid number in: " + input);
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}

	private void option4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a user ID\n");
		String line = scanner.nextLine();

		try {
			int userId = Integer.parseInt(line);
			List<Transaction> transactions = trController.list(userId);

			if (transactions == null) {
				System.err.println("\t---EMPTY---");
				return;
			}
			printTransactions(userId, transactions);
		} catch (NumberFormatException e) {
			System.err.println("Error: Invalid number in: " + line);
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}

	private void option5() {
		System.out.println("Good bye!");
	}

	private void defaultOption() {
		System.err.println("Error: Invalid input, please enter only [1-5] ");
	}

	private void printTransactions(int userId, List<Transaction> transactions) {
		if (transactions.size() == 0) {
			System.out.println("No transaction records for this user!");
		} else {
			for (Transaction transaction : transactions) {
				User sender = transaction.getSender();
				User recipient = transaction.getRecipient();
				int amount = transaction.getAmount();

				if (userId == sender.getId()) {
					System.out.println("To " + recipient.getName() + "(id = " + recipient.getId() + ") -" + amount
							+ " with id = " + transaction.getId());
				} else {
					System.out.println("From " + sender.getName() + "(id = " + sender.getId() + ") +" + amount
							+ " with id = " + transaction.getId());
				}
			}

		}

	}

	private int checkBalance(String data) {
		int balance = Integer.parseInt(data);

		if (balance < 50) {
			throw new IllegalUserException("Error: Opening account balance cannot be less than 50");
		}
		return balance;
	}
}
