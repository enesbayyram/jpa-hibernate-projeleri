package com.proje.transaction.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proje.model.User;
import com.proje.transaction.repository.IUserRepository;
import com.proje.transaction.service.IUserService;

@Service("userService") // Service sinifi olduğunu söyler ve context'e bu sınıftan bir bean oluşturur aynı @Component veya @Repository anatasyonu gibi.
public class UserServiceImpl implements IUserService, Serializable {
 
	
	@Autowired
	private IUserRepository  userRepository;

	@Override
	public boolean save(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public boolean update(User user) {
		return this.userRepository.update(user);
	}

	@Override
	public boolean delete(Integer userId) {
		return this.userRepository.delete(userId);
	}

	@Override
	public User getUserById(Integer userId) {
		return this.userRepository.getUserById(userId);
	}

	@Override
	public List<User> getUserList() {
		return this.userRepository.getUserList();
	}

	@Override
	public User getUserListWithUserDetailById(Integer userId) {
		return this.userRepository.getUserListWithUserDetailById(userId);
	}
}
