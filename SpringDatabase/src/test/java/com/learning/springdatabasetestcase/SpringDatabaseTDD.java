package com.learning.springdatabasetestcase;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.learning.springdatabase.model.UserModel;
import com.learning.springdatabase.services.DOA_Imp;
import com.learning.springdatabase.services.IDOA;

public class SpringDatabaseTDD 
{
	IDOA idaoservice = new DOA_Imp();
	
	@Ignore
	@Test
	public void testConnection() 
	{
		boolean getConnected = idaoservice.isConnected();
		assertEquals(true,getConnected);
	}

	@Test
	public void testInsertion()
	{
		UserModel model = new UserModel(102,"Sakshi","Vile Parle");
		int rowsaffected = idaoservice.insertData(model);
		assertEquals(1,rowsaffected);
	}
}
