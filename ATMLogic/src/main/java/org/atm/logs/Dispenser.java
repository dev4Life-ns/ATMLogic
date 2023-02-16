package org.atm.logs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Dispenser {
	private long twenties;
	private final int totalTransactions = 0;
	private Map<Integer,Integer> transactionLog;


	//---- accessors and mutators
	public long getTwenties() {
		return twenties;
	}

	public void setTwenties(long twenties) {
		this.twenties = twenties;
	}

	public int getTotalTransactions() {
		return totalTransactions;
	}

	public Map<Integer, Integer> getTransactionLog() {
		return transactionLog;
	}

	public void setTransactionLog(Map<Integer, Integer> transactionLog) {
		this.transactionLog = transactionLog;
	}

	//add Transactions keeps track of all account deposits, withdrawals, and transfers
	public void addTransactions(int accountNumber, int transactionAmount) throws IOException {
		ObjectMapper writeTransaction = new ObjectMapper(new YAMLFactory());
		transactionLog.put(accountNumber, transactionAmount);
		writeTransaction.writeValue(new File("src/main/resources/data/currency_dispenser.yml"), transactionLog);
	}
	public void displayTransactionLog(){ //renders transaction log to screen in map form
		System.out.printf("%50s", "Transaction Log");
		transactionLog.forEach((k,v) -> System.out.println("  " + k + " " + v));
	}

}
