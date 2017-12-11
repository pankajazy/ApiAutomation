package com.rivigo.utils;

public enum EndPointURL {

	CITY_WEATHER("/v1/public/yql?q=select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"");

	String resourcePath;

	EndPointURL(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String getResourcePath(String data) {
		return this.resourcePath + data + "\")&format=json&env=store://datatables.org/alltableswithkeys";
	}
}
