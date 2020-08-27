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
	
		<form:form action="/SpringMvcDb/save" method="post">
			<table>
						<c:if test="${edits!=null}">			
					<tr>
						<td>
							<label>ID: </label>
						</td>
						<td>
							<input type="text" name="id" value='<c:out value="${edits.getId()}"></c:out>'/>
						</td>
					</tr>
					<tr>
						<td>
							<label>Name: </label>
						</td>
						<td>
							<input type="text" name="name" value='<c:out value="${edits.getName()}"></c:out>'/>
						</td>
					</tr>
					<tr>
						<td>
							<label>Address: </label>
						</td>
						<td>
							<input type="text" name="address" value='<c:out value="${edits.getAddress()}"></c:out>'/>
						</td>
					</tr>
					<tr>
						<td>
							<button>Update</button>
						</td>
					</tr>
				</c:if>
			</table>
		</form:form>
	
</body>
</html>