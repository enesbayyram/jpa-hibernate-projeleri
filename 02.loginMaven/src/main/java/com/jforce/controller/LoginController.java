package com.jforce.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.jforce.model.User;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	
	public String login()
	{
		if(user.getUsername().equals("enes") && user.getPassword().equals("123"))
		{
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", user);
			return "/home.xhtml?faces-redirect=true";
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı adı veya şifre hatalı!"));
			return "/login.xhtml?faces-redirect=true";
		}
	}
	

	public User getUser() {
		if (this.user == null) {
			return new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
