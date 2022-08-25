<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user landing page</title>
<link rel="stylesheet" href="styles/user.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<header>
		<ul>
			<li class="left"><img src="images/Mars.png" height="100px"
				width="150px"></li>
			<li>
				<div class="search">
					<input type="search"
						placeholder="Search your favourite author books" name="author">
					<a href="/searchByAuthor">
						<button>
							<i class="fa fa-search"></i>
						</button>
					</a>
				</div>
			</li>
			<li class="profile"><a href="profile.jsp" class="right"><img
					alt="profile" src="images/profile.png" width="70px" height="70px"></a></li>
		</ul>
	</header>

	<nav>
		<div class="catgry">
			<ul>
				<li><a href="home.jsp">Home</a></li>
				<li><a href="literature.jsp">Literature</a></li>
				<li><a href="education.jsp">Education</a></li>
				<li><a href="novels.jsp">Novels</a></li>
				<li><a href="poetry.jsp">Poetry</a></li>
				<li><a href="comic.jsp">Comic</a></li>
			</ul>
		</div>

		<div class="history">
			<ul>
				<li><a href="history.jsp">History of Orders</a></li>
				<li><a href="buy.jsp">Buy</a></li>
			</ul>
		</div>
	</nav>

	<main>
		<!-- <div class="slide-container">
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
		</div> -->

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

	<!-- <script>
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
	</script> -->
</body>
</html>