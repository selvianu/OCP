<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator Page</title>
<link rel="stylesheet" href="styles/navbar.css">
<link rel="stylesheet" href="styles/book.css">
<link rel="stylesheet" href="styles/footer.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<body>
	<header>
		<ul>
			<li class="left"><img src="images/Mars.png" height="95px"
				width="150px"></li>
			<li class="profile"><img alt="profile" src="images/profile.png"
				width="70px" height="70px"></li>
			<li class="admin">Administrator</li>
		</ul>
	</header>

	<nav>
		<div class="menu">
			<ul>
				<li><a href="home.jsp">Home</a></li>
				<li><a href="/Books">Books</a></li>
				<li><a href="orders.jsp">Orders</a></li>
				<li><a href="Users">Users</a></li>
				<li><a href="addbooks.jsp">Add Books</a></li>
			</ul>
		</div>
	</nav>

	<main>
		<p>${msg }</p>
		<div class="books-container">
			<c:forEach var="bk" items="${data}">
				<div class="book-info">
					<div>
						<img alt="book cover page" src="data:image/jpg;base64,${bk.imagesPath}">
					</div>
					<div>
						<form action="update" class="container" id="${bk.bookId }">
							<div class="head"><h1>${bk.bookName}</h1>
							<i style='font-size:20px' class='fas' onclick="enable(${bk.bookId})" class="test">&#xf304;</i>
							</div>
							<div class="input-feild">
								<label>Book ID</label>
								<input type="text" name="bkid" value="${bk.bookId}" placeholder="Enter a id for the book" 
								pattern="[A-Z]{2,4}[0-9]{3}" title="The book id should contain 1 to 4 alphabets and 3 numbers" required  class="inactive">
							</div>
				
							<div class="input-feild">
								<label>Book Name</label>
								<input type="text" name="bkname" value="${bk.bookName}" placeholder="Enter the name of the book" required 
								pattern="[A-Za-z\s.]{8,50}" title="PLease enter a proper book name" class="inactive">
							</div>
				
							<div class="input-feild">
							<label>Author Name</label>
							<input type="text" name="authorname" value="${bk.author}" placeholder="Enter the author name of the book" 
								pattern="[A-Z]{1}[A-Za-z\s\,]{4,18}" title="Please enter a valid author name" required class="inactive">
							</div>
				
							<div class="input-feild">
							<label>Publisher</label>
							<input type="text" name="publisher" value="${bk.publisher }" placeholder="Enter the publisher of the book"
							 	pattern="[A-Z]{1}[A-Za-z\s]{4,50}" title="Please enter a valid publisher name" required class="inactive">
							</div>
							
							<div class="input-feild">
								<label>Edition</label>
							<input type="text" name="edition" value="${bk.edition}" placeholder="Enter the edition of the book" 
								pattern="[0-9]{1,2}" title="Please enter a valid edition number" class="inactive">
							</div>
			
							<div class="input-feild">
								<label>Quantity</label>
							<input type="text" name="quantity" value="${bk.avlQuantity}" placeholder="Enter the available Quantity of the book" 
								pattern="[0-9]*" required="required" class="inactive">
							</div>
			
							<div class="input-feild">
								<label>Price</label>
							<input type="text" name="price" value="${bk.price }" placeholder="Enter the price of the book" 
								pattern="[0-9]*" required class="inactive">
							</div>
			
							<div class="input-feild">
								<label>MRP Rate</label>
							<input type="text" name="mrpRate" value="${bk.mrpRate }" placeholder="Enter the MRP price of the book" 
								pattern="[0-9]*" required class="inactive">
							</div>

							<div class="submit">
								<input type="submit" name="Save" value="Save">
							</div>
						</form>
						<div class="btn">
							<a href="/delete?id=${bk.bookId }"><button class="del">Delete</button></a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</main>
	<footer>
		<div class="logo">
			<img alt="logo" src="images/Mars.png" width="150px" height="100px">
		</div>
		<div>
			<ul>
				<li><i class="fa fa-phone"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="tel:+6382639293">6382639293</a></li>
				<li><i class="fa fa-gmail">&#xf0e0;</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="mailto:mars1234@gmail.com">mars1234@gmail.com</a>
			</ul>
		</div>

		<div class="addr">
			12A, Middle Street,<br>Golden City,<br>Madurai,<br>Tamil Nadu.
		</div>
	</footer>
	<script type="text/javascript">
		function enable(trigger){
			console.log("Inside Function");
			/* var text = document.getElementsByClassName('inactive')[10]; */
			console.log(trigger);
			var cont=trigger.querySelectorAll('.inactive');
			console.log(cont.length);
			for(let i = 0; i < cont.length; i++){
				cont[i].classList.add('active');
			}
		}
		
	</script>
</body>
</html>