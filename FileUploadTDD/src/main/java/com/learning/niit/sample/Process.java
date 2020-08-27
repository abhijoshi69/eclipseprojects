package com.learning.niit.sample;

import java.awt.event.ItemEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sample.learning.DB_Conn;
import com.sample.learning.FileModel;

/**
 * Servlet implementation class Process
 */
@MultipartConfig(fileSizeThreshold = 1024*1024*2,maxFileSize = 1024*1024*10,maxRequestSize = 1024*1024*50)
public class Process extends HttpServlet 
{

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Process() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		Part part = request.getPart("file");
		String fileName = extractFileName(part);
		String savePath = "C:\\Users\\rahul\\eclipse-workspace\\FileUploadTDD\\src\\main\\webapp\\images\\" + File.separator + fileName;
		File fileSaveDir = new File(savePath);
		part.write(savePath + File.separator); 
		DB_Conn db = new DB_Conn();
		FileModel fileModel = new FileModel(name, savePath, fileName);
		int rowsaffected = db.addFile(fileModel);
		if(rowsaffected > 0)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("View.jsp");
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
