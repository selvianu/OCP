<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	</header>

	<nav id="nav">
		<div class="catgry">
			<ul>
			<li><a href="home.jsp">Home</a></li>
				<li><a href="biography.jsp">Biography</a></li>
				<li><a href="education.jsp">Education</a></li>
				<li><a href="novels.jsp">Novels</a></li>
				<li><a href="poetry.jsp">Poetry</a></li>
				<li><a href="history.jsp">History</a></li>
			</ul>
		</div>

		<div class="history">
			<ul>
				<li><a href="history.jsp">History of Orders</a></li>
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
				<img alt="slide 1" src="images/bok.jpg" height="400px" width="100%">

			</div>

			<div class="slides">
				<div class="text">
					Only Cash on Delivery <br>is Available!
				</div>
				<img alt="cash on delivery" src="images/cashondevlry.jpg"
					width="100%" height="400px" style="float: right;">
			</div>

			<div class="slides">
				<div class="text">
					Free Shipping Available<br> in Nationwide!
				</div>
				<img alt="discount" src="images/delivery.jpg" width="100%"
					height="400px">

			</div>

			<a class="prev" onclick="plusDivs(-1)">&#10094;</a> <a class="next"
				onclick="plusDivs(1)">&#10095;</a>
		</div>

		<div class="topic">
			<h1>Top Most Searched Books</h1>
		</div>

		<div class="books-container">
			<div>
				<img alt="wings of fire" src="images/WF123.jpg" width="200px"
					height="300px">
				<h4>Wings of Fire</h4>
				<p>Book ID: WF123</p>
				<a href="placeOrder.jsp"><button>Buy</button></a>
			</div>

			<div>
				<img alt="wings of fire" src="images/WF456.jpg">
				<h4>Wings of Fire (Tamil)</h4>
				<p>Book ID: WF456</p>
				<a href="placeOrder.jsp"><button>Buy</button></a>
			</div>

			<div>
				<img alt="Ponniyin Selvan" src="images/PS456.jpg">
				<h4>Ponniyin Selvan (Tamil)</h4>
				<p>Book ID: PS456</p>
				<a href="placeOrder.jsp"><button>Buy</button></a>
			</div>

			<div>
				<img alt="Quantitative Aptitude" src="images/QA123.jpg">
				<h4>Quantitative Aptitude (Fully Solved)</h4>
				<p>Book ID: QA123</p>
				<a href="placeOrder.jsp"><button>Buy</button></a>
			</div>
		</div>
		
		<a href="books.jsp" class="view">View all</a>
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