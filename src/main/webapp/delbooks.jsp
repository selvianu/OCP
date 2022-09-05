<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Books Page</title>
<link rel="stylesheet" href="styles/user.css">
<link rel="stylesheet" href="styles/addbooks.css">
</head>
<body>
<header>
		<ul>
			<li class="left"><img src="images/Mars.png" height="100px"
				width="150px"></li>
			<li class="profile"><img alt="profile" src="images/profile.png" width="70px" height="70px"></li>
			<li class="admin">Administrator</li>
		</ul>
	</header>
	
	<nav>
		<div class="menu">
			<ul>
				<li><a href="home.jsp">Home</a></li>
				<li><a href="admin_landing.jsp">Books</a></li>
				<li><a href="orders.jsp">Orders</a></li>
				<li><a href="users.jsp">Users</a></li>
				<li><a href="addbooks.jsp">Add Books</a></li>
				<li><a href="delbooks.jsp">Remove Books</a></li>
			</ul>
		</div>
	</nav>
	<main>
	<div class="delete-form-container">
	<form action="/delBooks" class="delete-container">
		<label>Book ID</label>
		<input type="text" name="bkid" placeholder="Enter book id for remove">
		<div></div>
		<input type="submit" name="submit" value="Remove">
	</form>
	</div>
	</main>
</body>
</html>