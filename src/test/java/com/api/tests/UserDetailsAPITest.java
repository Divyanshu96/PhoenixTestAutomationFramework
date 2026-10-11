package com.api.tests;

import static com.api.constant.Role.FD;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class UserDetailsAPITest {
	@Test(description = "Verify if the user details API response is shown correctly" , groups = {"api","smoke","regression"} )
	public void userDetailsAPITest() {			
		given()
		.spec(requestSpecWithAuth(FD))
		.when()
			.get("userdetails")
		.then()
			.spec(responseSpec_TEXT(200))
		.and()
			.body(matchesJsonSchemaInClasspath("Response-schema/UserDetailsResponseSchema.json"));
		}

}
