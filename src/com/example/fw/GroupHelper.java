package com.example.fw;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.example.tests.GroupObjects;

public class GroupHelper extends HelperWithWebDriverBase {
	
	public GroupHelper(ApplicationManager manager) { 					// give parameter: link to the main class
		super(manager);													// call the constructor from super class
	}

	public Set<GroupObjects> getGroups() {
		manager.getNavigationHelper().goToGroupListPage();
		WebElement form = findElements(By.tagName("form")).get(1);					// we found needed form
		List<WebElement> checkboxes = form.findElements(By.name("selected[]"));		// we found needed element
		Set<GroupObjects> groups = new HashSet<GroupObjects>(); 					// created empty set
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			//
			title = title.substring("Select (".length(), title.length()-")".length());
			//
			GroupObjects group = new GroupObjects()
				.setName(title)
				.setId(checkbox.getAttribute("value"));
			groups.add(group);
		}
		return groups;
	}
	
	public void createGroup(GroupObjects groupObject) {
		manager.getNavigationHelper().goToGroupListPage();				// manager - call to ApplicationManager
		initGroupCreation();
		fillGroupForm(groupObject);
		submitCreation();
		manager.getNavigationHelper().returnToGroupListPage();
	}
	
	private void initGroupCreation() {
		findElement(By.name("new")).click();
	}
	
	private void fillGroupForm(GroupObjects groupObject) {
		Reporter.log("filling group form");
		type("group_name", groupObject.name);
		type("group_header", groupObject.header);
		type("group_footer", groupObject.footer);
	}
	
	public void deleteGroup(int i) {
		manager.getNavigationHelper().goToGroupListPage();
		findElement(By.name("selected[]")).click();
		findElement(By.name("delete")).click();
		manager.getNavigationHelper().returnToGroupListPage();
	}

}
