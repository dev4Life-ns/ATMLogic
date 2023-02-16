package org.atm.accounts;

import java.io.IOException;

public interface CustomerTransactionType {

    void accountDeposit() throws IOException;
    void accountWithdraw() throws IOException;


}
