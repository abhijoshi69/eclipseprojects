package com.learning.database_tdd.models;

public class UserModel
{
	

	private int id;
	private String username;
	private String password;
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
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

	public UserModel(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}
