package com.api.tests;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import com.api.utils.SpecUtil;

import static com.api.constant.Role.*;
import static com.api.utils.AuthTokenProvider.*;
import static com.api.utils.ConfigManager2.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static io.restassured.RestAssured.*;

public class CountAPITest {

	@Test
	public void verifyCountAPIResponse() {
		given()
		 .spec(SpecUtil.requestSpecWithAuth(FD))
		 .when()
		 .get("/dashboard/count")
		 .then()
		 .spec(SpecUtil.responseSpec_OK())
		 .body("message",equalTo("Success"))		 
		 .body("data",notNullValue())
		 .body("data.size()",equalTo(3))
		 .body("data.count",everyItem(greaterThanOrEqualTo(0)))
		 .body("data.label",everyItem(not(blankOrNullString())))
		 .body("data.key",containsInAnyOrder("pending_fst_assignment","pending_for_delivery","created_today"))
		 .body(matchesJsonSchemaInClasspath("Response-schema/CountAPIResponseSchema-FD.json"));
	}
		@Test
		public void countAPITest_MissingAuthToken() {
			given()
			 .baseUri(getProperty("BASE_URI"))
			 .spec(SpecUtil.requestSpec())
			 .when()
			 .get("/dashboard/count")
			 .then()			 
			 .spec(SpecUtil.responseSpec_TEXT(401));
		}
	
	}
