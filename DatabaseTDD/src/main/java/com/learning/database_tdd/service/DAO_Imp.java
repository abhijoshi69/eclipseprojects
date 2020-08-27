package com.learning.database_tdd.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learning.database_tdd.models.UserModel;
import com.learning.database_tdd.services.IDAO_Service;

public class DAO_Imp implements IDAO_Service 
{
	String user="sa";
	String pwd="sasa";
	String url="jdbc:sqlserver://localhost:1433;databaseName=online";
	Connection con=null;
	UserModel model;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	public boolean getConnected() 
	{
		try {
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
			System.out.println(e);
		}
		catch (SQLException e)
		{
			System.out.println("getConnected Error "+e.getMessage());
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
					model.setUsername(rs.getString("name"));
					model.setUsername(rs.getString("password"));
					modelList.add(model);
				}
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		
			
		}
		return modelList;
	}
	public int insertedData(UserModel model)
	{
		int rowsinserted=0;
		if(getConnected())
		{
			
			String query = "insert into Student values (?,?,?)";
			try
			{
				pst = con.prepareStatement(query);
				pst.setInt(1,model.getId());
				pst.setString(2,model.getUsername());
				pst.setString(3,model.getPassword());
				rowsinserted = pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		
		return rowsinserted;
	}
	public int updatedData(int i, UserModel model) {
		int rowsinserted=0;
		if(getConnected())
		{
			String query = "update Student "
					+ "set name=?,"
					+ "password=? "
					+ "where id=?";
			try
			{
				pst = con.prepareStatement(query);
				pst.setString(1,model.getUsername());
				pst.setString(2,model.getPassword());
				pst.setInt(3, i);
				rowsinserted = pst.executeUpdate();
			}
			catch(SQLException e) {
				System.out.println(e);
			}
					
		}
		return rowsinserted;
	}
	public UserModel getById(int i) 
	{
		UserModel model=null;
		if(getConnected())
		{
			String query = "select * from Student where id=?";
			try
			{
				pst = con.prepareStatement(query);
				pst.setInt(1,i);
				rs = pst.executeQuery();
				if(rs.next())
				{
					model = new UserModel();
					model.setId(rs.getInt("id"));
					model.setUsername(rs.getString("name"));
					model.setPassword(rs.getString("password"));
				
				}
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		if(model!=null)
		{
			return model;
		}
		return null;
	}
	public int delete(int i, UserModel model) {
		int deletedrows=0;
		if(getConnected())
		{
			String query = "delete from Student where id=?";
			try
			{
				pst = con.prepareStatement(query);
				pst.setInt(1,i);
				deletedrows = pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return deletedrows;
	}
	
}
