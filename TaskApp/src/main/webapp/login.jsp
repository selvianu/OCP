<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	    
	<div><%@include file="header.jsp"%></div>
	<br>
	<br>
	<form action="welcome.jsp">
		Enter username: <input type="text" name="username"><br> <br>
		Enter password: <input type="password" name="password"><br>
		<br> <input type="submit" value="login">

	</form>

	<div><%@include file="footer.jsp"%></div>

</body>
</html>