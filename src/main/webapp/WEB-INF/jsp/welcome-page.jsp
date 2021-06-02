<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
				<a href="/create"><button><spring:message code="button.new" /></button></a>
				<p><a href="?language=sw_TZ">Swahili</a> | <a href="?language=en">English</a></p>
			</nav>
			<div class="hero">
				<h2><spring:message code="hero.title" /></h2>
				<p><spring:message code="hero.slogan" /></p>
			</div>
		</div>
	</header>
	
	<!-- Main section -->
	<main>
		<aside class="side-menu">
			<table>
				<tr>
					<th><spring:message code="main.aside.categories" /></th>
				<tr><td><a href="/category/starter"><spring:message code="main.aside.starter" /></a></td></tr>
				<tr><td><a href="/category/main"><spring:message code="main.aside.main" /></a></td></tr>
				<tr><td><a href="/category/dessert"><spring:message code="main.aside.dessert" /></a></td></tr>
				<tr><td><a href="/category/other"><spring:message code="main.aside.other" /></a></td></tr>	
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
							<a href="/delete/${b.id}"><spring:message code="button.delete" /></a> <a href="/edit/${b.id}"><spring:message code="button.edit" /></a>
						</div>
						<div class="middle">
							<p>${b.body}</p>
						</div>
						<div class="bottom">
							<span>${formattedDate}</span>
							<c:forEach items="${b.tags}" var="item" varStatus="i">									
								<span class="tags"><i>#${item}</i></span>	
							</c:forEach>
							<a href="/details/${b.id}"><spring:message code="button.readmore" /></a>
						</div>
					</article>
				</c:forEach>
		</c:when>
		<c:otherwise>
			<h2><spring:message code="main.nodata" /></h2>
		</c:otherwise>
	</c:choose>
			
		</section>
	</main>
	
	<footer>
	<p> &copy; Foodie 2021.</p>
	</footer>
</body>
</html>