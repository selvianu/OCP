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
			<li class="left"><img src="images/Mars.png" height="80px"
				width="150px"></li>
			<li class="profile">
				<a href="emp_logout.jsp">
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
<label>Employee ID</label>
<input type="text" value="3001" name="empid" disabled="disabled">
<label>Name</label>
<input type="text" value="Roselie" name="empname" disabled="disabled">
<label>Email Id</label>
<input type="email" value="roselie1234@gmail.com" name="emailid" disabled="disabled">
<label>Phone no</label>
<input type="tel" value="6382736490" name="phno" disabled="disabled">
<label>Address</label>
<input type="text" value="12A, Middle St, Golden City" name="addr" disabled="disabled">
<label>District</label>
<input type="text" value="Madurai" name="dist" disabled="disabled">
<label>State</label>
<input type="text" value="Tamil Nadu" name="state" disabled="disabled">
<label>Pin code</label>
<input type="text" value="627501" name="pincode" disabled="disabled">
</form>
</fieldset>
</body>
</html>