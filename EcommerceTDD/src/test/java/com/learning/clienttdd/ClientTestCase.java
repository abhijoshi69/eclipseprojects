package com.learning.clienttdd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.learning.clientserivces.DOA_Imp;
import com.learning.clientserivces.IDOA;
import com.learning.models.UserModel;

public class ClientTestCase
{
	IDOA doaservice = new DOA_Imp();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}
	
	@Ignore
	@Test
	public void testConnected()
	{
		boolean getConnected = doaservice.isConnected();
		assertEquals(true,getConnected);
	}
	
	@Ignore
	@Test
	public void insertData()
	{
		UserModel model = new UserModel(1002,"Sakshi","Vile Parle","sakshigada","gada11",400099,"Maharashtra");
		int rowsaffected = doaservice.insertData(model);
		assertEquals(1,rowsaffected);
	}
	
	@Ignore
	@Test
	public void getData()
	{
		List<UserModel> modelList = doaservice.getData();
		assertEquals(true,(modelList.size()>0));
	}

	@Ignore
	@Test
	public void updataData()
	{
		UserModel model = new UserModel(1001,"Abhishek","Vile Parle","abhi02","joshi9",400099,"Maharashtra");
		int rowsaffected = doaservice.updataData(1001,model);
		assertEquals(1,rowsaffected);
	}
	
	@Ignore
	@Test
	public void getById()
	{
		UserModel model = doaservice.getById(1001);
		assertEquals("Abhishek",model.getCustomername());
		
	}
	
	@Ignore
	@Test
	public void deleteData()
	{
		UserModel model = new UserModel();
		int deleterows = doaservice.deleteData(1002,model);
		assertEquals(1,deleterows);
	}

	@Test
	public void checkLogin()
	{
		boolean checkLogin = doaservice.checkLogin("abhi02","joshi9");
		assertEquals(true,checkLogin);
	}
}

