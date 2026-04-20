package com.api.tests;

import static com.api.utils.AuthTokenProvider.getToken;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import static com.api.constant.Role.*;
import com.api.utils.ConfigManager2;
import com.api.utils.SpecUtil;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

public class UserDetailsAPITest {
	@Test
	public void userDetailsAPITest() {			
		given()
		.spec(SpecUtil.requestSpecWithAuth(FD))
		.when()
			.get("userdetails")
		.then()
			.spec(SpecUtil.responseSpec_TEXT(200))
		.and()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response-schema/UserDetailsResponseSchema.json"));
		}

}
