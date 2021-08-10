package com.proje.repository.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.proje.model.Employee;
import com.proje.repository.ICrudDAORepository;

@Repository
public class CrudDAOServiceImpl  extends JdbcDaoSupport implements ICrudDAORepository{

	@Override
	public boolean createEmployeeTable() {
		String query = "CREATE TABLE employee(employeeId INT,firstName VARCHAR(25),lastName VARCHAR(25),gender VARCHAR(5),birthOfDate DATE , createDate DATETIME, PRIMARY KEY(employeeId))";
		try {
			this.getJdbcTemplate().execute(query);

		} catch (Exception e) {
			System.out.println("Hata :"+e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean save(Employee employee) {
		
		String query = "INSERT INTO employee (employeeId,firstName,lastName,gender,birthOfDate,createDate)"
				+ "VALUES(?,?,?,?,?,?)";
	try {
		this.getJdbcTemplate().update(query, new Object[]{employee.getEmployeeId(),employee.getFirstName(),employee.getLastName(),employee.getGender(),employee.getBirthOfDate(),employee.getCreateDate()});
		System.out.println("Employee Kaydedildi.");
	} catch (Exception e) {
		System.out.println("Hata : "+e + " " + e.getMessage() + " " +" " + e.getCause());
		return false;
	}
		return true;
	}

	@Override
	public boolean update(Employee employee) {
		String query = "UPDATE employee SET firstName=?,lastName=?, birthOfDate=? WHERE employeeId=?";
		try {
			this.getJdbcTemplate().update(query, new Object[]{employee.getFirstName(),employee.getLastName(),employee.getBirthOfDate(),employee.getEmployeeId()});
			System.out.println("Employee Güncellendi.");
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage() + " " + e.getCause());
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Integer employeeId) {
		String query = "DELETE FROM employee WHERE employeeId=?";
		try {
			this.getJdbcTemplate().update(query, new Object[] {employeeId});
			System.out.println("Employee Silindi.");
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		String query = "SELECT * FROM employee WHERE employeeId=?";
		Employee employee=null;
		try {
			// BeanPropertyRowMapper =  tablonun kolonları ile classın propertyleri aynı isimlere sahipse arkada benim yerime mapliyor.
			//Aynı isme sahip değilse o  zaman kendi RowMapper'ımızı oluşturabiliriz.
			employee = this.getJdbcTemplate().queryForObject(query, new Object[] {employeeId},new BeanPropertyRowMapper<>(Employee.class));
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployeeList() {
		String query  = "SELECT * FROM employee";
		List<Employee> employeeList=null;
		try {
			employeeList = this.getJdbcTemplate().query(query, new BeanPropertyRowMapper<>(Employee.class));
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
		}
		return employeeList;
	}
	
	@Autowired
	public void setDriverManagerDataSource(DataSource dataSource)
	{
		this.setDataSource(dataSource);
	}

}
