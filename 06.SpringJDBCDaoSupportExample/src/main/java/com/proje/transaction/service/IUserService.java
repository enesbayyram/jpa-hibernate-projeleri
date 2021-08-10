package com.proje.transaction.service;

import java.util.List;

import com.proje.model.User;

public interface IUserService {
	
	boolean save(User user);

	boolean update(User user);

	boolean delete(Integer userId);

	User getUserById(Integer userId);

	List<User> getUserList();

	User getUserListWithUserDetailById(Integer userId);
}
