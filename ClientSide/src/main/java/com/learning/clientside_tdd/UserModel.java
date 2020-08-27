package com.learning.clientside_tdd;

public class UserModel  
{
	private int c_id;
	private String c_name;
	private String c_address;
	private String c_username;
	private int c_password;
	private int c_zip;
	private String c_state;
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public String getC_username() {
		return c_username;
	}
	public void setC_username(String c_username) {
		this.c_username = c_username;
	}
	public int getC_password() {
		return c_password;
	}
	public void setC_password(int c_password) {
		this.c_password = c_password;
	}
	public int getC_zip() {
		return c_zip;
	}
	public void setC_zip(int c_zip) {
		this.c_zip = c_zip;
	}
	public String getC_state() {
		return c_state;
	}
	public void setC_state(String c_state) {
		this.c_state = c_state;
	}
	
	public UserModel(int c_id, String c_name, String c_address, String c_username, int c_password, int c_zip,
			String c_state) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_address = c_address;
		this.c_username = c_username;
		this.c_password = c_password;
		this.c_zip = c_zip;
		this.c_state = c_state;
	}
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "UserModel [c_id=" + c_id + ", c_name=" + c_name + ", c_address=" + c_address + ", c_username="
				+ c_username + ", c_password=" + c_password + ", c_zip=" + c_zip + ", c_state=" + c_state + "]";
	}
}
