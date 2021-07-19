<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book found</title>
</head>
	<h1>List of all book found</h1>
	<c:forEach items="${searchList}" var="book">
		<tr>
			<td>id: </td>
			<td>${book.id}</td>
			<td>Title: </td>
			<td>${book.title}</td>
			<td>Author: </td>
			<td>${book.author}</td>
		</tr>
		<br>
	</c:forEach>
	
	<p>
		<a href="/index">HOME</a>
	</p>
<body>

</body>
</html>