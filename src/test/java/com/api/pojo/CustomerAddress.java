package com.api.pojo;

public class CustomerAddress {
	private String flat_number;
	private String apartment_name;
	private String street_name;
	private String landmark;
	private String area;
	private String pincode;
	private String country;
	private String state;

	public CustomerAddress(String flat_number, String apartment_name, String street_name, String landmark, String area,
			String pincode, String country, String state) {
		super();
		this.flat_number = flat_number;
		this.apartment_name = apartment_name;
		this.street_name = street_name;
		this.landmark = landmark;
		this.area = area;
		this.pincode = pincode;
		this.country = country;
		this.state = state;
	}

	public String getFlat_number() {
		return flat_number;
	}

	public void setFlat_number(String flat_number) {
		this.flat_number = flat_number;
	}

	public String getApartment_name() {
		return apartment_name;
	}

	public void setApartment_name(String apartment_name) {
		this.apartment_name = apartment_name;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "CustomerAddress [flat_number=" + flat_number + ", apartment_name=" + apartment_name + ", street_name="
				+ street_name + ", landmark=" + landmark + ", area=" + area + ", pincode=" + pincode + ", country="
				+ country + ", state=" + state + "]";
	}

}
