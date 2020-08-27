package com.learning.services;

import java.util.List;

import com.learning.models.UserModel;

public interface IDOA {

	boolean isConnected();

	int insertData(UserModel model);

	int updateData(int i, UserModel model);

	List<UserModel> getData();

	UserModel getById(int i);

	int deleteData(int i, UserModel model);

	

	
	

}
