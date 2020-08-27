package com.learning.demotesttdd.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learning.demotesttdd.models.UserModel;

public class DOA_Imp implements IDOA 
{
	String url="jdbc:h2:tcp://localhost/~/test";
	String user="sa";
	String pwd="";
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	String query = null;
	UserModel model = null;

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
			System.out.println("ClassNotFoundExecption Error: "+e.getMessage());
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
			query = "insert into Employee values (?,?,?,?)";
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

	public List<UserModel> getAllData() 
	{
		List<UserModel> modelList = new ArrayList();
		if(isConnected())
		{
			query = "select * from Employee";
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
				System.out.println("Getting All Data Error: "+e.getMessage());
			}
		}
		return modelList;
	}

	public List<UserModel> getById(int i)
	{
		System.out.println("id is:"+i);
		List<UserModel> modelList = new ArrayList();
		if(isConnected())
		{
			query = "select * from Employee where id=?";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,i);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next())
				{
					model = new UserModel();
					model.setId(i);
					model.setName(resultSet.getString("name"));
					model.setAddress(resultSet.getString("address"));
					model.setPassword(resultSet.getString("password"));
					modelList.add(model);
				}
			}
			catch(SQLException e)
			{
				System.out.println("Getting Data By Id Error: "+e.getMessage());
			}
		}
		return modelList;
	}

	public boolean updataData(int i, UserModel model) 
	{
		System.out.println("value of id is "+i);
		boolean status=false;
		int rowsaffected = 0;
		if(isConnected())
		{
			query = "update Employee "
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
			finally {
				if(rowsaffected>0)
				{
					status=true;
				}
			}
		}
		return status;
	}

	public int deleteData(int i)
	{
		
		System.out.println(i);
		int rowsaffected = 0;
		if(isConnected())
		{
			query = "delete from Employee where id=?";
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
