package com.api.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import static com.api.utils.DateTimeUtil.*;
import com.api.utils.SpecUtil;

public class CreateJobAPITest {

	@Test
	public void createJobAPITest() {
		// Creating the CreateJObPayload Object
		
		
		Customer customer = new Customer("Divyanshu", "Sharma", "7042705899", "9560586629", "divyansshu786@gmail.com",
				"");
		CustomerAddress customerAddress = new CustomerAddress("1069", "Freinds", "Durga Ashram", "New Delhi",
				"Chhattarpur", "110074", "India", "Delhi");
		CustomerProduct customerProduct = new CustomerProduct(getTimeWithDaysAgo(10), "23353352666799",
				"23353352666799", "23353352666799", getTimeWithDaysAgo(10), 1, 1);
		Problems problems = new Problems(1, "Battery Issue");
		List<Problems> problemsList = new ArrayList<Problems>();
		problemsList.add(problems);

		CreateJobPayload createJobPayload = new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct,
				problemsList);

		given().spec(SpecUtil.requestSpecWithAuth(Role.FD, createJobPayload)).log().all().when().post("/job/create")
				.then()
				.spec(SpecUtil.responseSpec_OK()
						.body(matchesJsonSchemaInClasspath("Response-schema/CreateJobAPIResponseSchema.json")))
				.body("message", equalTo("Job created successfully. ")).body("data.mst_service_location_id", equalTo(1))
				.body("data.job_number", startsWith("JOB_"));

	}

}
