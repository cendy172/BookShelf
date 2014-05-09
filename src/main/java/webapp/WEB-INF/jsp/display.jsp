<html>
<head>
	<title>there is <%= books.length%> books</title>
</head>

<body>
	<% 
		for(int i =0; i <books.length; i++){
	%>
		No.<%= i %>
		ISBN: <%= books[i].getIsbn() %>
		Name: <%= books[i].getName() %>
		Price: <%= books[i].getPrice() %>
		Author: <%= books[i].getAuthor() %>
	<%
		}
	%>
</body>
</html>