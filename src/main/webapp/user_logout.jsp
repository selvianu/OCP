<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Logout</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="styles/logout.css">
</head>
<body>
<div class="logout">
			<fieldset class="logout-panel">
				<legend>Logout</legend>
				<form action="/userLogout">
					<div class="input-icon">
						<i class="fa fa-user icon"></i> <input type="text"
							placeholder="Enter your Username" name="username" class="input-field">
						<i class="fa fa-lock icon"></i> <input type="password"
							placeholder="Enter your password" name="pwd" class="input-field">
						<input type="submit" value="Logout" />
					</div>
				</form>
			</fieldset>
		</div>
</body>
</html>