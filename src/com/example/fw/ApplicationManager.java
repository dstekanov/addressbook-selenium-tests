package com.example.fw;


public class ApplicationManager {  							
	
	private static ApplicationManager singleton;

	private WebDriverHelper webDriverHelper;				// link to WebDriverHelper class
	private GroupHelper groupHelper;						// link to GroupHelper class
	private NavigationHelper navigationHelper;				// link to NavigationHelper class
	private ContactHelper contactHelper;					// link to ContactHelper class
	
	public static ApplicationManager getInstance() {
		if (singleton == null) {
			singleton = new ApplicationManager();
		}
		return singleton;
	}
	
	public void stop() {		
		if (webDriverHelper != null) {						// call stop() method from WebDriverHelper		
			webDriverHelper.stop();							// if webdriver was initiliazed then stop it
		}							
	}

	public WebDriverHelper getWebDriverHelper() {			// getWebDriverHelper() is used by getDriver() to gain driver from WebDriverHelper class
		if (webDriverHelper == null) {
			webDriverHelper = new WebDriverHelper(this);
		}
		return webDriverHelper;
	}

	public GroupHelper getGroupHelper() {					// getGroupHelper() is used by "GroupCreationTests" test
		if (groupHelper == null) {							// lazy Singleton. Means: this will be initialized by request 
			groupHelper = new GroupHelper(this);
		}
			
		return groupHelper;
	}

	public NavigationHelper getNavigationHelper() {			// getNavigationHelper is used by navigation methods in GroupHelper and ContactHelper classes
		if (navigationHelper == null) {						// lazy Singleton Means: this will be initialized by request 
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	
	public ContactHelper getContactHelper() {				// getContactHelper() is used by "ContactCreationTests" test
		if (contactHelper == null) {						// lazy Singleton Means: this will be initialized by request 
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}

}

