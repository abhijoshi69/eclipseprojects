package com.learning.friendsdemotdd.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learning.friendsdemotdd.models.UserModel;

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
	
	String query = null;
	
	public boolean isConnected() 
	{
		try
		{
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection(url, user, pwd);
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

	public boolean insertData(UserModel model) 
	{
		boolean status = false;
		int rowsaffected = 0;
		if(isConnected())
		{
			query = "insert into friends values (?,?,?,?)";
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
				System.out.println("Insertion Error: "+e.getMessage());
			}
			finally
			{
				if(rowsaffected > 0)
				{
					status = true;
				}
			}
		}
		return status;
	}

	public List<UserModel> getData() 
	{
		List<UserModel> modelList = new ArrayList();
		
		if(isConnected())
		{
			query = "select * from friends";
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
				System.out.println("Error while Getting Data: "+e.getMessage());
			}
		}
		return modelList;
	}

	public List<UserModel> getById(int i)
	{
		List<UserModel> modelList = new ArrayList();
		if(isConnected())
		{
			query = "select * from friends where id=?";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,i);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next())
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
				System.out.println("Error while Getting Data By ID: "+e.getMessage());
			}
		}
		return modelList;
	}

	public int updateData(int i, UserModel model) 
	{
		
		int rowsaffected = 0;
		if(isConnected())
		{
			query = "update friends "
					+ "set name=?,"
					+ "address=?,"
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

	public boolean deleteData(int i) 
	{
		boolean status = false;
		int rowsaffected = 0;
		if(isConnected())
		{
			query = "delete from friends where id=?";
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
			finally
			{
				if(rowsaffected > 0)
				{
					status = true;
				}
			}
		}
		return status;
	}

}
