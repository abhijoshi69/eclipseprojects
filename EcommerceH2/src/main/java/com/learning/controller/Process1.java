package com.learning.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.learning.models.ProdModel;
import com.learning.productservices.DAO_Impl;

/**
 * Servlet implementation class Process1
 */
@MultipartConfig(fileSizeThreshold = 1024*1024*2,maxFileSize = 1024*1024*10,maxRequestSize = 1024*1024*50)
public class Process1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Process1() {
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
		Part part = request.getPart("productimage");
		String fileName = extractFileName(part);
		String savePath = "C:\\Users\\rahul\\eclipse-workspace\\EcommerceH2\\src\\main\\webapp\\images12" + File.separator + fileName;
		File fileSaveDir = new File(savePath);
		part.write(savePath + File.separator);
		DAO_Impl dao = new DAO_Impl();
		ProdModel prodModel = new ProdModel(productid, productname, productquantity, productcost, productdescription, fileName, savePath);
		int rowsaffected = dao.insertProd(prodModel);
		if(rowsaffected > 0)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("ProductView.jsp");
			dispatcher.forward(request, response);
		}
	}

	private String extractFileName(Part part) 
	{
		String contentDisp = part.getHeader("content-disposition");
		String [] items = contentDisp.split(";");
		for(String s : items)
		{
			if(s.trim().startsWith("filename"))
			{
				return s.substring(s.indexOf("=")+2,s.length()-1);
			}
		}
		return "";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
