package com.niit.advjavademos.helloworld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String uvalue = request.getParameter("userid");
	    String pvalue = request.getParameter("password");
	    String uval = request.getParameter("userid");
	    String pval = request.getParameter("password");
	    if((uvalue.equals("Admin")) && (pvalue.equals("admin")))
	    {
	    	request.setAttribute("rcVw",uvalue);
	    	request.setAttribute("rcVw",pvalue);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("Valid");
	    	dispatcher.forward(request, response);
	    }
	    else if((uval.equals("Guest")) && (pval.equals("guest")))
	    	{
	    		request.setAttribute("pcVw",uval);
	    		request.setAttribute("pcVw",pval);
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("Guest");
	    		dispatcher.forward(request, response);
	    	}
	    else
	    {
	    	request.setAttribute("ucVW",uvalue);
	    	request.setAttribute("ucVw",pvalue);
	    	RequestDispatcher eu = request.getRequestDispatcher("Invalid");
	    	eu.forward(request, response);
	    	
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
