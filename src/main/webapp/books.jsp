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
<link rel="stylesheet" href="styles/dropdown.css">
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
				<li class="dropdown"><a href="Books" class="dropbtn">Books</a>
					<div class="dropdown-content">
    					<a href="Novels">Novels</a>
    					<a href="Poetry">Poetry</a>
    					<a href="History">History</a>
    					<a href="Education">Education</a>
    					<a href="Biography">Biography</a>
    					<a href="Books">All Books</a>
  					</div>
				</li>
				<li><a href="Orders">Orders</a></li>
				<li><a href="Users">Users</a></li>
				<li><a href="addbooks.jsp">Add Books</a></li>
			</ul>
		</div>
	</nav>

	<main>
		<p class="msg">${msg }</p>
		<div class="books-container">
			<c:forEach var="bk" items="${books}">
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
								<input type="text" name="bkid" value="${bk.bookId}" readonly>
							</div>
				
							<div class="input-feild">
								<label>Book Name</label>
								<input type="text" name="bkname" value="${bk.bookName}" readonly>
							</div>
				
							<div class="input-feild">
							<label>Author Name</label>
							<input type="text" name="authorname" value="${bk.author}" readonly>
							</div>
				
							<div class="input-feild">
							<label>Publisher</label>
							<input type="text" name="publisher" value="${bk.publisher }" readonly>
							</div>
							
							<div class="input-feild">
								<label>Edition</label>
							<input type="text" name="edition" value="${bk.edition}" readonly>
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
								<label>Actual Price</label>
							<input type="text" name="price" value="${bk.actPrice }" placeholder="Enter the price of the book" 
								pattern="[0-9]*" required class="inactive">
							</div>
			
							<div class="input-feild">
								<label>MRP Rate</label>
							<input type="text" name="mrpRate" value="${bk.mrpRate }" placeholder="Enter the MRP price of the book" 
								pattern="[0-9]*" required class="inactive">
							</div>

							<div class="submit">
								<input type="submit" name="Save" value="Save" onclick="disable(${bk.bookId})">
							</div>
							<!-- <div class="popup" id="popup">
								<p>Do you want to delete this books</p>
							</div> -->
						</form>
						<div class="btn">
							<a href="/delete?id=${bk.bookId }"><button class="del">Delete</button></a>
							<%-- <button class="del" onclick="popup(${bk.bookId})">Delete</button> --%>
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
		
		function disable(trigger){
			console.log("Inside Function");
			/* var text = document.getElementsByClassName('inactive')[10]; */
			console.log(trigger);
			var cont=trigger.querySelectorAll('.active');
			console.log(cont.length);
			for(let i = 0; i < cont.length; i++){
				cont[i].classList.add('inactive');
			}
		}
		
	</script>
</body>
</html>