package org.atm.atm.canister;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATMCanisters implements Canisters {
    private long cashDispenserFullTotal= 20000;
	private long currentDispenserBalance;
	private long  monetaryCanisterTotal = 0;
	private long cashDepositTotal = 0;
	private List<Long> cashDispenser;
	private Map<Integer,Object> cashDispenserLog;
	private Map<Integer,Object> monetaryCanisterLog;
	private Map<Integer,Object> cashDepositLog;


	public List<Long> getCashDispenser() {
		return cashDispenser;
	}

	public void setCashDispenser(List<Long> cashDispenser) {
		this.cashDispenser = cashDispenser;
	}

	public Map<Integer, Object> getMonetaryCanisterLog() {
		return monetaryCanisterLog;
	}

	public void setMonetaryCanisterLog(Map<Integer, Object> monetaryCanisterLog) {
		this.monetaryCanisterLog = monetaryCanisterLog;
	}

	public Map<Integer, Object> getCashDepositLog() {
		return cashDepositLog;
	}

	public void setCashDepositLog(Map<Integer, Object> cashDepositLog) {
		this.cashDepositLog = cashDepositLog;
	}

	public long getCashDispenserFullTotal() {
		return cashDispenserFullTotal;
	}

	public long getCurrentDispenserBalance() {
		return currentDispenserBalance;
	}

	public void setCurrentDispenserBalance(long currentDispenserBalance) {
		this.currentDispenserBalance = currentDispenserBalance;
	}

	public long getMonetaryCanisterTotal() {
		return monetaryCanisterTotal;
	}

	public void setMonetaryCanisterTotal(long monetaryCanisterTotal) {
		this.monetaryCanisterTotal = monetaryCanisterTotal;
	}

	public long getCashDepositTotal() {
		return cashDepositTotal;
	}

	public void setCashDepositTotal(long cashDepositTotal) {
		this.cashDepositTotal = cashDepositTotal;
	}

	//----------- Methods
	@Override
	public void cashDispenserCanister(int amountDispensed) {
	 currentDispenserBalance =  cashDispenserFullTotal -= amountDispensed;
	}

	@Override
	public void monetaryItemDepositsCanister(long amountDeposited) {
           monetaryCanisterTotal += amountDeposited;
	}

	@Override
	public void cashDepositCanister(int cashDeposits) {
          cashDepositTotal += cashDeposits;
	}

	public Map<Integer,Object> getCashDepositCashDispenserLog(int accountNumber ,int dispenseAmount){
		cashDispenserLog = new HashMap<>();
		cashDispenserLog.put(accountNumber, dispenseAmount);
		return cashDispenserLog;
	}
}
