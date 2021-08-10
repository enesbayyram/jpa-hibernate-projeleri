package com.proje.model;

import java.util.List;

public class DBConnectionWithInjection {
	
	private Database database;
	
	private Employee employee;
	
	private List<String> databaseList;
		
	public DBConnectionWithInjection() {

	}
	
	
	public void printDatabaseInformation()
	{
		System.out.println("Database Bilgileri");
		System.out.println("URL : " +getDatabase().getUrl());
		System.out.println("Username : " +getDatabase().getUsername());
		System.out.println("Password : " +getDatabase().getPassword());
		System.out.println("********************************************");
		
		System.out.println("Employee Bilgileri : ");
		System.out.println("Firstname : " + getEmployee().getFirstName());
		System.out.println("Lastname : " + getEmployee().getLastName());
		System.out.println("Age : " +getEmployee().getAge());
	}

	public DBConnectionWithInjection(Database database , Employee employee) {
		this.database = database;
		this.employee=employee;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "DBConnectionWithInjection [database=" + database + ", employee=" + employee + ", databaseList="
				+ databaseList + ", getDatabase()=" + getDatabase() + ", getEmployee()=" + getEmployee()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
