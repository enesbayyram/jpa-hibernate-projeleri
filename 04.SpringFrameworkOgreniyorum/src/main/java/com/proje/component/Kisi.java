package com.proje.component;

import org.springframework.stereotype.Component;

//applicationContext.xml içinde benim yerime Kisi sınıfından bir bean oluşturacaktır.İd değerine ise bu sınıfın
//baş harfi küçük olacak şekilde(kisi) atayacaktır. <bean id="kisi" class="com.proje.component.Kisi">
//ne zaman kullanılır ? eğer ki bir bean oluşturacaksak ve DEĞER ATAMASI YAPMAYACAKSAK hızlı bir şekilde kullanabiliriz.
@Component
public class Kisi {
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	public Kisi() {

	}

	public Kisi(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	
	public void getKisiInfo()
	{
		System.out.println("Firsname : Enes");
		System.out.println("Lastname : Bayram");
		System.out.println("Age : 22");
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

	@Override
	public String toString() {
		return "Kisi [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
}
