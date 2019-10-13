<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
	<h1>Signup</h1>
	<form method="POST" action = "Signup"><br>
		<input type="text" name="name" value="name"/><br>
		<input type="email" name="email" value="email"/><br>
		<input type="password" name="password" value="password"/><br>
		<input type="text" name="dateOfBirth" value="dateOfBirth"/><br>
		<input type="text" name="phone_no" value="phone_no"/><br>
		<input type="text" name="gender" value="gender"/><br>
		<input type="text" name="locality" value="locality"/><br>
		<input type="text" name="city" value="city"/><br>
		<input type="text" name="state" value="state"/><br>
		<input type="text" name="country" value="country"/><br>
		<input type="submit" value="signup" name="signup"/><br>
	</form>
	Already have an account <a href='${pageContext.request.contextPath}/index.jsp'>Login</a>
	<br>
	<br>
	
	<%
        if ( "error".equals("") || "error"==null) {
    %>
    	Great
    <%
        } 
        else {
    %>
        ${error}
    <%
        }
    %>
</body>
</html>