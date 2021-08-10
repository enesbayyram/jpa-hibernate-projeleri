package com.proje.model;

public class DBConnection {
	
	private String url;
	
	private String username;
	
	private String password;
	
	public DBConnection() {

	}

	public DBConnection(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	
	public void validation()
	{
		if(this.url!=null && this.username!=null && this.password!=null)
		{
			openConnection();
		}else {
			System.out.println("Bağlantı açılırken bir sorun oluştu lütfen tüm bilgileri doldurunuz");
		}
	}
	

	public void openConnection()
	{
		System.out.println("URL :" + getUrl());
		System.out.println(username+" kullanıcı adı ve " + password +" şifresiyle bağlantı açıldı");
	}
	public void closeConnection()
	{
		System.out.println("Bağlantı kapatıldı");
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
}
