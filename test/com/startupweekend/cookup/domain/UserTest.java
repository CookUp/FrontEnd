package com.startupweekend.cookup.domain;

import static com.startupweekend.cookup.test.utils.JsonAssert.assertJson;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class UserTest {

	@Test
	public void toJson() {
		Integer id = 1;
		Integer locationId = 2;
		String type = "cooker";
		String name = "great cooker";


		User user = new User(id, locationId, type, name);
		String actualJson = user.toJson();


		String expectedJson =
				"{\"id\":" + id + ","
				+ "\"locationId\":" + locationId + ","
				+ "\"type\":\"cooker\","
				+ "\"name\":\"" + name + "\"}";

		assertJson(expectedJson, actualJson);
	}

	@Test
	public void fromJson() {
		Integer id = 1;
		Integer locationId = 2;
		String type = "cooker";
		String name = "great cooker";

		String json =
				"{\"id\":" + id + ","
				+ "\"locationId\":" + locationId + ","
				+ "\"type\":\"cooker\","
				+ "\"name\":\"" + name + "\"}";


		User actualUser = DomainEntity.fromJson(json, User.class);


		User expectedUser = new User(id, locationId, type, name);
		assertEquals(expectedUser, actualUser);
	}
}
