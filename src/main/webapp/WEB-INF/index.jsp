<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<!DOCTYPE html>
			<html>

			<head>
				<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bookStyle.css" />
			</head>

			<body>
				<h2>Book Library Extra</h2>

				<c:if test="${search == 'true'}">
					<h2>Search</h2>
					<form action="search" method="post">
						<input type="text" name="valueofbook" placeholder="id, title, author,..." />
						<input type="submit" value="Search" />
						${msgsearch}
					</form>
				</c:if>

				<h2>${formTitle}</h2>
				<span>${bookMod.id} ${bookMod.title} ${bookMod.author}</span>
				<div id="formindex">
					<form:form action="insert" method="post" modelAttribute="book">
						<table id="formtable">
							<tr>
								<td>
									Title:
								</td>
								<td>
									<input type="text" name="title" ${req} placeholder="Title" />
								</td>
							</tr>
							<tr>
								<td>
									Author:
								</td>
								<td>
									<input type="text" name="author" ${req} placeholder="Author" />
								</td>
							</tr>
							<tr>
								<td>
									Genre:
								</td>
								<td>
									<input type="text" name="genre" placeholder="Genre" />
								</td>
								<td>
									<p>${msggenre}</p>
								</td>
							</tr>
							<tr>
								<td>
									Year:
								</td>
								<td>
									<input type="number" name="year" value="0" />
								</td>
							</tr>
							<tr>
								<td>
									Pages:
								</td>
								<td>
									<input type="number" name="pages" value="0" />
								</td>
							</tr>
							<tr>
								<td>
									Price:
								</td>
								<td>
									<input type="number" step="0.01" name="price" value="0" />
								</td>
							</tr>
							<tr>
								<td>
									ISBN:
								</td>
								<td>
									<input type="number" name="isbn" value="0" />
								</td>
								<td>
									[Insert 13 numbers]
								</td>
							</tr>
							<tr>
								<td></td>
								<!--td>
									<input type="submit" value="Submit and view" name="suband" id="submitview" />
								</td-->
								<td>
									<input type="submit" value="Submit" name="sub" id="submitnot" />
								</td>
								<td>
									<p>${message}</p>
									<p>${msgisbn}</p>
								</td>
							</tr>
						</table>
					</form:form>
				</div>
				<p id="linkto">
					<a href="/index">HOME</a>
					<!--/p>
			<p-->
					<a href="/repo">Print the book list</a>
				</p>
			</body>

			</html>