package com.proje.autowired;

public class Address {
	
	private String no;
	
	private String street;
	
	private String district;
	
	private String city;
	
	public Address() {

	}

	public Address(String no, String street, String district, String city) {
		this.no = no;
		this.street = street;
		this.district = district;
		this.city = city;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
