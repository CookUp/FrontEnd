package com.startupweekend.cookup.storage;

import java.util.Collections;
import java.util.List;

import models.Location;
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

	public List<Order> find(Integer locationId, Integer cookId, Integer mealType) {
		PostMessage.FindParameters parameters = new FindParameters();
		parameters.setCook(cookId);
		parameters.setLocation(locationId);
		parameters.setMeal(mealType);

		PostMessage message = new PostMessage(PostMessage.FIND, parameters);
		String postResponse = client.post(message.toJson());
		return JsonSerializer.unserializeList(postResponse, Order.class);
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

	public List<Location> getLocations() {
		String json = "[\n" +
				"        {\n" +
				"            \"id\": 1, \n" +
				"            \"name\": \"Gotico\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 2, \n" +
				"            \"name\": \"Gracia\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 3, \n" +
				"            \"name\": \"Born\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 4, \n" +
				"            \"name\": \"Raval\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 5, \n" +
				"            \"name\": \"Sants\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 6, \n" +
				"            \"name\": \"Poble Sec\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 7, \n" +
				"            \"name\": \"Poble Nou\"\n" +
				"        }\n" +
				"    ]";

		return JsonSerializer.unserializeList(json, Location.class);
	}

	public List<Meal> getMeals() {
		String json = "[{\n" +
				"            \"id\": 1, \n" +
				"            \"description\": \"Paella de la iaia\", \n" +
				"            \"name\": \"Paella\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 2, \n" +
				"            \"description\": \"Garbanzos con anchoas\", \n" +
				"            \"name\": \"SpaghettiCarbonara\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 3, \n" +
				"            \"description\": \"Spaghetti carbonara\", \n" +
				"            \"name\": \"SpaghettiCarbonara\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 4, \n" +
				"            \"description\": \"Crema de puerros\", \n" +
				"            \"name\": \"cremaPuerros\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 5, \n" +
				"            \"description\": \"Bacalao al pil-pil\", \n" +
				"            \"name\": \"bacalaoPilPil\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 6, \n" +
				"            \"description\": \"Tallarines de espinacas con almejas\", \n" +
				"            \"name\": \"tallarinesEspinacasAlmejas\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 7, \n" +
				"            \"description\": \"Cerdo con Roquefort y champiniones\", \n" +
				"            \"name\": \"cerdoRoquefortChampiniones\"\n" +
				"        }, \n" +
				"        {\n" +
				"            \"id\": 8, \n" +
				"            \"description\": \"Botifarra del valles\", \n" +
				"            \"name\": \"botifarra\"\n" +
				"        }]";

		return JsonSerializer.unserializeList(json, Meal.class);
	}

	public List<Order> getRandomOrders() {
		List<Order> orders = find(null, null, null);
		Collections.shuffle(orders);
		return orders.subList(0, 8);
	}
}
