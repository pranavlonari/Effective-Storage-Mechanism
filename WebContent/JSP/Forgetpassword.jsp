<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget Password</title>
<%String msg=(String)request.getAttribute("msg"); %>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>
 <div class="features">
 
  <div class="col-md-8">
  	   	 	<div class="contact-right">
						<h2>Login Page</h2>
						<div class="contact-form">
							<form id="form" method="post" action="<%=request.getContextPath()%>/RegistrationServlet" name="registration">
							 <input class="textbox"  autocomplete="off" type="text" name="emailid" required="required" placeholder="Email id">
				 <input type="hidden" value="forgetpassword" name="page">
				 <input type="submit" value="Get Password">
				 <br>
              	        	<%if("false".equals(msg)){ %>

<p>Username is not Registered. To registered <a href="<%=request.getContextPath()%>/JSP/Registration.jsp">Click here</a></p>
<%}else if("true".equals(msg)){ %>
<p>Please check your email-id for Password</p>
<%} %>				</form>
						</div>
						<jsp:include page="Footer.jsp"></jsp:include>
				</div>
				</div>
 </div>				
 

		

</body>
</html>