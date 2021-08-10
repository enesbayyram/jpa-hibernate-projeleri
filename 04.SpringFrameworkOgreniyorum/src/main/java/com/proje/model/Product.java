package com.proje.model;

public class Product {
	
	private String productName;
	
	private double price;
	
	private Integer avaible;
	
	public Product() {

	}

	public Product(String productName, double price, Integer avaible) {
		this.productName = productName;
		this.price = price;
		this.avaible = avaible;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getAvaible() {
		return avaible;
	}

	public void setAvaible(Integer avaible) {
		this.avaible = avaible;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", avaible=" + avaible + "]";
	}
}
