package com.proje.transaction.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proje.model.UserDetail;
import com.proje.transaction.repository.IUserDetailRepository;
import com.proje.transaction.service.IUserDetailService;

@Service("userDetailService") // Bu sınıfın service sınıfı olduğunu söyler ve context'e bu sınıftan bean oluşturur(nesne türetir) aynı @Component ve @Repository 'de olduğu gibi.
public class UserDetailServiceImpl implements IUserDetailService,Serializable{

	@Autowired
	private IUserDetailRepository userDetailRepository;
	
	@Override
	public boolean save(Integer userId, UserDetail userdaDetail) {
		return this.userDetailRepository.save(userId, userdaDetail);
	}

	@Override
	public boolean update(UserDetail userDetail) {
		return this.userDetailRepository.update(userDetail);
	}

	@Override
	public boolean delete(Integer userDetailId) {
		return this.userDetailRepository.delete(userDetailId);
	}

	@Override
	public UserDetail getUserDetailById(Integer userDetailId) {
		return this.userDetailRepository.getUserDetailById(userDetailId);
	}

	@Override
	public List<UserDetail> getUserDetailList() {
		return this.userDetailRepository.getUserDetailList();
	}
}
