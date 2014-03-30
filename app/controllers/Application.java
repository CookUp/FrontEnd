package controllers;


import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.landing;

public class Application extends Controller {
	public static Result index() {
		return ok(landing.render());
	}

	public static Result find(String locationId) {
		Logger.debug("-->" + locationId);
		return null;
	}
}
