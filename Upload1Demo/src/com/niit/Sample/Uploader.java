package com.niit.Sample;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.sun.corba.se.pept.transport.OutboundConnectionCache;

/**
 * Servlet implementation class Uploader
 */
@WebServlet(name = "Uploader1", urlPatterns = { "/Uploader1" })
public class Uploader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uploader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		if(!ServletFileUpload.isMultipartContent(request))
		{
			out.println("Nothing to upload");
			return;
		}
		FileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemFactory);
		try
		{
			List<FileItem> items = upload.parseRequest((RequestContext) request);
			for(FileItem item : items)
			{
				String contentType = item.getContentType();
				if(!contentType.equals("image/jpg"))
				{
					out.println("only png format image files supported");
					continue;
				}
				File uploadDir = new File("E:\\UploadImage");
				File file = File.createTempFile("img","jpg",uploadDir);
				item.write(file);
				out.println("File Saved Successfully");
			}
		}
		catch(FileUploadException e)
		{
			out.println("upload fail");
		}
		catch(Exception e)
		{
			out.println("can't save");
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
