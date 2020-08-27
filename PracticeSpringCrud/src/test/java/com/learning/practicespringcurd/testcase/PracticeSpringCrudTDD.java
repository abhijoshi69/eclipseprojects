package com.learning.practicespringcurd.testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.learning.practicespringcrud.model.UserModel;
import com.learning.practicespringcrud.services.DOA_Imp;
import com.learning.practicespringcrud.services.Idoaservice;

public class PracticeSpringCrudTDD 
{
	Idoaservice idoa = new DOA_Imp();
	
	@Test
	public void testConnection() 
	{
		UserModel model = new UserModel(101,"Abhishek","VileParle");
		int rowsaffected = idoa.insertData(model);
		assertEquals(1,rowsaffected);
	}
	
	

}
