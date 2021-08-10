package com.proje.service;

import java.util.List;

import com.proje.model.Student;

public interface ICrudDAOService {
	
	void save(Student student);
	
	void update(Student student);
	
	void delete(Integer studentId);
	
	Student get(Integer studentId);
	
	List<Student> getStudentList();
	
	
}
