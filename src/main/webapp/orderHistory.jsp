<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order History</title>
</head>
<body>
<header>
		<%-- <%= session.getAttribute("user") %> --%>
		<ul>
			<li class="left"><img src="images/Mars.png" height="95px"
				width="150px"></li>
			<li>
				<form class="search" action="/searchBooks">
					<input type="search"
						placeholder="Search your favourite books" name="keyword">
					<button type="submit"><i class="fa fa-search"></i></button>
				</form>
			</li>
			<li class="profile"><a href="profile.jsp" class="right"><img
					alt="profile" src="images/profile.png" width="70px" height="70px"></a></li>
			<li class="profile"><a href="carts"><img alt="cart" src="images/cart.png" width="60px" height="60px"></a></li>
		</ul>
	</header>

	<nav id="nav">
		<div class="catgry">
			<ul>
			<li><a href="home.jsp">Home</a></li>
				<li><a href="userBiography">Biography</a></li>
				<li><a href="userEducation">Education</a></li>
				<li><a href="userNovels">Novels</a></li>
				<li><a href="userPoetry">Poetry</a></li>
				<li><a href="userHistory">History</a></li>
				<li><a href="getAllBooks">All</a></li>
				<li class="button" onclick="showFilters()"><a href="#">Filters <i class="fa fa-caret-down"></i></a></li>
			</ul>
		</div>
	</nav>
 
 	<div class="filters" id="filters">
 		<button class="dropdown-btn">Price <i class="fa fa-caret-down"></i></button>
 		<div class="dropdown-container">
    		<a href="under200">Under Rs.200</a>
    		<a href="over500">Rs.201 - Rs.500</a>
    		<a href="over800">Rs.501 - Rs.800</a>
    		<a href="under1000">Rs.801 - Rs.1000</a>
    		<a href="over1000">Over Rs.1000</a>
  		</div>
 		<button class="dropdown-btn">Language <i class="fa fa-caret-down"></i></button>
 		<div class="dropdown-container">
    		<a href="language?lang=English">English</a>
    		<a href="language?lang=Tamil">Tamil</a>
    		<a href="language?lang=Hindi">Hindi</a>
    		<a href="language?lang=Telugu">Telugu</a>
    		<a href="language?lang=Malayalam">Malayalam</a>
    		<a href="language?lang=Kanadam">Kanadam</a>
  		</div>
 	</div>
	
	<main>
		<c:if test="${not empty orderHistory }">
			<div class="history">
				<div class="img">
				</div>
			</div>
		</c:if>
	</main>
</body>
</html>