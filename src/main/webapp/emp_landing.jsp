<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator page</title>
<link rel="stylesheet" href="styles/user.css">
</head>
<body>
<header>
		<ul>
			<li class="left"><img src="images/Mars.png" height="95px"
				width="150px"></li>
			<li class="profile"><a href="emp_profile.jsp">
				<img alt="profile" src="images/profile.png" width="70px" height="70px"></a></li>
			<!-- <li class="admin">Administrator</li> -->
		</ul>
	</header>
	
	<nav>
		<div class="menu">
			<ul>
				<li><a href="home.jsp">Home</a></li>
				<li><a href="/getOrderByPlace">MyOrders</a></li>
				<li><a href="/updatePaidOrder">Update Order</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>