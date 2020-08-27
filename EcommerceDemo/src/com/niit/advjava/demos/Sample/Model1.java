package com.niit.advjava.demos.Sample;

public class Model1 
{
	String productid;
	String productname;
	String productquantity;
	String productdescription;
	public Model1(String productid, String productname, String productquantity, String productdescription) 
	{
		super();
		this.productid = productid;
		this.productname = productname;
		this.productquantity = productquantity;
		this.productdescription = productdescription;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductquantity() {
		return productquantity;
	}
	public void setProductquantity(String productquantity) {
		this.productquantity = productquantity;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	@Override
	public String toString() {
		return "Model1 [productid=" + productid + ", productname=" + productname + ", productquantity="
				+ productquantity + ", productdescription=" + productdescription + "]";
	}
	
}
