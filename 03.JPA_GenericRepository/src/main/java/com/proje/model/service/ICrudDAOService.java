package com.proje.model.service;

import com.proje.model.BaseEntity;

public interface ICrudDAOService {

	<T extends BaseEntity> void save(T dbEntity);
	
	<T extends BaseEntity> void update(T dbEntity);
	
	<T extends BaseEntity> void remove(T dbEntity);
	
	<T extends BaseEntity> T get(T dbEntity,Integer id);
	
}
