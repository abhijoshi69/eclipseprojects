package com.learning.database_tdd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.learning.database_tdd.models.UserModel;
import com.learning.database_tdd.service.DAO_Imp;
import com.learning.database_tdd.services.IDAO_Service;

public class DatabaseTestCases {

	IDAO_Service daoService = new DAO_Imp();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}
	@Ignore
	@Test
	public void testConn() {
		boolean isConnected = daoService.getConnected();
		assertEquals(true,isConnected);
	}
	@Ignore
	@Test
	public void getDataTest()
	{
		List<UserModel> modelList = daoService.getData();
		assertEquals(true,(modelList.size()>0));
	}
	@Ignore
	@Test
	public void insertedDataTest()
	{
		UserModel model = new UserModel(106,"Balaji","guru7");
		int rowsinserted = daoService.insertedData(model);
		assertEquals(1,rowsinserted);
	}
	@Ignore
	@Test
	public void updateDataTest()
	{
		UserModel model = new UserModel(106,"Guru","guru7");
		int noofrows = daoService.updatedData(106,model);
		assertEquals(1,noofrows);
		
	}
	
	@Ignore
	@Test
	public void getByIdTest()
	{
		UserModel model = daoService.getById(101);
		assertEquals("Abhishek",model.getUsername());
		
	}
	
	@Test
	public void deleteTest()
	{
		UserModel model = new UserModel();
		int deletedrows = daoService.delete(106,model);
		assertEquals(1,deletedrows);
		
		
	}
}
