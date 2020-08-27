
package com.niit.Sample;

public class Model 
{
	int productid;
	String productname;
	int productquantity;
	int productcost;
	String productdescription;
	public Model(int productid, String productname, int productquantity, int productcost, String productdescription) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productquantity = productquantity;
		this.productcost = productcost;
		this.productdescription = productdescription;
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

	@Override
	public String toString() {
		return "Model [productid=" + productid + ", productname=" + productname + ", productquantity=" + productquantity
				+ ", productcost=" + productcost + ", productdescription=" + productdescription + "]";
	}
	}
