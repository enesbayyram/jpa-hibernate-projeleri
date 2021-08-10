package com.proje.test;

import java.util.List;

import com.proje.model.Student;
import com.proje.service.ICrudDAOService;
import com.proje.service.impl.CrudDAOServiceImpl;

public class Test {
	public static void main(String[] args) {
		
		ICrudDAOService crudDAOService =new CrudDAOServiceImpl();
		
		Student student  =crudDAOService.get(2);
//		student.setFirstName("Aysun");
//		student.setLastName("Meral");
//		
//		crudDAOService.update(student);
		
		List<Student> studentList=crudDAOService.getStudentList();
		for (Student student2 : studentList) {
			System.out.println(student2);
		}
	}
}
