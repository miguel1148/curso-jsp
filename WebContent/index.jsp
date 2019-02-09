



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/estilo.css">

</head>
<body>

	<div class="login-page">
		<div class="form">

			<c:out value="${'Esta frase foi escrita em JSTL' }" />
			<p />
			<p />

			<form action="LoginServlet" method="post" class="Login-form">
				Login: <input type="text" id="Login" name="Login"> <br />
				Senha: <input type="password" id="Senha" name="Senha"> <br />
				 <button type="submit" value="LOGAR">LOGAR</button>

			</form>



		</div>
	</div>



	<br />

</body>
</html>