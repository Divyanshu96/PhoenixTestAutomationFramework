package com.api.tests;

import static com.api.constant.Role.FD;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class MasterAPITest {
	
	@Test(description = "Verify if the Master API response is giving correct response" , groups = {"api","regression","smoke"} )
	public void masterAPITest() {
		given()
		.spec(requestSpecWithAuth(FD))
		.when()	//action
		.post("master") //postrequest
		.then() //Validateable response
		.log().all()
		.spec(responseSpec_OK())
		.body("message",equalTo("Success")) //checking K:V
		.body("data", notNullValue())//assertingbodydataisnotnull
		.body("data",hasKey("mst_oem"))
		.body("data",hasKey("mst_model"))
		.body("$",hasKey("message"))
		.body("$",hasKey("data"))
		.body("data.mst_oem.size()", greaterThan(0))
		.body("data.mst_model.size()", greaterThan(0))
		.body("data.mst_oem.id" , everyItem(notNullValue()))
		.body("data.mst_oem.name" , everyItem(notNullValue()))
		.body(matchesJsonSchemaInClasspath("Response-schema/MasterAPIResponseSchema.json"));
		
	}
		@Test(description = "Verify if the Master API response is giving status code for invalid token" , groups = {"api","regression","smoke","negative"} )
		public void InvalidTokenMasterAPITest() {
			given()
			.spec(requestSpec())//EmptyContentType
			.log().all() //logrequestsection
			.when()	//action
			.post("master") //postrequest
			.then() //Validateable response
			.spec(responseSpec_TEXT(401));
		
		
}}