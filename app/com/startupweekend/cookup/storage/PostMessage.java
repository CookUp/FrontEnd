package com.startupweekend.cookup.storage;

import com.startupweekend.cookup.tools.JsonSerializer;

public class PostMessage {
	public static final int FIND = 1;
	public static final int CREATE_ORDER = 2;
	public static final int CLOSE_ORDER = 3;

	private int action;
	private Object data;


	public PostMessage(int action, Object data) {
		this.action = action;
		this.data = data;
	}

	public PostMessage() {
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object entity) {
		this.data = entity;
	}

	public String toJson() {
		return JsonSerializer.serialize(this);
	}

	public static class FindParameters {
		private Integer meal;
		private Integer location;
		private Integer cook;

		public Integer getMeal() {
			return meal;
		}
		public void setMeal(Integer meal) {
			this.meal = meal;
		}
		public Integer getLocation() {
			return location;
		}
		public void setLocation(Integer location) {
			this.location = location;
		}
		public Integer getCook() {
			return cook;
		}
		public void setCook(Integer cook) {
			this.cook = cook;
		}

		public FindParameters() {
			// TODO Auto-generated constructor stub
		}
	}
}
