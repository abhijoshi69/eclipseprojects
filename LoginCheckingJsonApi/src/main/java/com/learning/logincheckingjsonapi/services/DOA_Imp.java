package com.learning.logincheckingjsonapi.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.learning.logincheckingjsonapi.dbconfig.CreateConnection;
import com.learning.logincheckingjsonapi.model.UserModel;

@Component
public class DOA_Imp implements IDOA 
{

	CreateConnection createConnection = new CreateConnection();
	Connection connection = createConnection.getConnection();
	
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	UserModel model = null;
	
	String query = null;
	
	public int insertCredentials(UserModel model) 
	{
		String hashpw = BCrypt.hashpw(model.getPassword(),BCrypt.gensalt());
		int rowsaffected = 0;
		try
		{
			query = "insert into login values (?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,model.getUsername());
			preparedStatement.setString(2,hashpw);
			rowsaffected = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Insertion Error: "+e.getMessage());
		}
		return rowsaffected;
	}

	public boolean checkCredentials(String username, String password)
	{
		try
		{
			query = "select * from login where username='"+username+"'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if(resultSet.next())
			{
				while(BCrypt.checkpw(password, resultSet.getString("password")))
				{
					return true;
				}
			}
		}
		catch(SQLException e)
		{
			System.out.println("Login Failed");
		}
		return false;
	}
	
}
