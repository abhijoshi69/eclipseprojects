package com.learning.spirngjsonapi.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.spirngjsonapi.model.UserModel;

@Component
public interface IDOA 
{
	public int insertData(UserModel model);
	
	public UserModel viewOneData(int id);
	
	public List<UserModel> viewAll();
	
	public int updateData(int id,UserModel model);
	
	public int deleteData(int id);
}
