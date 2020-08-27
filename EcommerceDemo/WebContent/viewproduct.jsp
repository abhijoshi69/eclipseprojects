<%@page import="java.util.List"%>
<%@page import="com.niit.advjava.demos.Sample.Model1"%>
<%@page import="com.niit.advjava.demos.Sample.DB_Conn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  		<jsp:include page="display.jsp"/>
</head>
<body>
<%response.setHeader("Cache","no-cache,no-store,must-revalidate"); %>
		<%
			DB_Conn db = new DB_Conn();
			String id = request.getParameter("viewd");
			List<Model1> onedata = db.viewbyid(id);
			if(onedata.size()>0)
			{
		%>
				<div class="container">
				<div class="jumbotron cols-sm-8">
				<form>
				<%
					for(Model1 model1 : onedata)
					{
				%>
							<div class="align: center">
							<div class="form-group">
								<label for="id">ProductID:</label>
								<%=id %>	
							</div>
							<div class="form-group">
								<label for="name">ProductName:</label>
								<%=model1.getProductname() %>
							</div>
							<div class="form-group">
								<label for="quantity">ProductQuantity:</label>
								<%=model1.getProductquantity() %>
							</div>
							<div class="form-group">
								<label for="description">ProductDescription:</label>
								<%=model1.getProductdescription() %>
							</div>
							</div>
							<a href="viewall.jsp"><button type="button" class="btn btn-secondary btn-sm">Back</button></a>
					<%
						}
					%>
					</form>
					</div>
					</div>
			<%
			}
		
			%>
							
</body>
</html>