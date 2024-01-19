<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Download</title>
<%ArrayList<String> filelist = (ArrayList<String>) request.getAttribute("filelist"); %>
<%ArrayList<String> deletefilelist = (ArrayList<String>) request.getAttribute("deletefilelist"); %>
</head>
<body>
<%@include file="AfterLoginHeader.jsp"%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="37%" align="center"><table width="195" border="1"
					cellspacing="10" cellpadding="10">
					<table cellspacing='0'> <!-- cellspacing='0' is important, must stay -->

	<!-- Table Header -->
	<thead>
		<tr>
			<th>File Name</th>
			<th>Size</th>
			<th>Download</th>
			<th>Delete</th>
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->
	<tbody>
<%for(int i=0;i<filelist.size();i++){ %>
		<tr>
			<td><%=filelist.get(i) %></td>
			<td><%=filelist.get(++i) %>KB</td>
			<td><a href="<%=request.getContextPath()%>/FileDownloader?filename=<%=filelist.get(i-1)%>" >Download</a></td>
			<td><a href="<%=request.getContextPath()%>/FileDownloader?filename=<%=filelist.get(i-1)%>&task=delete" >Delete</a></td>
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