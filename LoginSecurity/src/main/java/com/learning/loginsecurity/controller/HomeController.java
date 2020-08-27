package com.learning.loginsecurity.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.learning.loginsecurity.model.UserModel;
import com.learning.loginsecurity.services.IDOA;

@Controller
public class HomeController 
{
	@Autowired
	UserModel model;
	
	@Autowired
	IDOA idoaservice;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register()
	{
		return "register";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String register(@ModelAttribute UserModel model)
	{
		List<GrantedAuthority> authorities = new ArrayList();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		String encodedPassword = bCryptPasswordEncoder.encode(model.getPassword());
		UserModel user = new UserModel(model.getUsername(),encodedPassword);
		int rows = idoaservice.insertCredentials(user);
		if(rows>0)
		{
			return "index";
		}
		else 
		{
			return "register";
		}
	}
	
	@RequestMapping(value="/welcome",method=RequestMethod.POST)
	public String login(@ModelAttribute UserModel model)
	{
		
		//String encodedPass = bCryptPasswordEncoder.encode(model.getPassword());
		boolean check = idoaservice.login(model.getUsername(),model.getPassword());
		System.out.println("Welcome "+check);
		if(check==true)
		{
			return "success";
		}
		else
		{
			return "index";
		}
		//System.out.println("Password is "+model.getPassword());	
		//return "success";
		
		
	}
}
