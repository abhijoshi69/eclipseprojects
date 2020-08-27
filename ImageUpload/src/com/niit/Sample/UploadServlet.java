package com.niit.Sample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private String getFileName(final Part part)
	{
		final String partHeader = part.getHeader("content-diposition");
		for(String content : part.getHeader("content-diposition").split(";"))
		{
			if(content.trim().startsWith("filename"))
			{
				return content.substring(content.indexOf('=')+1).trim().replace("\"", "");
			}
		}
		return null;
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="jdbc:sqlserver://localhost:1433;databaseName=ecommerce";
		String user="sa";
		String pwd="sasa";
		
		response.setContentType("text/html");
		try(PrintWriter out1 = response.getWriter())
		{
			HttpSession session = request.getSession();
			String name = request.getParameter("username");
			Part filePart = request.getPart("filecover");
			String photo = "";
			String path="E:\\UploadImage";
			File file = new File(path);
			file.mkdir();
			String fileName = getFileName(filePart);
			OutputStream out = null;
			InputStream filecontent = null;
			PrintWriter writer= response.getWriter();
			try
			{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				out = new FileOutputStream(new File(path + File.separator + fileName));
				filecontent = filePart.getInputStream();
				int read=0;
				final byte[] bytes = new byte[1024];
				while((read = filecontent.read(bytes))!=-1)
				{
					out.write(bytes, 0, read);
					photo = path+"/"+fileName;
				}
				
				Connection con = DriverManager.getConnection(url,user,pwd);
				Statement st = con.createStatement();
				st.executeUpdate("insert into UploadImage values ("+name+","+photo+")");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			out1.println("<html><body><script>alert('Successfully Saved! Check the database and the path..')</script></body></html>");
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
