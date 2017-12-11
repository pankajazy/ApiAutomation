package com.rivigo.webservices.methods;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Webservices {

	public static Response Get(String uri)
	{
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(uri);
		return response;
	}
	
	public static Response Post(String uri,String stringJSON)
	{
		RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(uri);
		return response;
	}
	
	public static Response Put(String uri,String stringJSON)
	{
		RequestSpecification requestSpecification = RestAssured.given().body(stringJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(uri);
		return response;
	}
	
/*	public static void loginToApplication(String uri, String userName, String password)
	{
		RequestSpecification requestspecification= RestAssured.given().auth().form(userName, password);
		Response response=requestspecification.get(uri);
	}*/
}
