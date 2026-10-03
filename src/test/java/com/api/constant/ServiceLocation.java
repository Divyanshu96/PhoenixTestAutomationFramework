package com.api.constant;

public enum ServiceLocation {
	SERVICE_LOCATION_A(1), SERVICE_LOCATION_B(2), SERVICE_LOCATION_C(3);

	int code;

	private ServiceLocation (int code) {
		this.code= code;}
	
	public int getCode() {
		return code;
	}
}