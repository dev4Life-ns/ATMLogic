package org.atm;

import org.atm.accounts.CheckingAccount;
import org.atm.accounts.SavingsAccount;
import org.atm.atm.sessions.UserCredentials;
import org.atm.receipt.TransactionReceipt;
import org.atm.user.menus.InterfacePrompts;
import org.atm.yaml.connect.ConnectYaml;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class ATMDriver {
	public static void main(String[] args) throws IOException, URISyntaxException {
		//class instances
		InterfacePrompts interfacePrompts = new InterfacePrompts();
		CheckingAccount checking = new CheckingAccount();
		SavingsAccount savings = new SavingsAccount();
		UserCredentials credentials = new UserCredentials();
		TransactionReceipt receipt = new TransactionReceipt();
		ConnectYaml connectYaml = new ConnectYaml();

		//-- keyboard scanner grabs user input
		Scanner keyboard = new Scanner(System.in);

		//-- instance variables
		var userSelected = 0;

		//-- validate user credentials
		interfacePrompts.welcomeScreen();

		credentials.validateUserCredentials();

		while (userSelected != -1) {
			interfacePrompts.menuOptions();
			userSelected = keyboard.nextInt();

			  switch (userSelected) {
				  case 1 -> checking.printCheckingBalance();
				  case 2 -> checking.accountDeposit();
				  case 3 -> checking.accountWithdraw();
				  case 4 -> checking.transferFunds(savings);
				 case 5 -> System.out.println(interfacePrompts.transactionPrompts().get(10));

				  }

			  }
		}

	}











