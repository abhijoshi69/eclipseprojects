package com.e_commerce.projectinjectiondemo;

public class DemoClass 
{
	String userName;
	
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void showMsg()
	{
		System.out.println("Hello from "+userName);
	}
}
