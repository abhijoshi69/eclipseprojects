<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/LoginSecurity/save" method="post">
	<table>
		<tr>
			<td><label>Username:</label></td>
			<td>
				<input type="text" name="username" placeholder="Enter username"/> 
			</td>
		</tr>
		<tr>
			<td><label>Password:</label></td>
			<td>
				<input type="password" name="password" placeholder="Enter password"/>
			</td>
		</tr>
		<tr>
			<td>
				<button>Submit</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>