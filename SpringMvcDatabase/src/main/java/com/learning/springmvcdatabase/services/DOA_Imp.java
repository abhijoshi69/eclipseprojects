package com.learning.springmvcdatabase.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.learning.springmvcdatabase.model.UserModel;

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
			if(connection != null)
			{
				return true;
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundError: "+e.getMessage());
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
			query = "insert into student values (?,?,?)";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,model.getId());
				preparedStatement.setString(2,model.getName());
				preparedStatement.setString(3,model.getAddress());
				rowsaffected = preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("Insertion Error: "+e.getMessage());
			}
		}
		return rowsaffected;
	}

}
