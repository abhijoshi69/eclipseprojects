package com.niit.advjavademos.servlets;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class IP_Filter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, 
					urlPatterns = {"/ProcessData"},
		initParams = { 
				@WebInitParam(name = "ValidIP", value = "10.16.69.133")
		}, 
		servletNames = { "ProcessData" })
public class IP_Filter implements Filter {
	String ValidAddr;
    /**
     * Default constructor. 
     */
    public IP_Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String userIP = request.getRemoteAddr();
		
		if (userIP.equals(ValidAddr)) {
			System.out.println("Success");
			RequestDispatcher dispatcher = request.getRequestDispatcher("ProcessData");
			dispatcher.forward(request, response);
		}
		else
		{
			System.out.println("Failed");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.html");
			dispatcher.forward(request, response);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		ValidAddr = fConfig.getInitParameter("ValidIP").toString();
	}

}
