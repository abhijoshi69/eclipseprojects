package com.e_commerce.diannotationspractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoParent 
{
	@Autowired
	DemoChild demochild;
	
	public void greet()
	{
		demochild.setName("Abhishek");
		System.out.println("Hello from "+demochild.getName());
	}
}
