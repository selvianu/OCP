<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator page</title>
<link rel="stylesheet" href="styles/navbar.css">
<link rel="stylesheet" href="styles/admin_landing.css">
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
				<li><a href="/Books">Books</a></li>
				<li><a href="orders.jsp">Orders</a></li>
				<li><a href="Users">Users</a></li>
				<li><a href="addbooks.jsp">Add Books</a></li>
			</ul>
		</div>
	</nav>
	
	<main>
	<table>
        <thead>
          <tr>
            <th>Book id</th>
            <th>Book Name</th>
            <th>Author Name</th>
            <th>Edition</th>
            <th>Publisher</th>
            <th>Subject</th>
            <th>Price</th>
            <th>Quantity</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>WF123</td>
            <td>Wings of Fire</td>
            <td>ABJ.Abdul Kalam</td>
            <td class="center_col">1</td>
            <td>World University</td>
            <td>Biography</td>
            <td class="center_col">789</td>
            <td class="center_col">788</td>
          </tr>
          <tr>
            <td>HFJ123</td>
            <td>Heart First Java</td>
            <td>Bert Bates</td>
            <td class="center_col">2</td>
            <td>O'reilly</td>
            <td>Computer Programming</td>
            <td class="center_col">500</td>
            <td class="center_col">278</td>
          </tr>
          <tr>
            <td>HFJ124</td>
            <td>Heart First Java</td>
            <td>Kathy Seirra</td>
            <td class="center_col">2</td>
            <td>O'reilly</td>
            <td>Computer Programming</td>
            <td class="center_col">500</td>
            <td class="center_col">271</td>
          </tr>
          <tr>
            <td>CPL123</td>
            <td>Concepts in Computer Programming</td>
            <td>John C Mitchell</td>
            <td class="center_col">1</td>
            <td>Canbridge University</td>
            <td>Computer Programming</td>
            <td class="center_col">1000</td>
            <td class="center_col">99</td>
          </tr>
          <tr>
            <td>PYSM123</td>
            <td>Power of Your Subconcious Mind</td>
            <td>Joseph Murphy</td>
            <td class="center_col">2</td>
            <td>World University</td>
            <td>Phycology</td>
            <td class="center_col">250</td>
            <td class="center_col">350</td>
          </tr>
          <tr>
            <td>PYSM124</td>
            <td>Power of Your Subconcious Mind</td>
            <td>Joseph Murphy</td>
            <td class="center_col">1</td>
            <td>World University</td>
            <td>Phycology</td>
            <td class="center_col">250</td>
            <td class="center_col">350</td>
          </tr>
          <tr>
            <td>PS123</td>
            <td>Ponniyin Selvan</td>
            <td>Kalki Krishnamurthy</td>
            <td class="center_col">1</td>
            <td>Mangala Noolagam</td>
            <td>Novel</td>
            <td class="center_col">1200</td>
            <td class="center_col">400</td>
          </tr>
          <tr>
            <td>LSD123</td>
            <td>A Love Story Destiny</td>
            <td>Deesha Sangani</td>
            <td class="center_col">1</td>
            <td>Srihti Publisher</td>
            <td>Fiction</td>
            <td class="center_col">200</td>
            <td class="center_col">150</td>
          </tr>
        </tbody>
      </table>
	</main>
</body>
</html>