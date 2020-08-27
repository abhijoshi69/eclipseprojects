package com.learning.springloginsecurity.services;

import org.springframework.stereotype.Component;

import com.learning.springloginsecurity.model.UserModel;

@Component
public interface IDOA 
{

	int insertCredentials(UserModel model);

	boolean checkCredentials(String string, String string2);

}
