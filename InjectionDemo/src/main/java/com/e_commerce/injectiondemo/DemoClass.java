package com.e_commerce.injectiondemo;

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
		System.out.println("Value from child class is "+childdemo.getVal());
	}
}