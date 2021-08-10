package com.proje.autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	
	private String firstName;
	
	private String lastName;
	
	@Autowired //applicationContext.xml içinde id değeri address1 olan bean'i buradaki address1 'e bağlar otomatik olarak.
	private Address address1;
	
	public Employee() {

	}

	public Employee(String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address;
	}
	
	public void printEmployeeInfo()
	{
		System.out.println("Adı ve Soyadı : "+firstName + " "+ lastName);
		System.out.println("Adres Bilgileri : ");
		System.out.println("------------------------------------");
		System.out.println("Şehir : " + getAddress().getCity());
		System.out.println("İlçe : " + getAddress().getDistrict());
		System.out.println("Mahalle : " +getAddress().getStreet());
		System.out.println("Numara : " +getAddress().getNo());
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address1;
	}

	public void setAddress(Address address) {
		this.address1 = address;
	}
}
