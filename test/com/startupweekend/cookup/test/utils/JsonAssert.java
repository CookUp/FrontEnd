package com.startupweekend.cookup.test.utils;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonAssert {
	private static Logger logger = LoggerFactory.getLogger(JSONAssert.class);

	public static void assertJson(String expected, String actual) {
		try {
			logger.debug("Expected: {}", expected);
			logger.debug("Actual: {}", actual);
			JSONAssert.assertEquals(expected, actual, true);
		} catch (JSONException e) {
			throw new RuntimeException("I couldn't parse JSON", e);
		}
	}
}
