package com.learning.admintdd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.learning.adminservices.DOA_Impl;
import com.learning.adminservices.IDOA;

public class AdminTestCase 
{
	IDOA doaservice = new DOA_Impl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Ignore
	@Test
	public void testConnection()
	{
		boolean getConnected = doaservice.isConnected();
		assertEquals(true,getConnected);
	}

	@Test
	public void checkLogin()
	{
		boolean checkLogin = doaservice.Login("Abhishek","abhi69");
		assertEquals(true,checkLogin);
	}
}
