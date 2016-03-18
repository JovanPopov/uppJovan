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
		<div>
			<h1>Ponude</h1>
			
			<c:if test="${ponudjaci.size() == 0}">
				<div class="message">
					Ponude ce biti javno dostupne kasnije
			
				</div>
			</c:if>
			
			
			<table border="1">
				
			<c:forEach var="pr"			
					items="${ponudjaci}">
					<tr>
					    <td>${pr.getNaziv()}</td>
					    <td>${pr.getPonuda()}</td>
					</tr>
					</c:forEach>
			</table>
		</div>
	
	
	<!--za nazad -->
		<div class="home">
			<a href="${pageContext.request.contextPath}/application/welcome">Početna</a>
		</div>
	</body>
</html>