<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Post</title>
</head>
<body>
	<h2>Create A New Blog Post</h2>
	<form:form method="post" action="/results" modelAttribute="blog">
		<table class="bordered">
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /></td>
				<td style="width:500px"><form:errors path="title" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input path="body" /></td>
				<td style="width:500px"><form:errors path="body" cssClass="error" /></td>
			</tr>			
			<tr>
				<td>Publish Date:</td>
				<td><form:input path="publishdate" /></td>
				<td style="width:500px"><form:errors path="publishdate" cssClass="error" /></td>
			</tr>
			<tr>
				<td># of Calories:</td>
				<td><form:input path="calories" /></td>
				<td style="width:500px"><form:errors path="calories" cssClass="error" /></td>
			</tr>
	
			<tr>
				<td>Category:</td>
				<td><form:select path="category">
						<form:option value="" label="-- Please Select --" />
						<form:option value="Stater" label="Stater" />
						<form:option value="Main Course" label="Main Course" />
						<form:option value="Dessert" label="Dessert" />
					</form:select>
				</td>
				<td style="width:500px"><form:errors path="category" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Select Tags:</td>
				<td>
					<form:checkbox path="tags" value="healthy" label="Healthy" /><br> 
					<form:checkbox path="tags"	value="Snack" label="Snack" /><br> 
					<form:checkbox path="tags" value="lunch" label="Lunch" /><br>
					<form:checkbox path="tags" value="SugarFree" label="Sugar Free" /><br>
					<form:checkbox path="tags" value="Vegan" label="Vegan" /><br>
					<form:checkbox path="tags" value="Sweet" label="Sweet" /><br>
				</td>
				<td style="width:500px"><form:errors path="tags" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td colspan="3"><input type="submit" value="Ceate"></td>
			</tr>
		</table>
	</form:form>
	<a href="/home"><button>Cancel</button></a>
</body>
</html>