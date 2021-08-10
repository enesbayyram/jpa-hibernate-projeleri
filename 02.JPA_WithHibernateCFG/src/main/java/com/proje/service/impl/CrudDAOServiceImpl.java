package com.proje.service.impl;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.proje.model.Student;
import com.proje.service.ICrudDAOService;

public class CrudDAOServiceImpl implements ICrudDAOService {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

	@Override
	public void save(Student student) {
		Session session = null;
		try {
			session = factory.openSession();
			Transaction transaction = (Transaction) session.beginTransaction();
			session.save(student);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Hata : " + e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Student student) {
		Session session = null;
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.update(student);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Hata : " + e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Integer studentId) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Student deleteStudent = session.get(Student.class, studentId);
			if (deleteStudent != null) {
				session.delete(deleteStudent);
				session.getTransaction().commit();
			}
		} catch (Exception e) {
			System.out.println("Hata : " + e.getMessage());
		}
	}

	@Override
	public Student get(Integer studentId) {
		Session session = factory.openSession();
		Student student = session.get(Student.class, studentId);
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentList() {
		Session session = factory.openSession();
		List<Student> studentList=null;
		try {
			studentList = session.createQuery("from Student").list();
		} catch (Exception e) {
			System.out.println("Hata : "+e.getMessage());
		}
		return studentList;
	}

}
