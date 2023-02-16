package org.atm.accounts;

public class SavingsAccount implements CustomerTransactionType{
	private int savingsNumber;
	private long  savingsBalance;



	//---getters and setters ----------------------

	public long getSavingsBalance() {return savingsBalance;}

	public void setSavingsBalance(long savingsBalance) {this.savingsBalance = savingsBalance;}

	public int getSavingsNumber() {return savingsNumber;}

	public void setSavingsNumber(int savingsNumber) {this.savingsNumber = savingsNumber;}


	//----- methods --------------------------------
	@Override
	public void accountDeposit() {	}

	@Override
	public void accountWithdraw() {

	}

	public String toString() {
		return  "Savings Number: " + savingsNumber +  " Savings Balance  $" +savingsBalance;
	}

}
