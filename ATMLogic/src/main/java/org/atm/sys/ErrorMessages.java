package org.atm.sys;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessages {
	public List<String> displayErrorMessage() {
	List<String> errorMessage = new ArrayList<String>();
	errorMessage.add("Unable to locate account details. Please contact customer service.");
	errorMessage.add("Invalid pin number. Please try again.");
	errorMessage.add("Invalid Selection. Please try again.");
	return errorMessage;
	}
}
