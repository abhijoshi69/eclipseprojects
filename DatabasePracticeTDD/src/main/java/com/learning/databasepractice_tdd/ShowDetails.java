package com.learning.databasepractice_tdd;

import java.util.List;

public class ShowDetails 
{
	IDAO doaservice = new DAO_Imp();
	
	public void showDetails()
	{
		List<UserModel> modelList = doaservice.getData();
		for(UserModel modelObj : modelList)
		{
			System.out.println(modelObj);
		}
	}
}
