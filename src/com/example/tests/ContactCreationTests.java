package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
		
	@Test
	public void testNewAddressBookCanBeCreated() throws Exception {
		FillAddressBookEntryParameter validAddress = new FillAddressBookEntryParameter("Dmytro", "Stekanov", "15 John St", "59067", "0951214775", "52255", "dstekanov@gmail.com", "d.stekanov@astoundcommerce.com", "9",
					"April", "1990", "Rob", "7354 Skillmant St", "333-333-3333");
		app.getContactHelper().createAddressBook(validAddress);  
	}
}
