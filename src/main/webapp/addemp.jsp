<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Books Page</title>
<link rel="stylesheet" href="styles/user.css">
<link rel="stylesheet" href="styles/addbooks.css">
</head>
<body>
<header>
		<ul>
			<li class="left"><img src="images/Mars.png" height="95px"
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
				<li><a href="employees.jsp">Employees</a></li>
				<li><a href="users.jsp">Users</a></li>
				<li><a href="addbooks.jsp">Add Books</a></li>
				<li><a href="addemp.jsp">Add Employees</a></li>
				<li><a href="delbooks.jsp">Remove Books</a></li>
			</ul>
		</div>
	</nav>
	<main>
	<p>${id}</p>
	<div class="form-container">
	<form action="/addEmp" class="container">
		<label>Employee Name</label>
		<input type="text" name="empname" placeholder="Enter employee name" pattern="[A-Z]{1}[A-Za-z\s\,]{4,18}"
			title="Please enter a valid name" required>
		<label>Password</label>
		<input type="text" name="pwd" placeholder="Enter password of the employee" pattern="[A-Za-z]*[0-9]{4,6}"
		title="Please enter a valid password" required>
		<label>Phone number</label>
		<input type="text" name="phno" placeholder="Enter the phone number of the employee" pattern="[0-9]{10}"
		title="Please enter a correct phone number" required>
		<label>Email Id</label>
		<input type="email" name="email" placeholder="Enter the email of the employee">
		<label>Date of Birth</label>
		<input type="date" name="dob" id="datePickerId">
		<label>Address</label>
		<input type="text" name="addr" placeholder="Enter the address of the employee" required>
		<label>District</label>
		<input type="text" name="dist" placeholder="Enter the district of the employee" pattern="[A-Za-z]{4,20}"
		title="Please enter a valid district name" required>
		<label>State</label>
		<input type="text" name="state" placeholder="Enter the state of the employee" pattern="[A-Za-z]{4,20}"
		title="Please enter a valid state" required>
		<label>Pin code</label>
		<input type="text" name="pincode" placeholder="Enter the pincode of the employee" pattern="[0-9]{6}"
		title="Please enter a valid pincode" required>
		<label>Work Location</label>
		<input type="text" name="workLoc" placeholder="Enter the work location of the employee" pattern="[A-Za-z]{4,20}"
		title="Please enter a valid district name" required>
		<div></div>
		<input type="submit" name="submit" value="Add">
	</form>
	</div>
	</main>
	<script type="text/javascript">datePickerId.max = new Date().toISOString().split("T")[0];</script>
</body>
</html>