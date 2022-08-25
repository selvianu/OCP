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
            <th>Employee id</th>
            <th>Employee Name</th>
            <th>Phone no</th>
            <th>Address</th>
            <th>District</th>
            <th>State</th>
            <th>Work Location</th>           
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1028</td>
            <td>Suthan</td>
            <td>6328475968</td>
            <td>146/1, North street, ABC Nagar</td>
            <td>Tirunelveli</td>
            <td>Tamil Nadu</td>
            <td>Tirunelveli</td>
          </tr>
          <tr>
            <td>1029</td>
            <td>Raja</td>
            <td>6328475968</td>
            <td>11A, Middle street, Golden Nagar</td>
            <td>Madurai</td>
            <td>Tamil Nadu</td>
            <td>Chennai</td>
          </tr>
          <tr>
            <td>1030</td>
            <td>Alex</td>
            <td>6328475968</td>
            <td>15/1, West street, Neru Nagar</td>
            <td>Theni</td>
            <td>Tamil Nadu</td>
            <td>Theni</td>
          </tr>
        </tbody>
      </table>
	</main>
</body>
</html>