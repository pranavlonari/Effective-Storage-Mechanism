<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="<%=request.getContextPath()%>/css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
<!--webfont-->
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<!-- Add fancyBox main JS and CSS files -->
<script src="<%=request.getContextPath()%>/js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/css/popup.css" rel="stylesheet" type="text/css">
		<script>
			$(document).ready(function() {
				$('.popup-with-zoom-anim').magnificPopup({
					type: 'inline',
					fixedContentPos: false,
					fixedBgPos: true,
					overflowY: 'auto',
					closeBtnInside: true,
					preloader: false,
					midClick: true,
					removalDelay: 300,
					mainClass: 'my-mfp-zoom-in'
			});
		});
		</script>
<!--Animation-->
<script src="<%=request.getContextPath()%>/js/wow.min.js"></script>
<link href="<%=request.getContextPath()%>/css/animate.css" rel='stylesheet' type='text/css' />
<script>
	new WOW().init();
</script>
</head>
<body>
<!-- <div class="header">
   <div class="container">
      <div class="header_top">
	      <div class="header-left">
					 <div class="logo wow bounceInDown" data-wow-delay="0.4s">
						<a href="index.html"><img src="<%=request.getContextPath()%>/images/logo.png" alt=""/></a>
					 </div>
					 <div class="menu">
						  <a class="toggleMenu" href="#"><img src="<%=request.getContextPath()%>/images/nav.png" alt="" /></a>
						    <ul class="nav" id="nav">
						    	<li class="active"><a href="index.html">Product</a></li>
						    	<li><a href="industries.html">Industries</a></li>
						    	<li><a href="pricing.html">Pricing</a></li>
						    	<li><a href="features.html">Features</a></li>
						    	<div class="clearfix"></div>
							</ul>
							<script type="text/javascript" src="<%=request.getContextPath()%>/js/responsive-nav.js"></script>
				    </div>
				    <div class="clearfix"></div>
	      </div>
	      </div>
	      </div>
	      </div>
	       -->
	       <div class="price_header">
   <div class="container">
      <div class="header_top">
	      <div class="header-left">
					 <div class="logo">
						<a href="Homepage.jsp"><img src="images/logo.png" alt=""/></a>
					 </div>
					 <div class="menu">
						  <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
						    <ul class="nav" id="nav">
						    	<li><a href="<%=request.getContextPath() %>/JSP/Homepage.jsp">Homepage</a></li>
						    	<li><a href="<%=request.getContextPath() %>/JSP/Registration.jsp">Registration</a></li>
						    	<li><a href="<%=request.getContextPath() %>/JSP/Login.jsp">Log in</a></li>
						    	<li><a href="<%=request.getContextPath() %>/JSP/Forgetpassword.jsp">Forget Password</a></li>
						    	<div class="clearfix"></div>
							</ul>
							<script type="text/javascript" src="js/responsive-nav.js"></script>
				    </div>
	       </div>
	      <ul class="phone">
	      	<li><i class="ph_icon"> </i></li>
	      	<li><p>+91(7350057224)</p></li>
	      </ul>
	      <div class="clearfix"> </div>
	   </div>
	   <div class="clearfix"></div>
	</div>
</div>
	      
</body>
</html>