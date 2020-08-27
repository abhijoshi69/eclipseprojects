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
import javax.swing.JOptionPane;



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
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String emailid = request.getParameter("emailid");
		String pass = request.getParameter("pwd");
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String url="jdbc:sqlserver://localhost:1433;databaseName=registration";
		String user="sa";
		String pwd="sasa";
		String query="Insert into reg values(?,?,?,?,?,?,?,?,?)";
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,user,pwd);
			
			PreparedStatement pt = con.prepareStatement(query);
			pt.setString(1,fname);
			pt.setString(2,lname);
			pt.setString(3,emailid);
			pt.setString(4,pass);
			pt.setString(5,username);
			pt.setString(6,address);
			pt.setString(7,city);
			pt.setString(8,state);
			pt.setString(9,zip);
			int val=pt.executeUpdate();
			//JOptionPane.showMessageDialog(null, "Values Inserted");
			if (val>0) {
				System.out.println("Success");
			}
			else
			{
				System.out.println("Fail");
			}
			
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
