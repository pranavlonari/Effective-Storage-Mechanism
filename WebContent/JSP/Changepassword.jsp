<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<%String emailid=(String)session.getAttribute("emailid");
String message=(String)request.getAttribute("message");
%>
</head>
<body>


<jsp:include page="AfterLoginHeader.jsp"></jsp:include>


<div class="features">
 
  <div class="col-md-8">
  	   	 	<div class="contact-right">
						<h2>Change Password Page</h2>
						<div class="contact-form">
							<form id="form" method="post" action="<%=request.getContextPath()%>/RegistrationServlet" name="registration">
				<input autocomplete="off" type="password"   placeholder="Confirm Password" name="cpwd" required="required">
				 <input autocomplete="off" type="password"   placeholder="New Password" name="npwd" required="required">
				 <input autocomplete="off" type="password"   placeholder="Verify New Password" name="password" required="required">
				 <input type="hidden" value="changepwd" name="page">
				 <input type="submit" value="Change Password">
				 <br>
				    <%if(message!=null){%>
							<%=message %>
					<%} %> 
				</form>
				</div>
				</div>
				</div>
 </div>				


</body>
</html>