<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../javascript/validation.js"></script>
<%String var=(String)request.getAttribute("message"); %>
<title>Registration</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
  <div class="features">
  	     <div class="col-md-4">
  	   	 	<div class="contact-left">
				<h2>location</h2>
				  <div class="company_address">
				     	        <p>NIgdi</p>
						   		<p>GPPY
					</p>
						   		<p>INDIA</p>
				   		<p>Phone:8007956806</p>
				 	 	<p>Email: <span><a href="mailto:pranavlonari12@gmail.com">pranavlonari12@Gmail.com</a></span></p>
				   		<p>Follow on: <span><a href="#">Facebook</a></span>, <span><a href="#">Twitter</a></span></p>
				   </div>
				  		
             </div>
  	   	  </div>
  	   	  <div class="col-md-8">
  	   	 	<div class="contact-right">
						<h2>Registration Page</h2>
						<div class="contact-form">
							<form id="form" method="post" action="<%=request.getContextPath()%>/RegistrationServlet" name="registration">
							<%if(var != null){ %>
						<label> <%=var %></label>
						<%}%>
							  <input type="text" class="textbox" id="FNAME" name ="fname"  placeholder="First Name" onblur="firstname();" required="required" maxlength="16">
							   	<label id="FNAMEERROR"></label>
				<input type="text" class="textbox" id="LNAME" name ="lname"  placeholder="Last Name" onblur="lastname();" required="required" maxlength="16">
				<label id="LNAMEERROR"></label>
				<div class="form_label">
				
				<label  style="font-weight: bold;">Gender </label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" value="Male" name ="gender" checked="checked"><label>Male</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio"   value="Female" name ="gender" ><label>Female</label>
				</div>
				
				<input type="number" class="textbox" id="MNO" name ="mno"  placeholder="Mobile Number" onblur="mobilenumber();" required="required" range="9999999999"><br>
					<label id="MNOERROR"></label>
				<input type="email" class="textbox" placeholder="Email" id="EMAILID" name="emailid"onblur="emailid1()">
				<input type="email" class="textbox" placeholder="Verify Email" id="VEMAILID" name="vemailid" onblur="emailid1()">
				<label id="VEMAILERROR"></label>
				<br><div class="clearfix"> </div>
									 	<input type="submit" value="Send message">
									 	<input type="reset" value="Reset">
						<input type="hidden" value="registration"name="page">
						</form>
						
						
						
						</div>
					</div>
  	   	 </div>
  	     <div class="clearfix"> </div>
	 </div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>