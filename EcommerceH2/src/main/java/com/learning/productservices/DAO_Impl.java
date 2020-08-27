package com.learning.productservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learning.models.ProdModel;

public class DAO_Impl implements IDAO {

	String url="jdbc:h2:tcp://localhost/~/test";
	String user="sa";
	String pwd="";
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	ProdModel prodModel = null;
	public boolean isConnected() 
	{
		try
		{
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection(url, user, pwd);
			if(connection!=null)
			{
				return true;
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("ClassNotFoundException Error: "+e.getMessage());
		}
		catch(SQLException e)
		{
			System.out.println("Connection Error: "+e.getMessage());
		}
		return false;
	}

	public int insertProd(ProdModel prodModel)
	{
		int rowsaffected = 0;
		if(isConnected())
		{
			String query = "insert into product values (?,?,?,?,?,?,?)";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,prodModel.getProductid());
				preparedStatement.setString(2,prodModel.getProductname());
				preparedStatement.setInt(3,prodModel.getProductquantity());
				preparedStatement.setInt(4,prodModel.getProductcost());
				preparedStatement.setString(5,prodModel.getProductdescription());
				preparedStatement.setString(6,prodModel.getProductimagefilename());
				preparedStatement.setString(7,prodModel.getProductimagepath());
				rowsaffected = preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("Insertion Error: "+e.getMessage());
			}
		}
		return rowsaffected;
	}

	public List<ProdModel> getProductData() 
	{
		List<ProdModel> productList = new ArrayList();
		if(isConnected())
		{
			String query = "select * from product";
			try
			{
				statement = connection.createStatement();
				resultSet = statement.executeQuery(query);
				while(resultSet.next())
				{
					prodModel = new ProdModel();
					prodModel.setProductid(resultSet.getInt("PRODUCTID"));
					prodModel.setProductname(resultSet.getString("PRODUCTNAME"));
					prodModel.setProductquantity(resultSet.getInt("PRODUCTQUANTITY"));
					prodModel.setProductcost(resultSet.getInt("PRODUCTCOST"));
					prodModel.setProductdescription(resultSet.getString("PRODUCTDESCRIPTION"));
					prodModel.setProductimagefilename(resultSet.getString("PRODUCTIMAGEFILENAME"));
					productList.add(prodModel);
				}
			}
			catch(SQLException e)
			{
				System.out.println("Getting Data Error: "+e.getMessage());
			}
		}
		return productList;
	}

	

	

}
