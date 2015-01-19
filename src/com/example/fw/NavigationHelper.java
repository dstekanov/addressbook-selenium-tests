
package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperWithWebDriverBase {
	
	public NavigationHelper(ApplicationManager manager) { 				// give parameter: link to the main class
		super(manager);													// call the constructor from super class
	}

	protected void openAddAddressBookPage() {
		findElement(By.linkText("add new")).click();
	}
	
	public void goToGroupListPage() {
		findElement(By.linkText("groups")).click();
	}
	
	public void openMainPage() {
		openUrl("http://localhost/addressbookv4.1.4/");
	}
	
	public void returnToGroupListPage() {
		findElement(By.linkText("group page")).click();
	}

	public void returnToMainPage() {
		findElement(By.linkText("home page")).click();
	}
	
	
}
