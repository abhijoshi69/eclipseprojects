<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<%
		String user = request.getParameter("user");
		String pass = request.getParameter("pwd");
		if(user.equals("Abhishek") && pass.equals("pass@123"))
		{
	%>
		<jsp:forward page="Success.jsp">
		<jsp:param value="<%=user%>" name="user"></jsp:param>
		</jsp:forward>
	<%
		}
		else
		{
				out.println("<h3>Invalid Credentials</h3>");
	%>
		<jsp:include page="index.jsp"></jsp:include>
	<%
		}
	%>
</body>
</html>