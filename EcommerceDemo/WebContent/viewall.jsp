<%@page import="com.niit.advjava.demos.Sample.Model1"%>
<%@page import="java.util.List"%>
<%@page import="com.niit.advjava.demos.Sample.DB_Conn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  		<jsp:include page="display.jsp"/>
</head>
<body>
<%response.setHeader("Cache-Control","no-store,no-cache,must-revalidate"); %>
	<%
			DB_Conn db = new DB_Conn();
			List<Model1> alldata = db.viewall();
			if(alldata.size()>0)
			{
	%>
		
    	
		<div class="container">
		
		<table class="table table-hover">
		<thead class="thead-dark">
		<tr>
			<th>ProductID</th>
			<th>ProductName</th>
			<th>ProductQuantity</th>
			<th>ProductDescription</th>
		</tr>
		</thead>
		<tbody>
		<%
			for(Model1 model1 : alldata)
			{
		%>
			<tr>
			<td>
		<%
				out.print(model1.getProductid());
		%>
			</td>
			<td>
		<%
				out.print(model1.getProductname());
		%>
			</td>
			<td>
		<%
				out.print(model1.getProductquantity());
		%>
			</td>
			<td>
		<%
				out.print(model1.getProductdescription());	
		%>
			</td>
			<td>
				<a href="viewproduct.jsp?viewd=<%=model1.getProductid() %>"><button type="button" class="btn btn-secondary btn-sm">View</button></a>
			</td>
			<td>
				<a href="updateproduct.jsp?viewd=<%=model1.getProductid() %>"><button type="button" class="btn btn-secondary btn-sm">Update</button></a>
			</td>
			<td>
				<a href="deleteproduct.jsp?viewd=<%=model1.getProductid() %>"><button type="button" class="btn btn-secondary btn-sm">Delete</button></a>
			</td>
			</tr>
		 <%
			 }
		 %>
			</tbody>
			</table>
			</div>
	<%
		}
			else
			{
		%>
				<div class="alert alert-warning alert-dismissible">
    				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    				<strong>Hey!</strong> Click on the Add Item button to add products.
  				</div>
		<%
			}

	%>
</body>
</html>