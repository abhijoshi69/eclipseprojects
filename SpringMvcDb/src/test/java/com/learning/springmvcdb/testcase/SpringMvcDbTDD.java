package com.learning.springmvcdb.testcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.learning.springmvcdb.model.UserModel;
import com.learning.springmvcdb.services.DOA_Imp;
import com.learning.springmvcdb.services.IDOA;

public class SpringMvcDbTDD 
{
	IDOA idoaservice = new DOA_Imp();
	
	@Ignore
	@Test
	public void testInsertion() 
	{
		UserModel model = new UserModel(104,"Krutik","NalaSopara");
		int rowsaffected = idoaservice.insertData(model);
		assertEquals(1,rowsaffected);
	}

	@Ignore
	@Test
	public void testGetAllData()
	{
		List<UserModel> modelList = idoaservice.getAllData();
		assertEquals(true,(modelList.size()>0));
	}
	
	@Ignore
	@Test
	public void testUpdation()
	{
		UserModel model = new UserModel(101,"Abhi","Vile Parle");
		int rowsaffecteds = idoaservice.updateData(101,model);
		assertEquals(1,rowsaffecteds);
	}
	
	@Ignore
	@Test
	public void testgetDataById()
	{
		UserModel model = idoaservice.getDataById(101);
		assertEquals("Abhishek",model.getName());
	}
	
	@Test
	public void testDeletion()
	{
		int rowsaffected = idoaservice.deleteData(104);
		assertEquals(1,rowsaffected);
		
	}
}
