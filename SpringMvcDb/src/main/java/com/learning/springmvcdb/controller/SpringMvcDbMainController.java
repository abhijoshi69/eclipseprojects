package com.learning.springmvcdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springmvcdb.model.UserModel;
import com.learning.springmvcdb.services.IDOA;

@Controller
public class SpringMvcDbMainController 
{
	@Autowired
	IDOA idoaservice;
	
	@Autowired
	UserModel model;
	
	@RequestMapping("/")
	public ModelAndView index()
	{
		List<UserModel> model = idoaservice.getAllData();
		ModelAndView mv = new ModelAndView();
		mv.addObject("users",model);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public ModelAndView view(@PathVariable int id)
	{
		UserModel model1 = idoaservice.getDataById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("views",model1);
		mv.setViewName("view");
		return mv;
	}
	
	@RequestMapping("/back")
	public String back()
	{
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id)
	{
		UserModel model2 = idoaservice.getDataById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("edits",model2);
		mv.setViewName("update");
		return mv;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String save(@ModelAttribute UserModel model)
	{
		int id = model.getId();
		int rows = idoaservice.updateData(id, model);
		if(rows>0)
		{
			return "redirect:/";
		}
		return "update";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable int id)
	{
		int rows = idoaservice.deleteData(id);
		if(rows>0)
		{
			return "redirect:/";
		}
		else
		{
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value="/insertpage",method=RequestMethod.POST)
	public String insertpage()
	{
		return "new";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String insertpage(@ModelAttribute UserModel model)
	{
		
		int rows = idoaservice.insertData(model);
		if(rows>0)
		{
			return "redirect:/";
		}
		else
		{
			return "new";
		}
	}
}