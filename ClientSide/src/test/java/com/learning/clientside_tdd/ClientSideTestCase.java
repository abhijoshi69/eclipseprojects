package com.learning.clientside_tdd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ClientSideTestCase 
{
	IDOA doaservice = new DOAImp();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}

	@Ignore
	@Test
	public void testConn() 
	{
		boolean getConnected = doaservice.isConnected();
		assertEquals(true,getConnected);
	}

	@Ignore
	@Test
	public void insertDataTest()
	{
		UserModel model = new UserModel(1001,"Abhishek","Vile Parle","abhi02",123456,400099,"Maharashtra");
		int rowsaffected = doaservice.insertData(model);
		assertEquals(1,rowsaffected);
	}
	
	@Test
	public void loginTest()
	{
		boolean checkLogin = doaservice.Login("abhi02","123456");
		assertEquals(true,checkLogin);
	}
	
}
