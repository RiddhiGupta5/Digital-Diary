<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
          
          	
          
            <h5 class="card-title text-center">Sign up</h5>
            
            <%
		        if ( "error".equals("") || "error"==null) {
		    %>
		    	Great
		    <%
		        } 
		        else {
		    %>
		        <font color="red"> ${error} </font><br>
		    <%
		        }
		    %>
            <form class="form-signin" method="POST" action = "Signup" >
              <div class="form-label-group">
                
                <input type="text" id="name" class="form-control" placeholder="Enter name"  name="name" required>
                <label for="name">Name</label>
              </div>
               <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required >
                <label for="inputEmail">Email address</label>
              </div>
              
              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
                <label for="inputPassword">Password</label>
              </div>
              <div class="form-label-group">
              <input type="text" id="inputdob" class="form-control" placeholder="dob" name="dateOfBirth" required>
               <label for="inputdob">Date of birth</label>
                </div>
                <div class ="form-label-group">
                <input type="text" id="inputpno" class="form-control" placeholder="pno" name="phone_no" required>
                <label for="inputpno">Phone no</label>
                </div>
                <div class="form-label-group">
                 <input type="text" id="inputgender" class="form-control" placeholder="gender" name="gender" required>
                  <label for="inputgender">Gender</label>
                  </div>
                 <div class="form-label-group">
                  <input type="text" id="inputlocality" class="form-control" placeholder="locality" name="locality" required>
                   <label for="inputlocality">Locality</label>
                   </div>
                   <div class="form-label-group">
                    <input type="text" id="inputcity" class="form-control" placeholder="city" name="city" required>
                      <label for="inputcity">City</label>
                      </div>
                      <div class="form-label-group">
                       <input type="text" id="inputstate" class="form-control" placeholder="state" name="state" required>
                        <label for="inputstate">State</label>
                        </div>
                        <div class="form-label-group">
                         <input type="text" id="inputcountry" class="form-control" placeholder="country" name="country" required>
                          <label for="inputcountry">Country</label>
                          </div>
            

              
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign up</button><br><br>
               <b>Already have an account</b>
               <a href="${pageContext.request.contextPath}/index.jsp">Login</a>
              
               
            
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <style>
  :root {
  --input-padding-x: 1.5rem;
  --input-padding-y: .75rem;
}

body {
  background:powderblue;
 
}

.card-signin {
  border: 0;
  border-radius: 1rem;
  box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
}

.card-signin .card-title {
  margin-bottom: 2rem;
  font-weight: 300;
  font-size: 1.5rem;
}

.card-signin .card-body {
  padding: 2rem;
}

.form-signin {
  width: 100%;
}

.form-signin .btn {
  font-size: 80%;
  border-radius: 5rem;
  letter-spacing: .1rem;
  font-weight: bold;
  padding: 1rem;
  transition: all 0.2s;
}

.form-label-group {
  position: relative;
  margin-bottom: 1rem;
}

.form-label-group input {
  height: auto;
  border-radius: 2rem;
}

.form-label-group>input,
.form-label-group>label {
  padding: var(--input-padding-y) var(--input-padding-x);
}

.form-label-group>label {
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  width: 100%;
  margin-bottom: 0;
  /* Override default `<label>` margin */
  line-height: 1.5;
  color: #495057;
  border: 1px solid transparent;
  border-radius: .25rem;
  transition: all .1s ease-in-out;
}

.form-label-group input::-webkit-input-placeholder {
  color: transparent;
}

.form-label-group input:-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-moz-placeholder {
  color: transparent;
}

.form-label-group input::placeholder {
  color: transparent;
}

.form-label-group input:not(:placeholder-shown) {
  padding-top: calc(var(--input-padding-y) + var(--input-padding-y) * (2 / 3));
  padding-bottom: calc(var(--input-padding-y) / 3);
}

.form-label-group input:not(:placeholder-shown)~label {
  padding-top: calc(var(--input-padding-y) / 3);
  padding-bottom: calc(var(--input-padding-y) / 3);
  font-size: 12px;
  color: #777;
  
</body>
</html>
