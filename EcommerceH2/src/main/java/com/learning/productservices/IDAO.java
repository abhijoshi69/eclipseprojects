package com.learning.productservices;

import java.util.List;

import com.learning.models.ProdModel;

public interface IDAO {

	boolean isConnected();

	int insertProd(ProdModel prodModel);

	List<ProdModel> getProductData();

	

}
