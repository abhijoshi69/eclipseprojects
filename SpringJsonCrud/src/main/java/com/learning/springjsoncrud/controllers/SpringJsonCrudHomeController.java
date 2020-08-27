package com.learning.springjsoncrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.springjsoncrud.models.UserModel;
import com.learning.springjsoncrud.services.IDOA;

@Controller
public class SpringJsonCrudHomeController 
{
	@Autowired
	UserModel model;
	
	@Autowired
	IDOA idoaservice;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String index()
	{
		return "";
	}
}
