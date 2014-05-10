<html>
<head>
	<title>books</title>
</head>

<body>

	<%
		ArrayList<Book> books =(ArrayList<Book>)request.getAttribute("books");
	%>

	<h1>
		There are <%= books.size() books%>	
	</h1>
	<% 

		for(int i =0; i <books.size(); i++){
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