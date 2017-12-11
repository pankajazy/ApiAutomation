package com.webservice.services;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class Service {
	@Test
	public void login()
	{	
		// RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 Response resp=RestAssured.get("https://query.yahooapis.com/v1/public/yql?q=select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"nome, ak\")&format=json&env=store://datatables.org/alltableswithkeys");
		 Assert.assertEquals(resp.getStatusCode(), 200);
		 System.out.println(resp.asString());
	}

}
