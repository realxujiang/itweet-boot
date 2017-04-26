<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Effe - About</title>
	<link rel="shortcut icon" href="favicon.ico" />
	<!-- Load CSS -->
	<link href="<%=basePath%>style/front/css/style.css" rel="stylesheet" type="text/css" />
	<!-- Load Fonts -->
	<%--<link rel="stylesheet" href="http://fonts.useso.com/css?family=Droid+Serif:regular,italic,bold,bolditalic" type="text/css" />
	<link rel="stylesheet" href="http://fonts.useso.com/css?family=Droid+Sans:regular,bold" type="text/css" />--%>
	<!-- Load jQuery library -->
	<script type="text/javascript" src="<%=basePath%>style/front/scripts/jquery-1.6.2.min.js"></script>
	<!-- Load custom js -->
	<script type="text/javascript" src="<%=basePath%>style/front/scripts/panelslide.js"></script>
	<script type="text/javascript" src="<%=basePath%>style/front/scripts/custom.js"></script>
	<!-- Load topcontrol js -->
	<script type="text/javascript" src="<%=basePath%>style/front/scripts/scrolltopcontrol.js"></script>
	<!-- Load NIVO Slider -->
	<link rel="stylesheet" href="<%=basePath%>style/front/css/nivo-slider.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="<%=basePath%>style/front/css/nivo-theme.css" type="text/css" media="screen" />
	<script src="<%=basePath%>style/front/scripts/jquery.nivo.slider.pack.js" type="text/javascript"></script>
	<script src="<%=basePath%>style/front/scripts/nivo-options.js" type="text/javascript"></script>
	<!-- Load fancybox -->
	<script type="text/javascript" src="<%=basePath%>style/front/scripts/jquery.fancybox-1.3.4.pack.js"></script>
	<script type="text/javascript" src="<%=basePath%>style/front/scripts/jquery.easing-1.3.pack.js"></script>
	<script type="text/javascript" src="<%=basePath%>style/front/scripts/jquery.mousewheel-3.0.4.pack.js"></script>
	<link rel="stylesheet" href="<%=basePath%>style/front/css/jquery.fancybox-1.3.4.css" type="text/css" media="screen" />
</head>
<body>
<!--This is the START of the header-->
<div id="topcontrol" style="position: fixed; bottom: 5px; left: 960px; opacity: 1; cursor: pointer;" title="Go to Top"></div>
<div id="header-wrapper">
	<div id="header">
		<div id="logo"><a href="index.html"><img src="<%=basePath%>style/front/images/logo.png" width="100" height="80" alt="logo" /></a></div>
		<div id="header-text">
			<h4>So want to know more about our creative team?</h4>
			<h6><a href="index.html">Home</a> → About</h6>
		</div>
	</div>
</div>
<!--END of header-->
<!--This is the START of the menu-->
<div id="menu-wrapper">
	<div id="main-menu">
		<ul>
			<li><a href="index.html">Home</a></li>
			<li><a class="selected" href="about.html">About →</a></li>
			<li><a href="portfolio.html">Portfolio</a></li>
			<li><a href="blog.html">Blog</a></li>
			<li><a href="contact.html">Contact</a></li>
			<li><a href="features.html">Features</a></li>
		</ul>
	</div>
	<!--This is the START of the footer-->
	<div id="footer">
		<div id="social-box">
			<ul>
				<li>
					<div class="facebook"><a href="#"></a></div>
				</li>
				<li>
					<div class="twitter"><a href="#"></a></div>
				</li>
				<li>
					<div class="rss"><a href="#"></a></div>
				</li>
			</ul>
		</div>
		<h6>Copyright © 2017 - effe.theme by <a href="https://github.com/itweet/itweet-boot" target="_blank" title="个人推文">Itweet</a></h6>
	</div>
	<!--END of footer-->
</div>
<!--END of menu-->
<!--This is the START of the content-->
<div id="content">
	<div class="spacer"></div>
	<div class="team-text">
		<h2>This is a bit about me...</h2>
		<div class="star-divider"></div>
		<h5>You can check me out via my social links!</h5>
	</div>
	<div class="spacer"></div>
	<div class="about">
		<h5>I make some sweet designs.</h5>
		<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel
			Dapibus id, mattis vel, nisi. Sed pretium, ligula sollici tudin ot justo. Suspendisse potenti.Sed egestas, ante et vulputate volutpat, eros pede semper est, vitae luctus metus
			Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapibus id, mattis vel, nisi. Sed pretium, ligula sollicitudin laoreet viverra, tortor liber
			sodales leo, eget blandit nunc tortor eu nibh. Nullam mollis. Ut justo. Suspendisse potenti.Sed egestas, ante et vulputate volutpat</p>
		<div class="spacer"></div>
		<h5>And I offer design packages for you!</h5>
		<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel
			Dapibus id, mattis vel, nisi. Sed pretium, ligula sollici tudin ot justo. Suspendisse potenti.Sed egestas, ante et vulputate volutpat, eros pede semper est, vitae luctus metus
			Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
		<a class="single_image" href="<%=basePath%>style/front/images/about/large/pricing-table.jpg"><img src="<%=basePath%>style/front/images/about/large/pricing-table.jpg" width="720" height="500" alt="pricing" /></a>
	</div>
	<div class="spacer"></div>
</div>
<!--END of content-->
<p class="slide"><a href="#" class="btn-slide"></a></p>
<div id="slide-panel">
	<!--This is the START of the follow section-->
	<div id="follow">
		<h3>Get Notified About My Newest Freebies & Upcoming Themes!</h3>
		<h5>
			<p>I do make some awesome freebies for you to use... All of them are FREE and pixel perfect!</p>
			<p>Thanks for showing me the support by subscribing, and I'll try not to disappoint you...</p>
		</h5>
		<img class="star-divider" src="<%=basePath%>style/front/images/star_divider.png" /> <a href="http://www.twitter.com/92_five">
		<div id="follow-twitter"><img src="<%=basePath%>style/front/images/tweet_top.png" />
			<h4>Follow me on twitter</h4>
		</div>
	</a><a href="http://eepurl.com/dqtGj">
		<div id="follow-mail"><img src="<%=basePath%>style/front/images/mail_top.png" />
			<h4>Subscribe to my newsletter</h4>
		</div>
	</a>
		<h1>Thanks for that!</h1>
	</div>
	<!--END of follow section-->
</div>
</body>
</html>