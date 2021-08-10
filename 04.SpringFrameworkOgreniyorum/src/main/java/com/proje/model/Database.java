package com.proje.model;

import java.util.List;

public class Database {
	
	private String url;
	
	private String username;
	
	private String password;
	
	private List<String> databaseList;
	
	public Database() {

	}

	public Database(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public List<String> getDatabaseList() {
		return databaseList;
	}

	public void setDatabaseList(List<String> databaseList) {
		this.databaseList = databaseList;
	}

	@Override
	public String toString() {
		return "Database [url=" + url + ", username=" + username + ", password=" + password + "]";
	}
}
