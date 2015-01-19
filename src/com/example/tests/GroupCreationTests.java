package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
	Random rnd = new Random();
	
	@DataProvider(name = "randomGroups")
	public Iterator<Object[]> generateRandomGroups() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 3; i++) {
			GroupObjects group = new GroupObjects()
				.setName("name"+rnd.nextInt())
				.setHeader("header"+rnd.nextInt())
				.setFooter("footer"+rnd.nextInt());
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	@Test(dataProvider = "randomGroups")
	public void testValidGroupCanBeCreated(GroupObjects validGroup) throws Exception {
		Set<GroupObjects> oldList = app.getGroupHelper().getGroups();
		// action
		app.getGroupHelper().createGroup(validGroup);
		// verification
		Set<GroupObjects> newList = app.getGroupHelper().getGroups();
		verifyGroupEdit(oldList, validGroup, newList);
	}
	
	private void verifyGroupEdit(Set<GroupObjects> oldList,
			GroupObjects validGroup, Set<GroupObjects> newList) {
		assertThat(newList.size(), equalTo(oldList.size()+1));
		validGroup.setId("$$$");
		oldList.add(validGroup);
		validGroup.setId(null);
		assertThat(newList, equalTo(oldList));
	}

	@Test
	public void testGroupWithEmprtyDataCanBeCreated() throws Exception {
		GroupObjects emptyDataGroup = new GroupObjects()
			.setName("").setHeader("").setFooter("");
		Set<GroupObjects> oldList = app.getGroupHelper().getGroups();
		// action
		app.getGroupHelper().createGroup(emptyDataGroup);
		// verification
		Set<GroupObjects> newList = app.getGroupHelper().getGroups();
		verifyGroupEdit(oldList, emptyDataGroup, newList);
	}
}
