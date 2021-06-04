<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/style.css">
<title>New Post</title>
</head>
<body>
<div class="header">
<h2 class="slogan"><spring:message code="fm.form.blogpost"/></h2>
</div>
	<div class="container">
	<form:form method="post" action="/results" modelAttribute="blog">
		<table class="bordered">
			<tr>
				<td><spring:message code="fm.form.title" /></td>
				<td><form:input class="btnradius" path="title" /></td>
				<td style="width:500px"><form:errors path="title" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="fm.form.description"/></td>
				<td><form:input class="btnradius" path="body" /></td>
				<td style="width:500px"><form:errors path="body" cssClass="error" /></td>
			</tr>			
			<tr>
				<td><spring:message code="fm.form.publisheddate"/></td>
				<td><form:input class="btnradius" path="publishdate" /></td>
				<td style="width:500px"><form:errors path="publishdate" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="fm.form.nocalories"/></td>
				<td><form:input class="btnradius" path="calories" /></td>
				<td style="width:500px"><form:errors path="calories" cssClass="error" /></td>
			</tr>
	
			<tr>
				<td><spring:message code="fm.form.categorgy" /></td>
				<td><form:select class="btnradius" path="category">
						<form:option value="" label="-- Please Select --" />
						<form:option value="stater" label="Stater" />
						<form:option value="main" label="Main Course" />
						<form:option value="dessert" label="Dessert" />
						<form:option value="other" label="Other" />
					</form:select>
				</td>
				<td style="width:500px"><form:errors path="category" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="fm.form.selecttags"/></td>
				<td>
					<form:checkbox path="tags" value="healthy" label="#Healthy" /><br> 
					<form:checkbox path="tags"	value="Snack" label="#Snack" /><br> 
					<form:checkbox path="tags" value="lunch" label="#Lunch" /><br>
					<form:checkbox path="tags" value="SugarFree" label="#Sugar Free" /><br>
					<form:checkbox path="tags" value="Vegan" label="#Vegan" /><br>
					<form:checkbox path="tags" value="Sweet" label="#Sweet" /><br>
				</td>
				<td style="width:500px"><form:errors path="tags" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td colspan="3"><button type="submit"class="btnradius lang"><spring:message code="button.create"/></button></td>
			</tr>
		</table>
	</form:form>
	</div>
	<a href="/home"><button class="delete1 btnradius lang"><spring:message code="button.cancel"/></button></a>
	
	
</body>
</html>