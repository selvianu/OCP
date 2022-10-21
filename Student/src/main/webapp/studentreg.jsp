<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%="Welcome" + request.getParameter("name")%>

	<form action="marks.jsp">
		Enter mark1<input type="number" name="mark1"> <br> Enter
		mark2<input type="number" name="mark2"> <input type="submit"
			value="Go">
	</form>

</body>
</html>