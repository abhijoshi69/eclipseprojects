package com.learning.springmvcdb.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.springmvcdb.dbconfig.CreateConnection;
import com.learning.springmvcdb.model.UserModel;

@Component
public class DOA_Imp implements IDOA
{
	CreateConnection createConnection = new CreateConnection();
	Connection connection = createConnection.getConnection();
	
	UserModel model = null;
	
	String query = null;
	
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	public int insertData(UserModel model) 
	{
		int rowsaffected = 0;
		
		try
		{
			query = "insert into Student values (?,?,?)";
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

	public List<UserModel> getAllData() 
	{
		List<UserModel> modelList = new ArrayList();
		try
		{
			query = "select * from Student";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next())
			{
				model = new UserModel();
				model.setId(resultSet.getInt("ID"));
				model.setName(resultSet.getString("Name"));
				model.setAddress(resultSet.getString("Address"));
				modelList.add(model);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Getting All Data Error: "+e.getMessage());
		}
		return modelList;
	}

	public int updateData(int i, UserModel model)
	{
		int rowsaffected = 0;
		
		try
		{
			query = "update Student "
					+ "set name=?,"
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

	public UserModel getDataById(int i) 
	{
		
		try
		{
			query = "select * from Student where id=?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,i);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				model = new UserModel();
				model.setId(resultSet.getInt("ID"));
				model.setName(resultSet.getString("Name"));
				model.setAddress(resultSet.getString("Address"));
				
			}
			
		}
		catch(SQLException e)
		{
			System.out.println("Getting Data By ID Error: "+e.getMessage());
		}
		
		return model;
	}

	public int deleteData(int i)
	{
		int rowsaffected =0;
		try
		{
			query = "delete from Student where id=?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,i);
			rowsaffected = preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Deletion Error: "+e.getMessage());
		}
		
		return rowsaffected;
	}

	
	
	
	
	
}
