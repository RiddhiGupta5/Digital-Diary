<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}
input[type=text] {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
.navbar {
  overflow: hidden;
  background-color: #333;
  font-family: Arial, Helvetica, sans-serif;
}
.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
.dropdown {
  float: left;
  overflow: hidden;
}
.dropdown .dropbtn {
  cursor: pointer;
  font-size: 16px;
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}
.navbar a:hover, .dropdown:hover .dropbtn, .dropbtn:focus {
  background-color: red;
}
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}
.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}
.dropdown-content a:hover {
  background-color: #ddd;
}
.show {
  display: block;
}
textarea{
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}
li {
  float: left;
}
li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
li a:hover:not(.active) {
  background-color: #111;
}
.active {
  background-color: #2F4F4F;
}
button {
  background-color: #2F4F4F;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 10%;
}
button:hover {
  opacity: 0.8;
}
.container {
  padding-bottom: 50px;
  padding: 16px;
}
span.psw {
  float: right;
  padding-top: 16px;
}
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}
.topnav-right {
  float: right;
}
/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
<title>Contacts</title>
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

  <div class="navbar">
    <div class="dropdown">
    <button class="dropbtn" onclick="myFunction1()">Reminders
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content" id="myDropdown1">
      <a href="${pageContext.request.contextPath}/reminder.jsp">Add Reminder</a>
      <a href="displayReminder">View Reminders</a>
    </div>
    </div>
    <div class="dropdown">
    <button class="dropbtn" onclick="myFunction2()">Key Notes
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content" id="myDropdown2">
      <a href="${pageContext.request.contextPath}/keynote.jsp">Add Key Note</a>
      <a href="displayKeynote">View Key Note</a>
    </div>
    </div>
    <div class="dropdown">
    <button class="dropbtn" onclick="myFunction3()">Contacts
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content" id="myDropdown3">
      <a href="${pageContext.request.contextPath}/contact.jsp">Add Contact</a>
      <a href="displayContact">View Contact</a>
    </div>
    </div>
    <div class="dropdown">
    <button class="dropbtn" onclick="myFunction4()">Schedule
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content" id="myDropdown4">
      <a href="${pageContext.request.contextPath}/schedule.jsp">Add to Schedule</a>
      <a href="displaySchedule">View Schedule</a>
    </div>
    </div>
    <div class="dropdown">
    <button class="dropbtn" onclick="myFunction5()">Review
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content" id="myDropdown5">
      <a href="${pageContext.request.contextPath}/review.jsp">Add Review</a>
      <a href="displayReview">View Review</a>
    </div>
    </div>
    <div class="topnav-right">
    <a href="Logout">Logout</a>
  </div>
  </div>
  
	<h1 style="text-align:center">CONTACTS</h1>
	<form method="post" action="Contact">
	<div class="container">
	<%
		if ( "error".equals("") || "error"==null) {
	%>
		Great
	<%
		} 
		else {
	%>
		<font color="red"> ${error} </font><br><br><br>
	<%
		}
	%>
	<label for="name"><b>NAME</b></label><br>
	  <input type="text" placeholder="Enter name" name="name" required><br><br>
	<label for="pno"><b>PHONE NO</b></label><br>
	  <input type="number" placeholder="Enter phone no" name="phone_no" required><br><br>
	<label for="email"><b>EMAIL ID</b></label><br>
	 <input type="text" placeholder="Enter email id" name="email" required><br><br>
	<label for="address"><b>ADDRESS</b></label><br>
	 <input type="text" placeholder="Enter address" name="address" required><br><br>

<button type="submit">SAVE CONTACTS</button>
</div>

</form>
<br><br>
<script>
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction1() {
  document.getElementById("myDropdown1").classList.toggle("show");
}
// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {
  var myDropdown = document.getElementById("myDropdown1");
    if (myDropdown.classList.contains('show')) {
      myDropdown.classList.remove('show');
    }
  }
}
function myFunction2() {
  document.getElementById("myDropdown2").classList.toggle("show");
}
// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {
  var myDropdown = document.getElementById("myDropdown2");
    if (myDropdown.classList.contains('show')) {
      myDropdown.classList.remove('show');
    }
  }
}
function myFunction3() {
  document.getElementById("myDropdown3").classList.toggle("show");
}
// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {
  var myDropdown = document.getElementById("myDropdown3");
    if (myDropdown.classList.contains('show')) {
      myDropdown.classList.remove('show');
    }
  }
}
function myFunction4() {
  document.getElementById("myDropdown4").classList.toggle("show");
}
// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {
  var myDropdown = document.getElementById("myDropdown4");
    if (myDropdown.classList.contains('show')) {
      myDropdown.classList.remove('show');
    }
  }
}
function myFunction5() {
  document.getElementById("myDropdown5").classList.toggle("show");
}
// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {
  var myDropdown = document.getElementById("myDropdown5");
    if (myDropdown.classList.contains('show')) {
      myDropdown.classList.remove('show');
    }
  }
}
</script>
</body>
</html>
    
  