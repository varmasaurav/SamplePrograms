package com.tamaram.domain.user;

import java.io.Serializable;

public class User implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email, fullname, password;
	
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

		
}
