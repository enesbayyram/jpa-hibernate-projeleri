package com.proje.repository.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proje.db.model.Product;
import com.proje.repository.ICrudDAOService;
import com.proje.repository.rowMapper.ProductRowMapper;

//1-veritabanı işlemleri yapılan sınıf üzerinde tanımlanır.
//2- Aynı component anatasyonu gibi bizim yerimize app.xml 'de bean oluşturur.(ÇOK ÖNEMLİ)
@Repository //<bean id="crudDAOServiceImpl"  class="com.proje.respository.impl.CrudDAOServiceImpl/>
public class CrudDAOServiceImpl1 implements ICrudDAOService{
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createProductTable() {
		
		String query="CREATE TABLE product(productId int,productname varchar(50),price double,avaible int,createdate datetime, primary key(productId))";
		try {
			jdbcTemplate.execute(query);
			System.out.println("Tablo oluşturuldu.");
		} catch (RuntimeException e) {
			System.out.println("Hata : " + e.getMessage());
		}
	}

	@Override
	public boolean save(Product product) {
		try {
			String query="INSERT INTO product (productId,productName,price,avaible,createDate) values(?,?,?,?,?)";
			this.jdbcTemplate.update(query, new Object[] {product.getProductId(),product.getProductname(),product.getPrice(),product.getAvaible(),product.getCreatedate()});
			System.out.println("Product Eklendi.");
			
		} catch (Exception e) {
			System.out.println("Hata : "+ e.getMessage());
			return false;
		}
		return true;
	}
	
	@Override
	public int saveProductList(List<Product> products) {
		String query="INSERT INTO product (productId,productName,price,avaible,createDate) values(?,?,?,?,?)";
		int saveCount=0;
		for (Product product : products) {
			try {
				this.jdbcTemplate.update(query, new Object[] {product.getProductId(),product.getProductname(),product.getPrice(),product.getAvaible(),product.getCreatedate()});
				saveCount++;
			} catch (Exception e) {
				System.out.println("Hata :" + e.getMessage());
			}
		}
		return saveCount;
	}

	@Override
	public Product getProductById(Integer productId) {
		
		String query = "SELECT * FROM product WHERE productId=?";
		Product product=null;
		try {
			product = this.jdbcTemplate.queryForObject(query, new Object[] {productId}, new ProductRowMapper());
		} catch (Exception e) {
			System.out.println("Hata : "+e);
		}
		return product;
	}
	
	public Product getProductByIdBPRM(Integer productId) {
		
		String query = "SELECT * FROM product WHERE productId=?";
		Product product=null;
		try {
//			List<Product> productList = this.jdbcTemplate.query(query, new BeanPropertyRowMapper(Product.class)); // TOPLU SELECT İÇİN
			//Product tablosundaki kolonlar ile Product classı içinde propertyler birbirleri ile aynı isme sahipse otomatik olarak arkada mapliyor.
			//kullandığımız sınıf ismi BeanPropertyRowMapper sınıfı.
			product = this.jdbcTemplate.queryForObject(query, new Object[] {productId},new BeanPropertyRowMapper<>(Product.class));
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
		}
		return product;
	}
	
	@Override
	public List<Product> getProductList() {
		
		String query = "SELECT * FROM product";
		List<Product> productList=null;
		
		try {
			 productList=  this.jdbcTemplate.query(query, new ProductRowMapper());
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
		}
		return productList;
	}
	
	@Override
	public boolean update(Product product) {
		
		String query  = "UPDATE product set productname=?, price=?, avaible=? WHERE productId=?";
		try {
//		 this.jdbcTemplate.update(query, new PreparedStatementSetter() {
//				@Override
//				public void setValues(PreparedStatement ps) throws SQLException {
//					ps.setString(1, product.getProductName());
//					ps.setDouble(2, product.getPrice());
//					ps.setInt(3, product.getAvaible());
//					ps.setInt(4, product.getProductId());
//				}
//			});
		this.jdbcTemplate.update(query, new Object[] {product.getProductname(),product.getPrice(),product.getAvaible(),product.getProductId()});	
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(Integer productId) {
		String query = "DELETE FROM product WHERE productId=?";
		try {
			jdbcTemplate.update(query, new Object[] {productId});
		} catch (Exception e) {
			System.out.println("Hata :"+ e.getMessage());
			return false;
		}
		return true;
	}
	
	@Autowired
	public void setDrivermanager(DataSource dataSource) { //AppConfig ve xml içindeki bean return type ile bu metotun parametre tipi mapleniyor.
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	
}
