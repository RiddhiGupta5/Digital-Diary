<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("name")) userName = cookie.getValue();
}
}
if(userName == null) response.sendRedirect("index.jsp");
%>

<h1>WELCOME TO DIGITAL DIARY</h1>

${name}

<br><br><br>
<form action="Logout" method="post">
	<input type="submit" value="Logout" >
</form>

</body>
</html>