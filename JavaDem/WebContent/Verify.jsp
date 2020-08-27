<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		String user="sa";
		String pwd="sasa";
		String url="jdbc:sqlserver://localhost:1433;databaseName=registration";
		String query="Select * from reg";
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement pt = con.prepareStatement(query);
			ResultSet rs = pt.executeQuery();
			while(rs.next())
			{
				if(rs.getString("username").equals(username) && rs.getString("password").equals(password))
				{
					out.println("Login Successfull")			
				}
			}
		}
		
	%>
</body>
</html>