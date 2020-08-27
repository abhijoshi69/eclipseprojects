package com.learning.spirngjsonapi.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.learning.spirngjsonapi.model.UserModel;
import com.learning.spirngjsonapi.services.DOA_Imp;
import com.learning.spirngjsonapi.services.IDOA;


@Controller
public class HomeController 
{	
	
	
	@Autowired
	IDOA idoaservice;
	
	@Autowired
	UserModel model;
	
	@RequestMapping(value="/insertUser",method = RequestMethod.POST)
	public @ResponseBody Map insertUserData(@RequestBody UserModel model)
	{
		Map userMap = null;
		idoaservice = new DOA_Imp();
		Gson gson = new Gson();
		try
		{
			//model = gson.fromJson(request.getReader(),UserModel.class);
		
			
			
			int i = idoaservice.insertData(model);
		 	userMap = new HashMap();
		
		 	if(i>0)
			{
				userMap.put("Success",true);
			}
			else
			{
				userMap.put("Success",false);
			}
		 	
		}
		catch (Exception e) 
		{
			System.out.println("Error: "+e.getMessage());
			userMap.put("Success",false);
		}
		
		return userMap;
		
	}

	@RequestMapping(value="/getById",method=RequestMethod.GET)
	public @ResponseBody Map getById(@RequestParam ("id") int id)
	{
		Map map1 = new HashMap();
		idoaservice = new DOA_Imp();
		UserModel model1 = new UserModel();
		try
		{
			model1=	idoaservice.viewOneData(id);
			
			if(model1!=null)
			{
				map1.put("Success",true);
				map1.put("userData",model1);
			}
			else
			{
				map1.put("Success",false);
			}
			
		}
		catch(Exception e)
		{
			map1.put("Success",false);
		}
		return map1;
	}
	
	@RequestMapping(value="/viewAllData",method=RequestMethod.GET)
	public @ResponseBody Map viewAllData()
	{
		idoaservice = new DOA_Imp();
		List<UserModel> userMap = new ArrayList<UserModel>();
		userMap = idoaservice.viewAll();
		Map uMap = new HashMap();
		if(userMap!=null)
		{
			uMap.put("Success",true);
			uMap.put("data",userMap);
		}
		else
		{
			uMap.put("Success",false);
		}
		return uMap;
	}
	
	@RequestMapping(value="/updateData",method=RequestMethod.POST)
	public @ResponseBody Map updateData(@RequestParam ("id") int id,@RequestBody UserModel model)
	{
		idoaservice = new DOA_Imp();
		Map Umap = new HashMap();
		try
		{
			int i = idoaservice.updateData(id, model);
			if(i>0)
			{
				Umap.put("Success",true);
				Umap.put("Data",model);
			}
			else
			{
				Umap.put("Success",false);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
			Umap.put("Success",false);
		}
		return Umap;
	}
	
	@RequestMapping(value="/deleteData",method=RequestMethod.POST)
	public @ResponseBody Map deleteData(@RequestParam ("id") int id)
	{
		idoaservice = new DOA_Imp();
		Map deleteMap = new HashMap();
		try
		{
			int i = idoaservice.deleteData(id);
			if(i>0)
			{
				deleteMap.put("Success",true);
			}
			else
			{
				deleteMap.put("Success",false);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
			deleteMap.put("Success",false);
		}
		return deleteMap;
	}
}
