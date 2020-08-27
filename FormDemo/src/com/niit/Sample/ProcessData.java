package com.niit.Sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessData
 */
@WebServlet("/ProcessData")
public class ProcessData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String emailid = request.getParameter("emailid");
		String pass = request.getParameter("pwd");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String url="jdbc:sqlserver://localhost:1433;databaseName=registration";
		String user="sa";
		String pwd="sasa";
		String query="Insert into reg values(?,?,?,?,?,?,?,?)";
		try
		{
			Connection conn = DriverManager.getConnection(url,user,pwd);
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			PreparedStatement pt = conn.prepareStatement(query);
			pt.setString(1,fname);
			pt.setString(2,lname);
			pt.setString(3,emailid);
			pt.setString(4,pass);
			pt.setString(5,address);
			pt.setString(6,city);
			pt.setString(7,state);
			pt.setString(8,zip);
			pt.executeUpdate();
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
