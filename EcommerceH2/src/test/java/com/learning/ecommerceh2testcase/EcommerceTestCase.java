package com.learning.ecommerceh2testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.learning.adminservices.DOA_Imp;
import com.learning.adminservices.IDOA;

public class EcommerceTestCase {

	IDOA doaservice = new DOA_Imp();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testConnection()
	{
		boolean getConnected = doaservice.isConnected();
		assertEquals(true,getConnected);
	}

	@Test
	public void testLogin()
	{
		boolean checkLogin = doaservice.Login("Abhishek","abhi69");
		assertEquals(true,checkLogin);
		
	}
	
}
