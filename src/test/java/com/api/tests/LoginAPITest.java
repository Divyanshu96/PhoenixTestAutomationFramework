package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.utils.ConfigManager2;
import com.restassured.demo.UserCredentials;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginAPITest {
	@Test	
	public void loginAPITest() throws IOException {
		 
		UserCredentials userCredentials = new UserCredentials("iamfd","password");
		
		given()
			
			.baseUri(ConfigManager2.getProperty("BASE_URI"))
		.and()
			.contentType(ContentType.JSON)
			.and()
			.accept(ContentType.JSON)
			.and()
			.body(userCredentials)
			.log().uri()
			.log().method()
			.log().headers()
			.log().body()			
		.when()
			.post("login")
		.then()
			.log().all()
			.statusCode(200)
			.time(lessThan(1000L))
		.and()
			.body("message",equalTo("Success"))
		.and()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response-schema/LoginResponseSchema.json"));
				
	}

	}

