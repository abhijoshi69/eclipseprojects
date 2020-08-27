<%@page import="com.learning.models.ProductModel"%>
<%@page import="java.util.List"%>
<%@page import="com.learning.productservices.DOA_Imp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">


body {
  font-family: "Poppins", sans-serif;
  height: 100vh;
}

a {
  color: #92badd;
  display:inline-block;
  text-decoration: none;
  font-weight: 400;
}

h2 {
  text-align: center;
  font-size: 16px;
  font-weight: 600;
  text-transform: uppercase;
  display:inline-block;
  margin: 40px 8px 10px 8px; 
  color: #cccccc;
}



/* STRUCTURE */

.wrapper {
  display: flex;
  align-items: center;
  flex-direction: column; 
  justify-content: center;
  width: 100%;
  min-height: 100%;
  padding: 20px;
}

#formContent {
  -webkit-border-radius: 10px 10px 10px 10px;
  border-radius: 10px 10px 10px 10px;
  background: #fff;
  padding: 25px;
  width: 90%;
  max-width: 450px;
  position: relative;
  padding: 0px;
  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  text-align: center;
}

#formFooter {
  background-color: #f6f6f6;
  border-top: 1px solid #dce8f1;
  padding: 20px;
  text-align: center;
  -webkit-border-radius: 0 0 10px 10px;
  border-radius: 0 0 10px 10px;
}



/* TABS */

h2.inactive {
  color: #cccccc;
}

h2.active {
  color: #0d0d0d;
  border-bottom: 2px solid #5fbae9;
}



/* FORM TYPOGRAPHY*/

input[type=button], input[type=submit], input[type=reset]  {
  background-color: #56baed;
  border: none;
  color: white;
  padding: 15px 80px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  text-transform: uppercase;
  font-size: 13px;
  -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
  margin: 5px 20px 40px 20px;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -ms-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

input[type=button]:hover, input[type=submit]:hover, input[type=reset]:hover  {
  background-color: #39ace7;
}

input[type=button]:active, input[type=submit]:active, input[type=reset]:active  {
  -moz-transform: scale(0.95);
  -webkit-transform: scale(0.95);
  -o-transform: scale(0.95);
  -ms-transform: scale(0.95);
  transform: scale(0.95);
}

button[type=button], button[type=submit], button[type=reset]  {
  background-color: #56baed;
  border: none;
  color: white;
  padding: 8px 55px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  text-transform: uppercase;
  font-size: 13px;
  -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
  margin: 5px 20px 40px 20px;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -ms-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

button[type=button]:hover, button[type=submit]:hover, button[type=reset]:hover  {
  background-color: #39ace7;
}

button[type=button]:active, button[type=submit]:active, button[type=reset]:active  {
  -moz-transform: scale(0.95);
  -webkit-transform: scale(0.95);
  -o-transform: scale(0.95);
  -ms-transform: scale(0.95);
  transform: scale(0.95);
}

input[type=text],input[type=file] {
  background-color: #f6f6f6;
  border: none;
  color: #0d0d0d;
  padding: 12px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 13px;
  font-family: Verdana;
  margin: 5px;
  width: 85%;
  border: 2px solid #f6f6f6;
  -webkit-transition: all 0.5s ease-in-out;
  -moz-transition: all 0.5s ease-in-out;
  -ms-transition: all 0.5s ease-in-out;
  -o-transition: all 0.5s ease-in-out;
  transition: all 0.5s ease-in-out;
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
}
input[type=text]:focus {
  background-color: #fff;
  border-bottom: 2px solid #5fbae9;
}
label#l1{
        border: none;
        color: #0d0d0d;
        padding: 5px 10px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-family: Arial Black;
        margin: 5px;
        width: 70%;
        font-size: 16px;
  -webkit-transition: all 0.5s ease-in-out;
  -moz-transition: all 0.5s ease-in-out;
  -ms-transition: all 0.5s ease-in-out;
  -o-transition: all 0.5s ease-in-out;
  transition: all 0.5s ease-in-out;
}



/* ANIMATIONS */

/* Simple CSS3 Fade-in-down Animation */
.fadeInDown {
  -webkit-animation-name: fadeInDown;
  animation-name: fadeInDown;
  -webkit-animation-duration: 1s;
  animation-duration: 1s;
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
}

@-webkit-keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

@keyframes fadeInDown {
  0% {
    opacity: 0;
    -webkit-transform: translate3d(0, -100%, 0);
    transform: translate3d(0, -100%, 0);
  }
  100% {
    opacity: 1;
    -webkit-transform: none;
    transform: none;
  }
}

/* Simple CSS3 Fade-in Animation */
@-webkit-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@-moz-keyframes fadeIn { from { opacity:0; } to { opacity:1; } }
@keyframes fadeIn { from { opacity:0; } to { opacity:1; } }

.fadeIn {
  opacity:0;
  -webkit-animation:fadeIn ease-in 1;
  -moz-animation:fadeIn ease-in 1;
  animation:fadeIn ease-in 1;

  -webkit-animation-fill-mode:forwards;
  -moz-animation-fill-mode:forwards;
  animation-fill-mode:forwards;

  -webkit-animation-duration:1s;
  -moz-animation-duration:1s;
  animation-duration:1s;
}

#fadeIn {
  opacity:0;
  -webkit-animation:fadeIn ease-in 1;
  -moz-animation:fadeIn ease-in 1;
  animation:fadeIn ease-in 1;

  -webkit-animation-fill-mode:forwards;
  -moz-animation-fill-mode:forwards;
  animation-fill-mode:forwards;

  -webkit-animation-duration:1s;
  -moz-animation-duration:1s;
  animation-duration:1s;
}

