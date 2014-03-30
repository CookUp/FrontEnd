package controllers;

import java.util.List;

import models.Location;
import models.Meal;
import models.Order;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.landing;

import com.startupweekend.cookup.storage.DatabaseConnection;
import com.startupweekend.cookup.tools.HttpClient;

public class Application extends Controller {
	public static Result index() {
		DatabaseConnection connection = constructConnection();
		List<Order> orders = connection.getRandomOrders();
		return indexWithOrders(orders);
	}

	private static Result indexWithOrders(List<Order> orders) {
		DatabaseConnection connection = constructConnection();
		List<Location> locations = connection.getLocations();
		List<Meal> meals = connection.getMeals();
		return ok(landing.render(locations, meals, orders));
	}

	public static Result find() {
		DynamicForm requestData = Form.form().bindFromRequest();

		Logger.debug("request data: " + requestData);

		Integer locationId = getId(requestData, "locationId");
		Integer cookId = getId(requestData, "cookId");
		Integer mealId = getId(requestData, "mealId");

		Logger.debug("locationId: " + locationId + ", cookId: " + cookId + ", mealId: " + mealId);

		List<Order> orders = constructConnection().find(locationId, cookId, mealId);
		return indexWithOrders(orders);
	}

	private static Integer getId(DynamicForm requestData, String field) {
		try {
			String value = requestData.get(field);
			return Integer.parseInt(value);
		} catch (RuntimeException e) {

			return null;
		}
	}

	private static DatabaseConnection constructConnection() {
		HttpClient client = new HttpClient();
		DatabaseConnection connection = new DatabaseConnection(client);
		return connection;
	}
}
