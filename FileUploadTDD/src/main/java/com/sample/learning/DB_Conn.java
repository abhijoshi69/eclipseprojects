package com.sample.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Conn 
{
	String name;
	String filename;
	String path;
	String url="jdbc:sqlserver://localhost:1433;databaseName=online";
	String user="sa";
	String pwd="sasa";
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	FileModel fileModel = null;
	
	public boolean isConnected()
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url,user,pwd);
			if(connection!=null)
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
	
	public int addFile(FileModel fileModel)
	{
		int rowsaffected = 0;
		if(isConnected())
		{
			String query = "insert into files1 values (?,?,?)";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1,fileModel.getName());
				preparedStatement.setString(2,fileModel.getPath());
				preparedStatement.setString(3,fileModel.getFilename());
				rowsaffected=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return rowsaffected;
	}
}
