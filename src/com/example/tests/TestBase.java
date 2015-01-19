package com.example.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import com.example.fw.ApplicationManager;			// import ApplicationManager class from com.example.fw framework


public class TestBase {
	
	protected ApplicationManager app; 				// link to main class ApplicationManager in the framework
	
	@BeforeClass
	public void setUp() throws Exception {
		app = ApplicationManager.getInstance();
		
	}

	@AfterTest
	public void tearDown() throws Exception {
		ApplicationManager.getInstance().stop();	// init stop() method from framework's main class

	}
}