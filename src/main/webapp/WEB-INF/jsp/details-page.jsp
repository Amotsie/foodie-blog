<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="hero.details"/></title>
</head>
<body>
<javatime:format value="${blog.publishdate}" pattern="dd-MM-yyyy" var="formattedDate"/>
	<h1>${blog.title}</h1>
	<h3>${blog.category} - ${blog.calories} Calories</h3>
	<p>${blog.body}</p>
	<c:forEach items="${blog.tags}" var="item" varStatus="i">									
		<span class="tags"><i>#${item}</i></span>	
	</c:forEach>
	<br>
	Created: <i>${formattedDate}</i>
	<hr>
	<a href="/home"><button><spring:message code="button.back"/></button></a>
</body>
</html>