package com.learning.springjsoncrud.services;

import com.learning.springjsoncrud.models.UserModel;

public interface IDOA {

	int insertData(UserModel model);

	int updateData(int i,UserModel model);

}
