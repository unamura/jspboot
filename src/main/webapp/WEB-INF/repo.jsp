<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Book list</title>
</head>

<body>
	<h1>List of all book in the list</h1>
	<p>${msgrepo}</p>
	<c:forEach items="${bookList}" var="book">
		<form method="post" action="modify">
		<tr>
			<td>id: </td>
			<td>${book.id}</td>
			<td>Title: </td>
			<td>${book.title}</td>
			<td>Author: </td>
			<td>${book.author}</td>		
			<c:if test="${book.genre != ''}">
				<td>Genre:</td>
				<td> ${book.genre}</td>
			</c:if>
			<c:if test="${book.year != 0}">
				<td>Year:</td>
				<td> ${book.year}</td>
			</c:if>
			<c:if test="${book.pages != 0}">
				<td>Pages number:</td>
				<td> ${book.pages}</td>
			</c:if>
			<c:if test="${book.price != 0}">
				<td>Price:</td>
				<td> ${book.price}</td>
			</c:if>
			<c:if test="${book.isbn != 0}">
				<td>ISBN:</td>
				<td> ${book.isbn}</td>
			</c:if>		
				<td>
				<input type="hidden" name="id" value="${book.id}"/>
				<input type="submit" name="modify" value="Modify"/>		
				</td>
		</tr>
		</form>
		<br>
	</c:forEach>
	
	<form action="repo" method="post">
		<p>${msgdelete}</p>
		<input type="number" name="id" placeholder="delete id"/>
		<input type="submit" value="Remove by Id"/>
	</form>	
	
	<p>
		<a href="/index">HOME</a>
	</p>
</body>
</html>