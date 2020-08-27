package com.learning.springmvcdatabasetdd;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.learning.springmvcdatabase.model.UserModel;
import com.learning.springmvcdatabase.services.DOA_Imp;
import com.learning.springmvcdatabase.services.IDOA;

public class SpringMvcDatabaseTestCase {

	IDOA idoaservices = new DOA_Imp();
	
	@Ignore
	@Test
	public void testConnection() 
	{
		boolean getConnected = idoaservices.isConnected();
		assertEquals(true,getConnected);
	}
	
	@Test
	public void testInsertion()
	{
		UserModel model = new UserModel(103,"Aparna","Santacruz");
		int rowsaffected = idoaservices.insertData(model);
		assertEquals(1,rowsaffected);
	}

}
