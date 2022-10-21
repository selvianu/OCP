<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<form action="register" method="post">
		<table style="with: 50%">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

		</table>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>