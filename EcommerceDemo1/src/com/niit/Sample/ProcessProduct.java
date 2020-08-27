package com.niit.Sample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessProduct
 */
@WebServlet("/ProcessProduct")
public class ProcessProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productid = Integer.parseInt(request.getParameter("productid"));
		String productname = request.getParameter("productname");
		int productquantity = Integer.parseInt(request.getParameter("productquantity"));
		int productcost = Integer.parseInt(request.getParameter("productcost"));
		String productdescription = request.getParameter("productdescription");
		DB_Conn db = new DB_Conn();
		Model model = new Model(productid,productname,productquantity,productcost,productdescription);
		int productinserted = db.addProducts(model);
		if(productinserted>0)
		{
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
