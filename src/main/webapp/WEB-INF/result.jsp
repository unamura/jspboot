<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book inserted</title>
</head>
<body>
	<h2>Inserimento avvenuto</h2>
	<span>Id: </span><span>${book.id}</span><br/>
	<span>Title: </span><span>${book.title}</span><br/>
	<span>Author: </span><span>${book.author}</span><br/>
	
	<p>
		<a href="/index">HOME</a>
	</p>
	
</body>
</html>