package com.learning.imagejsonapi.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.imagejsonapi.dbconfig.CreateConnection;
import com.learning.imagejsonapi.model.UserModel;

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
			query = "insert into imagejson values (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,model.getId());
			preparedStatement.setString(2,model.getName());
			preparedStatement.setString(3,model.getAddress());
			preparedStatement.setString(4,model.getFilename());
			preparedStatement.setString(5,model.getPath());
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
			query = "select * from imagejson";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next())
			{
				model = new UserModel();
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				model.setAddress(resultSet.getString("address"));
				model.setFilename(resultSet.getString("filename"));
				model.setPath(resultSet.getString("path"));
				modelList.add(model);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Getting All Data Error: "+e.getMessage());
		}
		return modelList;
	}



	public UserModel oneData(int id) 
	{
		try
		{
			query = "select * from imagejson where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				model = new UserModel();
				model.setId(resultSet.getInt("id"));
				model.setName(resultSet.getString("name"));
				model.setAddress(resultSet.getString("address"));
				model.setFilename(resultSet.getString("filename"));
				model.setPath(resultSet.getString("path"));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Getting One Data Error: "+e.getMessage());
		}
		return model;
	}



	public int updateData(int id, UserModel model) 
	{
		int rowsaffected = 0;
		try
		{
			query = "update imagejson set "
					+ "name=?,"
					+ "address=?,"
					+ "filename=?,"
					+ "path=? where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,model.getName());
			preparedStatement.setString(2,model.getAddress());
			preparedStatement.setString(3,model.getFilename());
			preparedStatement.setString(4,model.getPath());
			preparedStatement.setInt(5,id);
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
			query = "delete from imagejson where id=?";
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
