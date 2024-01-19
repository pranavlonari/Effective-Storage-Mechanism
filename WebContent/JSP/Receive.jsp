<%@page import="bean.RegistrationBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Receive </title>
<%ArrayList<RegistrationBean> filelist = (ArrayList<RegistrationBean>) request.getAttribute("file"); %>
</head>
<body>
<%@include file="AfterLoginHeader.jsp"%>
	<table width="100%" border="0" cellspacing="10" cellpadding="10">
		<tr>
			<td width="37%" align="center"><table width="195" border="1"
					cellspacing="10" cellpadding="10">
					<table width="60%"  border="1" cellspacing='0'> <!-- cellspacing='0' is important, must stay -->

	<!-- Table Header -->
	<thead>
		<tr>
			<th>File Name</th>
			
			<th>Size</th>
			<th>Email Id</th>
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->
	<tbody>
<%for(int i=0;i<filelist.size();i++){ %>
		<tr>
			<td><%=filelist.get(i).getFname() %></td>
			<td><%=(Integer.parseInt(filelist.get(i).getMno()))/1024 %> KB</td>
			<td><%=filelist.get(i).getMailid() %></td>
		</tr><!-- Table Row -->

	<%} %>
 
 -	</tbody>
	<!-- Table Body -->

</table>
					
					
					<tr>
					</tr>
				</table></td>
		</tr>
	</table>

</body>
</html>