package com.api.tests;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import com.api.utils.SpecUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

import static com.api.constant.Role.*;
import static com.api.utils.AuthTokenProvider.*;
import static com.api.utils.ConfigManager2.*;

import static io.restassured.RestAssured.*;

public class MasterAPITest {
	
	@Test
	public void masterAPITest() {
		given()
		.spec(SpecUtil.requestSpecWithAuth(FD))
		.when()	//action
		.post("master") //postrequest
		.then() //Validateable response
		.log().all()
		.spec(SpecUtil.responseSpec_OK())
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
			.spec(SpecUtil.requestSpec())//EmptyContentType
			.log().all() //logrequestsection
			.when()	//action
			.post("master") //postrequest
			.then() //Validateable response
			.spec(SpecUtil.responseSpec_TEXT(401));
		
		
}}