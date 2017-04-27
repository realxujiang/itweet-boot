<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/style/front/theme/effe";
	String URL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
	<title>About</title>
	<jsp:include page="tools/style.jsp"></jsp:include>
</head>

<body>
<!--This is the START of the header-->
<div id="topcontrol" style="position: fixed; bottom: 5px; left: 960px; opacity: 1; cursor: pointer;" title="Go to Top"></div>
<div id="header-wrapper">
	<div id="header">
		<div id="logo">
			<a href="<%=URL%>/"><img src="<%=basePath%>/images/logo.png" width="100" height="80" alt="logo" /></a>
		</div>
		<div id="header-text">
			<h4>So want to know more about our creative team?</h4>
			<h6><a href="<%=URL%>/">Home</a> → About</h6>
		</div>
	</div>
</div>
<!--END of header-->


<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>


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
		<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel Dapibus id, mattis vel, nisi. Sed pretium, ligula sollici tudin ot justo. Suspendisse potenti.Sed egestas, ante et vulputate volutpat, eros pede semper est, vitae luctus metus Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel, dapibus id, mattis vel, nisi. Sed pretium, ligula sollicitudin laoreet viverra, tortor liber sodales leo, eget blandit nunc tortor eu nibh. Nullam mollis. Ut justo. Suspendisse potenti.Sed egestas, ante et vulputate volutpat</p>
		<div class="spacer"></div>
		<h5>And I offer design packages for you!</h5>
		<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Phasellus hendrerit. Pellentesque aliquet nibh nec urna. In nisi neque, aliquet vel Dapibus id, mattis vel, nisi. Sed pretium, ligula sollici tudin ot justo. Suspendisse potenti.Sed egestas, ante et vulputate volutpat, eros pede semper est, vitae luctus metus Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
		<a class="single_image" href="<%=basePath%>/images/about/large/pricing-table.jpg"><img src="<%=basePath%>/images/about/large/pricing-table.jpg" width="720" height="500" alt="pricing" /></a>
	</div>
	<div class="spacer"></div>
</div>


<!--This is the START of the follow section-->
<jsp:include page="tools/panel.jsp"></jsp:include>

</body>

</html>