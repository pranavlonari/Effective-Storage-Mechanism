<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%String username=(String)request.getAttribute("username"); %>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
  <div class="features">
 
  <div class="col-md-8">
  	   	 	<div class="contact-right">
						<h2>Login Page</h2>
						<div class="contact-form">
							<form id="form" method="post" action="<%=request.getContextPath()%>/RegistrationServlet" name="registration">
							 <input class="textbox"  autocomplete="off" type="text" name="uname" required="required" placeholder="Username">
				 <input autocomplete="off" type="password"   placeholder="Password" name="password" required="required">
				 <input type="hidden" value="login" name="page">
				 <input type="submit" value="Login">
				 <br>
				 <% if("invalid".equals(username)){ %>
            <label><font color="red">Invalid username & password.<br>Please enter the correct username & password </font></label>
            <%} %>
				</form>
				</div>
				</div>
				</div>
 </div>				
</body>
</html>