<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=request.getContextPath()%>/assets/css/style.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send File</title>
<%ArrayList<String> userList = (ArrayList<String>) request.getAttribute("userList");
String emailid = (String)session.getAttribute("emailid"); 
String msg = (String)request.getAttribute("message"); 

%>
</head>
<body>
<jsp:include page="AfterLoginHeader.jsp"></jsp:include>

<%if(msg!=null){ %>
<%=msg %>
<%} %>
<form id="upload" method="post" action="<%=request.getContextPath() %>/RegistrationServlet" enctype="multipart/form-data">
<select name="user">
<%for(int i=0;i<userList.size();i++){
	if(!emailid.equalsIgnoreCase(userList.get(i))){
	%>


<option value="<%=userList.get(i) %>"><%=userList.get(i) %></option>
<%
	}} %>
</select>

			<div id="drop">
				Drop Here

				<a>Send</a>
				<input type="file" name="filename" multiple />
			</div>
<input type="hidden" name ="page" value = "sendsave">

			<ul>
				<!-- The file uploads will be shown here -->
			</ul>
		</form>
<script src="<%=request.getContextPath()%>/assets/js/jquery.knob.js"></script>

		<!-- jQuery File Upload Dependencies -->
		<script src="<%=request.getContextPath()%>/assets/js/jquery.ui.widget.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/jquery.iframe-transport.js"></script>
		<script src="<%=request.getContextPath()%>/assets/js/jquery.fileupload.js"></script>
		
		<!-- Our main JS file -->
		<script src="<%=request.getContextPath()%>/assets/js/script.js"></script>

</body>
</html>