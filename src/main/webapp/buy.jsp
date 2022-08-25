<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user landing page</title>
<link rel="stylesheet" href="styles/user.css">
<link rel="stylesheet" href="styles/buy.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<header>
		<ul>
			<li class="left"><img src="images/Mars.png" height="80px"
				width="150px"></li>
			<li class="profile"><a href="profile.jsp" class="right"><img
					alt="profile" src="images/profile.png" width="50px" height="50px"></a></li>
		</ul>
	</header>
<main>
<div class="buy-form-container">
<form action="/placeOrder">
<label>Book ID</label>
<input type="text" name="bkid" placeholder="Enter the book id" required>
<label>Quantity</label>
<input type="text" name="quantity" placeholder="Enter how many books you want" pattern="[0-9]*" required>
<input type="submit" name="submit" value="Buy">
</form>
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