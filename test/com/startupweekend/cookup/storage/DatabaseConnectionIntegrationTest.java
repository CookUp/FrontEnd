package com.startupweekend.cookup.storage;

import java.util.Arrays;
import java.util.List;

import models.Meal;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.startupweekend.cookup.tools.HttpClient;

public class DatabaseConnectionIntegrationTest {
	private static Logger logger =
			LoggerFactory.getLogger(DatabaseConnectionIntegrationTest.class);

	@Test
	public void find() {
		HttpClient client = new HttpClient();
		DatabaseConnection database = new DatabaseConnection(client);

		Integer mealType = 3;
		Integer location = 1;
		Integer cookId = 2;


		List<Meal> meals = database.find(location, cookId, mealType);
		logger.debug(Arrays.toString(meals.toArray()));
	}

	@Test
	public void closeOrder() {
		HttpClient client = new HttpClient();
		DatabaseConnection database = new DatabaseConnection(client);


		Integer orderId = 1;
		Integer buyerId = 2;

		database.closeOrder(orderId, buyerId);
	}
}
