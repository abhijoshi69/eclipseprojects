package com.learning.clientside_tdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DOAImp implements IDOA 
{

	String url="jdbc:sqlserver://localhost:1433;databaseName=online";
	String user="sa";
	String pwd="sasa";
	Connection con;
	UserModel model=null;
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	
	public boolean isConnected() 
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con= DriverManager.getConnection(url,user,pwd);
			if(con!=null)
			{
				return true;
			}
			return false;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return false;
	}

	public int insertData(UserModel model) 
	{
		int rowsaffected=0;
		if(isConnected())
		{
			String query = "insert into registration values (?,?,?,?,?,?,?)";
			try
			{
					pst = con.prepareStatement(query);
					pst.setInt(1,model.getC_id());
					pst.setString(2,model.getC_name());
					pst.setString(3,model.getC_address());
					pst.setString(4,model.getC_username());
					pst.setInt(5,model.getC_password());
					pst.setInt(6,model.getC_zip());
					pst.setString(7,model.getC_state());
					rowsaffected = pst.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return rowsaffected;
	}

	public boolean Login(String string, String i) 
	{
		if(isConnected())
		{
			String query = "select * from registration where CUsername='"+string+"' and CPassword='"+i+"'";
			try
			{
				st = con.createStatement();
				rs = st.executeQuery(query);
				if(rs.next())
				{
					if(rs.getString("CUsername").equals(string) && rs.getString("CPassword").equals(i))
					{
						return true;
					}
					return false;
				}
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return false;
	}

	

}
