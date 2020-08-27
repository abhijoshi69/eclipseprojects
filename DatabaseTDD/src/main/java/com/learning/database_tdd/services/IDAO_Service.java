package com.learning.database_tdd.services;

import java.util.List;

import com.learning.database_tdd.models.UserModel;

public interface IDAO_Service
{

	boolean getConnected();

	List<UserModel> getData();

	int insertedData(UserModel model);

	int updatedData(int i, UserModel model);

	UserModel getById(int i);

	int delete(int i, UserModel model);
	
}
