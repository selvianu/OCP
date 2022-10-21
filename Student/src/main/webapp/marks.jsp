<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>marks</title>
</head>
<body>

	<%="Mark 1 = " + request.getParameter("mark1")%>
	<br>
	<%="Mark 2 = " + request.getParameter("mark2")%>

	<%
	int mark1 = Integer.parseInt(request.getParameter("mark1"));
	%>
	<br>
	<%
	int mark2 = Integer.parseInt(request.getParameter("mark2"));
	%>
	<br> Total:
	<%=(mark1 + mark2)%>
	<br> Average:
	<%=((mark1 + mark2) / 2)%>
</body>
</html>