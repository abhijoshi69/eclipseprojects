package com.learning.demotesttdd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.h2.engine.User;
import org.h2.engine.UserAggregate;

import com.google.gson.Gson;
import com.learning.demotesttdd.models.UserModel;
import com.learning.demotesttdd.services.DOA_Imp;
import com.learning.demotesttdd.services.IDOA;

/**
 * Servlet implementation class ProcessData
 */
@WebServlet("/")
public class ProcessData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RequestDispatcher dispatcher = null;
    IDOA idoa;
    public ProcessData() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlPath = request.getServletPath();
		response.setContentType("application/json");
		System.out.println(urlPath);
		switch(urlPath)
		{
			case "/":
					dispatcher = request.getRequestDispatcher("/views/index.jsp");
					dispatcher.forward(request, response);
					break;
			case "/display":
					idoa = new DOA_Imp();
					List<UserModel> userMap = new ArrayList();
					userMap = idoa.getAllData();
					Gson gson = new Gson();
					String user = gson.toJson(userMap);
					response.getWriter().print(user);
					break;
			
			case "/onedata":
					idoa = new DOA_Imp();
					int viewid = Integer.parseInt(request.getParameter("id"));
					List<UserModel> model2 = idoa.getById(viewid);
					Gson gi = new Gson();
					String iop = gi.toJson(model2);
					response.getWriter().print(iop);
					break;
			
			case "/updatedata":
				idoa = new DOA_Imp();
				Gson gu = new Gson();
				UserModel userModel3= gu.fromJson(request.getReader(),UserModel.class);
				boolean datas = idoa.updataData(userModel3.getId(),userModel3);
				Map<String,Boolean> updatedata = new HashMap<String, Boolean>();
				updatedata.put("status",datas);
				response.getWriter().print(gu.toJson(updatedata));
				break;
			
			case "/delete":
				idoa = new DOA_Imp();
				int deleteid = Integer.parseInt(request.getParameter("id"));
				Gson p = new Gson();
				int result = idoa.deleteData(deleteid);
				if(result>0)
				{
					response.getWriter().print("deleted successfully");
				}
				else
				{
					response.getWriter().print("not deleted properly");
				}
				break;
			
			
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
