package com.e_commerce.diannotationspractice;

import org.springframework.stereotype.Component;

@Component
public class DemoChild extends DemoParent
{
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
