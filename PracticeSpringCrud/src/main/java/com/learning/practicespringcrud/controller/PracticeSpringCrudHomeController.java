package com.learning.practicespringcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.learning.practicespringcrud.model.UserModel;
import com.learning.practicespringcrud.services.Idoaservice;

@Controller
public class PracticeSpringCrudHomeController 
{
	
	@Autowired
	UserModel model;
	
	@Autowired
	Idoaservice idoa;
}
