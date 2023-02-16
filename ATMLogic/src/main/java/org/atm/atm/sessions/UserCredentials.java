package org.atm.atm.sessions;

import org.atm.sys.ErrorMessages;
import org.atm.user.menus.InterfacePrompts;
import org.atm.yaml.connect.ConnectYaml;

import java.io.IOException;
import java.util.Scanner;

public class UserCredentials {
	InterfacePrompts prompts = new InterfacePrompts();

	Scanner keyboard = new Scanner(System.in);
	ErrorMessages errors = new ErrorMessages();
	ConnectYaml connectYaml = new ConnectYaml();

	public void validateUserCredentials() throws IOException {
		System.out.print(prompts.transactionPrompts().get(0));
		var card = keyboard.nextInt();
		var cardValidation = card == connectYaml.connectCheckingData().getCardNumber() ? prompts.transactionPrompts().get(1) :
			errors.displayErrorMessage().get(0);
		System.out.println(cardValidation);
		var pin2 = keyboard.nextInt();
		if (pin2 != connectYaml.connectCheckingData().getPin()) {
			System.out.print(errors.displayErrorMessage().get(1) + "\n "
				+ prompts.transactionPrompts().get(2));

		}

	}
}
