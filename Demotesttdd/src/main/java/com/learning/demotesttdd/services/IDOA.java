package com.learning.demotesttdd.services;

import java.util.List;

import com.learning.demotesttdd.models.UserModel;

public interface IDOA {

	boolean isConnected();

	boolean insertData(UserModel model);

	List<UserModel> getAllData();

	List<UserModel> getById(int i);

	boolean updataData(int i, UserModel model);

	int deleteData(int i);

}
