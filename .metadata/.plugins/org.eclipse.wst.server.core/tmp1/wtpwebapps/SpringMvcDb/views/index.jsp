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
<h1>Index</h1>
	<c:if test="${users!=null }">
	<table border="2">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
			</tr>
		</thead>
		<c:forEach var="user" items="${users}">
		<tbody>
		<tr>
			<td><c:out value="${user.id}"></c:out></td>
			<td><c:out value="${user.name}"></c:out></td>
			<td><c:out value="${user.address}"></c:out></td>
			<td><a href="view/${user.id}">View</a></td>
			<td><a href="edit/${user.id}">Edit</a></td>
			<td><a href="delete/${user.id}">Delete</a></td>
		<tr>
		</tbody>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>