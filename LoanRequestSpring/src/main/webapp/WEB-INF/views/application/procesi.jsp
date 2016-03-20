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
			<td></td>
			</tr>
			
			<c:forEach var="pr"			
					items="${listaInstanci}">
					<tr>
					<td>${pr.getId()}</td>
					  <td>${pr.getProcessDefinitionKey()}</td>
					  <td><a href="./procesi/kill/${pr.getId()}">End instance</a></td>
					</tr>
					</c:forEach>
			</table>
			
		</div>
		
		
		<div>
			<h1>Zavrsene instance</h1>
			<table border="1">
			<tr>
			<td>Id</td>
			<td>ProcessDefinitionId</td>
			</tr>
			
			<c:forEach var="pr"			
					items="${history}">
					<tr>
					<td>${pr.getId()}</td>
					  <td>${pr.getProcessDefinitionId()}</td>
					</tr>
					</c:forEach>
			</table>
			
		</div>
	
	
			<div>
			<h1>Tasks</h1>
			<table border="1">
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Assignee</td>
				<td>ProcessInstanceId</td>
			</tr>
			
			<c:forEach var="pr"			
					items="${tasks}">
					<tr>
						<td>${pr.getId()}</td>
					    <td>${pr.getName()}</td>
					    <td>${pr.getAssignee()}</td>
					    <td>${pr.getProcessInstanceId()}</td>
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