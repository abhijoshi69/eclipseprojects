package com.niit.Sample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.advjava.demos.Sample.DB_Conn;
import com.niit.advjava.demos.Sample.Model1;

/**
 * Servlet implementation class UpdateProcess
 */
@WebServlet("/UpdateProcess")
public class UpdateProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productid = request.getParameter("id");
		String productname = request.getParameter("name");
		String productquantity = request.getParameter("quantity");
		String productdescription = request.getParameter("description");
		DB_Conn db = new DB_Conn();
		
		Model1 model2 = new Model1(productid,productname,productquantity,productdescription);
		
		int productinserted = db.edit(productid, model2);
		//System.out.println(productinserted);
		if(productinserted>0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("viewall.jsp");
			rd.forward(request, response);
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
