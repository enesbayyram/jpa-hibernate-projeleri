package com.proje.repository;

import java.util.List;

import com.proje.model.Employee;

public interface ICrudDAORepository {
	
	boolean createEmployeeTable();
	
	boolean save(Employee employee);
	
	boolean update(Employee employee);
	
	boolean delete(Integer employeeId);
	
	Employee getEmployeeById(Integer employeeId);
	
	List<Employee> getEmployeeList();
	
}
