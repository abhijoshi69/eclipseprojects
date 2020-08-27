package com.learning.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessData
 */
public class ProcessData extends HttpServlet 
{
	RequestDispatcher dispatcher = null;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProcessData() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlPath = request.getServletPath();
		System.out.println(urlPath);
		switch(urlPath)	
		{
			case "/":
						dispatcher = request.getRequestDispatcher("/views/index.html");
						dispatcher.forward(request, response);
						break;
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
