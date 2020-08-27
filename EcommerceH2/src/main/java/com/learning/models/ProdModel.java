package com.learning.models;

public class ProdModel 
{
	private int productid;
	private String productname;
	private int productquantity;
	private int productcost;
	private String productdescription;
	private String productimagefilename;
	private String productimagepath;
	
	public ProdModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdModel(int productid, String productname, int productquantity, int productcost, String productdescription,
			String productimagefilename, String productimagepath) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productquantity = productquantity;
		this.productcost = productcost;
		this.productdescription = productdescription;
		this.productimagefilename = productimagefilename;
		this.productimagepath = productimagepath;
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

	public String getProductimagepath() {
		return productimagepath;
	}

	public void setProductimagepath(String productimagepath) {
		this.productimagepath = productimagepath;
	}

	@Override
	public String toString() {
		return "ProdModel [productid=" + productid + ", productname=" + productname + ", productquantity="
				+ productquantity + ", productcost=" + productcost + ", productdescription=" + productdescription
				+ ", productimagefilename=" + productimagefilename + ", productimagepath=" + productimagepath + "]";
	}
	
	
}
