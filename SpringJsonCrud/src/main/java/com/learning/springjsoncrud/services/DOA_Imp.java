package com.learning.springjsoncrud.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.learning.springjsoncrud.dbconfig.CreateConnection;
import com.learning.springjsoncrud.models.UserModel;

public class DOA_Imp implements IDOA 
{
	CreateConnection createConnection = new CreateConnection();
	Connection connection = createConnection.getConnection();
	
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	 
	String query = null;
	
	UserModel model = null;
	
	public int insertData(UserModel model)
	{
		int rowsaffected = 0;
		try
		{
			query = "insert into info values (?,?,?)";
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
		return rowsaffected;
	}

	public int updateData(int i,UserModel model) 
	{
		int rowsaffected = 0;
		try
		{
			query = "update info set "
					+ "name=?,"
					+ "address=? "
					+ "where id=?";
					
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,model.getName());
			preparedStatement.setString(2,model.getAddress());
			preparedStatement.setInt(3,i);
			rowsaffected = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Updation Error: "+e.getMessage());
		}
		return rowsaffected;
	}

}
