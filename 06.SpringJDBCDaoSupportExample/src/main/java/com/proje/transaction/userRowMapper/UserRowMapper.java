package com.proje.transaction.userRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.proje.model.User;
import com.proje.model.UserDetail;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		Integer userId = rs.getInt("userId");
		String username = rs.getString("username");
		String password  =rs.getString("password");
		Date createDate  = rs.getDate("createDate");
		boolean isActive = rs.getBoolean("isActive");
		
		Integer userDetailId  = rs.getInt("userDetailId");
		String firstName = rs.getString("firstName");
		String lastName = rs.getString("lastName");
		Date birthOfDate  = rs.getDate("birthOfDate");
		
		User user  = new User(userId, username, password, createDate, isActive);
		UserDetail userDetail = new UserDetail(userDetailId, firstName, lastName, birthOfDate);
		user.setUserDetail(userDetail);
		
		return user;
	}

}
