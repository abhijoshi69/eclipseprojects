package com.e_commerce.practiceinjectiondemo;

public class DemoClass implements DemoP
{
	public ChildDemo childdemo;

	public void netflix()
	{
		System.out.println("Let's watch "+childdemo.getType()+" from "+childdemo.getApp()+" on "+childdemo.getDevice());
	}

	public void amazon() 
	{
		System.out.println("Let's watch "+childdemo.getType()+" from "+childdemo.getApp()+" on "+childdemo.getDevice() );
	}
	
	public ChildDemo getChilddemo() {
		return childdemo;
	}

	public void setChilddemo(ChildDemo childdemo) {
		this.childdemo = childdemo;
	}

	

		
}
