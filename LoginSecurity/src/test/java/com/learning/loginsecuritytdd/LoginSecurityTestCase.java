package com.learning.loginsecuritytdd;

import static org.junit.Assert.*;

import org.junit.Test;

import com.learning.loginsecurity.model.UserModel;
import com.learning.loginsecurity.services.DOA_Imp;
import com.learning.loginsecurity.services.IDOA;

public class LoginSecurityTestCase
{

	IDOA idoaservice = new DOA_Imp();
	@Test
	public void test() 
	{
		UserModel model = new UserModel("Max","1234");
		int rowsaffected = idoaservice.insertCredentials(model);
		assertEquals(1,rowsaffected);
	}
	
	@Test
	public void testLogin()
	{
		boolean checkLogin = idoaservice.login("Max","1234");
		assertEquals(true,checkLogin);
	}
}
