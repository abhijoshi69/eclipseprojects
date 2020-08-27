<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<jsp:useBean class="com.niit.userbeandemo.userModel" id="userModel">
		<jsp:setProperty name="userModel" property="userName" param="UserName"/>
		Welcome <jsp:getProperty name="userModel" property="userName"/>
	</jsp:useBean>


</body>
</html>