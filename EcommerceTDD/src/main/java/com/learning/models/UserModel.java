package com.learning.models;

public class UserModel 
{
	private int customerid;
	private String customername;
	private String customeraddress;
	private String customerusername;
	private String customerpassword;
	private int customerzipno;
	private String customerstate;
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(int customerid, String customername, String customeraddress, String customerusername,
			String customerpassword, int customerzipno, String customerstate) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.customeraddress = customeraddress;
		this.customerusername = customerusername;
		this.customerpassword = customerpassword;
		this.customerzipno = customerzipno;
		this.customerstate = customerstate;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getCustomerusername() {
		return customerusername;
	}

	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}

	public String getCustomerpassword() {
		return customerpassword;
	}

	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}

	public int getCustomerzipno() {
		return customerzipno;
	}

	public void setCustomerzipno(int customerzipno) {
		this.customerzipno = customerzipno;
	}

	public String getCustomerstate() {
		return customerstate;
	}

	public void setCustomerstate(String customerstate) {
		this.customerstate = customerstate;
	}

	@Override
	public String toString() {
		return "UserModel [customerid=" + customerid + ", customername=" + customername + ", customeraddress="
				+ customeraddress + ", customerusername=" + customerusername + ", customerpassword=" + customerpassword
				+ ", customerzipno=" + customerzipno + ", customerstate=" + customerstate + "]";
	}

	
}
