package com.api.tests;

import static com.api.utils.AuthTokenProvider.getToken;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import static com.api.constant.Role.*;
import com.api.utils.ConfigManager2;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

public class UserDetailsAPITest {
	@Test
	public void userDetailsAPITest() {
		Header	authHeader = new Header("Authorization", getToken(FD));
		
		given()
			.baseUri(ConfigManager2.getProperty("BASE_URI"))
		.and()
			.header(authHeader)
		.and()
			.accept(ContentType.JSON)
			.log().uri()
			.log().method()
			.log().body()
			.log().headers()
		.when()
			.get("userdetails")
		.then()
			.log().all()
			.statusCode(200)
			.time(lessThan(1000L))
		.and()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response-schema/UserDetailsResponseSchema.json"));
		}

}
