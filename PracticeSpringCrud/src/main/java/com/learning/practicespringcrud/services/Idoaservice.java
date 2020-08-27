package com.learning.practicespringcrud.services;

import org.springframework.stereotype.Component;

import com.learning.practicespringcrud.model.UserModel;

@Component
public interface Idoaservice 
{

	int insertData(UserModel model);

}
