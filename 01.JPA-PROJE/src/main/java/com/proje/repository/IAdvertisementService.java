package com.proje.repository;

import java.util.List;

import com.proje.factory.IFactory;
import com.proje.factory.iml.FactoryImpl;
import com.proje.model.Advertisement;

public interface IAdvertisementService {
	
	IFactory factory =new FactoryImpl();
	
	boolean save(Advertisement advertisement);
	
	boolean update(Advertisement advertisement);
	
	boolean remove(Advertisement advertisement);
	
	List<Advertisement> getAllAdvertisement();
	
	Advertisement getAdvertisementById(Integer advertisementId);
	
	List<Advertisement> getAdvertisementByUsername(String username);
}
