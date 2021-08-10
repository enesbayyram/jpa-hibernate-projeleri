package com.proje.model.test;

import com.proje.model.Student;
import com.proje.model.Teacher;
import com.proje.model.service.ICrudDAOService;
import com.proje.model.service.impl.CrudDAOServiceImpl;

public class Test {
	public static void main(String[] args) {
		
		ICrudDAOService serviceDao = new CrudDAOServiceImpl();
		 
		Student student =new Student("Enes","Bayram",25,"Erkek");
		Teacher teacher =new Teacher("Sinan","Başarslan",32,"Erkek");
		String a="Enes";
		
		serviceDao.save(student);
		serviceDao.save(teacher);
		
	}
}
