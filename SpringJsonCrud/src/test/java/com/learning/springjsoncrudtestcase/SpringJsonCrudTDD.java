package com.learning.springjsoncrudtestcase;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.learning.springjsoncrud.models.UserModel;
import com.learning.springjsoncrud.services.DOA_Imp;
import com.learning.springjsoncrud.services.IDOA;

public class SpringJsonCrudTDD 
{
	
	IDOA idoaservice = new DOA_Imp();
	
	@Ignore
	@Test
	public void test()
	{
		UserModel model = new UserModel(101,"Abc","xyz");
		int rowsaffected = idoaservice.insertData(model);
		assertEquals(1,rowsaffected);
	}

	@Test
	public void testUpdation()
	{
		UserModel model = new UserModel(101,"Abd","dkd");
		int rowsaffected = idoaservice.updateData(101,model);
		assertEquals(1,rowsaffected);
		
	}
}
