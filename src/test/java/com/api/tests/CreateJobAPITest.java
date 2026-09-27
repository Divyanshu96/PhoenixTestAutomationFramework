package com.api.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.pojo.CreateJobPayload;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.Problems;
import com.api.utils.SpecUtil;

public class CreateJobAPITest {

	@Test
	public void createJobAPITest() {
		// Creating the CreateJObPayload Object
		Customer customer = new Customer("Divyanshu", "Sharma", "7042705899", "9560586629", "divyansshu786@gmail.com",
				"");
		CustomerAddress customerAddress = new CustomerAddress("1069", "Freinds", "Durga Ashram", "New Delhi",
				"Chhattarpur", "110074", "India", "Delhi");
		CustomerProduct customerProduct = new CustomerProduct("2025-06-30T18:30:00.000Z", "19753352666356",
				"19753352666356", "19753352666356", "2025-06-30T18:30:00.000Z", 1, 1);
		Problems problems = new Problems(1, "Battery Issue");
		Problems[] problemsArray = new Problems[1];
		problemsArray[0] = problems;

		CreateJobPayload createJobPayload = new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct,
				problemsArray);

		given().spec(SpecUtil.requestSpecWithAuth(Role.FD, createJobPayload)).log().all().when().post("/job/create")
				.then().spec(SpecUtil.responseSpec_OK());
	}

}
