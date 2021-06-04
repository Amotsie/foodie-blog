<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/style.css">
<title><spring:message code="hero.conpost"/></title>
</head>
<body class="aligning">
	<table class="bordered">
			<tr>
				<td>Title:</td>
				<td>${blog.title}</td>
			</tr>
			<tr>
				<td>Description:</td>
				<td>${blog.body}</td>
			</tr>			
			<tr>
				<td>Publish Date:</td>
				<td>${blog.publishdate}</td>
			</tr>
			<tr>
				<td># of Calories:</td>
				<td>${blog.calories}</td>
			</tr>
	
			<tr>
				<td>Category:</td>
				<td>${blog.category}</td>
			</tr>
			<tr>
				<td>Selected Tags:</td>
				<td>
				<c:forEach items="${blog.tags}" var="item" varStatus="i">
					<c:choose>
						<c:when test="${i.last}">#${item}.</c:when>
						<c:otherwise>#${item}, </c:otherwise>
					</c:choose>
				</c:forEach>
				</td>
			</tr>
			
		</table>
		<javatime:format value="${blog.publishdate}" pattern="dd-MM-yyyy" var="formattedDate"/>
		<form:form method="post" action="/savepost" modelAttribute="blog">
			<form:hidden path="title" value="${blog.title}"/>
			<form:hidden path="body" value="${blog.body}"/>
			<form:hidden path="publishdate" value="${formattedDate}"/>
			<form:hidden path="calories" value="${blog.calories}"/>
			<form:hidden path="category" value="${blog.category}"/>
			<form:hidden path="tags" value="${blog.tags}"/>

			<input type="submit" value="Confirm" class="lang">
		</form:form>
		
		<form:form method="post" action="/backtoedit" modelAttribute="blog">
				<form:hidden path="title" value="${blog.title}"/>
			<form:hidden path="body" value="${blog.body}"/>
			<form:hidden path="publishdate" value="${formattedDate}"/>
			<form:hidden path="calories" value="${blog.calories}"/>
			<form:hidden path="category" value="${blog.category}"/>
			<form:hidden path="tags" value="${blog.tags}"/>
			<input type="submit" value="Back to Edit" class=" btncolor">
		</form:form>
		
</body>
</html>