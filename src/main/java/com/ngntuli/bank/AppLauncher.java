package com.ngntuli.bank;

import com.ngntuli.bank.databases.DataStore;
import com.ngntuli.bank.views.View;

public class AppLauncher {
	private static View view = new View();

	public static void main(String[] args) {
		System.out.println("\n1. Loading Data...");
		DataStore.getInstance().loadData();
		System.out.println("\n2. Starting Application...");
		view.menu();
	}
}
