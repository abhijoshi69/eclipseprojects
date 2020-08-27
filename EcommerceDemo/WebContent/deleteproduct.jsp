<%@page import="com.niit.advjava.demos.Sample.DB_Conn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="display.jsp"></jsp:include>
</head>
<body>
	
	
		<%	
			DB_Conn db =new DB_Conn();
			String id = request.getParameter("viewd");
			int productdeleted = db.delete(id);
			if(productdeleted>0)
			{
		%>
				<%RequestDispatcher rd = request.getRequestDispatcher("viewall.jsp");
					rd.forward(request, response);	
				%>
			<%
			}
		%>
					
</body>
</html>