package com.niit.advjava.demos.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		// TODO Auto-generate
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border=1 bgcolor=yellow>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Studid</th>");
		out.println("<th>EmailID</th>");
		out.println("<th>Contact</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Abhishek</td>");
		out.println("<td>s001</td>");
		out.println("<td>abhishekjoshi0874@gmail.com</td>");
		out.println("<td>9987564439</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Sakshi</td>");
		out.println("<td>s002</td>");
		out.println("<td>sakshigada@gmail.com</td>");
		out.println("<td>984947303</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Rohit</td>");
		out.println("<td>s003</td>");
		out.println("<td>jerryfulani@gmail.com</td>");
		out.println("<td>9394734883</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Aparna</td>");
		out.println("<td>s004</td>");
		out.println("<td>aparnaraswe@gmail.com</td>");
		out.println("<td>739373993</td>");
		out.println("</tr>");
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
