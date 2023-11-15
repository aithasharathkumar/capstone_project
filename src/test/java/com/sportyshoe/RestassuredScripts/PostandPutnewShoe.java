package com.sportyshoe.RestassuredScripts;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostandPutnewShoe {

	@Test(priority='1')
	public void add_new_product()
	{
		
		Response response = RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/add-shoe")
				.contentType("application/json")
				.queryParam("id","1020")
				.queryParam("image", "www.imge.com")
				.queryParam("name","Nike")
				.queryParam("category", "Running")
				.queryParam("sizes","5,6,7")
				.queryParam("price", "2000")
				.when()
				.post()
				.then()
				.statusCode(200)
				.body("message",equalTo("Nike Added Successfully."))
				.extract()
				.response();
	
		System.out.println(response.getBody().asPrettyString());
		System.out.println("Status Code " + response.getStatusCode());
		
}
	
	
	@Test(priority='2')
	public void update_a_product()
	{
		
		Response response = RestAssured
				.given()
				.baseUri("http://localhost:9010")
				.basePath("/update-shoe")
				.queryParam("id","1020")
				.queryParam("image", "www.imge123.com")
				.queryParam("name","sketchers")
				.queryParam("category", "Running")
				.queryParam("sizes","5,6,7")
				.queryParam("price", "2500")
				.when()
				.put()
				.then()
				.statusCode(200)
				.body("message",equalTo("sketchers Updated Successfully."))
				.extract()
				.response();
	
		
		System.out.println(response.getBody().asPrettyString());
				
		
}
	
	@Test(priority='3')
	public void delete_product()
	{
		
		RestAssured.given()
		.baseUri("http://localhost:9010")
		.basePath("/delete-shoe")
		.queryParam("id", "1020")
		.when().delete()
		.then().log().all();
		
	}
	
	
}
