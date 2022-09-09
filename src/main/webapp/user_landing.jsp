<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user landing page</title>
<link rel="stylesheet" href="styles/user.css">
<link rel="stylesheet" href="styles/footer.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
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
			</ul>
		</div>
	</nav>

	<main>
		<div class="slide-container">
			<div class="slides">
				<div class="text">
					Mars Book Center<br>A massive collection of books with
					affordable price in<br>various categories<br> <span>Buy!
						and Enjoy!</span>
				</div>
				<img alt="slide 1" src="images/bok.jpg" height="350px" width="100%">

			</div>

			<div class="slides">
				<div class="text">
					Only Cash on Delivery <br>is Available!
				</div>
				<img alt="cash on delivery" src="images/cashondevlry.jpg"
					width="100%" height="350px" style="float: right;">
			</div>

			<div class="slides">
				<div class="text">
					Free Shipping Available<br> in Nationwide!
				</div>
				<img alt="discount" src="images/delivery.jpg" width="100%"
					height="350px">

			</div>

			<a class="prev" onclick="plusDivs(-1)">&#10094;</a> <a class="next"
				onclick="plusDivs(1)">&#10095;</a>
		</div>

		<div class="topic">
			<h1>Top Most Searched Books</h1>
		</div>
		
		<div class="books-container">
			<c:forEach var="book" items="${topBooks}" varStatus="loop">
				<c:if test = "${loop.index < 4}">
					<div class="book-info">
							<div class="img">
								<img alt="${book.bookName }" src="data:image/jpg;base64,${book.imagesPath}" width="100%" height="270px">
								<h3>${book.bookName }</h3>
							</div>
							<div class="details">
								<h4>Rs.${book.actualPrice }</h4>
							</div>
							<div class="view-btn">
								<a href="/getBooks?id=${book.bookId }&cat=${book.category}"><button>View</button></a>
							</div>
						</div>
				</c:if>
			</c:forEach>
		</div>
		
		
		
		<div class="books-container">
			<c:forEach var="book" items="${books}" varStatus="loop">
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
		
		<a href="getAllBooks" class="view">View all</a>
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

	<script>
		let slideIndex = 0;
		
		showSlides();

		function showSlides() {
			let i;
			let slides = document.getElementsByClassName("slides");
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slideIndex++;
			if (slideIndex > slides.length) {
				slideIndex = 1
			}
			slides[slideIndex - 1].style.display = "block";
			setTimeout(showSlides, 2000); // Change image every 2 seconds
		}

		window.onscroll = function() {myFunction()};

		var navbar = document.getElementById("nav");
		var sticky = navbar.offsetTop;
		function myFunction() {
		  if (window.pageYOffset >= sticky) {
		    navbar.classList.add("sticky")
		  } else {
		    navbar.classList.remove("sticky");
		  }
		}
	</script>
</body>
</html>