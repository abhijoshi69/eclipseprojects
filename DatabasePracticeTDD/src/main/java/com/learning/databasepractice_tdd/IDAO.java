package com.learning.databasepractice_tdd;

import java.util.List;

public interface IDAO 
{

	boolean getConnected();

	List<UserModel> getData();

	int insertData(UserModel model);

	int updateData(int i, UserModel model);

	UserModel getById(int i);

	int deleteData(int i, UserModel model);

	

}
