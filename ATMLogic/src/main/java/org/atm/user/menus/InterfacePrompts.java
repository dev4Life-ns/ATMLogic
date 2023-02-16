package org.atm.user.menus;

import java.util.ArrayList;
import java.util.List;


/* Here we store menu options within an ArrayList,
 given its dynamic structure and ability to maintain order.
 Thus, imposing minimal to no cost as opposed to implementing a Hashmap.
 */
public class InterfacePrompts  implements UserInterfacePrompts {

	public void welcomeScreen()  {
		String link = "Welcome to Midwest ATM";
		System.out.printf("_".repeat(20) + link+"_".repeat(25)+"%n");
	}

     @Override
	public void menuOptions() { //method allows user to select transaction type
		List<String> menuItems = new ArrayList<String>();
		menuItems.add("_____________Menu Options____________");
		menuItems.add("1 - Checking Balance");
		menuItems.add("2 - Checking Deposit");
		menuItems.add("3 - Checking Withdraw");
		menuItems.add("4 - Transfer Funds");
		menuItems.add("______________Savings Options__________");
		menuItems.add("5 - Savings Balance");
		menuItems.add("6 - Savings  Deposit");
		menuItems.add("7 - Savings Withdraw");
		menuItems.add("8 - Exit");
		menuItems.add("_______________________________________");

		for (String item : menuItems) {
			System.out.println("\t" +item);
		}
	}

	@Override
	public List<String> transactionPrompts() {
	    List<String>transactionPrompts = new ArrayList<>();
		transactionPrompts.add("Last 5 digits of Card ");//0
		transactionPrompts.add("Enter Pin");//1
		transactionPrompts.add("Re-Enter Pin");//2
		transactionPrompts.add("Checking Deposit Amount => ");//3
		transactionPrompts.add("Checking Withdrawal => $20 |   $40   | $60  |\" +\n" +
			"\t\t\t\t\"$80 |  $100   | $120 ");//4
		transactionPrompts.add("Transfer  Amount => ");//5
		transactionPrompts.add("Savings Deposit Amount => ");//6
		transactionPrompts.add("Savings Withdrawal => ");//7
		transactionPrompts.add("INSUFFICIENT FUNDS");//8
		transactionPrompts.add("Print Receipt? 1- Yes or 2- No");//9
		transactionPrompts.add("Invalid Entry");//10
		return transactionPrompts;
	}

/* 	public void printReceiptOption(int index, TransactionReceipt receipt, String description, int account,
	                               int amount, long balance){
		System.out.println("Print Receipt? 1- Yes or 2- No");
		if(index == 1)
			receipt.transactionReceipt(description,account,amount, balance);
	else
			JOptionPane.showConfirmDialog(null, "Thanks for Choosing Midwest ATM!");
	} */

}














