package com.proje.repository;

import java.util.List;

import com.proje.model.Education;

public interface IEducationService {
	
	boolean save(Education education);
	
	boolean update(Education education);
	
	boolean remove(Education education);
	
	List<Education> getAllEducation();
	
	Education getEducationById(Integer educationId);
	
	Education getWithAdvertisement(Integer educationId);
}
