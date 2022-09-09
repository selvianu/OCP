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
			<li class="profile"><a href="profile.jsp" class="right"><img
					alt="profile" src="images/profile.png" width="70px" height="70px"></a></li>
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
			</ul>
		</div>
	</nav>	
	</header>

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
</body>
</html>