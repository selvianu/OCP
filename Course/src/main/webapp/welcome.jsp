<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expressiontag</title>
</head>
<body>
	<%
	String name = "Selvi";
	long aadhar = 8908323;
	int mark1 = 70;
	int mark2 = 90;
	int result;
	%>
	User name :
	<%=name%>
	<br>
	<br> Result of the user:
	<%=result = +(mark1 + mark2)%>
</body>
</html>