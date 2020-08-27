package com.learning.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class ProductModels 
{

	private int productid;
	private File productimages;
	
	public ProductModels() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductModels(int productid, File productimages) {
		super();
		this.productid = productid;
		this.productimages = productimages;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public File getProductimages() {
		return productimages;
	}

	public void setProductimages(File productimages) {
		this.productimages = productimages;
	}

	@Override
	public String toString() {
		return "ProductModels [productid=" + productid + ", productimages=" + productimages + "]";
	}
	
	
	
	
	
}
