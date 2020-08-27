package com.learning.productservices;

import java.util.List;

import com.learning.models.ProductModel;

public interface IDOA 
{

	boolean isConnected();

	int insertData(ProductModel productModel);

	List<ProductModel> getData();

	List<ProductModel> getById(int i);

	int updateProduct(int i, ProductModel productModel);

	int deleteProduct(int i);

	

}
