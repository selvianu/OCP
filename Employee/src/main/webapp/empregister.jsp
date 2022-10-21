<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<%="Welcome" + request.getParameter("empname")%><br>

	<%="Your salary is: " + request.getParameter("salary")%>
	<%
	String firstname = request.getParameter("empname");
	String lastname = "Lastname";
	%>
	<!-- Declaration Tags -->
	<%!int salary = 5000;%><br> Revised salary:
	<!-- Expression -->
	<%=(salary + 1000)%>

	Employee full name=<%=firstname + lastname%>
	<br>
	<br>
	<!-- using Scriplet -->
	<%
	out.println(firstname + lastname);
	%>
</body>
</html>