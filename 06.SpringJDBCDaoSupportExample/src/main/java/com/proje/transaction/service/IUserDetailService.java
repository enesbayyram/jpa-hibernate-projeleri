package com.proje.transaction.service;

import java.util.List;

import com.proje.model.UserDetail;

public interface IUserDetailService {

	boolean save(Integer userId, UserDetail userdaDetail);

	boolean update(UserDetail userDetail);

	boolean delete(Integer userDetailId);

	UserDetail getUserDetailById(Integer userDetailId);

	List<UserDetail> getUserDetailList();
}
