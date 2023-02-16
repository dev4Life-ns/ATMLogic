
package org.atm.yaml.connect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.atm.accounts.CheckingAccount;
import org.atm.atm.canister.ATMCanisters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConnectYaml {

	//--- methods to read yaml file --------------------------------

  public long readCheckingAccountDataFile() throws IOException {//read yaml file
	  ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	  File file = new File(classLoader.getResource("accounts.yml").getFile());
	  ObjectMapper om = new ObjectMapper(new YAMLFactory());
	  // Mapping the account.yml file  to the CheckingAccount class
	  CheckingAccount checking = om.readValue(file, CheckingAccount.class);
	  return 0;
  }

	//--  method for updating customer accounts  without overriding  existing account details  --------
	public void  updateCustomerAccounts(long updateBalance) throws IOException {
		ObjectMapper mapAccount = new YAMLMapper();
		CheckingAccount checking = mapAccount.readValue(new File("src/main/resources/data/accounts.yml"),
			CheckingAccount.class);
		checking.getCheckingBalance();
		checking.setCheckingBalance(updateBalance);
		mapAccount.writeValue(new FileWriter("src/main/resources/student_modified.yml"), CheckingAccount.class);

	}

	// Method that maps  the currency_dispenser.yml file  to ATMCanister class
	public void  mapToATMCanisters() throws IOException { //maps dispenser to yaml currency_dispenser
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		File file = new File(classLoader.getResource("currency_dispenser.yml").getFile());
		ObjectMapper atmOM = new ObjectMapper(new YAMLFactory());
		ATMCanisters canisters = atmOM.readValue(file,ATMCanisters.class);


	}

	// Method that updates the currency_dispenser.yml file  with current currency values
	public void upateCashDispenser(long updateAmount) throws IOException {
		ObjectMapper mapDispenser = new YAMLMapper();
		ATMCanisters canisters = mapDispenser.readValue(new File("src/main/resources/data/currency_dispenser"),
			ATMCanisters.class);
	    canisters.getCashDispenser();
		//remaining code should make a call request to cash dispenser update yml file.
	}

	public void upateMonetaryCanister(long updateTotal) throws IOException {
		ObjectMapper mapDispenser = new YAMLMapper();
		ATMCanisters canisters = mapDispenser.readValue(new File("src/main/resources/data/currency_dispenser"),
			ATMCanisters.class);
		//remaining code should make a call request to monetary  canister  update yml file.

	}




}
