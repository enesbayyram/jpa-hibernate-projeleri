package com.proje.model;

import java.io.Serializable;
import java.util.Date;

public class UserDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer userDetailId;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthOfDate;
	
	public UserDetail() {

	}

	public UserDetail(Integer userDetailId, String firstName, String lastName, Date birthOfDate) {
		this.userDetailId = userDetailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthOfDate = birthOfDate;
	}

	public Integer getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Integer userDetailId) {
		this.userDetailId = userDetailId;
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

	public Date getBirthOfDate() {
		return birthOfDate;
	}

	public void setBirthOfDate(Date birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	@Override
	public String toString() {
		return "UserDetail [userDetailId=" + userDetailId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthOfDate=" + birthOfDate + "]";
	}
}
