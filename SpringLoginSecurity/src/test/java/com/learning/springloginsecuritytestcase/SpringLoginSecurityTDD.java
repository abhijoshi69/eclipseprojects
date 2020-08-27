package com.learning.springloginsecuritytestcase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.learning.springloginsecurity.model.UserModel;
import com.learning.springloginsecurity.services.DOA_Imp;
import com.learning.springloginsecurity.services.IDOA;

public class SpringLoginSecurityTDD 
{
	
	IDOA idoaservice = new DOA_Imp();
	
	@Test
	public void test() 
	{
		UserModel model = new UserModel("Abc","1234");
		int rowsaffected = idoaservice.insertCredentials(model);
		assertEquals(1,rowsaffected);
		
	}

	@Test
	public void testLogin()
	{
		boolean checkLogin = idoaservice.checkCredentials("Abc","1234");
		assertEquals(true,checkLogin);
		
	}
}
