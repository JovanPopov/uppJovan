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
	
		<center><h1>Oglasi</h1></center>
		
	<div class="message">${message}</div>
	<c:if test="${oglasOtvoreni == true}">
		<div>
			<h1>Prijava na otvoreni konkurs</h1>
			<a href="./oglasi/prijavaOtvoreni">Prijava</a>
			
		</div>
	</c:if>
	
	
	<c:if test="${oglasKvalifikacije == true}">
		<div>
			<h1>Prijava na kvalifikacije</h1>
			<a href="./oglasi/prijavaKvalifikacije">Prijava</a>
			
		</div>
	</c:if>
	
	
	
	<c:if test="${oglasRestriktivni == true}">
		<div>
			<h1>Prijava na restriktivni konkurs</h1>
			<a href="./oglasi/prijavaRestriktivni">Prijava</a>
			
		</div>
	</c:if>
	
	
			
	<!--za nazad -->
		<div class="home">
			<a href="${pageContext.request.contextPath}/application/welcome">Početna</a>
		</div>
	</body>
</html>