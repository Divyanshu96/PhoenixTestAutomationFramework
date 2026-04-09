package com.api.tests;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static com.api.constant.Role.*;
import static com.api.utils.AuthTokenProvider.*;
import static com.api.utils.ConfigManager2.*;

import static io.restassured.RestAssured.*;

public class MasterAPITest {
	
	@Test
	public void masterAPITest() {
		given()
		.baseUri(getProperty("BASE_URI")) // helpermethod
		.and() //optionalconjunction
		.header("Authorization",getToken(FD)) //RawHeader
		.and()
		.contentType("") //EmptyContentType
		.log().all() //logrequestsection
		.when()	//action
		.post("master") //postrequest
		.then() //Validateable response
		.log().all()
		.statusCode(200) //assertingStatusCode
		.time(lessThan(1000L)) //assertingresponsetime
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
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Response-schema/MasterAPIResponseSchema.json"));
		
	}
		@Test
		public void InvalidTokenMasterAPITest() {
			given()
			.baseUri(getProperty("BASE_URI")) // helpermethod
			.and() //optionalconjunction
			.header("Authorization","") //RawHeader
			.and()
			.contentType("") //EmptyContentType
			.log().all() //logrequestsection
			.when()	//action
			.post("master") //postrequest
			.then() //Validateable response
			.log().all()
			.statusCode(401);
		
		
}}
