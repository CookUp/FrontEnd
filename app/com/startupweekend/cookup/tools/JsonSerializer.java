package com.startupweekend.cookup.tools;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JsonSerializer {
	public static String serialize(Object toSerialize) {
		ObjectMapper mapper = constructMapper(true);
		try {
			return mapper.writeValueAsString(toSerialize);
		} catch (IOException e) {
			throw new RuntimeException("Something went bad!", e);
		}
	}

	public static String serializeKeepNull(Object toSerialize) {
		ObjectMapper mapper = constructMapper(false);
		try {
			return mapper.writeValueAsString(toSerialize);
		} catch (IOException e) {
			throw new RuntimeException("Something went bad!", e);
		}
	}

	public static <T> T unserialize(String json, Class<T> class_) {
		ObjectMapper mapper = constructMapper(true);
		try {
			return mapper.readValue(json, class_);
		} catch (IOException e) {
			throw new RuntimeException("Something went bad!", e);
		}
	}

	public static <T> List<T> unserializeList(String json, Class<T> class_) {
		ObjectMapper mapper = constructMapper(true);
		try {
			TypeFactory factory = TypeFactory.defaultInstance();
			CollectionType collectionType = factory.constructCollectionType(List.class, class_);
			List<T> list = mapper.readValue(json, collectionType);

			return list;
		} catch (IOException e) {
			throw new RuntimeException("Something went bad!", e);
		}
	}

	private static ObjectMapper constructMapper(boolean removeNulls) {
		ObjectMapper mapper = new ObjectMapper();
		if (removeNulls) {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		}
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper;
	}
}
