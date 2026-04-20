package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.pojo.UserCredentials;
import com.api.utils.ConfigManager2;
import com.api.utils.SpecUtil;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginAPITest {
	@Test	
	public void loginAPITest() throws IOException {
		 
		UserCredentials userCredentials = new UserCredentials("iamfd","password");		
		given()			
			.spec(SpecUtil.requestSpec(userCredentials))
			.when()
			.post("login")
		.then()
			.spec(SpecUtil.responseSpec_OK())
		.and()
			.body("message",equalTo("Success"))
		.and()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response-schema/LoginResponseSchema.json"));				
	}
	
	}

