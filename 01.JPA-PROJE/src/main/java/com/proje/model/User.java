package com.proje.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User.getAllUsers",query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.getUserCount",query = "SELECT count(u) FROM User u"),
	@NamedQuery(name = "User.getUserById",query = "SELECT u FROM User u WHERE u.userId=:userId"),
	@NamedQuery(name = "User.getWithUserDetailById",query = "SELECT u FROM User u LEFT JOIN FETCH u.userDetail WHERE u.userId=:userId"),
	@NamedQuery(name = "User.getWithUserDetailByUsername",query = "SELECT u FROM User u LEFT JOIN FETCH u.userDetail WHERE u.username=:username"),
	@NamedQuery(name = "User.getUserByUsername",query = "SELECT u FROM User u WHERE u.username=:username"),
	@NamedQuery(name = "User.fillUserInfoByUserId",
	query = "SELECT new com.proje.model.UserInfo(u.username,u.userDetail.firstName,u.userDetail.lastName,u.userDetail.birthOfDate) FROM User u WHERE u.userId=:userId"
			),
	@NamedQuery(name = "User.fillUserInfo",
	query = "SELECT new com.proje.model.UserInfo(u.username,u.userDetail.firstName,u.userDetail.lastName,u.userDetail.birthOfDate) FROM User u")
})
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name = "username", length = 30,nullable = false)
	private String username;
	
	@Column(name = "password", length = 30, nullable = false)
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private UserDetail userDetail;
	
	public User() {

	}

	public User(String username, String password, UserDetail userDetail,Date createDate) {
		this.username = username;
		this.password = password;
		this.userDetail=userDetail;
		this.createDate=createDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", createDate="
				+ createDate + ", userDetail=" + userDetail + "]";
	}
}
