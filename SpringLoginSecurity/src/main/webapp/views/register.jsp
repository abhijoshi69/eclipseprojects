<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/SpringLoginSecurity/register" method="post">
		<table>
			<tr>
				<td><label>Username: </label></td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td><label>Password: </label></td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><button>Register</button></td>
			</tr>
		</table>
	</form>
</body>
</html>