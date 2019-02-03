



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<c:import var="data" url="https://www.google.com.br" />
	<c:out value="${'ESTE CONTEUDO FOI BAIXADO DA PAGE google.com'}" />
	<br />
	<br />
	<c:out value="${data }" />

	<br />
	<br />
	<c:set var="data1" scope="page" value="${500*6 }" />
	<c:out value="${data1 }" />

	<br />
	<br />
	<c:catch var="erro">
		<% int var = 100/0; %>
	</c:catch>

	<c:if test="${erro != null }">
		<%="Exceção capturada [100/0]=> " %>
		<c:out value="${erro.message }"></c:out>
	</c:if>
	<br />
	<br />

	<%="Fazendo Verificações resultado de 100/3 =>  " %>
	<c:set var="numero" value="${100/3 }" />

	<c:choose>
		<c:when test="${numero >= 50 }">
			<c:out value="${'Maior ou igual a 50' }"></c:out>
		</c:when>

		<c:when test="${numero < 50 }">
			<c:out value="${'Menor que 50' }"></c:out>
		</c:when>

		<c:otherwise>
			<c:out value="${'Não encontrou valores correspondentes' }"></c:out>
		</c:otherwise>
	</c:choose>
	
	<br/>
	<br/>
	<br/>
	<%= "Contador em JSP" %><br/>
	<c:forEach var="n" begin="1" end="${numero }">
		Item : ${n}
	</c:forEach>

	<br/>
	<br/>
	<br/>
	<%= "Manipulando Strings[ Nome = Miguel-da-Silva-Raramalho]" %>
	<br/>
	<c:forTokens items="Miguel-da-Silva-Ramalho" delims="-" var="nome">
		Nome: <c:out value="${nome }"/>
		<br/>
	
	</c:forTokens>



	<br />

</body>
</html>