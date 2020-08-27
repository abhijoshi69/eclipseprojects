package com.learning.producttdd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.learning.models.ProductModel;
import com.learning.productservices.DOA_Imp;
import com.learning.productservices.IDOA;

public class ProductTestCase {

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
	public void insertData()
	{
		ProductModel productModel = new ProductModel();
		int rowsaffected = doaservice.insertData(productModel);
		
	}
	
	@Test
	public void getProductData()
	{
		List<ProductModel> productList = doaservice.getData();
		
	}
		
	@Test
	public void getByIdtest()
	{
		List<ProductModel> productModel = doaservice.getById(1001);
	
	}

	@Test
	public void updateTest()
	{
		ProductModel productModel = new ProductModel();
		int rowsaffected = doaservice.updateProduct(1001,productModel);
	}
	
	@Test
	public void deleteProduct()
	{
		ProductModel productModel = new ProductModel();
		int rowsaffected = doaservice.deleteProduct(1001);
		
	}
}
