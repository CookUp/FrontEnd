package com.startupweekend.cookup.storage;

import static com.startupweekend.cookup.test.utils.JsonAssert.assertJson;
import models.DomainEntity;

import org.junit.Test;

public class PostMessageTest {

	@Test
	public void toJson() {
		int action = PostMessage.FIND;
		DomainEntity entity = null;

		PostMessage msg = new PostMessage(action, entity);
		String actualJson = msg.toJson();

		String expectedMessage = "{\"action\":" + action + ", \"entity\":null}";
		assertJson(expectedMessage, actualJson);
	}

}
