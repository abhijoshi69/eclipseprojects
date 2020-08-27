package com.niit.advjava.demos.Sample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessServlet
 */
@WebServlet("/ProcessServlet")
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
			String productid = request.getParameter("productid");
			String productname = request.getParameter("productname");
			String productquantity = request.getParameter("productquantity");
			String productdescription = request.getParameter("productdescription");
			DB_Conn  db = new DB_Conn();
			Model1 model = new Model1(productid,productname,productquantity,productdescription); 
			System.out.println(model);
			int rowinserted= db.addProduct(model);
			if(rowinserted>0)
			{
				response.getWriter().print("<script>alert('Product added Successfully!!')</script>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewall.jsp");
				dispatcher.forward(request, response);
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
