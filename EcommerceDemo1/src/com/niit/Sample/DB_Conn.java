package com.niit.Sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB_Conn 
{
	int productid;
	String productname;
	int productquantity;
	int productcost;
	String productdescription;
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	Statement st=null;
	String url="jdbc:sqlserver://localhost:1433;databaseName=online";
	String user="sa";
	String pwd="sasa";
	Model model;
	
	public boolean getcon()
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url,user,pwd);
			if(con!=null)
			{
				return true;
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return false;
	}
	
	public boolean check(String val1,String val2) throws Exception
	{
		if(getcon())
		{
			String query = "select * from admin where username='"+val1+"' and password='"+val2+"'";
			st = con.createStatement();
			rs = st.executeQuery(query);
			if(rs.next())
			{
				if(rs.getString("username").equals(val1) && rs.getString("password").equals(val2))
				{
					return true;
				}
			}
			
		}
		return false;
	}
	
	public int addProducts(Model model)
	{
		int productid = model.getProductid();
		String productname = model.getProductname();
		int productquantity = model.getProductquantity();
		int productcost = model.getProductcost();
		String productdescription = model.getProductdescription();
		int rowinserted=0;
		if(getcon())
		{
			String query = "insert into product values (?,?,?,?,?)";
			try
			{
				pst = con.prepareStatement(query);
				pst.setInt(1,productid);
				pst.setString(2,productname);
				pst.setInt(3,productquantity);
				pst.setInt(4,productcost);
				pst.setString(5,productdescription);
				rowinserted = pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return rowinserted;
	}
	
	public List<Model> viewall()
	{
		List<Model> model = new ArrayList<Model>();
		Model model1;
		if(getcon())
		{
			String query = "select * from product";
			try
			{
				st = con.createStatement();
				rs = st.executeQuery(query);
				while(rs.next())
				{
					int productid = rs.getInt("productid");
					String productname = rs.getString("productname");
					int productquantity = rs.getInt("productquantity");
					int productcost = rs.getInt("productcost");
					String productdescription = rs.getString("productdescription");
					model1 = new Model(productid,productname,productquantity,productcost,productdescription);
					model.add(model1);
				}
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return model;
	}
	public List<Model> viewbyid(int id)
	{
		List<Model> model1 = new ArrayList<Model>();
		Model model2;
		if(getcon())
		{
			String query = "select * from product where productid=?";
			try
			{
				pst = con.prepareStatement(query);
				pst.setInt(1,id);
				rs = pst.executeQuery();
				if(rs.next())
				{
					int productid = rs.getInt("productid");
					String productname = rs.getString("productname");
					int productquantity = rs.getInt("productquantity");
					int productcost = rs.getInt("productcost");
					String productdescription = rs.getString("productdescription");
					model2 = new Model(productid,productname,productquantity,productcost,productdescription);
					model1.add(model2);
					
				}
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return model1;
	} 
	public int update(int id,Model model1)
	{
		String productname = model1.getProductname();
		int productquantity = model1.getProductquantity();
		int productcost= model1.getProductcost();
		String productdescription = model1.getProductdescription();
		int rowcount=0;
		if(getcon())
		{
			String query = "update online set prodructname=?,productquantity=?,productcost=?,productdescription=? where productid='"+id+"'";
			try
			{
				pst = con.prepareStatement(query);
				pst.setString(1,productname);
				pst.setInt(2,productquantity);
				pst.setInt(3,productcost);
				pst.setString(4,productdescription);
				rowcount = pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return rowcount;
	}
	public int delete(int id)
	{
		int rowcount=0;
		if(getcon())
		{
			String query = "delete from online where productid='"+id+"'";
			try
			{
				pst = con.prepareStatement(query);
				rowcount = pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
			
		}
		return rowcount;
	}
}
