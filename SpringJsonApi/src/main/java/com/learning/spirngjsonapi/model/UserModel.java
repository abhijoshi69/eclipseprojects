package com.learning.spirngjsonapi.model;

import org.springframework.stereotype.Component;

@Component
public class UserModel 
{
	private int id;
	private String username;
	private String password;
	private String contactno;
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(int id, String username, String password, String contactno) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.contactno = contactno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", contactno=" + contactno
				+ "]";
	}
	
	
}
