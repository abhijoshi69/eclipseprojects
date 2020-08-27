package com.learning.adminservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DOA_Imp implements IDOA {

	String url="jdbc:h2:tcp://localhost/~/test";
	String user="sa";
	String pwd="";
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
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
	public boolean Login(String string, String string2)
	{
		if(isConnected())
		{
			String query = "select * from admin where username='"+string+"'and password='"+string2+"'";
			try
			{
				statement = connection.createStatement();
				resultSet = statement.executeQuery(query);
				if(resultSet.next())
				{
					if(resultSet.getString("username").equals(string) && resultSet.getString("password").equals(string2))
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
