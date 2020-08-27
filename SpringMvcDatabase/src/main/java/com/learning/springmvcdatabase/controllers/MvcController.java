package com.learning.springmvcdatabase.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.learning.springmvcdatabase.model.UserModel;
import com.learning.springmvcdatabase.services.IDOA;

@Controller
public class MvcController 
{
	@Autowired
	IDOA idoaservice;
	
	@Autowired
	UserModel model;
	
	
}
