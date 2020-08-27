package com.learning.spirngjsonapi.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class CreateConnection 
{
	String url="jdbc:h2:tcp://localhost/~/test";
	String user="sa";
	String pwd="";
	
	Connection connection = null;
	
	public Connection getConnection()
	{
		try
		{
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection(url, user, pwd);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundExceptioin Error: "+e.getMessage());
		}
		catch(SQLException e)
		{
			System.out.println("Connection Error: "+e.getMessage());
		}
		
		return connection;
	}
	
	public boolean checkConnection()
	{
		boolean isConnection = true;
		getConnection();
		if(connection.equals(null))
		{
			isConnection = false;
		}
		return isConnection;
	}
}
