package com.learning.imagejsonapi.model;

import org.springframework.stereotype.Component;

@Component
public class UserModel 
{
	private int id;
	private String name;
	private String address;
	private String filename;
	private String path;
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(int id, String name, String address, String filename, String path) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.filename = filename;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", address=" + address + ", filename=" + filename + ", path="
				+ path + "]";
	}
	
	
}
