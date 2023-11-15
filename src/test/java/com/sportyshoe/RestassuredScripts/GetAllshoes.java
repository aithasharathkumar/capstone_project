package com.sportyshoe.RestassuredScripts;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllshoes {

	
	@Test (priority='1')
	public void get_all_shoes()
	{
		//http://localhost:9010/get-shoes
				Response response = RestAssured
						.given()
						.baseUri("http://localhost:9010")
						.basePath("/get-shoes")
						.when()
						.get()
						.then()
						.statusCode(200)
						.body("message",equalTo("18 Shoes Fetched Successfully."))
						.extract()
						.response();
			
				System.out.println(response.getBody().asPrettyString());
				System.out.println("Status Code " + response.getStatusCode());
	}
	

	@Test(priority='2')
	public void get_all_users()
	{
		
		//http://localhost:9010/get-users
				Response response = RestAssured
						.given()
						.baseUri("http://localhost:9010")
						.basePath("/get-users")
						.when()
						.get()
						.then()
						.statusCode(200)
						.body("message",equalTo("3 Users Fetched Successfully."))
						.extract()
						.response();
			
				System.out.println(response.getBody().asPrettyString());
				System.out.println("Status Code " + response.getStatusCode());
		
	}
}
