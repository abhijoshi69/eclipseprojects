<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		<form:form method="post">
			<table>
					<c:if test="${views!=null}">
						<tr>
							<td>
								<label>ID</label>
							</td>
							<td>
								<c:out value="${views.getId()}"></c:out>
							</td>
						</tr>
						<tr>
							<td>
								<label>Name</label>
							</td>
							<td>	
								<c:out value="${views.getName()}"></c:out>
							</td>
						</tr>
						<tr>
							<td>
								<label>Address</label>
							</td>
							<td>
								<c:out value="${views.getAddress()}"></c:out>
							</td>
						</tr>
						<tr>
							<!--<td><button>Back</button></td>  -->
							
						</tr>
					</c:if>
			</table>
		</form:form>
			<a href="/SpringMvcDb/back"><button>Back</button></a>

</body>
</html>