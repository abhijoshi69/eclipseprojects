<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uploader1</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/Uploader1" enctype="multipart/form-data" method="post">
		<input type="file" name="file" value="select images...."/>
		<input type="submit" value="start upload"/>
	</form>
</body>
</html>