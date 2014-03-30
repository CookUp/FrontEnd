package com.startupweekend.cookup.storage;

import java.util.List;

import models.Meal;
import models.Order;

import com.startupweekend.cookup.storage.PostMessage.FindParameters;
import com.startupweekend.cookup.tools.HttpClient;
import com.startupweekend.cookup.tools.JsonSerializer;

public class DatabaseConnection {
	private final HttpClient client;

	public DatabaseConnection(HttpClient client) {
		this.client = client;
	}

	public List<Meal> find(Integer locationId, Integer cookId, Integer mealType) {
		PostMessage.FindParameters parameters = new FindParameters();
		parameters.setCook(cookId);
		parameters.setLocation(locationId);
		parameters.setMeal(mealType);

		PostMessage message = new PostMessage(PostMessage.FIND, parameters);
		String postResponse = client.post(message.toJson());
		return JsonSerializer.unserializeList(postResponse, Meal.class);
	}

	public void createOrder() {

	}

	public void closeOrder(Integer orderId, Integer buyerId) {
		Order order = new Order();
		order.setBuyer(buyerId);
		order.setId(orderId);
		PostMessage message = new PostMessage(PostMessage.CLOSE_ORDER, order);
		client.post(message.toJson());
	}
}