.fadeIn.first {
  -webkit-animation-delay: 0.4s;
  -moz-animation-delay: 0.4s;
  animation-delay: 0.4s;
}

.fadeIn.second {
  -webkit-animation-delay: 0.6s;
  -moz-animation-delay: 0.6s;
  animation-delay: 0.6s;
}

.fadeIn.third {
  -webkit-animation-delay: 0.8s;
  -moz-animation-delay: 0.8s;
  animation-delay: 0.8s;
}

.fadeIn.fourth {
  -webkit-animation-delay: 1s;
  -moz-animation-delay: 1s;
  animation-delay: 1s;
}
.fadeIn.fifth{
	-webkit-animation-delay: 1.2s;
  -moz-animation-delay: 1.2s;
  animation-delay: 1.2s;
}
.fadeIn.sixth{
	-webkit-animation-delay: 1.4s;
  -moz-animation-delay: 1.4s;
  animation-delay: 1.4s;
}

.fadeIn.seventh{
	-webkit-animation-delay: 1.6s;
  -moz-animation-delay: 1.6s;
  animation-delay: 1.6s;
}

#fadeIn.eighth
{
	-webkit-animation-delay: 1.8s;
	-moz-animation-delay: 1.8s;
	animation-delay: 1.8s;
}
/* Simple CSS3 Fade-in Animation */
.underlineHover:after {
  display: block;
  left: 0;
  bottom: -10px;
  width: 0;
  height: 2px;
  background-color: #56baed;
  content: "";
  transition: width 0.2s;
}

.underlineHover:hover {
  color: #0d0d0d;
}

.underlineHover:hover:after{
  width: 100%;
}



/* OTHERS */

*:focus {
    outline: none;
} 

#icon {
  width:60%;
}
</style>
</head>
<body>
<jsp:include page="Navbar.jsp"></jsp:include>
<%response.setHeader("Cache","no-cache,no-store,must-revalidate"); %>
	<jsp:include page="Image.jsp"></jsp:include>
	<%
		DOA_Imp doa = new DOA_Imp();
		int id = Integer.parseInt(request.getParameter("viewid"));
		List<ProductModel> updatedata = doa.getById(id);
		if(updatedata.size()>0)
		{
	%>
			<div class="wrapper fadeInDown">
  				<div id="formContent">
    			<!-- Tabs Titles -->

    			<!-- Icon -->
    				<div class="fadeIn first">
      					<label style="font-family: Impact;color: #3F51B5">PRODUCT DETAILS</label>
    				</div>

    				<!-- Login Form -->
    				<form action="Update" enctype='multipart/form-data' method="post">
						<%
								for(ProductModel model : updatedata)
								{
						%>
										<label class="fadeIn second" id="l1" for="id">Product ID:</label>
										<input type="text" class="fadeIn second" name="productid" id="id" value="<%=model.getProductid()%>">
										<label class="fadeIn third" id="l1" for="name">Product Name:</label>
										<input type="text" class="fadeIn third" name="productname" id="name" value="<%=model.getProductname() %>">
										<label class="fadeIn fourth" id="l1" for="quantity">Product Quantity:</label>
										<input type="text" class="fadeIn fourth" name="productquantity" id="quantity" value="<%=model.getProductquantity() %>">
										<label class="fadeIn fifth" id="l1" for="cost">Product Cost:</label>
										<input type="text" class="fadeIn fifth" name="productcost" id="cost" value="<%=model.getProductcost()%>">
										<label class="fadeIn sixth" id="l1" for="description">Product Description:</label>
										<input type="text" class="fadeIn sixth" name="productdescription" id="description" value="<%=model.getProductdescription()%>">
										<label class="fadeIn seventh" id="l1" for="image">Product Image:</label>
										<input type="file" class="fadeIn seventh" name="productimage" accept="image/*" id="image">
										<div id="fadeIn eighth">										
												<button type="submit" class="btn btn-primary btn-sm">Update</button>
												<a href="ProductView.jsp"><button type="button" class="btn btn-primary btn-sm">Back</button></a>
										</div>
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