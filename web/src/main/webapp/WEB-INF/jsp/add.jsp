<html>
	<head>
		<title>Add a new book</title>
		<link rel="stylesheet" type="text/css" href="css/main.css">
	</head>
	<body>

	    <h1>Add a book</h1>

		<form method="POST">

		<label for="isbn">ISBN:
        <input type="text" name="isbn" maxlength="10"/>

        <br/>
        <label for="name">Name:
        <input type="text" name="name" maxlength="100"/>

        <br/>
        <label for="price">Price:
        <input type="text" name="price" maxlength="10"/>

        <br/>
        <label for="author">Author:
        <input type="text" name="author" maxlength="32"/>

        <br/>
        <button type="submit" value="Submit">Add</button>
		</form>
	</body>
</html>