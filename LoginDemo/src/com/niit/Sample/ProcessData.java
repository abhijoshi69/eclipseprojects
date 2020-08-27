package com.niit.Sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
		
		String user="sa";
		String pwd="sasa";
		String url="jdbc:sqlserver://localhost:1433;databaseName=registration";
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("pwd");
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String query = "Insert into reg11 values (?,?,?,?,?,?,?,?,?)";
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement pt = con.prepareStatement(query);
			pt.setString(1,fname);
			pt.setString(2,lname);
			pt.setString(3,emailid);
			pt.setString(4,password);
			pt.setString(5,username);
			pt.setString(6,address);
			pt.setString(7,city);
			pt.setString(8,state);
			pt.setString(9,zip);
			pt.executeUpdate();
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
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
