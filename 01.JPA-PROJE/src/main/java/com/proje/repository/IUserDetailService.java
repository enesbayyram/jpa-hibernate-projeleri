package com.proje.repository;

import java.util.List;

import com.proje.model.UserDetail;

public interface IUserDetailService {
	
	boolean save(UserDetail userDetail);
	
	boolean update(UserDetail userDetail);
	
	boolean remove(UserDetail userDetail);
	
	List<UserDetail> getAllUserDetail();
	
	UserDetail getUserDetailByUsername(String username);
	
	UserDetail getWithPhoneListUserDetailByUsername(String username);
}
