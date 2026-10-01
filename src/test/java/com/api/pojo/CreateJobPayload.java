package com.api.pojo;

import java.util.List;

public record CreateJobPayload(

		int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id, int mst_oem_id, Customer customer,
		CustomerAddress customer_address, CustomerProduct customer_product, List<Problems> problems) {
}
