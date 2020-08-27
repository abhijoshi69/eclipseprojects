package com.learning.friendsdemotdd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.learning.friendsdemotdd.models.UserModel;
import com.learning.friendsdemotdd.services.DOA_Imp;
import com.learning.friendsdemotdd.services.IDOA;

/**
 * Servlet implementation class ProcessData
 */

public class ProcessData extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    RequestDispatcher dispatcher = null;
    IDOA idoa;
    Gson gson = null;
    int result = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessData() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlPath = request.getServletPath();
		response.setContentType("application/json");
		switch(urlPath)
		{
		case "/":
					dispatcher = request.getRequestDispatcher("/views/index.jsp");
					dispatcher.forward(request, response);
					break;
				
		case "/display":
					idoa = new DOA_Imp();
					List<UserModel> userMap = new ArrayList();
					userMap = idoa.getData();
					gson = new Gson();
					String user = gson.toJson(userMap);
					response.getWriter().print(user);
					break;
					
		case "/view":
					idoa = new DOA_Imp();
					int viewid = Integer.parseInt(request.getParameter("id"));
					List<UserModel> userMaps = new ArrayList();
					userMaps = idoa.getById(viewid);
					gson = new Gson();
					String users = gson.toJson(userMaps);
					response.getWriter().print(users);
					break;
					
		case "/editdetails":
					idoa = new DOA_Imp();
					int editid = Integer.parseInt(request.getParameter("id"));
					List<UserModel> UserMap = new ArrayList<UserModel>();
					UserMap = idoa.getById(editid);
					gson = new Gson();
					String User = gson.toJson(UserMap);
					response.getWriter().print(User);
					break;
					
		case "/update":
					idoa = new DOA_Imp();
					gson = new Gson();
					UserModel model = gson.fromJson(request.getReader(),UserModel.class);
					result = idoa.updateData(model.getId(), model);
					if(result > 0)
					{
						response.getWriter().print("updated Successfully");
					}
					else
					{
						response.getWriter().print("not updated");
					}
					
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
