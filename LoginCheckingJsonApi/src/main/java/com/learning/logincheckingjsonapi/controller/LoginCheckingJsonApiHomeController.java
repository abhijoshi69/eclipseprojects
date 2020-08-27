package com.learning.logincheckingjsonapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.learning.logincheckingjsonapi.model.UserModel;
import com.learning.logincheckingjsonapi.services.DOA_Imp;
import com.learning.logincheckingjsonapi.services.IDOA;
import com.sun.xml.internal.ws.encoding.ContentType;

@Controller
public class LoginCheckingJsonApiHomeController
{
	@Autowired
	UserModel model;
	
	@Autowired
	IDOA idoaservice;
	
	@RequestMapping(value="/insertCredentials",method = RequestMethod.POST)
	public @ResponseBody Map insertCredentials(@RequestBody UserModel model)
	{
		idoaservice = new DOA_Imp();
		Map userMap = new HashMap();
	
		
		try
		{
			
			int i = idoaservice.insertCredentials(model);
			if(i>0)
			{
				userMap.put("Success",true);
			}
			else
			{
				userMap.put("Success",false);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
			userMap.put("Success",false);
		}
		
		return userMap;
	}
	
	@RequestMapping(value="/checkCredentials",method = RequestMethod.POST)
	public @ResponseBody Map checkCredentials(@RequestBody UserModel model)
	{
		idoaservice = new DOA_Imp();
		Map uMap = new HashMap();
		boolean check = idoaservice.checkCredentials(model.getUsername(),model.getPassword());
		if(check==true)
		{
			uMap.put("Success",true);
		}
		else
		{
			uMap.put("Success",false);
		}
		return uMap;
	}
}
