package com.proje.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	
	private String district;
	
	private String city;
	
	private String postalCode;
	
	public Address() {

	}

	public Address(String street, String district, String city, String postalCode) {
		this.street = street;
		this.district = district;
		this.city = city;
		this.postalCode = postalCode;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", district=" + district + ", city=" + city + ", postalCode=" + postalCode
				+ "]";
	}
}
