package com.learning.clientserivces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learning.models.UserModel;


public class DOA_Imp implements IDOA 
{
	String user="sa";
	String pwd="";
	String url="jdbc:h2:tcp://localhost/~/test";
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	UserModel model = null;
	
	public boolean isConnected() 
	{
		try
		{
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection(url,user,pwd);
			if(connection!=null)
			{
				return true;
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundException Error: "+e.getMessage());
		}
		catch(SQLException e)
		{
			System.out.println("Connection Error: "+e.getMessage());
		}
		return false;
	}

	public int insertData(UserModel model) 
	{
		int rowsaffected=0;
		if(isConnected())
		{
			String query = "insert into registration values (?,?,?,?,?,?,?)";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,model.getCustomerid());
				preparedStatement.setString(2,model.getCustomername());
				preparedStatement.setString(3,model.getCustomeraddress());
				preparedStatement.setString(4,model.getCustomerusername());
				preparedStatement.setString(5,model.getCustomerpassword());
				preparedStatement.setInt(6,model.getCustomerzipno());
				preparedStatement.setString(7,model.getCustomerstate());
				rowsaffected = preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("Insert Error: "+e.getMessage());
			}
		}
		return rowsaffected;
	}

	public List<UserModel> getData() 
	{
		List<UserModel> modelList = new ArrayList();
		if(isConnected())
		{
			String query = "select * from registration";
			try
			{
				statement = connection.createStatement();
				resultSet = statement.executeQuery(query);
				while(resultSet.next())
				{
					model = new UserModel();
					model.setCustomerid(resultSet.getInt("Customerid"));
					model.setCustomername(resultSet.getString("Customername"));
					model.setCustomeraddress(resultSet.getString("Customeraddress"));
					model.setCustomerusername(resultSet.getString("CUsername"));
					model.setCustomerpassword(resultSet.getString("CPassword"));
					model.setCustomerzipno(resultSet.getInt("Customerzip"));
					model.setCustomerstate(resultSet.getString("CState"));
					modelList.add(model);
				}
			}
			catch(SQLException e)
			{
				System.out.println("Data retrieving error: "+e.getMessage());
			}
		}
		return modelList;
	}

	public int updataData(int i, UserModel model) 
	{
		int rowsaffected = 0;
		if(isConnected())
		{
			String query = "update registration "
					+ "set Customername=?,"
					+ "Customeraddress=?,"
					+ "CUsername=?,"
					+ "CPassword=?,"
					+ "Customerzip=?,"
					+ "CState=? "
					+ "where Customerid=?";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1,model.getCustomername());
				preparedStatement.setString(2,model.getCustomeraddress());
				preparedStatement.setString(3,model.getCustomerusername());
				preparedStatement.setString(4,model.getCustomerpassword());
				preparedStatement.setInt(5,model.getCustomerzipno());
				preparedStatement.setString(6,model.getCustomerstate());
				preparedStatement.setInt(7,i);
				rowsaffected = preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("Updating Error: "+e.getMessage());
			}
		}
		return rowsaffected;
	}

	public UserModel getById(int i) 
	{
		if(isConnected())
		{
			String query = "select * from registration where Customerid=?";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,i);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next())
				{
					model = new UserModel();
					model.setCustomerid(resultSet.getInt("Customerid"));
					model.setCustomername(resultSet.getString("Customername"));
					model.setCustomeraddress(resultSet.getString("Customeraddress"));
					model.setCustomerusername(resultSet.getString("CUsername"));
					model.setCustomerpassword(resultSet.getString("CPassword"));
					model.setCustomerzipno(resultSet.getInt("Customerzip"));
					model.setCustomerstate(resultSet.getString("CState"));
				}
			}
			catch(SQLException e)
			{
				System.out.println("Error getting data: "+e.getMessage());
			}
			if(model!=null)
			{
				return model;
			}
		}
		return null;
	}

	public int deleteData(int i, UserModel model) 
	{
		int deleterows=0;
		if(isConnected())
		{
			String query = "delete from registration where Customerid=?";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,i);
				deleterows = preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("Deleted Error: "+e.getMessage());
			}
		}
		return deleterows;
	}

	public boolean checkLogin(String string, String string2) 
	{
		if(isConnected())
		{
			String query = "select * from registration where CUsername='"+string+"' and CPassword='"+string2+"'";
			try
			{
				statement = connection.createStatement();
				resultSet = statement.executeQuery(query);
				if(resultSet.next())
				{
					if(resultSet.getString("CUsername").equals(string) && resultSet.getString("CPassword").equals(string2))
					{
						return true;
					}
				}
			}
			catch(SQLException e)
			{
				System.out.println("Login Error: "+e.getMessage());
			}
		}
		return false;
	}

	

}
