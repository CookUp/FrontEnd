package com.startupweekend.cookup.tools;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientTest {
	private static Logger logger = LoggerFactory.getLogger(HttpClient.class);
	private final HttpClient client = new HttpClient();

	@BeforeClass
	public static void debugHttpClient() {
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
		System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "debug");
	}

	@Test
	public void postWorking() {
		String url = "/CookUpDB";
		String body = "{\"action\":1,\"data\":{}}";
		String response = client.post(body);

		logger.debug("Response: {}", response);

		assertNotNull(response);
	}
}
