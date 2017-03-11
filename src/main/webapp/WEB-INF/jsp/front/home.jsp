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
<title>Effe - Personal Blog</title>
<link rel="shortcut icon" href="favicon.ico" />
<!-- Load CSS -->
<link href="<%=basePath%>/front/css/style.css" rel="stylesheet" type="text/css" />
<!-- Load Fonts -->
<!-- Load jQuery library -->
<script type="text/javascript" src="<%=basePath%>/front/scripts/jquery-1.6.2.min.js"></script>
<!-- Load custom js -->
<script type="text/javascript" src="<%=basePath%>/front/scripts/panelslide.js"></script>
<script type="text/javascript" src="<%=basePath%>/front/scripts/custom.js"></script>
<!-- Load topcontrol js -->
<script type="text/javascript" src="<%=basePath%>/front/scripts/scrolltopcontrol.js"></script>
<!-- Load NIVO Slider -->
<link rel="stylesheet" href="<%=basePath%>/front/css/nivo-slider.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=basePath%>/front/css/nivo-theme.css" type="text/css" media="screen" />
<script src="<%=basePath%>/front/scripts/jquery.nivo.slider.pack.js" type="text/javascript"></script>
<script src="<%=basePath%>/front/scripts/nivo-options.js" type="text/javascript"></script>
<!-- Load fancybox -->
<script type="text/javascript" src="<%=basePath%>/front/scripts/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="<%=basePath%>/front/scripts/jquery.easing-1.3.pack.js"></script>
<script type="text/javascript" src="<%=basePath%>/front/scripts/jquery.mousewheel-3.0.4.pack.js"></script>
<link rel="stylesheet" href="<%=basePath%>/front/css/jquery.fancybox-1.3.4.css" type="text/css" media="screen" />
</head>
<body>
<!--This is the START of the header-->
<div id="topcontrol" style="position: fixed; bottom: 5px; left: 960px; opacity: 1; cursor: pointer;" title="Go to Top"></div>
<div id="header-wrapper">
	<div id="header">
		<div id="logo"> <a href="index.html"><img src="<%=basePath%>/front/images/logo.png" width="100" height="80" alt="logo" /></a> </div>
		<div id="header-text">
			<h4>We make a bunch of cool stuff, have a look around!</h4>
			<h6><a href="index.html">Home</a></h6>
		</div>
	</div>
</div>
<!--END of header-->
<!--This is the START of the menu-->
<div id="menu-wrapper">
	<div id="main-menu">
		<ul>
			<li><a class="selected" href="<%=basePath%>/front/index.html">Home →</a></li>
			<li><a href="<%=basePath%>/front/about.html">About</a></li>
			<li><a href="<%=basePath%>/front/portfolio.html">Portfolio</a></li>
			<li><a href="<%=basePath%>/front/blog.html">Blog</a></li>
			<li><a href="<%=basePath%>/front/contact.html">Contact</a></li>
			<li><a href="<%=basePath%>/front/features.html">Features</a></li>
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
	</div>
	<!--END of footer-->
</div>
<!--END of menu-->

<!--This is the START of the content-->
<div id="content">
	<!--This is the START of the NIVO slider-->
	<div class="slider-wrapper theme-effe">
		<div id="slider" class="nivoSlider"> <img src="<%=basePath%>/front/images/slider/slide1.jpg" alt="" title="#img1" /> <img src="<%=basePath%>/front/images/slider/slide2.jpg" alt="" title="#img2" /> <img src="<%=basePath%>/front/images/slider/slide3.jpg" alt="" title="#img3" /> <img src="<%=basePath%>/front/images/slider/slide4.jpg" alt="" title="#img4" /> </div>
	</div>
	<!--END of NIVO Slider-->
	<!--This is the START of the recent posts-->
	<div class="spacer"></div>
	<div id="recent-text">
		<h2>These are some of our latest posts...</h2>
		<div class="star-divider"></div>
		<h5>You can check them out in our blog section!</h5>
		<div class="spacer"></div>
	</div>
	<div id="recent-posts-container">
		<div class="section-description">
			<h5>Recent posts</h5>
			<p>Here you can find some of our most recent and fresh content...</p>
		</div>
		<div class="recent-summary">
			<div class="recent-item"> <a class="single_image" href="<%=basePath%>/front/images/blog/large/recent1.jpg"><img src="<%=basePath%>/front/images/blog/thumbs/recent1.jpg" width="250" height="150" alt="recent1" /></a>
				<h6>NYC</h6>
				<p>On a scooter?<a class="readmore" href="blog.html">read more →</a></p>
			</div>
			<div class="recent-item-last"> <a class="single_image" href="<%=basePath%>/front/images/blog/large/recent2.jpg"><img src="<%=basePath%>/front/images/blog/thumbs/recent2.jpg" width="250" height="150" alt="recent2" /></a>
				<h6>Feathers</h6>
				<p>Could drop some lorem here.<a class="readmore" href="blog.html">read more →</a></p>
			</div>
		</div>
		<!--END of recent posts-->
		<!--This is the START of the recent projects-->
		<div id="recent-projects-container">
			<div class="section-description">
				<h5>Recent projects</h5>
				<p>These are some of our latest projects, some nice stuff in here...</p>
			</div>
			<div class="recent-summary">
				<div class="recent-item"> <a class="single_image" href="<%=basePath%>/front/images/portfolio/thumbs/recent1.jpg"><img src="<%=basePath%>/front/images/portfolio/thumbs/recent1.jpg" width="250" height="150" alt="recent1" /></a>
					<h6>Moo Minicards</h6>
					<p>Kinda sweet huh?<a class="readmore" href="portfolio.html">read more →</a></p>
				</div>
				<div class="recent-item-last"> <a class="single_image" href="<%=basePath%>/front/images/portfolio/thumbs/recent2.jpg"><img src="<%=basePath%>/front/images/portfolio/thumbs/recent2.jpg" width="250" height="150" alt="recent2" /></a>
					<h6>Right off the press!</h6>
					<p>Could drop some lorem here.<a class="readmore" href="<%=basePath%>/front/portfolio.html">read more →</a></p>
				</div>
			</div>
			<!--END of recent projects-->
			<div class="spacer"></div>
			<!--END of content-->
		</div>
	</div>
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
		<img class="star-divider" src="<%=basePath%>/front/images/star_divider.png" /> <a href="http://www.twitter.com/92_five">
		<div id="follow-twitter"><img src="<%=basePath%>/front/images/tweet_top.png" />
			<h4>Follow me on twitter</h4>
		</div>
		</a><a href="http://eepurl.com/dqtGj">
		<div id="follow-mail"><img src="<%=basePath%>/front/images/mail_top.png" />
			<h4>Subscribe to my newsletter</h4>
		</div>
		</a>
		<h1>Thanks for that!</h1>
	</div>
	<!--END of follow section-->
</div>
</body>
</html>