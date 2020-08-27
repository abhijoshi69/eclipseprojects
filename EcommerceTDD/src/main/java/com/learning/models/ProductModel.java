package com.learning.models;

import java.io.InputStream;

public class ProductModel 
{
	private int productid;
	private String productname;
	private int productquantity;
	private int productcost;
	private String productdescription;
	private String productimagefilename;
	private String prodcutimagepath;
	
	
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductModel(int productid, String productname, int productquantity, int productcost,
			String productdescription, String productimagefilename, String prodcutimagepath) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productquantity = productquantity;
		this.productcost = productcost;
		this.productdescription = productdescription;
		this.productimagefilename = productimagefilename;
		this.prodcutimagepath = prodcutimagepath;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}

	public int getProductcost() {
		return productcost;
	}

	public void setProductcost(int productcost) {
		this.productcost = productcost;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public String getProductimagefilename() {
		return productimagefilename;
	}

	public void setProductimagefilename(String productimagefilename) {
		this.productimagefilename = productimagefilename;
	}

	public String getProdcutimagepath() {
		return prodcutimagepath;
	}

	public void setProdcutimagepath(String prodcutimagepath) {
		this.prodcutimagepath = prodcutimagepath;
	}

	@Override
	public String toString() {
		return "ProductModel [productid=" + productid + ", productname=" + productname + ", productquantity="
				+ productquantity + ", productcost=" + productcost + ", productdescription=" + productdescription
				+ ", productimagefilename=" + productimagefilename + ", prodcutimagepath=" + prodcutimagepath + "]";
	}
	
	
}
