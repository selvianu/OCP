<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/addbooks.css">
</head>
<body>
<main>
<div class="form-container">
		<form action="update" class="container">
			<label>Book ID</label>
			<input type="text" name="bkid" value="${data.bookId}" placeholder="Enter a id for the book" pattern="[A-Z]{2,4}[0-9]{3}" 
				title="The book id should contain 1 to 4 alphabets and 3 numbers" required>
				
			<label>Book Name</label>
			<input type="text" name="bkname" value="${data.bookName}" placeholder="Enter the name of the book" required pattern="[A-Za-z\s.]{8,50}"
				title="PLease enter a proper book name" >
				
			<label>Author Name</label>
			<input type="text" name="authorname" value="${data.author}" placeholder="Enter the author name of the book" pattern="[A-Z]{1}[A-Za-z\s\,]{4,18}"
				title="Please enter a valid author name" required>
				
			<label>Publisher</label>
			<input type="text" name="publisher" value="${data.publisher }" placeholder="Enter the publisher of the book" pattern="[A-Z]{1}[A-Za-z\s]{4,50}"
				title="Please enter a valid publisher name" required>
			
			<label>Edition</label>
			<input type="text" name="edition" value="${data.edition}" placeholder="Enter the edition of the book" pattern="[0-9]{1,2}"
				title="Please enter a valid edition number">
			
			<label>Quantity</label>
			<input type="text" name="quantity" value="${data.avlQuantity}" placeholder="Enter the available Quantity of the book" pattern="[0-9]*" required="required">
			
			<label>Price</label>
			<input type="text" name="price" value="${data.actPrice }" placeholder="Enter the price of the book" pattern="[0-9]*" required>
			
			<label>MRP Rate</label>
			<input type="text" name="mrpRate" value="${data.mrpRate }" placeholder="Enter the MRP price of the book" pattern="[0-9]*" required>
			
			<div></div>
			<input type="submit" name="Save" value="Save">
		</form>
	</div>
</main>
</body>
</html>