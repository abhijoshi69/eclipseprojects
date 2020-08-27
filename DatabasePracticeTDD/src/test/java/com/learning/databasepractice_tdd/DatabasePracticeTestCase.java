package com.learning.databasepractice_tdd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class DatabasePracticeTestCase {

	IDAO doaservice = new DAO_Imp();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
	}
	
	@Ignore
	@Test
	public void testConn() 
	{
		boolean isConnected = doaservice.getConnected();
		assertEquals(true,isConnected);
		
	}
	
	@Ignore
	@Test
	public void getDataTest()
	{ 
		List<UserModel> modelList = doaservice.getData();
		assertEquals(true,(modelList.size()>0));
	}

	@Ignore
	@Test
	public void insertDataTest()
	{
		UserModel model = new UserModel(106,"Balaji Sir","Guru7");
		int rowsaffected = doaservice.insertData(model);
		assertEquals(1,rowsaffected);
	}
	
	@Ignore
	@Test
	public void updateDataTest()
	{
		UserModel model = new UserModel(106,"BalajiSir","Balaji07");
		int rowsaffected = doaservice.updateData(106,model);
		assertEquals(1,rowsaffected);
	}
	
	@Ignore
	@Test
	public void getByIdTest()
	{
		UserModel model = doaservice.getById(106);
		assertEquals("Abhishek",model.getName());
	}
	
	@Test
	public void deleteDataTest()
	{
		UserModel model = new UserModel();
		int rowsaffected = doaservice.deleteData(106,model);
		assertEquals(1,rowsaffected);
		
	}
}
