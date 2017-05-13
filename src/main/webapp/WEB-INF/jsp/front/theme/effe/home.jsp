<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/style/front/theme/effe";
	String URL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!doctype html>
<html>

<head>
	<title>Home</title>
	<jsp:include page="tools/style.jsp"></jsp:include>
</head>
<body>

<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>

<!--This is the START of the content-->
<div id="content">

	<!--This is the START of the NIVO slider-->
	<div class="slider-wrapper theme-effe">
		<div id="slider" class="nivoSlider">
			<c:forEach items="${documentList}" var="document">
				<a href="/portfolio"><img src="<%=URL%>/upload/files/${document.ruleFilename}" alt="" title="#${document.filename}" /></a>
			</c:forEach>
		</div>
	</div>
	<!--END of NIVO Slider-->

	<!--This is the START of the recent posts-->
	<div class="spacer"></div>
	<div id="recent-text">
		<h2 style="font-family: 'Xingkai TC';">我最近的一些作品 . . .</h2>
		<div class="star-divider"></div>
		<h5 style="font-family: STXingkai">跟踪我的最新动态！</h5>
		<div class="spacer"></div>
	</div>
	<div id="recent-posts-container">
		<div class="section-description">
			<h5 style="font-family: 'Xingkai TC'">最近的帖子</h5>
			<p>这里你可以学习到有关云计算、大数据、行业最新技术以及我们生产环境的使用经验 . . . </p>
		</div>
		<div class="recent-summary">
			<div class="recent-item">
				<a class="single_image" href="<%=URL%>/upload/files/${articleFirst.coverPicture}"><img src="<%=URL%>/upload/files/${articleFirst.coverPicture}" width="250" height="150" alt="recent1" /></a>
				<h6 style="font-family: 'Xingkai TC'">${articleFirst.title}</h6>
				<p>${articleFirst.description}
					<a class="readmore" href="/tweet">阅读更多 →</a>
				</p>
			</div>
			<div class="recent-item-last">
				<a class="single_image" href="<%=URL%>/upload/files/${articleLast.coverPicture}"><img src="<%=URL%>/upload/files/${articleLast.coverPicture}" width="250" height="150" alt="recent2" /></a>
				<h6 style="font-family: 'Xingkai TC'">${articleLast.title}</h6>
				<p>${articleLast.description}
					<a class="readmore" href="/tweet">阅读更多 →</a>
				</p>
			</div>
		</div>
		<!--END of recent posts-->

		<!--This is the START of the recent projects-->
		<div id="recent-projects-container">
			<div class="section-description">
				<h5 style="font-family: 'Xingkai TC'">最近的项目</h5>
				<p>关于我们做的一些最新的开源项目，主要包括云计算、大数据、JavaWeb相关的内容，以及文档、视频教程 . . . </p>
			</div>

			<div class="recent-summary">
				<c:forEach items="${courseList}" var="course" varStatus="stat">
					<c:if test="${!stat.last}">
						<div class="recent-item">
							<a class="single_image" href="<%=URL%>/upload/files/${course.coverPicture}"><img src="<%=URL%>/upload/files/${course.coverPicture}" width="250" height="150" alt="recent1" /></a>
							<h6 style="font-family: 'Xingkai TC'">${course.title}</h6>
							<p>${course.description}
								<a class="readmore" href="/portfolio">阅读更多 →</a>
							</p>
						</div>
					</c:if>
					<c:if test="${stat.last}">
						<div class="recent-item-last">
							<a class="single_image" href="<%=URL%>/upload/files/${course.coverPicture}"><img src="<%=URL%>/upload/files/${course.coverPicture}" width="250" height="150" alt="recent1" /></a>
							<h6 style="font-family: 'Xingkai TC'">${course.title}</h6>
							<p>${course.description}
								<a class="readmore" href="/portfolio">阅读更多 →</a>
							</p>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<!--END of recent projects-->

			<div class="spacer"></div>
			<!--END of content-->
		</div>
	</div>
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<%--<jsp:include page="tools/panel.jsp"></jsp:include>--%>

</body>

</html>