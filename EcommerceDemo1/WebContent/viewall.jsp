<%@page import="com.niit.Sample.Model"%>
<%@page import="java.util.List"%>
<%@page import="com.niit.Sample.DB_Conn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="gradient.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<%
	DB_Conn db = new DB_Conn();
	List<Model> alldata = db.viewall();
	if(alldata.size()>0)
	{
%>
		<table class="table table-hover">
  			<thead class="thead-dark">
    			<tr>
      				<th scope="col">ProductID</th>
      				<th scope="col">ProductName</th>
      				<th scope="col">ProductQuantity</th>
      				<th scope="col">ProductCost</th>
      				<th scope="col">Product</th>
      			</tr>
  			</thead>
  			<tbody>
    			<%
    				for(Model model : alldata)
    				{
    			%>
    					<tr>
    						<td>
    							<%
    								out.print(model.getProductid());
    							%>
    						</td>
    						<td>
    							<%
    								out.print(model.getProductname());
    							%>
    						</td>
    						<td>
    							<%
    								out.print(model.getProductquantity());
    							%>
    						</td>
    						<td>
    							<%
    								out.print(model.getProductcost());
    							%>
    						</td>
    						<td>
    							<%
    								out.print(model.getProductdescription());
    							%>
    						</td>
    						<td>
				<a href="viewproduct.jsp?viewd=<%=model.getProductid() %>"><button type="button" class="btn btn-secondary btn-sm">View</button></a>
			</td>
			<td>
				<a href="updateproduct.jsp?viewd=<%=model.getProductid() %>"><button type="button" class="btn btn-secondary btn-sm">Update</button></a>
			</td>
			<td>
				<a href="deleteproduct.jsp?viewd=<%=model.getProductid() %>"><button type="button" class="btn btn-secondary btn-sm">Delete</button></a>
			</td>
    					</tr>
    					<%
    				}
    					%>
			</tbody>
</table>
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