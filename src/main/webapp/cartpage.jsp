<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart page</title>
<link rel="stylesheet" href="styles/navbar.css">
<link rel="stylesheet" href="styles/views.css">
<link rel="stylesheet" href="styles/user.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

</head>
<body>

	<header>
		<%-- <%= session.getAttribute("user") %> --%>
		<ul>
			<li class="left"><img src="images/Mars.png" height="95px"
				width="150px"></li>
			<li>
				<div class="search">
					<input type="search"
						placeholder="Search your favourite books" name="author">
					<a href="/searchByAuthor">
						<button>
							<i class="fa fa-search"></i>
						</button>
					</a>
				</div>
			</li>
			<li class="profile"><img alt="profile" src="images/profile.png" width="70px" height="70px"></li>
			<li class="profile"><a href="cart.jsp"><img alt="cart" src="images/cart.png" width="60px" height="60px"></a></li>
		</ul>
		
		<nav id="nav">
		<div class="catgry">
			<ul>
			<li><a href="userBooks">Home</a></li>
				<li><a href="userBiography">Biography</a></li>
				<li><a href="userEducation">Education</a></li>
				<li><a href="userNovels">Novels</a></li>
				<li><a href="userPoetry">Poetry</a></li>
				<li><a href="userHistory">History</a></li>
				<li><a href="userBooks">All</a></li>
				<li class="button" onclick="showFilters()"><a href="#">Filters <i class="fa fa-caret-down"></i></a></li>
			</ul>
		</div>
	</nav>	
	</header>
	
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
		<div><p class="msg">${msg }</p></div> 
	<c:forEach var="ct" items="${carts}">
		<div class="book-info">
			<div class="imgdiv">
				<img alt="book cover page" src="data:image/jpg;base64,${ct.bkImages}">
			</div>
			<div>
				<div class="container">
					<div class="head">
						<h1><i>${ct.bookName }</i></h1>
						<div>
							<div class="label">Author</div>
							<div>${ct.authors }</div>
						</div>
						<div>
							<div class="label">Publisher</div>
							<div>${ct.publishers}</div>
						</div>
						<c:if test =  "${ct.edition > 0 }">
							<div>
								<div class="label">Edition</div>
								<div>${ct.edition }</div>
							</div>
						</c:if>
						<div>
							<div class="label">Category</div>
							<div>${book.category}</div>
						</div>
					</div>
					
					<div class="price-container">
						<h2><span><em>Rs.</em></span>${ct.price }</h2>
					</div>
					<div class="btn">
						<a href="/deletecart?id=${ct.cartId }"><button class="cart">Remove</button></a>
						<a href="/getOrders?id=${book.bookId}"><button class="order">Order</button></a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	</main>
	
	<script src="script/userpage.js"></script>
</body>
</html>