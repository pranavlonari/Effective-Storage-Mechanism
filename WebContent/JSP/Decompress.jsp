<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DeCompress</title>
	<link href="<%=request.getContextPath()%>/assets/css/style.css" rel="stylesheet" />
</head>
<body>
<jsp:include page="AfterLoginHeader.jsp"></jsp:include>
<form id="upload" method="post" action="<%=request.getContextPath() %>/DeCompressServlet" enctype="multipart/form-data">
			<div id="drop">
				Drop Here

				<a>DeCompress</a>
				<input type="file" name="filename" multiple />
			</div>
<input type="hidden" name ="page" value = "compress">

			<ul>
				<!-- The file uploads will be shown here -->
			</ul>
			<a href="<%=request.getContextPath() %>/DeCompressServlet" style="color: white;">Save</a>
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