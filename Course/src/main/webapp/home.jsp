<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>JSP</h1>

	<br> scriptlet - used to execute java code in jsp
	<br>
	<%
	String name = "Selvi";
	long aadhar = 8908323;
	int mark1 = 70;
	int mark2 = 90;
	int result;
	%>
	<%
	out.println(name + "  " + aadhar);
	out.println("Result: " + (mark1 + mark2));
	%>

</body>
</html>