package org.atm.receipt;

import org.atm.sys.SystemClock;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class TransactionReceipt {
	private SystemClock clock = new SystemClock();
	private final int ATM_ID = 9178;
	private final int BRANCH_ID = 28917;
	List<String> transactionDescriptions;

	//----- accessors and mutators
	public int getATM_ID() {
		return ATM_ID;
	}

	public int getBRANCH_ID() {
		return BRANCH_ID;
	}


	//-------------        methods      --------------------------------

	public int generateTransactionSequence() {  //generates sequence number for receipts
		RandomGenerator sequence = RandomGenerator.of("L128X256MixRandom");
		return sequence.nextInt(9999999);
	}

	//-----preFormatted receipt. DO NOT REMOVE WHITESPACES
	public void transactionReceipt(int index, String description, int accountNumber, long transactionAmount,
	                               long balance) {
		ArrayList<String> headerContent = new ArrayList<String>();
		System.out.printf("%n%28s%n", "Midwest ATM\n");
		headerContent.add(clock.displaySystemDateAndTime() + "             Branch " + getBRANCH_ID());
		headerContent.add("ATM " + ATM_ID);
		headerContent.add("____________________________________________");
		headerContent.add("                                    #" + generateTransactionSequence());

		//--- transaction details of receipt

		List<String> transactionInfo = new ArrayList<String>();
		transactionInfo.add(description);
		transactionInfo.add("Account Ending In                  ****" + accountNumber);
		transactionInfo.add("Amount                               $ " + transactionAmount);
		transactionInfo.add("Available Balance                    $ \n" + balance);

		//---- forEach loop iterates through receipt sections
		headerContent.addAll(transactionInfo);
		if (index == 1 || index == 5){
			headerContent.clone();
			headerContent.remove(6);
			headerContent.forEach(System.out::println);
		} else
			 headerContent.forEach(System.out::println);



		}

	}


