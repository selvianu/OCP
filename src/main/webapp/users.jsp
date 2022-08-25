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
				<li><a href="employees.jsp">Employees</a></li>
				<li><a href="users.jsp">Users</a></li>
				<li><a href="addbooks.jsp">Add Books</a></li>
				<li><a href="addemp.jsp">Add Employees</a></li>
				<li><a href="delbooks.jsp">Remove Books</a></li>
			</ul>
		</div>
	</nav>
	
	<main>
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
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Roselie@2000</td>
            <td>Roselie</td>
            <td>6328475968</td>
            <td>roselie@gmail.com</td>
            <td>21A, 2nd Street, Golden city</td>
            <td>Trichy</td>
            <td>Tamil Nadu</td>
          </tr>
          <tr>
            <td>Babu@2001</td>
            <td>Babu</td>
            <td>6328475968</td>
            <td>babu123456@gmail.com</td>
            <td>78, 3rd Street, ABC city</td>
            <td>Theni</td>
            <td>Tamil Nadu</td>
          </tr>
          <tr>
            <td>Karthi@6475</td>
            <td>Karthi</td>
            <td>6328475968</td>
            <td>karthi34567@gmail.com</td>
            <td>67A, East Street, Anna nagar</td>
            <td>Madurai</td>
            <td>Tamil Nadu</td>
          </tr>
        </tbody>
      </table>
	</main>
</body>
</html>