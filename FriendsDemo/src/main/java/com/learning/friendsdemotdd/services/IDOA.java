package com.learning.friendsdemotdd.services;

import java.util.List;

import com.learning.friendsdemotdd.models.UserModel;

public interface IDOA {

	boolean isConnected();

	boolean insertData(UserModel model);

	List<UserModel> getData();

	List<UserModel> getById(int i);

	int updateData(int i, UserModel model);

	boolean deleteData(int i);

}
