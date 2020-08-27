package com.learning.productservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learning.models.ProductModel;

public class DOA_Imp implements IDOA 
{
	String user="sa";
	String pwd="";
	String url="jdbc:sqlserver://localhost:1433;databaseName=online";
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	ProductModel productModel = null;
	

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
			System.out.println("ClassNotFoundException Error: "+e.getMessage());
		}
		catch(SQLException e)
		{
			System.out.println("Connection Error: "+e.getMessage());
		}
		return false;
	}


	public int insertData(ProductModel productModel) 
	{
		int rowsaffected = 0;
		if(isConnected())
		{
			String query = "insert into product values (?,?,?,?,?,?)";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,productModel.getProductid());
				preparedStatement.setString(2,productModel.getProductname());
				preparedStatement.setInt(3,productModel.getProductquantity());
				preparedStatement.setInt(4,productModel.getProductcost());
				preparedStatement.setString(5,productModel.getProductdescription());
				preparedStatement.setString(6,productModel.getProductimagefilename());
				preparedStatement.setString(7,productModel.getProdcutimagepath());
				rowsaffected = preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("Data inserting Error: "+e.getMessage());
			}
			
		}
		return rowsaffected;
	}


	public List<ProductModel> getData() 
	{
		List<ProductModel> productList = new ArrayList();
		if(isConnected())
		{
			String query = "select * from product2";
			try
			{
				statement = connection.createStatement();
				resultSet = statement.executeQuery(query);
				while(resultSet.next())
				{
					productModel = new ProductModel();
					productModel.setProductid(resultSet.getInt("Productid"));
					productModel.setProductname(resultSet.getString("Productname"));
					productModel.setProductquantity(resultSet.getInt("Productquantity"));
					productModel.setProductcost(resultSet.getInt("Productcost"));
					productModel.setProductdescription(resultSet.getString("Productdescription"));
					productModel.setProductimagefilename(resultSet.getString("ProductImageFilename"));
					//productModel.setProdcutimagepath(resultSet.getString("ProductImagePath"));
					productList.add(productModel);
				}
			}
			catch(SQLException e)
			{
				System.out.println("Getting Error: "+e.getMessage());
			}
		}
		return productList;
	}


	public List<ProductModel> getById(int i) 
	{
		List<ProductModel> oneproduct = new ArrayList();
		if(isConnected())
		{
			String query = "select * from product2 where productid=?";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1,i);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next())
				{
					productModel = new ProductModel();
					productModel.setProductid(resultSet.getInt("Productid"));
					productModel.setProductname(resultSet.getString("Productname"));
					productModel.setProductquantity(resultSet.getInt("Productquantity"));
					productModel.setProductcost(resultSet.getInt("Productcost"));
					productModel.setProductdescription(resultSet.getString("Productdescription"));
					productModel.setProductimagefilename(resultSet.getString("ProductImageFilename"));
					oneproduct.add(productModel);
				}
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return oneproduct;
	}


	public int updateProduct(int i, ProductModel productModel) 
	{
		int rowsaffected = 0;
		if(isConnected())
		{
			String query = "update product2 "
					+ "set productname=?,"
					+ "productquantity=?,"
					+ "productcost=?,"
					+ "productdescription=?,"
					+ "productimagefilename=?,"
					+ "productimagepath=? "
					+ "where productid='"+i+"'";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1,productModel.getProductname());
				preparedStatement.setInt(2,productModel.getProductquantity());
				preparedStatement.setInt(3, productModel.getProductcost());
				preparedStatement.setString(4,productModel.getProductdescription());
				preparedStatement.setString(5,productModel.getProductimagefilename());
				preparedStatement.setString(6,productModel.getProdcutimagepath());
				rowsaffected = preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return rowsaffected;
	}


	public int deleteProduct(int i) 
	{
		int deletedrows = 0;
		if(isConnected())
		{
			String query = "delete from product2 where productid='"+i+"'";
			try
			{
				preparedStatement = connection.prepareStatement(query);
				deletedrows = preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		
		return deletedrows;
	}



}
