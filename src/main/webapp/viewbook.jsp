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
<link rel="stylesheet" href="styles/user.css">
<link rel="stylesheet" href="styles/views.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
		<div class="viewed-book">
			<div class="imgdiv">
				<img alt="book cover page" src="data:image/jpg;base64,${book.imagesPath}">
			</div>
			<div>
				<div class="container">
					<div class="head">
						<div class="topics">
							<h1><i>${book.bookName }</i></h1>
							<h4>by ${book.author } (Author) | ${book.publisher} (Publisher)</h4>
						</div>
						
						<div class="info">
							<c:if test =  "${book.edition > 0 }">
								<div>Edition : ${book.edition }</div>
							</c:if>
							<div>Category : ${book.category}</div>
						</div>
							
						<div class="price-container">
							<div><h2><span><em>Rs.</em></span>${book.actualPrice }</h2></div>
							<div><p class="msg">${msg }</p></div>
						</div>
					</div>
					
					<div class="btn">
						<a href="/addtocart?id=${book.bookId }&cat=${book.category}"><button class="cart">Add to cart</button></a>
						<a href="/getOrders?id=${book.bookId}"><button class="order">Order</button></a>
						<a href="#" class="review">Write Review</a>
					</div>
				</div>
			</div>
		</div>
		
		<div class="topic">
			<h1>Related Books</h1>
		</div>
		
		<div class="books-container">
			<c:forEach var="book" items="${relatedBook}" varStatus="loop">
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
		
		<div class="topic">
			<h1>Top Most Searched Books</h1>
		</div>
		
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
		
		<div class="review-panel">
			<div class="star-rating">
				<span class="rate-label">Rating :</span>
       			<span class="fa fa-star-o" data-rating="1"></span>
        		<span class="fa fa-star-o" data-rating="2"></span>
       			<span class="fa fa-star-o" data-rating="3"></span>
        		<span class="fa fa-star-o" data-rating="4"></span>
       			<span class="fa fa-star-o" data-rating="5"></span>
     			<input type="hidden" name="whatever1" class="rating-value" value="0.0">
			</div>
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
	
	<script type="text/javascript">
	var $star_rating = $(".star-rating .fa");

	var SetRatingStar = function () {
	  return $star_rating.each(function () {
	    if (
	      parseInt($star_rating.siblings("input.rating-value").val()) >=
	      parseInt($(this).data("rating"))
	    ) {
	      return $(this).removeClass("fa-star-o").addClass("fa-star");
	    } else {
	      return $(this).removeClass("fa-star").addClass("fa-star-o");
	    }
	  });
	};

	$star_rating.on("click", function () {
	  $star_rating.siblings("input.rating-value").val($(this).data("rating"));
	  return SetRatingStar();
	});

	SetRatingStar();
	$(document).ready(function () {});

	</script>	
</body>
</html>