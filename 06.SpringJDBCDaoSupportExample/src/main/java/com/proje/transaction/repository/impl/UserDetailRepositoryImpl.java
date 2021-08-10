package com.proje.transaction.repository.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proje.model.UserDetail;
import com.proje.transaction.repository.IUserDetailRepository;

@Repository("userDetailRepository") // <bean id="userDetailRepository" class="com.proje.model.UserDetailRepositoryImpl">
@Transactional
public class UserDetailRepositoryImpl extends JdbcDaoSupport implements IUserDetailRepository{

	@Override
	public boolean save(Integer userId, UserDetail userdaDetail) {
		String querySaveUserDetail = "INSERT INTO userdetail(userDetailId,firstName,lastName,birthOfDate)"
				+ "VALUES(?,?,?,?)";
		String queryUpdateUser = "UPDATE user u SET u.userDetailId=? WHERE u.userId=?";
		try {
			this.getJdbcTemplate().update(querySaveUserDetail, new Object[] {userdaDetail.getUserDetailId(),userdaDetail.getFirstName(),userdaDetail.getLastName(),userdaDetail.getBirthOfDate()});
			this.getJdbcTemplate().update(queryUpdateUser, new Object[] {userdaDetail.getUserDetailId(),userId});
			System.out.println("UserDetail eklendi");
		} catch (Exception e) {
			System.out.println("Hata : "+e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean update(UserDetail userDetail) {
		
		String query = "UPDATE userdetail ud SET ud.firstName=?, ud.lastName=?, ud.birthOfDate=? WHERE ud.userDetailId=?";
		try {
			this.getJdbcTemplate().update(query, new Object[] {userDetail.getFirstName(),userDetail.getLastName(),userDetail.getBirthOfDate(),userDetail.getUserDetailId()});
			System.out.println("UserDetail update edildi");
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Integer userDetailId) {
		String query  = "DELETE FROM userdetail ud WHERE ud.userDetailId=?";
		try {
			this.getJdbcTemplate().update(query, new Object[] {userDetailId});
			System.out.println("UserDetail Silindi");
		} catch (Exception e) {
			System.out.println("Hata : "+e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public UserDetail getUserDetailById(Integer userDetailId) {
		
		String query = "SELECT * FROM userdetail ud WHERE ud.userDetailId=?";
		
		UserDetail userDetail = null;
		try {
			userDetail = this.getJdbcTemplate().queryForObject(query, new Object[] {userDetailId},new BeanPropertyRowMapper<>(UserDetail.class));
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
		}
		return userDetail;
	}

	@Override
	public List<UserDetail> getUserDetailList() {
		String query = "SELECT * FROM userdetail ud";
		List<UserDetail> userDetailList=null;
		try {
			userDetailList = this.getJdbcTemplate().query(query, new BeanPropertyRowMapper<>(UserDetail.class));
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
		}
		return userDetailList;
	}
	
	@Autowired
	public void setdataSource(DataSource dataSource)
	{
		setDataSource(dataSource);
	}

}
