<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Successful Login</title>
</head>
<body>
<div><%@include file="header.jsp"%></div>
	<br>
	<br>

	<!-- Scriplet tag  -->
	<%
	String name = request.getParameter("username");
	String password = request.getParameter("password");
	%>
	<%
	if ((name.equals("admin")) && (password.equals("admin@123"))) {
		session.setAttribute("username", name);
		response.sendRedirect("addtask.jsp");
	} else {
		response.sendRedirect("login.jsp?error_message=Invalid_Login_Credentials");
	}
	%>
	<!-- Expression tag -->
	<%="Welcome : " + request.getParameter("username")%>
	<form action="addtask.jsp"></form>
	<div><%@include file="footer.jsp"%></div>
	
</body>
</html>