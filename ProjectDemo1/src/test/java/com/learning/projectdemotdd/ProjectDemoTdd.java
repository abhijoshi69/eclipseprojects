package com.learning.projectdemotdd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.learning.models.UserModel;
import com.learning.services.DOA_Imp;
import com.learning.services.IDOA;

public class ProjectDemoTdd 
{
	
	IDOA doaservice = new DOA_Imp();
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
	
	@Ignore
	@Test
	public void testInsertion()
	{
		UserModel model = new UserModel(102,"Abhishek","Vile Parle","abhi00");
		int rowsaffected = doaservice.insertData(model);
		assertEquals(1,rowsaffected);
	}

	
	@Test
	public void testUpdation()
	{
		UserModel model = new UserModel(101,"Abhishek","Vile Parle","abhi00");
		int rowsaffected = doaservice.updateData(101,model);
		assertEquals(1,rowsaffected);
	}
	
	@Ignore
	@Test
	public void testGetData()
	{
		List<UserModel> model = doaservice.getData();
		assertEquals(true,(model.size()>0));
		
	}
	
	@Ignore
	@Test
	public void testgetById()
	{
		UserModel model = doaservice.getById(101);
		assertEquals("Sakshi",model.getName());
	}
	
	@Ignore
	@Test
	public void testDeletion()
	{
		UserModel model = new UserModel();
		int rowsaffected = doaservice.deleteData(102,model);
		assertEquals(1,rowsaffected);
		
	}
	
	
	
	
}
