package com.learning.demotesttdd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.learning.models.UserModel;
import com.learning.services.DOA_Imp;
import com.learning.services.IDOA;

public class DemoTestCaseTDD {

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
		UserModel model = new UserModel(109,"Mohnish","Vile Parle","123456");
		int rowsaffected = doaservice.insertData(model);
		assertEquals(1,rowsaffected);
	}
	
	@Ignore
	@Test
	public void testGetData()
	{
		List<UserModel> modelList = doaservice.getData();
		assertEquals(true,(modelList.size()>0));
	}
	
	@Ignore
	@Test
	public void testUpdation()
	{
		UserModel model = new UserModel(107,"Kedar Sir","Vile Parle","kedar6");
		int rowsaffected = doaservice.updateData(107,model);
		assertEquals(1,rowsaffected);
	}
	
	@Ignore
	@Test
	public void testGetById()
	{
		UserModel model = doaservice.getById(101);
		assertEquals("Abhishek",model.getName());
		
	}
	
	@Ignore
	@Test
	public void testDeletion()
	{
		UserModel model = new UserModel();
		int rowsaffected = doaservice.deleteData(109,model);
		assertEquals(1,rowsaffected);
		
	}
}
