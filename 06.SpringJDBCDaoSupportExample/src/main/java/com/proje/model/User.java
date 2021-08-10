package com.proje.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer userId;
	
	private String username;
	
	private String password;
	
	private Date createDate;
	
	private UserDetail userDetail;
	
	private boolean isActive=false;
	
	public User() {

	}

	public User(Integer userId, String username, String password, Date createDate, boolean isActive) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.createDate = createDate;
		this.isActive = isActive;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", createDate="
				+ createDate + ", userDetail=" + userDetail.getUserDetailId() + ", isActive=" + isActive + "]";
	}
}
