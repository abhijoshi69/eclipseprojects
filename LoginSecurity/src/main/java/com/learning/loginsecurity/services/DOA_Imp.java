package com.learning.loginsecurity.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.learning.loginsecurity.dbconfig.CreateConnection;
import com.learning.loginsecurity.model.UserModel;
@Component
public class DOA_Imp implements IDOA 
{
	CreateConnection createConnection = new CreateConnection();
	Connection connection = createConnection.getConnection();
	
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	String query = null;
	
	UserModel model=null;

	public int insertCredentials(UserModel model) 
	{
		int rowsaffected = 0;
		try
		{
			query = "insert into admin values (?,?)";
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

	public boolean login(String string,String string2) 
	{
		boolean isLoggedIn = false;
		try
		{
			
			query = "select * from admin where username='"+string+"' and password='"+string2+"'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if(resultSet.next())
			{
				/*if(resultSet.getString("username").equals(string) && resultSet.getString("password").equals(string2))
				{
					System.out.println("username"+string+"and password"+string2);
					return true;
				}*/
				isLoggedIn = BCrypt.checkpw(string2,resultSet.getString("password"));
				
			}
		}
		catch(SQLException e)
		{
			System.out.println("Login Error: "+e.getMessage());
		}
		return isLoggedIn;
	}

	
}
