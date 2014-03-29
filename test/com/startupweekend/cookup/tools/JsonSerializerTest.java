package com.startupweekend.cookup.tools;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.startupweekend.cookup.domain.Meal;

public class JsonSerializerTest {

	@Test
	public void unserializeEmptyList() {
		String json = "[]";

		List<Meal> meals = JsonSerializer.unserializeList(json, Meal.class);

		assertEquals(Collections.emptyList(), meals);
	}

	@Test
	public void unserializeList() {
		String json = "[{\"id\":1}]";

		List<Meal> meals = JsonSerializer.unserializeList(json, Meal.class);

		Meal meal = new Meal();
		meal.setId(1);
		assertEquals(Arrays.asList(meal), meals);
	}
}
