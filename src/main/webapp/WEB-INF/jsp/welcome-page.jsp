<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/style.css">
<title>Foodie | Welcome</title>
</head>
<body>

	<!-- Navigation Bar-->
	<header>
		<div class="container">
			<nav>
				<p>Foodie</p>
				<a href="#">+New Post</a>
			</nav>
		</div>
	</header>
	
	<!-- Main section -->
	<main>
		<aside class="side-menu">
			<table>
				<tr>
					<th>Categories</th>
				<tr><td><a href="#">Starter</a></td></tr>
				<tr><td><a href="#">Main</a></td></tr>
				<tr><td><a href="#">Desert</a></td></tr>
				<tr><td><a href="#">Other</a></td></tr>	
			</table>
		</aside>
		<section class="post-container">
			
				<c:choose>
		<c:when test="${fn:length(blogs) > 0}">	
				<c:forEach items="${blogs}" var="b">
					<javatime:format value="${b.publishdate}" pattern="dd-MM-yyyy" var="formattedDate"/>
					<article class="post-card">
						<div class="top">
							<h4>${b.title}</h4>
							<a href="/delete/${b.id}">Delete</a> <a href="/edit/${b.id}">Edit</a>
						</div>
						<div class="middle">
							<p>${b.body}</p>
						</div>
						<div class="bottom">
							<span>${formattedDate}</span>
							<c:forEach items="${b.tags}" var="item" varStatus="i">									
								<span class="tags"><i>#${item}</i></span>	
							</c:forEach>
							<a href="/details/${b.id}">Read More</a>
						</div>
					</article>
				</c:forEach>
		</c:when>
		<c:otherwise>
			<h2>No Blog available, click on top right to add new.</h2>
		</c:otherwise>
	</c:choose>
			
		</section>
	</main>
	
	<footer>
	<p> &copy; Foodie 2021.</p>
	</footer>
</body>
</html>