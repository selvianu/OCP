<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="styles/profile.css">
<link rel="stylesheet" href="styles/user.css">
</head>
<body>
<header>
		<ul>
			<li class="left"><img src="images/Mars.png" height="100px"
				width="150px"></li>
			<li class="profile">
				<a href="user_logout.jsp">
					<img alt="logout" src="images/logout1.png" title="logout" width="30px" height="30px">
				</a>
			</li>
		</ul>
	</header>
<fieldset>
	<legend>
		<img alt="profile" src="images/profile.png" width="150px" height="150px">
	</legend>
	<form action="" class="container">
		<label>Name</label>
		<input type="text" value="Roselie M" name="name" required pattern="[A-Z]{1}[A-Za-z\s\,]{4,18}"
		title="Please enter a valid name eg.M Roselie">
		<label>User name</label>
		<input type="text" value="Roselie@2000" name="username" disabled="disabled">
		<label>Email Id</label>
		<input type="email" value="mars1234@gmail.com" name="emailid" disabled="disabled">
		<label>Phone no</label>
		<input type="tel" value="6382736490" name="phno" required pattern="[0-9]{10}"
		title="Please enter a correct phone number">
		<label>Address</label>
		<input type="text" value="12A, Middle St, Golden City" name="addr" required>
		<label>District</label>
		<input type="text" value="Madurai" name="dist" required pattern="[A-Za-z]{4,20}"
		title="Please enter a valid district name">
		<label>State</label>
		<input type="text" value="Tamil Nadu" name="state" required pattern="[A-Za-z]{4,20}"
		title="Please enter a valid district name">
		<label>Pin code</label>
		<input type="text" value="627501" name="pincode" required pattern="[0-9]{6}"
		title="Please enter a valid pincode">
		<div></div>
		<input type="submit" name="submit" value="submit">
	</form>
</fieldset>
</body>
</html>