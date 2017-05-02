<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/style/front/theme/effe";
%>
<!DOCTYPE html>
<html>

<head>
	<title>About</title>
	<jsp:include page="tools/style.jsp"></jsp:include>
</head>

<body>

<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>


<!--This is the START of the content-->
<div id="content">
	<div class="spacer"></div>
	<div class="team-text">
		<h2 style="font-family: STXingkai">关于我们...</h2>
		<div class="star-divider"></div>
		<h5 style="font-family: STXingkai">你可以通过社交链与我们取得联系，互相学习!</h5>
	</div>
	<div class="spacer"></div>
	<div class="about">
		<h5 style="font-family: STXingkai">关于自由软件设计.</h5>
		<p>	游走在极客路上的小码农，一枚热爱Coding的攻城狮，设计了一些自由的软件，初衷是设计给自己用，做为一个有品位的人，很难找到和我意的自由软件，
			而我设计的软件朋友看到都很是喜欢，所以开源出来：<br>
			&nbsp;&nbsp; 1.大型分布式监控系统skynet 	<br>
			&nbsp;&nbsp; 2.个人博客系统itweet-boot		<br>
			&nbsp;&nbsp; 3.[视频]企业级Hadoop解决方案教程.
		</p>
		<div class="spacer"></div>
		<h5 style="font-family: STXingkai">我们提供免费的教程!</h5>
		<p>如果我们提供的免费教程对你有所帮助，为了让我们能更好的发展下去，你可以捐赠我们，非常感谢支持！</p>
		<a class="single_image" href="<%=basePath%>/images/about/large/pricing-table.jpg"><img src="<%=basePath%>/images/about/large/pricing-table.jpg" width="720" height="500" alt="pricing" /></a>
	</div>
	<div class="spacer"></div>
</div>


<!--This is the START of the follow section-->
<%--<jsp:include page="tools/panel.jsp"></jsp:include>--%>

</body>

</html>