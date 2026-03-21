package com.api.tests;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class UserDetailsAPITest {
	@Test
	public void userDetailsAPITest() {
		Header	authHeader = new Header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NCwiZmlyc3RfbmFtZSI6ImZkIiwibGFzdF9uYW1lIjoiZmQiLCJsb2dpbl9pZCI6ImlhbWZkIiwibW9iaWxlX251bWJlciI6Ijg4OTk3NzY2NTUiLCJlbWFpbF9pZCI6Im1hcmtAZ21haWwuY29tIiwicGFzc3dvcmQiOiI1ZjRkY2MzYjVhYTc2NWQ2MWQ4MzI3ZGViODgyY2Y5OSIsInJlc2V0X3Bhc3N3b3JkX2RhdGUiOm51bGwsImxvY2tfc3RhdHVzIjowLCJpc19hY3RpdmUiOjEsIm1zdF9yb2xlX2lkIjo1LCJtc3Rfc2VydmljZV9sb2NhdGlvbl9pZCI6MSwiY3JlYXRlZF9hdCI6IjIwMjEtMTEtMDNUMDg6MDY6MjMuMDAwWiIsIm1vZGlmaWVkX2F0IjoiMjAyMS0xMS0wM1QwODowNjoyMy4wMDBaIiwicm9sZV9uYW1lIjoiRnJvbnREZXNrIiwic2VydmljZV9sb2NhdGlvbiI6IlNlcnZpY2UgQ2VudGVyIEEiLCJpYXQiOjE3NzQwOTIwNTJ9.UPd8WiR1AJtpsej3wgc9PsxZiV0gZsKHGnhhhPfkhhg");
		given()
			.baseUri("http://64.227.160.186:9000/v1")
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
