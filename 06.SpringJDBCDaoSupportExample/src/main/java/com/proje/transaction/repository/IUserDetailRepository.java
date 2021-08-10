package com.proje.transaction.repository;

import java.util.List;

import com.proje.model.UserDetail;

public interface IUserDetailRepository {
	
	boolean save(Integer userId,UserDetail userdaDetail);
	
	boolean update(UserDetail userDetail);
	
	boolean delete(Integer userDetailId);
	
	UserDetail getUserDetailById(Integer userDetailId);
	
	List<UserDetail> getUserDetailList();

}
