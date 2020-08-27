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
		<jsp:include page="display.jsp"></jsp:include>
</head>
<body>
<%response.setHeader("Cache","no-cache,no-store,must-revalidate"); %>
		<form action="ProcessServlet">
			<div class="container center">
			<div class="jumbotron">
  					<div class="form-group row-sm-4">
  					<div class="form-group row">
    						<label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Product ID:</label>
    						<div class="col-sm-8">
      							<input type="text" class="form-control form-control-lg" id="colFormLabelLg" name="productid">
    						</div>
  					</div>
  					<div class="form-group row">
    					<label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Product Name:</label>
    					<div class="col-sm-8">
      						<input type="text" class="form-control form-control-lg" id="colFormLabelLg" name="productname">
   					 	</div>
 					 </div>
  					<div class="form-group row">
    					<label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Product Quantity:</label>
    					<div class="col-sm-8">
      						<input type="text" class="form-control form-control-lg" id="colFormLabelLg" name="productquantity">
    					</div>
  					</div>
  					<div class="form-group row">
    					<label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">Product Description:</label>
    					<div class="col-sm-8">
  							  <textarea class="form-control" id="exampleFormControlTextarea1" rows="6" name="productdescription"></textarea>
      
    					</div>
  					</div>
  								<center><button type="submit" class="btn btn-primary btn-lg">Submit</button></center>
  					</div>
 		 </div>
		</form>
	
</body>
</html>