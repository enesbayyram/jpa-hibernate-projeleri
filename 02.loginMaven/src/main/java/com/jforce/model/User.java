package com.jforce.model;

public class User {

	private String username;
	private String password;
	
	private boolean isLogin;
	
	public User() {
	}

	public User(String username, String password, boolean isLogin) {
		this.username = username;
		this.password = password;
		this.isLogin = isLogin;
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

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", isLogin=" + isLogin + "]";
	}
	
}
