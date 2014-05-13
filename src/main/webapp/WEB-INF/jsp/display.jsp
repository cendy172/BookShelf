<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn' %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>books</title>
</head>

<body>
	<h1>

	<br/>
		There are ${fn:length(books)} books
	</h1>
	<br/>
	<c:forEach var="book" items="${books}">
		ISBN: ${book.isbn} <br/>
		Name: ${book.name} <br/>
		Price: ${book.price} <br/>
		Author: ${book.author} <br/>
		<hr/>
	</c:forEach>
</body>
</html>