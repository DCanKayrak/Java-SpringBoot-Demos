<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rest Demo Project</title>
</head>
<body>

	<h3>This project is demo for rest.</h3>
	<hr>
	
	<a href="${pageContext.request.contextPath}/test/hello">Say Hello!</a>
	<a href="${pageContext.request.contextPath}/api/students">Show Student List!</a>	
	
</body>
</html>