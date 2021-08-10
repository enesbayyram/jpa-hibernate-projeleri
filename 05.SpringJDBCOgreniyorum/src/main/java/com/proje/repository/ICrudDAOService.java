package com.proje.repository;

import java.util.List;

import com.proje.db.model.Product;

public interface ICrudDAOService {

	boolean save(Product product);
	
	int saveProductList(List<Product> products);
	
	boolean update(Product product);
	
	boolean delete(Integer productId);
	
	Product getProductById(Integer productId);
	
	List<Product> getProductList();
	
	void createProductTable();
}
