package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperWithWebDriverBase {

	protected final ApplicationManager manager;							// link to the main class (ApplicationManager)
	private WebDriver driver;											// link to the webdriver
	
	public HelperWithWebDriverBase(ApplicationManager manager) { 		// give parameter: link to the main class
		this.manager = manager;											// save link
		driver = manager.getWebDriverHelper().getDriver();				// local call to driver	
	}
	
	protected void type(String locator, String name) {
		findElement(By.name(locator)).click();
		findElement(By.name(locator)).sendKeys(name);
	}
	
	protected void selectFromDropDown(String locator, String name) {
		new Select(findElement(By.name(locator))).selectByVisibleText(name);
	}

	protected WebElement findElement(By name) {
		return driver.findElement(name);
	}
	
	protected List<WebElement> findElements(By name) {
		return driver.findElements(name);
	}

	protected void openUrl(String string) {
		driver.get(string);
	}

	protected void submitCreation() {
		findElement(By.name("submit")).click();
	}
	
	
}
