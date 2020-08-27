package com.learning.logincheckingjsonapi.services;

import org.springframework.stereotype.Component;

import com.learning.logincheckingjsonapi.model.UserModel;

@Component
public interface IDOA 
{
	public int insertCredentials(UserModel model);
	
	public boolean checkCredentials(String username,String password);
}
