package com.e_commerce.injectdemo;

public class DemoClass 
{
	public ChildDemo childdemo;

	public ChildDemo getChilddemo() {
		return childdemo;
	}

	public void setChilddemo(ChildDemo childdemo) {
		this.childdemo = childdemo;
	}
	
	public void showMsg()
	{
		System.out.println("Lets watch "+childdemo.getType()+" from "+childdemo.getApp()+" on "+childdemo.getDevice());
	}
	
}
