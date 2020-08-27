package com.learning.spirngjsonapi.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.spirngjsonapi.dbconfig.CreateConnection;
import com.learning.spirngjsonapi.model.UserModel;

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

	public int insertData(UserModel model) 
	{
		int rowsaffected = 0;
		try
		{
			query = "insert into jsonapi values (?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,model.getId());
			preparedStatement.setString(2,model.getUsername());
			preparedStatement.setString(3,model.getPassword());
			preparedStatement.setString(4,model.getContactno());
			rowsaffected = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Insertion Error: "+e.getMessage());
		}
		
		return rowsaffected;
	}

	public UserModel viewOneData(int id) 
	{
		
		try
		{
			query = "select * from jsonapi where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				model = new UserModel();
				model.setId(resultSet.getInt("id"));
				model.setUsername(resultSet.getString("username"));
				model.setPassword(resultSet.getString("password"));
				model.setContactno(resultSet.getString("contactno"));
				
			}
			
		}
		catch(SQLException e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		return model;
	}

	public List<UserModel> viewAll()
	{
		List<UserModel> modelList = new ArrayList();
		try
		{
			query = "select * from jsonapi";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next())
			{
				model = new UserModel();
				model.setId(resultSet.getInt("id"));
				model.setUsername(resultSet.getString("username"));
				model.setPassword(resultSet.getString("password"));
				model.setContactno(resultSet.getString("contactno"));
				modelList.add(model);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Getting All Data Error: "+e.getMessage());
		}
		return modelList;
	}

	public int updateData(int id, UserModel model) 
	{
		int rowsaffected = 0;
		try
		{
			query = "update jsonapi set "
					+ "username=?,"
					+ "password=?,"
					+ "contactno=? "
					+ "where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,model.getUsername());
			preparedStatement.setString(2,model.getPassword());
			preparedStatement.setString(3,model.getContactno());
			preparedStatement.setInt(4,id);
			rowsaffected = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Updation Error: "+e.getMessage());
		}
		return rowsaffected;
	}

	public int deleteData(int id) 
	{
		int rowsaffected = 0;
		try
		{
			query = "delete from jsonapi where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			rowsaffected = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Deletion Error: "+e.getMessage());
		}
		return rowsaffected;
	}
	
	
}
