<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator page</title>
<link rel="stylesheet" href="styles/navbar.css">
<link rel="stylesheet" href="styles/admin_landing.css">
<link rel="stylesheet" href="styles/dropdown.css">
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
	<div><h1>Top Searched Books</h1></div>
		<div class="books-container">
			<c:forEach var="book" items="${topBooks}" varStatus="loop">
				<c:if test = "${loop.index < 4}">
					<div>
						<div class="details">
							<img alt="${book.bookName }" src="data:image/jpg;base64,${book.imagesPath}" width="200px"
								height="300px">
							<h3>${book.bookName }</h3>
							<h4>Rs.${book.actualPrice }</h4>
						</div>
						<div class="view-btn"><a href="/getBooks?id=${book.bookId }&cat=${book.category}"><button>View</button></a></div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</main>
</body>
</html>