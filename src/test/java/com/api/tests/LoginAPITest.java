package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentials;
import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class LoginAPITest {

	private UserCredentials userCredentials;

	@BeforeMethod(description = "Create the Payload for the Login API")
	public void setup() {
		userCredentials = new UserCredentials("iamfd", "password");
	}

	@Test(description = "Verifying if Login Api is working for fd user", groups = { "api", "regression", "smoke" })
	public void loginAPITest() throws IOException {

		given().spec(requestSpec(userCredentials))
		.when()
		.post("login")
		.then()
		.spec(responseSpec_OK())
		.and()
		.body("message", equalTo("Success")).and()
		.body(matchesJsonSchemaInClasspath("Response-schema/LoginResponseSchema.json"));
	}

}
