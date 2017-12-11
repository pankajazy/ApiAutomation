package com.rivigo.utils;

import java.util.HashMap;

public class APIHeaders {

	HashMap<String, String> headers = new HashMap<String, String>();

	public static HashMap<String, String> getCommonHeaders() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");

		return headers;
	}

	public HashMap<String, String> getNotLoggedInHeaders() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");

		return headers;
	}

	public HashMap<String, String> getHeaders() {
		return headers;
	}

	public void addHeader(HashMap<String, String> existingheaders) {
		for (String key : existingheaders.keySet()) {
			headers.put(key, existingheaders.get(key));
		}
	}

	public void addHeader(String header, String value) {
		headers.put(header, value);
	}

}