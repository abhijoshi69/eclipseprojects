<%@page import="com.learning.models.ProdModel"%>
<%@page import="java.util.List"%>
<%@page import="com.learning.productservices.DAO_Impl"%>
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
  		<style>
  			#divide
			{
				width: 300px;
				word-break: normal;
			}
			
  		</style>
</head>
<body>
<%
	DAO_Impl dao = new DAO_Impl();
	List<ProdModel> alldata = dao.getProductData();
	if(alldata.size()>0)
	{
%>
		<table class="table table-hover">
			<thead class="thead-dark">
				<th scope="col">ProductId</th>
				<th scope="col">ProductName</th>
				<th scope="col">ProductQuantity</th>
				<th scope="col">ProductCost (per Item)</th>
				<th scope="col">ProductDescription</th>
				<th scope="col">ProductImage</th>
				<th scpoe="col" colspan="3"></th>
			</thead>
			<tbody>
			<%
				for(ProdModel model : alldata)
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
						<td id="divide">
							<%
								out.print(model.getProductdescription());
							%>
						</td>la;lakjdlkkkddldldkjlkdlddkdkdkdkldkjdlkjdlkjfljkdflkdkdkddkjdkdfkjdkdfjdfdkjdfdfjdkjfjdj
						<td>
							<img  src="images12/<%=model.getProductimagefilename()%>" width="100" height="100"/>
						</td>
						<td>
								<a href="OneProductView.jsp?viewid=<%=model.getProductid() %>"><button type="button" class="btn btn-secondary btn-sm">View</button></a>
							</td>
							<td>
								<a href="UpdateProduct.jsp?viewid=<%=model.getProductid() %>"><button type="button" class="btn btn-secondary btn-sm">Update</button></a>
							</td>
							<td>
								<a href="DeleteProduct.jsp?viewid=<%=model.getProductid() %>"><button type="button" class="btn btn-secondary btn-sm">Delete</button></a>
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