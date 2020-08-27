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
	<h1>Index Page</h1>
	<form action="/LoginSecurity/welcome" method="post">
		<input type="text" name="username"/>
		<input type="password" name="password"/>
		<button>Login</button>
	</form>
	<a href="/LoginSecurity/register">Register</a>
</body>
</html>