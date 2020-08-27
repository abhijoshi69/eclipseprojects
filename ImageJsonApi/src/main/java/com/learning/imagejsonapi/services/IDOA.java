package com.learning.imagejsonapi.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.imagejsonapi.model.UserModel;


@Component
public interface IDOA 
{
	public int insertData(UserModel model);
	
	public List<UserModel> getAllData();
	
	public UserModel oneData(int id);
	
	public int updateData(int id,UserModel model);
	
	public int deleteData(int id);
}
