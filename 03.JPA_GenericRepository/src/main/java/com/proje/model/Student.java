package com.proje.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "firstname",length = 30,nullable = false)
	private String firstName;
	
	@Column(name = "lastname",length = 30,nullable = false)
	private String lastName;
	
	@Column(name = "age",length = 3,nullable = true)
	private Integer age;
	
	@Column(name = "gender",length = 5,nullable = false)
	private String gender;
	
	public Student() {

	}

	public Student(String firstName, String lastName, Integer age, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ "]";
	}
}
