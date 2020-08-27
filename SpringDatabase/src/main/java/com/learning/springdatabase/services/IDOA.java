package com.learning.springdatabase.services;

import org.springframework.stereotype.Component;

import com.learning.springdatabase.model.UserModel;
@Component
public interface IDOA 
{

	boolean isConnected();

	int insertData(UserModel model);

}
