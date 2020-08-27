package com.learning.springmvcdb.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.springmvcdb.model.UserModel;

@Component
public interface IDOA 
{

	int insertData(UserModel model);

	List<UserModel> getAllData();

	int updateData(int i, UserModel model);

	UserModel getDataById(int i);

	int deleteData(int i);

	



}
