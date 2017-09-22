<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>BitTrip</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://bootstraptaste.com" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="css/jcarousel.css" rel="stylesheet" />
<link href="css/flexslider.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<link href="skins/default.css" rel="stylesheet" />
</head>
<body>
	<div id="wrapper">
		<!-- start header -->
		<header>
		<div class="navbar navbar-default navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="newfeed.do"><span>B</span>it<span>T</span>rip</a>
				</div>
				<div class="navbar-collapse collapse ">
					<ul class="nav navbar-nav">
						<li><a href="newsfeed.do">Newsfeed</a></li>
						<%
							if (session.getAttribute("userName") == null || session.getAttribute("userName").equals("")) {
						%>
						<li><a href="login.jsp">Login</a></li>
						<%
							} else {
						%>
						<li><a href="logout.jsp">Logout</a></li>
						<%
							}
						%>
					</ul>
				</div>
			</div>
		</div>
		</header>
		<!-- end header -->
		<section id="inner-headline">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="#"><i class="fa fa-home"></i></a><i
							class="icon-angle-right"></i></li>
						<li class="active">Newsfeed</li>
					</ul>
				</div>
			</div>
		</div>
		</section>
		<section id="content">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<h4>${postInfo.title}</h4>
					<c:forEach var="post" items="${postInfo.contentList}"
						varStatus="status">
						<dl class="dl-horizontal" id="day${status.count}">
							<dt>${status.count}일차</dt>
							<dd>${post.content}</dd>
						</dl>
					</c:forEach>
				</div>
				<div class="col-lg-6">
					<%-- 					<c:forEach var="post" items="${postInfo.locationList}"
						varStatus="status">
						<iframe src="map/Polyline2.html?id=${post.location}" class="map"
							id="map_day${status.count }"width="400px" height="400px" scrolling="no"></iframe>
					</c:forEach> --%>
					<h4>여행지도</h4>

					<ul class="nav nav-tabs">
						<c:forEach var="post" items="${postInfo.locationList}"
							varStatus="status">
							<li><a href="#${status.count}" data-toggle="tab">Day
									${status.count}</a></li>
						</c:forEach>
					</ul>
					<div class="tab-content">
						<c:forEach var="post" items="${postInfo.locationList}"
							varStatus="status">
							<div class="tab-pane active" id="${status.count}">
								<iframe src="map/Polyline2.html?id=${post.location}" class="map"
									id="map_day${status.count }" width="400px" height="400px"
									scrolling="no"></iframe>
							</div>
						</c:forEach>
					</div>

				</div>
			</div>
		</div>
		</section>
		<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="widget">
						<h5 class="widgetheading">Get in touch with us</h5>
						<address>
							<strong>Moderna company Inc</strong><br> Modernbuilding
							suite V124, AB 01<br> Someplace 16425 Earth
						</address>
						<p>
							<i class="icon-phone"></i> (123) 456-7890 - (123) 555-7891 <br>
							<i class="icon-envelope-alt"></i> email@domainname.com
						</p>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="widget">
						<h5 class="widgetheading">Pages</h5>
						<ul class="link-list">
							<li><a href="#">Press release</a></li>
							<li><a href="#">Terms and conditions</a></li>
							<li><a href="#">Privacy policy</a></li>
							<li><a href="#">Career center</a></li>
							<li><a href="#">Contact us</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="widget">
						<h5 class="widgetheading">Latest posts</h5>
						<ul class="link-list">
							<li><a href="#">Lorem ipsum dolor sit amet, consectetur
									adipiscing elit.</a></li>
							<li><a href="#">Pellentesque et pulvinar enim. Quisque
									at tempor ligula</a></li>
							<li><a href="#">Natus error sit voluptatem accusantium
									doloremque</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="widget">
						<h5 class="widgetheading">Flickr photostream</h5>
						<div class="flickr_badge">
							<script type="text/javascript"
								src="http://www.flickr.com/badge_code_v2.gne?count=8&amp;display=random&amp;size=s&amp;layout=x&amp;source=user&amp;user=34178660@N03"></script>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
		<div id="sub-footer">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<div class="copyright">
							<p>&copy; Moderna Theme. All right reserved.</p>
							<div class="credits">
								<!-- 
                                All the links in the footer should remain intact. 
                                You can delete the links only if you purchased the pro version.
                                Licensing information: https://bootstrapmade.com/license/
                                Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Moderna
                            -->
								<a href="https://bootstrapmade.com/">Free Bootstrap Themes</a>
								by <a href="https://bootstrapmade.com/">BootstrapMade</a>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<ul class="social-network">
							<li><a href="#" data-placement="top" title="Facebook"><i
									class="fa fa-facebook"></i></a></li>
							<li><a href="#" data-placement="top" title="Twitter"><i
									class="fa fa-twitter"></i></a></li>
							<li><a href="#" data-placement="top" title="Linkedin"><i
									class="fa fa-linkedin"></i></a></li>
							<li><a href="#" data-placement="top" title="Pinterest"><i
									class="fa fa-pinterest"></i></a></li>
							<li><a href="#" data-placement="top" title="Google plus"><i
									class="fa fa-google-plus"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		</footer>
	</div>
	<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
	<!-- javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.fancybox.pack.js"></script>
	<script src="js/jquery.fancybox-media.js"></script>
	<script src="js/google-code-prettify/prettify.js"></script>
	<script src="js/portfolio/jquery.quicksand.js"></script>
	<script src="js/portfolio/setting.js"></script>
	<script src="js/jquery.flexslider.js"></script>
	<script src="js/animate.js"></script>
	<script src="js/bit3.js?ver=2"></script>
	<script src="js/custom.js"></script>

</body>
</html>