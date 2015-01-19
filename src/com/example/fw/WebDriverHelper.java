package com.example.fw;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverHelper {
	
	public static WebDriver driver;													// link to WebDriver
	private StringBuffer verificationErrors = new StringBuffer();					// link to WebDriver
	private final ApplicationManager manager;
	
	public WebDriverHelper(ApplicationManager manager) {							// constructor
		this.manager = manager;
		driver = new FirefoxDriver();												// init driver
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			// init driver
		driver.get("http://localhost/addressbookv4.1.4/");
	}

	public void stop() {															// stop method
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	public WebDriver getDriver() {													// gain WebDriver link
		return driver;
	}
}
