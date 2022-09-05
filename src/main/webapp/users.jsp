<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<li class="profile"><img alt="profile" src="images/profile.png"
				width="70px" height="70px"></li>
			<li class="admin">Administrator</li>
		</ul>
	</header>

	<nav>
		<div class="menu">
			<ul>
				<li><a href="home.jsp">Home</a></li>
				<li><a href="/Books">Books</a></li>
				<li><a href="orders.jsp">Orders</a></li>
				<li><a href="Users">Users</a></li>
				<li><a href="addbooks.jsp">Add Books</a></li>
			</ul>
		</div>
	</nav>

	<main>
		<h1>Users List</h1>
		<table>
			<thead>
				<tr>
					<th>User Name</th>
					<th>Name</th>
					<th>Phone no</th>
					<th>Email ID</th>
					<th>Address</th>
					<th>District</th>
					<th>State</th>
					<th>Pincode</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${data}">
					<tr>
						<td>${user.userName}</td>
						<td>${user.name}</td>
						<td>${user.phoneno}</td>
						<td>${user.emailId}</td>
						<td>${user.address}</td>
						<td>${user.district}</td>
						<td>${user.state}</td>
						<td>${user.pincode}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>