



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld" %>
    
   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<c:out value="${'Bem vindo ao JSTL' }"/>

	<p/>
	<p/>
	<p/>
	<p/>
	
	<form action="LoginServlet" method="post">
		Login:
		<input type="text" id="Login" name="Login">
		<br/>
		Senha:
		<input type="text" id="Senha" name="Senha">
		<br/>
		<input type="submit" value="LOGAR">
		
	</form>		
	
	
	
	
	<br/>

</body>
</html>