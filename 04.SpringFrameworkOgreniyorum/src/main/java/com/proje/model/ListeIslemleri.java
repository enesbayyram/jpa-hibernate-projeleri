package com.proje.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListeIslemleri {

	private String firstName;
	
	private String lastName;
	
	private List<String> usersList=new ArrayList<>();
	
	private Map<String, String> usersMap=new HashMap<>();
	
	public void fill()
	{
		System.out.println("Firstname : "+  this.firstName);
		System.out.println("Lastname : " +this.lastName);
		
		System.out.println("User Listesi :");
		for (String user : usersList) {
			System.out.println(user);
		}
		System.out.println("**************************************");
		
		System.out.println("Map Listesi : " );
		
		Set<String> keySet = usersMap.keySet();
		for (String key : keySet) {
			System.out.println("Key : " +key + " Value : " +usersMap.get(key));
		}
		
	}
	
	
	public ListeIslemleri() {

	}

	public ListeIslemleri(String firstName, String lastName, List<String> usersList, Map<String, String> usersMap) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.usersList = usersList;
		this.usersMap = usersMap;
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


	public List<String> getUsersList() {
		return usersList;
	}


	public void setUsersList(List<String> usersList) {
		this.usersList = usersList;
	}


	public Map<String, String> getUsersMap() {
		return usersMap;
	}


	public void setUsersMap(Map<String, String> usersMap) {
		this.usersMap = usersMap;
	}
}
