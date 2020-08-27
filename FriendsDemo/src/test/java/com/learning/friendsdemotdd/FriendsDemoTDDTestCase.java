package com.learning.friendsdemotdd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.learning.friendsdemotdd.models.UserModel;
import com.learning.friendsdemotdd.services.DOA_Imp;
import com.learning.friendsdemotdd.services.IDOA;

public class FriendsDemoTDDTestCase
{
	IDOA idaoservices = new DOA_Imp();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Ignore
	@Test
	public void testConnection()
	{
		boolean getConnected = idaoservices.isConnected();
		assertEquals(true,getConnected);
	}
	
	@Ignore
	@Test
	public void testInsertion()
	{
		UserModel model = new UserModel(113,"Max","England","134543");
		boolean rowsaffected = idaoservices.insertData(model);
		assertEquals(true,rowsaffected);
	}
	
	@Ignore
	@Test
	public void testgetData()
	{
		List<UserModel> modelList = idaoservices.getData();
		assertEquals(true,(modelList.size()>0));
	}
	
	@Ignore
	@Test
	public void testgetById()
	{
		List<UserModel> modelList = idaoservices.getById(101);
		assertEquals(true,(modelList.size()>0));
	}
	
	@Ignore
	@Test
	public void testUpdation()
	{
		UserModel model = new UserModel(108,"Kedar Sir","Vile Parle","kedar6");
		int rowsaffected = idaoservices.updateData(108,model);
		assertEquals(true,rowsaffected);
	}
	
	@Test
	public void testDeletion()
	{
		boolean rowsaffected = idaoservices.deleteData(113);
		assertEquals(true,rowsaffected);
	}
}
