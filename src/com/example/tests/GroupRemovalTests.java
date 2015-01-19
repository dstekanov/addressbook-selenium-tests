package com.example.tests;

import org.testng.annotations.Test;


public class GroupRemovalTests extends TestBase {
		
	@Test
	public void testFirstGroupCanBeRemoved() throws Exception {
		app.getGroupHelper().deleteGroup(0);
		// validate
	}
}
