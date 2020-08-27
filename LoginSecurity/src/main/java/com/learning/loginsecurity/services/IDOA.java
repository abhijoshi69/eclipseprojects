package com.learning.loginsecurity.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


import com.learning.loginsecurity.model.UserModel;
@Component
public interface IDOA 
{

	int insertCredentials(UserModel user);

	boolean login(String string,String encodedPass);


}
