package com.learning.springloginsecurity.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.learning.springloginsecurity.dbconfig.CreateConnection;
import com.learning.springloginsecurity.model.UserModel;

@Component
public class DOA_Imp implements IDOA 
{
	CreateConnection createConnection = new CreateConnection();
	Connection connection = createConnection.getConnection();
	
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	String query = null;
	
	UserModel model = null;
	
	public int insertCredentials(UserModel model) 
	{
		int rowsaffected = 0;
		try
		{
			query = "insert into credentials values (?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,model.getUsername());
			preparedStatement.setString(2,model.getPassword());
			rowsaffected = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Insertion Error: "+e.getMessage());
		}
		return rowsaffected;
	}

	public boolean checkCredentials(String string, String string2)
	{
		try
		{
			query = "select * from credentials where username='"+string+"'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if(resultSet.next())
			{
				if( BCrypt.checkpw(string2,resultSet.getString("password")))
				{
					return true;
				}
			}
		}
		catch(SQLException e)
		{
			System.out.println("Login Failed "+e.getMessage());
		}
		return false;
	}
	
	
}
