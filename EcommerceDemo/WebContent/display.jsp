<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		HttpSession session2 = null;
		session2 = request.getSession(false);
		if (session.getAttribute("name") != null) {
			String value = session2.getAttribute("name").toString();
	%>
	<nav class="navbar navbar-dark bg-dark justify-content-between">
		<a class="navbar-brand" style="color: #fff">Welcome <%=value%></a>
		<form class="form-inline">
			<button style="margin-left: 5px; color: #fff"
					class="btn btn-outline-success my-2 my-sm-0" type="submit">
				<a href="Product.jsp">ADD ITEM</a>
			</button>
			<button style="margin-left: 5px; color: #fff"
				class="btn btn-outline-success my-2 my-sm-0" type="submit">
				<a href="LogOut">LOG OUT</a>
			</button>
		</form>
	</nav>
	<%
				} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);

		}
	%>
</body>
</html>