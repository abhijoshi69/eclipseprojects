<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>
  <!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Google Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-dark indigo">
		<span class="navbar-text white-text">
    		Index Page
  		</span>
  		<form action="/SpringMvcDb/insertpage" class="form-inline my-2 my-lg-0 ml-auto" method="post">
    			<button class="btn peach-gradient btn-md my-2 my-sm-0 ml-3" value="submit">Add New Details</button>	
  		</form>
	</nav>
	<c:if test="${users!=null }">
	<table class="table table-hover">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Address</th>
				<th scope="col" colspan="3"></th>
			</tr>
		</thead>
		<c:forEach var="user" items="${users}">
		<tbody>
		<tr>
			<td><c:out value="${user.id}"></c:out></td>
			<td><c:out value="${user.name}"></c:out></td>
			<td><c:out value="${user.address}"></c:out></td>
			<td><a href="view/${user.id}"><button type="button" class="btn btn-info btn-rounded btn-sm">View</button></a></td>
			<td><a href="edit/${user.id}"><button type="button" class="btn btn-info btn-rounded btn-sm">Edit</button></a></td>
			<td><a href="delete/${user.id}"><button type="button" class="btn btn-info btn-rounded btn-sm">Delete</button></a></td>
		<tr>
		</tbody>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>