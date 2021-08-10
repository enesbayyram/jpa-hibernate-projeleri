package com.proje.model.test;

import java.util.List;

import com.proje.model.Education;
import com.proje.repository.IEducationService;
import com.proje.repository.impl.EducationServiceImpl;

public class EducationTest {

	private static IEducationService educationService =new EducationServiceImpl();
	
	public static void main(String[] args) {
//		
//		List<Education> educationList = educationService.getAllEducation();
//		for (Education education : educationList) {
//			System.out.println(education);
//		}
		
//		Education education = educationService.getEducationById(2);
//		System.out.println(education);
		
		Education education = educationService.getWithAdvertisement(1);
		System.out.println(education);
	}
}
