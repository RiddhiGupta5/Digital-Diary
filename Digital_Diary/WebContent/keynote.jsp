<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<title>Key Notes</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">


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

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed top">
  <a class="navbar-brand" href="index.jsp">LOGIN</a>
  <ul class="navbar-nav">
  <li class="nav-item">
  <a class="nav-link" href="reminder.jsp">REMINDER</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="keynote.jsp">KEY NOTES</a>
    </li>
    <li class="nav-item">
     <a class="nav-link" href="contacts.jsp">CONTACTS</a>
      </li>
     <li class="nav-item">
     <a class="nav-link" href="schedule.jsp">SCHEDULE</a>
     </li>
  </ul>
</nav>


<h1 style="text-align:center">KEY NOTES</h1>

<div class="container">

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

	<form method="post" action="Keynote">
	    <b>NOTES</b><br>
	
	    <textarea name="notes" rows="10" cols="50" placeholder="Enter your notes" name="notes"  required></textarea><br>
	     
	     <button type="submit">SAVE NOTES</button><br>
	</form>
	<button onclick="location.href = 'dashboard.jsp';" type="button" class="cancelbtn">Cancel</button>
	

</div>
     

 


<style>
body {font-family: Arial, Helvetica, sans-serif;}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

input[type=text]{
  width: 70%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: auto;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}
.container {
  padding: 16px;
}
</style>
</body>
</html>
      