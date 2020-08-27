<%@page import="com.learning.productservices.DOA_Imp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Navbar.jsp"></jsp:include>
<%response.setHeader("Cache","no-cache,no-store,must-revalidate"); %>
	<%
		DOA_Imp doa = new DOA_Imp();
		int id = Integer.parseInt(request.getParameter("viewid"));
		int rowsaffected = doa.deleteProduct(id);
		if(rowsaffected > 0)
		{
	%>
			<%
					RequestDispatcher dispatcher = request.getRequestDispatcher("ProductView.jsp");
					dispatcher.forward(request, response);
			%>
			
	<%
		}	
	%>
</body>
</html>