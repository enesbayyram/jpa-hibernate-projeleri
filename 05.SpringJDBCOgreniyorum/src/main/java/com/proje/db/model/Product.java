package com.proje.db.model;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer productId;
	
	private String productname;
	
	private double price;
	
	private int avaible;
	
	private Date createdate;
	
	public Product() {

	}

	public Product(Integer productId, String productname, double price, int avaible, Date createdate) {
		this.productId = productId;
		this.productname = productname;
		this.price = price;
		this.avaible = avaible;
		this.createdate = createdate;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvaible() {
		return avaible;
	}

	public void setAvaible(int avaible) {
		this.avaible = avaible;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productname=" + productname + ", price=" + price + ", avaible="
				+ avaible + ", createdate=" + createdate + "]";
	}
	
}

