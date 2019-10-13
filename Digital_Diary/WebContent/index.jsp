<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Digital Diary</title>
</head>
<body>
	<h1>Login</h1>
	<form method="POST" action = "Login">
		<input type="text" name="name" value="name"/><br>
		<input type="email" name="email" value="email"/><br>
		<input type="password" name="password" value="password"/><br>
		<input type="submit" value="login" name="login"/><br><br>
	</form>
	Don't have an account <a href='${pageContext.request.contextPath}/signup.jsp'>Signup</a>
</body>
</html>