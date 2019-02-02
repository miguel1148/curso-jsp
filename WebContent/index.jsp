<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Welcome to my JSP project</h1>
	<%= "HELLS YEAH" %>
	
	<form action="receber-nome.jsp">
		Login: <input type="text" id="login" name="login"> 
		
		<input type="submit" value="Send"> 

	</form>
	<%session.setAttribute("curso", "(aula session, modulo 9) curso de JSP"); %><br/>
	
	
		
		<%= application.getInitParameter("estado") %>
		
		<%@ page import="java.util.Date"%><br/>
		<%= "(aula directivas) "+ new Date() %><br/>
		
		<%@ include file="pagina-include.jsp" %>
		
		<myprefix:minhatag/>
		

</body>
</html>