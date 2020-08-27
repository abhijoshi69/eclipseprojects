package com.niit.advjava.demos.hellosampledemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloSample
 */
@WebServlet("/HelloSample")
public class HelloSample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloSample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = request.getParameter("username");
		String pw = request.getParameter("Password");
		if(un.equals("Admin"))
		{
		
			
			request.setAttribute("rcVw",un);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Username");
			
			dispatcher.forward(request, response);
			
			
			
		  
		}
		else
		{
			if(pw.equals("admin"))
			{
				request.setAttribute("pcVw",pw);
				RequestDispatcher rd = request.getRequestDispatcher("Password");
				rd.forward(request, response);
			}
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
