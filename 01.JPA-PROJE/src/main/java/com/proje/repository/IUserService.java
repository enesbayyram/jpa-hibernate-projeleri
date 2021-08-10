package com.proje.repository;

import java.util.List;

import com.proje.model.User;
import com.proje.model.UserInfo;

public interface IUserService {

	boolean save(User user);
	
	boolean update(User user);
	
	boolean remove(User user);
	
	List<User> getAllUsers();
	
	Long getUserCount();
	
	User getUserById(Integer userId);
	
	User getWithUserDetailById(Integer userId);
	
	User getWithUserDetailByUsername(String username);
	
	User getUserByUsername(String username);
	
	UserInfo fillUserInfoByUserId(Integer userId);
	
	List<UserInfo> fillUserInfo();
}
