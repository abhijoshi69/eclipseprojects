package com.learning.services;

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
	String url="jdbc:h2:tcp://localhost/~/test";
	String user="sa";
	String pwd="";
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;

	UserModel model = null;
	
	public boolean isConnected() 
	{
		try
		{
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection(url, user, pwd);
			if(connection != null)
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
		int rowsaffected = 0;
		if(isConnected())
		{
			String query = "insert into Employee values (?,?,?,?)";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,model.getId());
				preparedStatement.setString(2,model.getName());
				preparedStatement.setString(3,model.getAddress());
				preparedStatement.setString(4,model.getPassword());
				rowsaffected = preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("Inserton Error: "+e.getMessage());
			}
		}
		return rowsaffected;
	}

	public List<UserModel> getData()
	{
		List<UserModel> modelList = new ArrayList();
		if(isConnected())
		{
			String query = "select * from Employee";
			try
			{
				statement = connection.createStatement();
				resultSet = statement.executeQuery(query);
				while(resultSet.next())
				{
					model = new UserModel();
					model.setId(resultSet.getInt("id"));
					model.setName(resultSet.getString("name"));
					model.setAddress(resultSet.getString("address"));
					model.setPassword(resultSet.getString("password"));
					modelList.add(model);
				}
			}
			catch(SQLException e)
			{
				System.out.println("Getting Data Error: "+e.getMessage());
			}
		}
		return modelList;
	}

	public int updateData(int i, UserModel model) 
	{
		int rowsaffected = 0;
		if(isConnected())
		{
			String query = "update Employee "
					+ "set name=?, "
					+ "address=?, "
					+ "password=? "
					+ "where id=?";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1,model.getName());
				preparedStatement.setString(2,model.getAddress());
				preparedStatement.setString(3,model.getPassword());
				preparedStatement.setInt(4,i);
				rowsaffected = preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("Updation Error: "+e.getMessage());
			}
		}
		return rowsaffected;
	}

	public UserModel getById(int i) 
	{
		if(isConnected())
		{
			String query = "select * from Employee where id=?";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,i);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next())
				{
					model = new UserModel();
					model.setName(resultSet.getString("name"));
					model.setAddress(resultSet.getString("address"));
					model.setPassword(resultSet.getString("password"));
				}
			}
			catch(SQLException e)
			{
				System.out.println("GetById Error: "+e.getMessage());
			}
		}
		if(model!=null)
		{
			return model;
		}
		return null;
	}

	public int deleteData(int i, UserModel model) 
	{
		int rowsaffected = 0;
		if(isConnected())
		{
			String query = "delete from Employee where id=?";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,i);
				rowsaffected = preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("Deletion Error: "+e.getMessage());
			}
		}
		return rowsaffected;
	}

	

}
