<%@page import="java.sql.Connection"%>
<%@page import="java.net.ConnectException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--This is a comment --%>
	<%! int a=5; %>
	<h1>
	<%
		out.println("Hello JSP");
	%>
	</h1>
	<%= a+5 %>
	<% out.println(a); %>
	<%Connection %>
	

</body>
</html>