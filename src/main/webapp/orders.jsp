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
            <th>Order id</th>
            <th>User Name</th>
            <th>Phone no</th>
            <th>City</th>
            <th>Book id</th>
            <th>Quantity</th>
            <th>Total price</th>  
            <th>Advance Amount</th>         
            <th>Status</th>
         	<th>Ordered Date</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1234</td>
            <td>Roselie</td>
            <td>6328475968</td>
            <td>Tirunelveli</td>
            <td>WF123</td>
            <td class="center_col">30</td>
            <td class="center_col">7880</td>
            <td class="center_col">2000</td>
            <td>Ordered</td>
            <td>21-08-22</td>
          </tr>
          <tr>
            <td>1235</td>
            <td>Karthi</td>
            <td>6372894337</td>
            <td>Madurai</td>
            <td>WF456</td>
            <td class="center_col">40</td>
            <td class="center_col">10000</td>
            <td class="center_col">2500</td>
            <td>received</td>
            <td>20-08-22</td>
          </tr>
          <tr>
            <td>1236</td>
            <td>Babu</td>
            <td>6328475968</td>
            <td>Theni</td>
            <td>PS456</td>
            <td class="center_col">20</td>
            <td class="center_col">8000</td>
            <td class="center_col">0</td>
            <td>Canceled</td>
            <td>19-08-22</td>
          </tr>
        </tbody>
      </table>
	</main>
</body>
</html>