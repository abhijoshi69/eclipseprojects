package com.learning.imagejsonapi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.ExtractingResponseErrorHandler;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.learning.imagejsonapi.model.UserModel;
import com.learning.imagejsonapi.services.DOA_Imp;
import com.learning.imagejsonapi.services.IDOA;


@Controller
@MultipartConfig(fileSizeThreshold = 1024*1024*2,maxFileSize = 1024*1024*10,maxRequestSize = 1024*1024*50)
public class ImageJsonApiHomeController
{
	@Autowired
	UserModel model;
	@Autowired
	IDOA idoaservice;
	
	public static String uploadDirectory = "C:\\Users\\rahul\\eclipse-workspace\\ImageJsonApi\\src\\main\\webapp\\images";
	
	
	@RequestMapping(value="/insertUser",method = RequestMethod.POST)

	public @ResponseBody Map insertData(@RequestParam("file") MultipartFile files,@ModelAttribute UserModel model)
	{
		Map userMap = new HashMap();
		idoaservice = new DOA_Imp();
		try
		{
			String fileName = files.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(files.getBytes());
			stream.close();
			
			model.setFilename(fileName);
			model.setPath(filePath);
			
			
			int i = idoaservice.insertData(model);
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
	
	@RequestMapping(value="/getAllData",method = RequestMethod.GET)
	public @ResponseBody Map getAllData()
	{
		Map uMap = new HashMap();
		idoaservice = new DOA_Imp();
		List<UserModel> listMap = new ArrayList();
		listMap = idoaservice.getAllData();
		if(listMap!=null)
		{
			uMap.put("data",listMap);
			uMap.put("Success",true);
		}
		else
		{
			uMap.put("Success",false);
		}
		
		return uMap;
	}
	
	@RequestMapping(value="/oneData",method=RequestMethod.GET)
	public @ResponseBody Map oneData(@RequestParam ("id") int id)
	{
		Map oneMap = new HashMap();
		idoaservice = new DOA_Imp();
		UserModel model = new UserModel();
		try
		{
			model = idoaservice.oneData(id);
			if(model!=null)
			{
				oneMap.put("OneData",model);
				oneMap.put("Success",true);
			}
			else
			{
				oneMap.put("Success",false);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
			oneMap.put("Success",false);
		}
		return oneMap;
	}
	
	@RequestMapping(value="/updateData",method=RequestMethod.POST)
	public @ResponseBody Map updateData(@RequestParam ("id") int id,@RequestParam ("file") MultipartFile files,@ModelAttribute UserModel model)
	{
		Map upMap = new HashMap();
		idoaservice = new DOA_Imp();
		try
		{
			String fileName = files.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			outputStream.write(files.getBytes());
			outputStream.close();
			
			model.setFilename(fileName);
			model.setPath(filePath);
			
			int i = idoaservice.updateData(id, model);
			if(i>0)
			{
				upMap.put("UpdateData",model);
				upMap.put("Success",true);
			}
			else
			{
				upMap.put("Success",false);
			}
		}
		catch (Exception e) 
		{
			System.out.println("Error: "+e.getMessage());
			upMap.put("Success",false);
		}
	
		return upMap;
	}
	
	@RequestMapping(value="/deleteData",method = RequestMethod.POST)
	public @ResponseBody Map deleteData(@RequestParam ("id") int id)
	{
		Map deleteMap = new HashMap();
		idoaservice = new DOA_Imp();
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
		catch (Exception e) 
		{
			System.out.println("Error: "+e.getMessage());
			deleteMap.put("Success",false);
		}
		
		return deleteMap;
	}
}
