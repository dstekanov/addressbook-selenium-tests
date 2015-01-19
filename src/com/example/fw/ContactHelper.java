package com.example.fw;

import com.example.tests.FillAddressBookEntryParameter;

public class ContactHelper  extends HelperWithWebDriverBase {
	
	public ContactHelper(ApplicationManager manager) { 					// give parameter: link to the main class
		super(manager);													// call the constructor from super class
	}

	private void fillAddressBookEntry(FillAddressBookEntryParameter addressObject) {
		type("firstname", addressObject.firstname);
		type("lastname", addressObject.lastname);
		type("address", addressObject.address);
	    type("home", addressObject.home);
	    type("mobile", addressObject.mobile);
	    type("work", addressObject.work);
	    type("email", addressObject.email);
	    type("email2", addressObject.email2);
	    selectFromDropDown("bday", addressObject.bday);
	    selectFromDropDown("bmonth", addressObject.bmonth);
	    type("byear", addressObject.byear);
	    selectFromDropDown("new_group", addressObject.group);
	    type("address2", addressObject.address2);
	    type("phone2", addressObject.phone2);
	}
	
	public void createAddressBook(FillAddressBookEntryParameter validAddress) {
		manager.getNavigationHelper().openAddAddressBookPage();
		fillAddressBookEntry(validAddress);
		submitCreation();
		manager.getNavigationHelper().returnToMainPage();
	}
}
