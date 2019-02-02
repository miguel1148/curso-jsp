<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<%= "NOME RECEBIDO: "+ request.getParameter("login") %><br/>
	
	<%= session.getAttribute("curso") %>
	
	
</body>
</html>