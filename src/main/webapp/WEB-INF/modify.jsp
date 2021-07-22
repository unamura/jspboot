<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Modify field of a book</title>
</head>
<body>
	<h2>Libro da modificare</h2>
	<p>${book.id} ${book.title} ${book.author}</p>
	<form:form action="/index/modify" method="post" modelAttribute="book">
		<input type="hidden" name="id" value="${book.id}"/>
		<p>
		Id: ${book.id}
		</p>
		<p>
		Title: 
			<input type="text" name="title" value="${book.title}"/>
			<input type="submit" name="newbook" value="Modify"/>
		</p>
		<p>
		Author:
			<input type="text" name="author" value="${book.author}"/>
			<input type="submit" name="newbook" value="Modify"/>
		</p>
		<p>
			<c:if test="${book.genre != ''}">
			Genre:
			<input type="number" name="genre" value="${book.genre}"/>
			<input type="submit" name="newbook" value="Modify"/>
			</c:if>
		</p>
		<p>
			<c:if test="${book.year != 0}">
			Year:
			<input type="number" name="year" value="${book.year}"/>
			<input type="submit" name="newbook" value="Modify"/>
			</c:if>
		</p>
		<p>
			<c:if test="${book.pages != 0}">
			Pages number:
			<input type="number" name="pages" value="${book.pages}"/>
			<input type="submit" name="newbook" value="Modify"/>
			</c:if>
		</p>
		<p>
			<c:if test="${book.price != 0}">
			Price:
			<input type="number" name="price" value="${book.price}"/>
			<input type="submit" name="newbook" value="Modify"/>
			</c:if>
		</p>
		<p>
			<c:if test="${book.isbn != 0}">
			ISBN code:
			<input type="number" name="isbn" value="${book.isbn}"/>
			<input type="submit" name="newbook" value="Modify"/>
			</c:if>
		</p>
	</form:form>

	<p>
		<a href="/index">HOME</a>
	</p>
</body>
</html>