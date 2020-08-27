package com.learning.producttestcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.learning.models.ProdModel;
import com.learning.productservices.DAO_Impl;
import com.learning.productservices.IDAO;

public class Producttestcase {

	IDAO daoservice = new DAO_Impl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testConnection()
	{
		boolean getConnected = daoservice.isConnected();
		assertEquals(true,getConnected);
	}
	
	@Test
	public void insertData()
	{
		ProdModel prodModel = new ProdModel();
		int rowsaffected = daoservice.insertProd(prodModel);
	}
	
	@Test
	public void getData()
	{
		List<ProdModel> prodList = daoservice.getProductData();
	}
}
