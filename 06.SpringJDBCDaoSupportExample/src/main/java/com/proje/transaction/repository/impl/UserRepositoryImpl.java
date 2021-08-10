package com.proje.transaction.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proje.model.User;
import com.proje.transaction.repository.IUserRepository;
import com.proje.transaction.userRowMapper.UserRowMapper;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl extends JdbcDaoSupport implements IUserRepository{

	@Override
	public boolean save(User user) {
		String query  = "INSERT INTO user (userId,username,password,createDate,isActive)"
				+ "VALUES(?,?,?,?,?)";
				
		try {
			this.getJdbcTemplate().update(query, new Object[] {user.getUserId(),user.getUsername(),user.getPassword(),user.getCreateDate(),user.isActive()});
			System.out.println("User Eklendi.");
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage() + " Location : " + e.getLocalizedMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean update(User user) {
		String query = "UPDATE user SET username=?,password=?,createDate=?,isActive=? WHERE userId=?";
		try {
			this.getJdbcTemplate().update(query, new Object[] {user.getUsername(),user.getPassword(),user.getCreateDate(),user.isActive(),user.getUserId()});
			System.out.println("User Güncellendi");
		} catch (Exception e) {
			System.out.println("Hata : "+e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Integer userId) {
		
		String queryfindUserDetailId = "SELECT userDetailId FROM user u WHERE u.userId=?";
		String queryDeleteUser = "DELETE FROM user u WHERE u.userId=?";
		String queryDeleteUserDetail = "DELETE FROM userdetail ud WHERE ud.userDetailId=?";
		Integer userDetailId;
		try {
			userDetailId = this.getJdbcTemplate().queryForObject(queryfindUserDetailId, new Object[] {userId}, new RowMapper<Integer>() {

				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					return rs.getInt("userDetailId");
				}
			});
			
			this.getJdbcTemplate().update(queryDeleteUser, new Object[] {userId});
			this.getJdbcTemplate().update(queryDeleteUserDetail, new Object[] {userDetailId});
			System.out.println("User Silindi");
		} catch (Exception e) {
			System.out.println("Hata : "+e.getMessage());
			return false;
		} 
		return true;
	}

	@Override
	public User getUserById(Integer userId) {
		String query = "SELECT * FROM user u WHERE u.userId=?";
		User user=null;
		try {
			user = this.getJdbcTemplate().queryForObject(query, new Object[] {userId},new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					Integer userId = rs.getInt("userId");
					String username = rs.getString("username");
					String password  =rs.getString("password");
					Date createDate  = rs.getDate("createDate");
					boolean isActive = rs.getBoolean("isActive");
					User user = new User(userId, username, password, createDate, isActive);
					return user;
				}
			});
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
		}
		return user;
	}

	@Override
	public List<User> getUserList() {
		String query = "SELECT * FROM user u";
		List<User> userList=null;
		try {
			userList = this.getJdbcTemplate().query(query, new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					Integer userId = rs.getInt("userId");
					String username = rs.getString("username");
					String password  =rs.getString("password");
					Date createDate  = rs.getDate("createDate");
					boolean isActive = rs.getBoolean("isActive");
					User user = new User(userId, username, password, createDate, isActive);
					return user;
				}
			});
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
		}
		return userList;
	}
	
	@Override
	public User getUserListWithUserDetailById(Integer userId) {
		String query = "SELECT * FROM user u INNER JOIN userdetail  ud ON(u.userDetailId=ud.userDetailId) WHERE u.userId=?";
		User user=null;
		try {
			user = this.getJdbcTemplate().queryForObject(query, new Object[] {userId}, new UserRowMapper());
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
		}
		return user;
	}
	
	
	@Autowired
	public void setdataSource(DataSource dataSource)
	{
		setDataSource(dataSource);
	}
}
