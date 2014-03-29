package com.startupweekend.cookup.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClient {
	private static Logger logger = LoggerFactory.getLogger(HttpClient.class);

	private static final String DOMAIN = "172.16.0.149";
	private static final int TIMEOUT_IN_SECS = 5;
	private static final String DEFAULT_ENCODING = "utf8";
	private static final int PORT = 8084;
	private static final String SCHEME = "http";
	private static final String URL = "/CookUpDB";

	public String post(String body) {
		DefaultHttpClient httpClient = new DefaultHttpClient();

		HttpHost targetHost = new HttpHost(DOMAIN, PORT, SCHEME);

		logger.debug("Target host {}", targetHost);

		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
				TIMEOUT_IN_SECS * 1000);

		HttpPost postRequest = new HttpPost(URL);

		postRequest.setHeader("Content-Type", "text/json");

		try {
			postRequest.setEntity(new StringEntity(body, DEFAULT_ENCODING));
			HttpResponse response = httpClient.execute(targetHost, postRequest);
			String content = validateResponseAndGetBody(response);
			return content;
		} catch (IOException e) {
			throw new RuntimeException("Problem posting", e);
		}
	}

	private String validateResponseAndGetBody(HttpResponse response) {
		StatusLine statusLine = response.getStatusLine();
		int status = statusLine.getStatusCode();

		if (status != 200) {
			throw new RuntimeException("Some error occurred! (status: "
					+ status + ") " + statusLine);
		}

		return getResponseAsStr(response);
	}

	private String getResponseAsStr(HttpResponse response) {
		try {
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,
					DEFAULT_ENCODING));

			StringWriter writer = new StringWriter();
			String line;
			while (((line = br.readLine()) != null)) {
				writer.write(line);
				writer.write('\n');
			}

			return writer.toString();
		} catch (IOException e) {
			throw new RuntimeException("Problem getting content", e);
		}
	}
}
