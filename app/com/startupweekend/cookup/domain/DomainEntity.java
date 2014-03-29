package com.startupweekend.cookup.domain;

import com.startupweekend.cookup.tools.JsonSerializer;

public class DomainEntity {
	public static <T> T fromJson(String json, Class<T> class_) {
		return JsonSerializer.<T>unserialize(json, class_);
	}

	public String toJson() {
		return JsonSerializer.serialize(this);
	}
}
