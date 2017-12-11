package com.rivigo.testscript;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import com.rivigo.pojo.response.City_Weather_Forcast_Respone;
import com.rivigo.pojo.response.Forecast;
import com.rivigo.utils.EndPointURL;
import com.rivigo.utils.URL;
import com.rivigo.webservices.methods.Webservices;

public class ExecutionSuite_CheckWeatherAPI {

	Response response;
	String[] locations = { "delhi, in", "copenhagen, dn", "invalid,invalid" };

	@BeforeMethod
	public void setUp() {
		System.out.println("started");
	}

	@DataProvider(name = "locaities")
	public Object[][] DataProvider_GuestDetailPage(Method selectTC) {
		Object result[][] = new Object[locations.length][1];
		for (int i = 0; i < locations.length; i++) {
			result[i][0] = locations[i];
		}
		return result;
	}

	@Test(dataProvider = "locaities")
	public void verify_willItRain(String location) {
		String days = "";
		String url = URL.fixUrl + EndPointURL.CITY_WEATHER.getResourcePath(location);
		System.out.println("Endpoint URL: "+url);
		response = Webservices.Get(url);
		System.out.println("status code " + response.getStatusCode());
		// Response
		//System.out.println(response.asString());

		Gson gson = new Gson();
		// Parsing JSON into java objects
		City_Weather_Forcast_Respone cityForcast = gson.fromJson(response.asString(),
				City_Weather_Forcast_Respone.class);
		// Asserting for invalid locations
		Assert.assertFalse(cityForcast.getQuery().getResults() == null, "Invalid Location");
		List<Forecast> forecast = cityForcast.getQuery().getResults().getChannel().getItem().getForecast();

		for (int i = 0; i < forecast.size() - 3; i++) {
			System.out.print(forecast.get(i).getText() + "\t");
			if (forecast.get(i).getText().contains("Rain") || forecast.get(i).getText().contains("Showers")) {
				// Adding
				days += forecast.get(i).getDate() + ",";
			}
		}
		if (days.length() > 0) {
			System.out.println("\n It will rain in the next 7 days for location :" + location + ", ON : " + days.toString());
			Assert.assertTrue(true, "It will rain in the next 7 days. Dates : ");
		} else {
			Assert.assertTrue(false, "It will not rain in the next 7 days.");
		}

	}
	
	@AfterMethod()
	public void finished()
	{
		System.out.println("Test Case Finished");
	}

}
