package com.proje.repository.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.proje.db.model.Product;

public class ProductRowMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Integer productId= rs.getInt("productId");
		String productName=rs.getString("productname");
		double price = rs.getDouble("price");
		int avaible = rs.getInt("avaible");
		Date createDate = rs.getDate("createdate");
		Product product =new Product(productId, productName, price, avaible, createDate);
		
		return product;
	}

}
