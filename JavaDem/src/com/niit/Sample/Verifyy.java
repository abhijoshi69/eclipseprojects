package com.niit.Sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Verifyy
 */
@WebServlet("/Verifyy")
public class Verifyy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verifyy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user="sa";
		String pwds="sasa";
		String url="jdbc:sqlserver://localhost:1433;databaseName=registration";
		String query="Select * from reg";
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,user,pwds);
			PreparedStatement pt = con.prepareStatement(query);
			ResultSet rs = pt.executeQuery();
			while(rs.next())
			{
				if(rs.getString("username").equals(username) && rs.getString("password").equals("password"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
					rd.forward(request, response);
				}
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
