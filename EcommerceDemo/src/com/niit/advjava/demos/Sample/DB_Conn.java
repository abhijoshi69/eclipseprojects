package com.niit.advjava.demos.Sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class DB_Conn 
{
	String user="sa";
	String pwd="sasa";
	String url="jdbc:sqlserver://localhost:1433;databaseName=ecommerce";
	String username;
	String password;
	String productid;
	String productname;
	String productquantity;
	String productdescription;
	Statement st=null;
	PreparedStatement pst=null;
	Connection con=null;
	Model1 model1;
	public boolean getconn()
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
		if(getconn())
		{
			String query="select * from admin where username='"+val1+"' and password='"+val2+"'";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
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
	public int addProduct(Model1 model1)
	{
		//List<Model1> model = new ArrayList<>();
		String productid = model1.getProductid();
		String productname = model1.getProductname();
		String productquantity = model1.getProductquantity();
		String productdescription = model1.getProductdescription();
		int productInserted=0;
		if(getconn())
		{
			String query = "insert into product values(?,?,?,?)";
			try
			{
				pst = con.prepareStatement(query);
				pst.setString(1,productid);
				pst.setString(2,productname);
				pst.setString(3,productquantity);
				pst.setString(4,productdescription);
				productInserted=pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		System.out.println(model1);
		System.out.println(productInserted);
		return productInserted;
	}
	public List<Model1> viewbyid(String id)
	{
		List<Model1> model = new ArrayList<Model1>();
		Model1 model2;
		if(getconn())
		{
			String query = "select * from product where productid=?";
			try
			{
				pst = con.prepareStatement(query);
				pst.setString(1,id);
				ResultSet rs = pst.executeQuery();
				if(rs.next())
				{
					String productid = rs.getString("productid");
					String productname = rs.getString("productname");
					String productquantity = rs.getString("productquantity");
					String productdescription = rs.getString("productdescription");
					model2 = new Model1(productid,productname,productquantity,productdescription);
					model.add(model2);
				}
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return model;
	}
	public List<Model1> viewall()
	{
		List<Model1> model = new ArrayList();
		Model1 model2;
		if(getconn())
		{
		String query = "select * from product ";
		try
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				String productid = rs.getString("productid");
				String productname = rs.getString("productname");
				String productquantity = rs.getString("productquantity");
				String productdescription = rs.getString("productdescription");
				model2 = new Model1(productid,productname,productquantity,productdescription);
				model.add(model2);
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		}
		return model;
	}
	public int edit(String id,Model1 model2)
	{
		String productid = model2.getProductid();
		String productname = model2.getProductname();
		String productquantity = model2.getProductquantity();
		String productdescription = model2.getProductdescription();
		//List<Model1> model = new ArrayList<Model1>();
		int rowCount=0;
		if(getconn())
		{
			String query = "update product set productname=?,productquantity=?,productdescription=? where productid='"+id+"'";
			
			try
			{
				pst = con.prepareStatement(query);
				pst.setString(1,productname);
				pst.setString(2,productquantity);
				pst.setString(3,productdescription);
				
				rowCount= pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		System.out.println(rowCount);
		return rowCount; 
	}
	public int delete(String id)
	{
		int rowCount=0;
		if(getconn())
		{
			String query = "delete from product where productid='"+id+"'";
			try
			{
				pst = con.prepareStatement(query);
				rowCount = pst.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		System.out.println(rowCount);
		return rowCount;
	}
}