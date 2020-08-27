package com.learning.demotesttdd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.learning.demotesttdd.models.UserModel;
import com.learning.demotesttdd.services.DOA_Imp;
import com.learning.demotesttdd.services.IDOA;

public class DemotestTdd 
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

	
	@Test
	public void testInsertion()
	{
		UserModel model = new UserModel(116,"Mahesh","Andheri","loke26");
		boolean rowsaffected = doaservice.insertData(model);
		assertEquals(true,rowsaffected);
	}
	
	@Ignore
	@Test
	public void testGetAllData()
	{
		List<UserModel> modelList = doaservice.getAllData();
		assertEquals(true,(modelList.size()>0));
	}
	
	@Ignore
	@Test
	public void testgetById()
	{
		List<UserModel> modelList = doaservice.getById(101);
		assertEquals(true,(modelList.size()>0));
	}
	
	@Ignore
	@Test
	public void testUpdation()
	{
		UserModel model = new UserModel(107,"Kedar Sir","Vile Parle","kedar6");
		boolean rowsaffected = doaservice.updataData(107,model);
		assertEquals(true,rowsaffected);
	}
	
	@Ignore
	@Test
	public void testDeletion()
	{
		
		boolean rowsaffected = doaservice.deleteData(113);
		assertEquals(true,rowsaffected);
	}
}
