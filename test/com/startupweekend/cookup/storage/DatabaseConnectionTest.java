package com.startupweekend.cookup.storage;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import models.Meal;

import org.junit.Test;
import org.mockito.Matchers;

import com.startupweekend.cookup.tools.HttpClient;

public class DatabaseConnectionTest {
	@Test
	public void findNoMatch() {
		String clientResponse = "[]";
		List<Meal> expectedMeal = Collections.<Meal>emptyList();

		find(clientResponse, expectedMeal);
	}

	@Test
	public void findMatch() {
		String clientResponse = "[{\"id\":1},{\"id\":2}]";
		List<Meal> expectedMeal = Arrays.asList(createMeal(1), createMeal(2));

		find(clientResponse, expectedMeal);
	}

	private Meal createMeal(int id) {
		Meal meal = new Meal();
		meal.setId(id);
		return meal;
	}

	private void find(String clientResponse, List<Meal> expectedMeals) {
		HttpClient client = mock(HttpClient.class);
		DatabaseConnection database = new DatabaseConnection(client);

		Integer mealType = 3;
		Integer locationId = 1;
		Integer cookId = 2;

		when(client.post(Matchers.anyString())).thenReturn(clientResponse);


		List<Meal> meals = database.find(locationId, cookId, mealType);


		String expectedBody =
				"{\"action\":" + PostMessage.FIND + ","
				+ "\"data\":{"
				+ "\"meal\":\"" + mealType + "\","
				+ "\"location\":" + locationId  + ","
				+ "\"cook\":" + cookId

				+"}}";
		verify(client).post(expectedBody);

		assertEquals(expectedMeals, meals);
	}

	@Test
	public void closeOrder() {
		String clientResponse = "";

		HttpClient client = mock(HttpClient.class);
		DatabaseConnection database = new DatabaseConnection(client);


		when(client.post(Matchers.anyString())).thenReturn(clientResponse);


		Integer orderId = 1;
		Integer buyerId = 2;

		database.closeOrder(orderId, buyerId);


		String expectedBody =
				"{\"action\":" + PostMessage.CLOSE_ORDER + ","
				+ "\"data\":{\"id\":" + orderId +","
				+ "\"buyer\":" + buyerId
				+ "}}";
		verify(client).post(expectedBody);
	}
}
