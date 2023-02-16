package org.atm.accounts;

import org.atm.receipt.TransactionReceipt;
import org.atm.user.menus.InterfacePrompts;
import org.atm.yaml.connect.ConnectYaml;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CheckingAccount  implements CustomerTransactionType {
    private int cardNumber;
	private int pin;
	private int checkingNumber;
	private long checkingBalance;
	private	List<SavingsAccount> savings;
	private int trackTransactions = 0;
	Scanner keyboard = new Scanner(System.in);

	//-------  instantiating classes
	InterfacePrompts interfacePrompts = new InterfacePrompts();
	ConnectYaml connectYaml = new ConnectYaml();
	TransactionReceipt receipt = new TransactionReceipt();
    //------------ create link to yaml file
   /*  File checkingFile = new File("src/main/resources/data/accounts.yml");
	ObjectMapper checkingMapper = new ObjectMapper(new YAMLFactory()); */

	//---------------------- accessors  and mutators -----------------//
	public int getCardNumber() {
		return cardNumber;
	}

	public int getPin() {
		return pin;
	}

	public int getCheckingNumber() {
		return checkingNumber;
	}

	public long getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(long checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public List<SavingsAccount> getSavings() {
		return savings;
	}

	public void setSavings(List<SavingsAccount> savings) {
		this.savings = savings;
	}



	//---------------------------- Methods ----------------------------------//

	public void printCheckingBalance() throws IOException {
	receipt.transactionReceipt(1, "Checking Balance", getCheckingNumber()
		,0, getCheckingBalance());
	}
	@Override
	public void accountDeposit() throws IOException {
		System.out.print(interfacePrompts.transactionPrompts().get(3));
		var depositAmount = keyboard.nextLong();
		connectYaml.updateCustomerAccounts( checkingBalance += depositAmount);
		trackTransactions++;
		receipt.transactionReceipt(2, "Checking Deposit ", checkingNumber , depositAmount, getCheckingBalance());
	}

	@Override
	public void accountWithdraw() throws IOException {
		System.out.print(interfacePrompts.transactionPrompts().get(4));
	   var withdrawAmount = keyboard.nextLong();
		if(withdrawAmount <= checkingBalance)
			connectYaml.updateCustomerAccounts( checkingBalance -= withdrawAmount);
		trackTransactions++;
		receipt.transactionReceipt(3, "Checking Deposit ", checkingNumber , withdrawAmount, getCheckingBalance());
	}

	public void transferFunds(SavingsAccount savings) throws IOException {
		System.out.print(interfacePrompts.transactionPrompts().get(5));
		var	transferAmount = keyboard.nextLong();
		if(checkingBalance >= transferAmount)
			connectYaml.updateCustomerAccounts(	checkingBalance -= transferAmount);
		trackTransactions++;
		receipt.transactionReceipt(3, "Transfer To Savings ", getCheckingNumber() , transferAmount,
			getCheckingBalance());
}


	public String toString() {
		return  "Checking Number: " + checkingNumber + " Checking Balance: " + checkingBalance;
	}




}
