<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign in page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="styles/login.css">
</head>
<body>
	<header>
		<img alt="logo" src="images/Mars.png">
	</header>
	<p style="color: red; text-align: center;">${msg}</p>
	<main>
		<div class="staff">
			<fieldset class="login-panel">
				<legend>Staff Login</legend>
				<form action="/stafflogin">
					<div class="input-icon">
						<i class="fa fa-user icon"></i> <input type="text"
							placeholder="Enter Username" name="username" class="input-field" required>
						<i class="fa fa-lock icon"></i> <input type="password"
							placeholder="Enter a password" name="pwd" class="input-field" required>
						<div class="button">
							<a href="reset.jsp"><button>Reset</button></a>
							<input type="submit" value="Login" class="login-staff" />
						</div>
					</div>
				</form>
			</fieldset>
		</div>

		<div class="user">
			<fieldset class="login-panel">
				<legend>User Login</legend>
				<form action="/userlogin">
					<div class="input-icon">
						<i class="fa fa-user icon"></i> <input type="text"
							placeholder="Enter Username" name="username" class="input-field" required>
						<i class="fa fa-lock icon"></i> <input type="password"
							placeholder="Enter a password" name="pwd" class="input-field" required>
						<input type="submit" value="Login" class="login" />
					</div>
				</form>

				<p>If you are new User</p>

				<a href="signin.jsp"><input type="button" value="Sign in"
					class="signin" /></a>
			</fieldset>
		</div>
	</main>

</body>
</html>