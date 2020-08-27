package com.learning.databasepractice_tdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO_Imp implements IDAO
{
	String user="sa";
	String pwd="sasa";
	String url="jdbc:sqlserver://localhost:1433;databaseName=online";
	Connection con=null;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	UserModel model;
	
	public boolean getConnected() 
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url,user,pwd);
			if(con!=null)
			{
				return true;
			}
			return false;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundException Error "+e.getMessage());
		}
		catch(SQLException e)
		{
			System.out.println("Connection Error "+e.getMessage());
		}
		return false;
	}

	public List<UserModel> getData() 
	{
		List<UserModel> modelList = new ArrayList();
		if(getConnected())
		{
			String query = "select * from Student";
			try
			{
				st = con.createStatement();
				rs = st.executeQuery(query);
				while(rs.next())
				{
					model = new UserModel();
					model.setId(rs.getInt("id"));
					model.setName(rs.getString("name"));
					model.setPassword(rs.getString("password"));
					modelList.add(model);
				}
			}
			catch(SQLException e)
			{
				System.out.println("Error getting Data "+e.getMessage());
			}
		}
		return modelList;
	}

	public int insertData(UserModel model) 
	{
		int rowsaffected=0;
		if(getConnected())
		{
			String query = "insert into Student values (?,?,?)";
			try
			{
				pst = con.prepareStatement(query);
				pst.setInt(1,model.getId());
				pst.setString(2,model.getName());
				pst.setString(3,model.getPassword());
				rowsaffected = pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("Insert Error "+e.getMessage());
			}
		}
		return rowsaffected;
	}

	public int updateData(int i, UserModel model) 
	{
		int rowsaffected=0;
		if(getConnected())
		{
			String query = "update Student "
					+ "set name=?,"
					+ "password=? "
					+ "where id=?";
			try
			{
				pst = con.prepareStatement(query);
				pst.setString(1,model.getName());
				pst.setString(2,model.getPassword());
				pst.setInt(3,i);
				rowsaffected = pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return rowsaffected;
	}

	public UserModel getById(int i) 
	{
		if(getConnected())
		{
			UserModel model=null;
			String query = "select * from String where id=?";
			try
			{
				pst = con.prepareStatement(query);
				pst.setInt(1, i);
				rs = pst.executeQuery();
				if(rs.next())
				{
					model = new UserModel();
					model.setId(rs.getInt("id"));;
					model.setName(rs.getString("name"));
					model.setPassword(rs.getString("password"));
					
				}
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
			if(model!=null)
			{
				return model;
			}
		}
		return null;
	}

	public int deleteData(int i, UserModel model) {
		int rowsaffected=0;
		if(getConnected())
		{
			String query = "delete from Student where id=?";
			try
			{
				pst = con.prepareStatement(query);
				pst.setInt(1,i);
				rowsaffected = pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return rowsaffected;
	}
	
}
