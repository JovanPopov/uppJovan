<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>Oglasi</title>
		<link href="<c:url value="/resources/stylesheets/styles.css"/>"
			rel="stylesheet" />
	</head>
	
	
	<body>
	<center><h1>Zahtev za zastitu prava</h1></center>
	<div class="message">${message}</div>
	
	<c:if test="${odgovor == false}">
	</br>
	<h1>Podnosenje zahteva</h1>
	<form name='f' action="<c:url value='/application/zalba/pokretanje' />" method='POST'>
	
				<fieldset>
					Naziv podnosioca zahteva:<br> <input type="text" required><br>
					Razlog za podnosenje zahteva:<br> <textarea rows="4" cols="50" type="text" name="razlog" required></textarea><br>
					Dokumentacija: <input type="file" >
						
					
					
					<div class="submit">
						<input type="submit" value="Potvrda">
					</div>
				</fieldset>
			</form>
	</c:if>

	<c:if test="${odgovor == true}">
		<div>
			<h1>Provera odgovora Republicke komisije</h1>
			<a href="./zalba/odgovor">Provera</a>
			
		</div>
	</c:if>
	
	
	
	<!--za nazad -->
		<div class="home">
			<a href="${pageContext.request.contextPath}/application/welcome">Početna</a>
		</div>
	</body>
</html>