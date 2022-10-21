<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Task</title>
</head>
<body>
<div><%@include file="header.jsp"%></div>
	<br>
	<br>

	<form action="listoftask.jsp">
		<%="Welcome : " + session.getAttribute("username")%>
		Task Name<input type="text" name="taskname"><br> <br>
		Date<input type="datetime-local" name="date"> <label
			for="status">Staus</label> <select id="cars" name="cars">
			<option value="yet to start">Pending</option>
			<option value="in Progress">In Progress</option>
			<option value="completed">Completed</option>
		</select> <input type="submit" name="add task">
	</form>
	<form action="login.jsp">
		<a href="login.jsp">Logout</a>
		<div>
			<%
			session.invalidate();
			%>
		</div>
	</form>
	<div><%@include file="footer.jsp"%></div>

</body>
</html>