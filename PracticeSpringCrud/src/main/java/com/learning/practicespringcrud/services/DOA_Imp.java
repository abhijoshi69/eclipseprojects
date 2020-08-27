package com.learning.practicespringcrud.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.learning.practicespringcrud.dbconfig.CreateConnection;
import com.learning.practicespringcrud.model.UserModel;

@Component
public class DOA_Imp implements Idoaservice 
{
	CreateConnection createConnection = new CreateConnection();
	Connection connection = createConnection.getConnection();
	
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	UserModel model = null;
	
	String query = null;

	public int insertData(UserModel model) 
	{
		int rowsaffected = 0;
		try
		{
			query = "insert into practiceinfo values (?,?,?)";
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
	
	
}
