<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<!DOCTYPE html>

			<html>

			<head>
				<meta charset="ISO-8859-1">
				<title>Book list</title>
				<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bookStyle.css" />
			</head>

			<body>
				<h1>List of all book in the list</h1>
				<p>${msgrepo}</p>
				<c:forEach items="${bookList}" var="book">
						<form method="post" action="/index/modify">
							<div class="table-form-repo">
								<div class="table-form-col">id: ${book.id}</div>
								
								<div class="table-form-col">Title: ${book.title}</div>
								
								<div class="table-form-col">Author: ${book.author}</div>
								
								
									<c:if test="${book.genre != ''}">
									<div>Genre:</div>
									<div> ${book.genre}</div>
								</c:if>
								<c:if test="${book.year != 0}">
									<div>Year:</div>
									<div> ${book.year}</div>
								</c:if>
								<c:if test="${book.pages != 0}">
									<div>Pages number:</div>
									<div> ${book.pages}</div>
								</c:if>
								<c:if test="${book.price != 0}">
									<div>Price:</div>
									<div> ${book.price}</div>
								</c:if>
								<c:if test="${book.isbn != 0}">
									<div>ISBN:</div>
									<div> ${book.isbn}</div>
								</c:if>
								
								<div class="table-form-col">
									<input type="hidden" name="id" value="${book.id}" />
									<input type="submit" name="modify" value="Modify" class="button-remove" />
								</div>
							</div>
						</form>

						<br>
				</c:forEach>

				<form action="/index/repo" method="post">
					<p>${msgdelete}</p>
					<input type="number" name="id" placeholder="delete id" />
					<input type="submit" value="Remove by Id" class="button-remove" />
				</form>

				<p>
					<a href="/index">HOME</a>
				</p>
			</body>

			</html>