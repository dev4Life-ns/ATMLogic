package org.atm.atm.canister;

public interface Canisters {
	void cashDispenserCanister(int amountDispensed);
	void monetaryItemDepositsCanister(long amountDeposited);
	void cashDepositCanister(int cashDeposits);

}
