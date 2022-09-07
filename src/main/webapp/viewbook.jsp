<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Books</title>
<link rel="stylesheet" href="styles/navbar.css">
<link rel="stylesheet" href="styles/footer.css">
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
			<li class="profile"><a href="carts"><img alt="cart" src="images/cart.png" width="60px" height="60px"></a></li>
		</ul>
		
		<nav id="nav">
		<div class="catgry">
			<ul>
			<li><a href="user_landing.jsp">Home</a></li>
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
		<div class="book-info">
			<div class="imgdiv">
				<img alt="book cover page" src="data:image/jpg;base64,${book.imagesPath}">
			</div>
			<div>
				<div class="container">
					<div class="head">
						<h1><i>${book.bookName }</i></h1>
						<div>
							<div class="label">Author</div>
							<div>${book.author }</div>
						</div>
						<div>
							<div class="label">Publisher</div>
							<div>${book.publisher}</div>
						</div>
						<c:if test =  "${book.edition > 0 }">
							<div>
								<div class="label">Edition</div>
								<div>${book.edition }</div>
							</div>
						</c:if>
					</div>
					
					<div class="price-container">
						<div><h2><span><em>Rs.</em></span>${book.actPrice }</h2></div>
						<div><p class="msg">${msg }</p></div>
					</div>
					<div class="btn">
						<a href="/addtocart?id=${book.bookId }&cat=${book.category}"><button class="cart">Add to cart</button></a>
						<a href="#"><button class="order">Order</button></a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="topic">
			<h1>Related Books</h1>
		</div>
		
		<div class="books-container">
			<c:forEach var="bk" items="${relatedBook}" varStatus="loop">
				<c:if test = "${loop.index < 4}">
					<div>
						<div class="details">
							<img alt="${bk.bookName }" src="data:image/jpg;base64,${bk.imagesPath}" width="200px"
								height="300px">
							<h3>${bk.bookName }</h3>
							<h4>Rs.${bk.actPrice }</h4>
						</div>
						<div class="view-btn"><a href="/getBooks?id=${bk.bookId }&cat=${bk.category}"><button>View</button></a></div>
					</div>
				</c:if>
			</c:forEach>
		</div>
		
		<div class="topic">
			<h1>Top Most Searched Books</h1>
		</div>
		
		<div class="books-container">
			<c:forEach var="bk" items="${topBooks}" varStatus="loop">
				<c:if test = "${loop.index < 4}">
					<div>
						<div class="details">
							<img alt="${bk.bookName }" src="data:image/jpg;base64,${bk.imagesPath}" width="200px"
								height="300px">
							<h3>${bk.bookName }</h3>
							<h4>Rs.${bk.actPrice }</h4>
						</div>
						<div class="view-btn"><a href="/getBooks?id=${bk.bookId }&cat=${bk.category}"><button>View</button></a></div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</main>
	
	<footer>
		<div class="logo">
			<img alt="logo" src="images/Mars.png" width="150px" height="100px">
		</div>
		<div>
			<ul>
				<li><i class="fa fa-phone"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="tel:+6382639293">6382639293</a></li>
				<li><i class="fa fa-gmail">&#xf0e0;</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="mailto:mars1234@gmail.com">mars1234@gmail.com</a>
			</ul>
		</div>

		<div class="addr">
			12A, Middle Street,<br>Golden City,<br>Madurai,<br>Tamil
			Nadu.
		</div>
	</footer>
	
</body>
</html>