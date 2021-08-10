package com.proje.transaction.repository;

import java.util.List;

import com.proje.model.User;

public interface IUserRepository {

	boolean save(User user);
	
	boolean update(User user);
	
	boolean delete(Integer userId);
	
	User getUserById(Integer userId);
	
	List<User> getUserList();
	
	User getUserListWithUserDetailById(Integer userId);
}
