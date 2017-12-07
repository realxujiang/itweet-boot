<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String URL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/style/front/theme/effe";
%>
<!DOCTYPE html>
<html>

<head>
	<title>About</title>
	<jsp:include page="tools/style.jsp"></jsp:include>
	<%--畅言--%>
	<script type="text/javascript">
        (function(){
            var appid = 'cyt1SoANh';
            var conf = 'prod_f1122db7ae1d42036c646ea61c3ae363';
            var width = window.innerWidth || document.documentElement.clientWidth;
            if (width < 960) {
                window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("https://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })();
	</script>
</head>

<body>

<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>


<!--This is the START of the content-->
<div id="content">
	<div class="spacer"></div>
	<div class="team-text">
		<h2 style="font-family: STXingkai">关于...</h2>
		<div class="star-divider"></div>
		<h5 style="font-family: STXingkai">我们就想做点不一样的事情...</h5>
	</div>
	<div class="spacer"></div>
	<div class="about">
		<h5 style="font-family: STXingkai">关于自由软件设计.</h5>
		<p>
			一些自由的软件，做为一个有品位的人，当然是设计给自己用啦：<br>
			&nbsp;&nbsp; 1.大型分布式监控系统skynet 	<br>
			&nbsp;&nbsp; 2.个人博客系统itweet-boot		<br>
			&nbsp;&nbsp; 3.我的GitHub地址：https://github.com/realxujiang	<br>
		</p>
		<div class="spacer"></div>
		<h5 style="font-family: STXingkai">我们的社交网络ID.</h5>
		<p>
			QQ 群 1: 457710636
			QQ 群 2: 288396468
		</p>
		<div class="spacer"></div>
		<h5 style="font-family: STXingkai">我们提供免费的教程.</h5>
		<p>如果我们提供的免费教程对你有所帮助，为了让我们能更好的发展下去，你可以捐赠我们，非常感谢支持！</p>
		<a class="single_image" href="<%=basePath%>/images/about/large/pricing-table.jpg"><img src="<%=basePath%>/images/about/large/pricing-table.jpg" width="720" height="500" alt="pricing" /></a>
	</div>
	<div class="spacer"></div>
	<!--PC和WAP自适应版-->
	<div id="SOHUCS" sid="twts-about"></div>
</div>


<!--This is the START of the follow section-->
<%--<jsp:include page="tools/panel.jsp"></jsp:include>--%>

</body>

</html>