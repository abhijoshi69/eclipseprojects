package com.learning.springmvcdatabase.services;

import com.learning.springmvcdatabase.model.UserModel;

public interface IDOA 
{

	boolean isConnected();

	int insertData(UserModel model);

}
