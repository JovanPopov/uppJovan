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
	<div class="message">${message}</div>
	
	
	
	
		<div>
			<h1>Aktivne instance</h1>
			<table border="1">
			<tr>
			<td>Id</td>
			<td>ProcessDefinitionKey</td>
			<td>isEnded</td>
			</tr>
			
			<c:forEach var="pr"			
					items="${listaInstanci}">
					<tr>
					<td>${pr.getId()}</td>
					  <td>${pr.getProcessDefinitionKey()}</td>
					  <td> ${pr.isEnded()}</td>
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