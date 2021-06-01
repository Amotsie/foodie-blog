<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
<javatime:format value="${blog.publishdate}" pattern="dd-MM-yyyy" var="formattedDate"/>
	<h1>${blog.title}</h1>
	<h3>${blog.category} - ${blog.calories} Calories</h3>
	<p>${blog.body}</p>
	<c:forEach items="${blog.tags}" var="item" varStatus="i">									
		<span class="tags"><i>#${item}</i></span>	
	</c:forEach>
	<i>${formattedDate}</i>
	<hr>
	<a href="/home"><button>Back</button></a>
</body>
</html>