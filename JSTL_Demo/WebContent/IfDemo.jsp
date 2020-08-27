<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		<input type="text" name="Userage"/>
		<input type="submit" value="submit"/>
	</form>
	<c:set var="Usrage" value="${param.Userage}"/>
	<c:if test="${Usrage>18}">
			<h1><c:out value="you can vote"></c:out></h1>
	</c:if>
	
	
</body>
</html>