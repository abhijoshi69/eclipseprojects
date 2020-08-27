package com.learning.mvcspring.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learning.mvcspring.model.UserModel;

@Controller
public class UserClass 
{
	@Autowired
	UserModel userModel;
	
	@RequestMapping("/")
	public ModelAndView hello()
	{
		userModel.setId("101");
		userModel.setName("Abhishek");
		userModel.setAddress("Vile Parle");
		ModelAndView mv = new ModelAndView();
		mv.addObject("userObj",userModel);
		mv.setViewName("index");
		return mv;
	}
}
