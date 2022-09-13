<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta content="text/html; charset=utf-8" />
<title>Administrator page</title>
<link rel="stylesheet" href="styles/user.css">
<link rel="stylesheet" href="styles/dropdown.css">
<link rel="stylesheet" href="styles/table.css">

</head>
<body>
	<header>
		<ul>
			<li class="left"><img alt="logo" src="images/Mars.png" height="95px"
				width="150px"></li>
			<li class="profile"><img alt="profile" src="images/profile.png"
				width="70px" height="70px"></li>
			<li class="admin">Administrator</li>
		</ul>
	</header>

	<nav>
		<div class="menu">
			<ul>
				<li><a href="adminHome">Home</a></li>
				<li class="dropdown"><a href="Books" class="dropbtn">Books</a>
					<div class="dropdown-content">
    					<a href="Novels">Novels</a>
    					<a href="Poetry">Poetry</a>
    					<a href="History">History</a>
    					<a href="Education">Education</a>
    					<a href="Biography">Biography</a>
    					<a href="Books">All Books</a>
  					</div>
				</li>
				<li><a href="Orders">Orders</a></li>
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
				<c:forEach var="user" items="${users}">
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