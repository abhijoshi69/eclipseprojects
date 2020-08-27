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
	<h1>Catch Demo</h1>
	<c:catch var="errMsg">
		<%int val=5/0; %>
		<c:set var="ans" value="${5/0}"></c:set>
		<c:out value="${ans}"></c:out>
	</c:catch>
	<c:if test="${errMsg!=null}">
		<h2 style="color:red">Exception :${errMsg}</h2>
		<h2 style="color:red">Exception Message :${errMsg.message}</h2>
	</c:if>

</body>
</html>