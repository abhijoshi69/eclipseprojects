package com.learning.springloginsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.springloginsecurity.model.UserModel;
import com.learning.springloginsecurity.services.IDOA;

@Controller
public class HomeController 
{
	@Autowired
	UserModel model;
	
	@Autowired 
	IDOA idoaservice;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(value="/registerhere",method=RequestMethod.GET)
	public String registerhere()
	{
		return "register";
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute UserModel model)
	{
		String hashpassword = BCrypt.hashpw(model.getPassword(),BCrypt.gensalt());
		UserModel user = new UserModel(model.getUsername(),hashpassword);
		int rows = idoaservice.insertCredentials(user);
		if(rows>0)
		{
			return "redirect:/";
		}
		else
		{
			return "register";
		}
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute UserModel model)
	{
		boolean check = idoaservice.checkCredentials(model.getUsername(),model.getPassword());
		if(check==true)
		{
			System.out.println("Login Done Successfully!!");
			return "success";
		}
		else
		{
			System.out.println("Invalid Username or Password!!");
			return "redirect:/";
		}
	}

	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logout()
	{
		return "redirect:/";
	}
}
