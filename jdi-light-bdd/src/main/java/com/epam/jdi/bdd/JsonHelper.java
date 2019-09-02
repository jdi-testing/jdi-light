package com.epam.jdi.bdd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class JsonHelper {
	static Gson gson = (new GsonBuilder()).create();

	public static <T> T deserializeJson(Class<T> model, String json) {
		T modelInstance = gson.fromJson(json, model);
		return modelInstance;
	}

	public static Map<String, String> deserializeJsonToMap(String jsonName) {
		String jsonDataPath = "src/test/resources/jsonData/";
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(jsonDataPath + jsonName + ".json"));
			Map<String, String> map = new HashMap<String, String>();
			map = (Map<String, String>) gson.fromJson(bufferReader, map.getClass());
			return map;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path ");
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
}
