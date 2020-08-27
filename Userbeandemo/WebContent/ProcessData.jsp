<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean class="com.niit.Sample.UserModel" id="model" scope="request">
		<jsp:setProperty property="username" name="model" value="${model.Username}">
			<jsp:forward page="ShowUser1.jsp"></jsp:forward>
		</jsp:setProperty>
		
		
	</jsp:useBean>
</body>
</html>