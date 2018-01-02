<%--
  Created by IntelliJ IDEA.
  User: whoami
  Date: 05/05/2017
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/style/front/twts";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Itweet &amp; Boot</title>

    <jsp:include page="tools/style.jsp"></jsp:include>

    <%-- timeline style--%>
    <link rel="stylesheet" href="<%=basePath%>/timeline/css/timeline.css"/>
    <link rel="stylesheet" href="<%=basePath%>/timeline/css/bootstrap.no-icons.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/timeline/css/font-awesome.css"/>
</head>
<body id="page">
<%--Nav Menu--%>
<jsp:include page="tools/navbar.jsp"></jsp:include>

<%--Start Content--%>
<div class="content-body">
    <div class="container">
        <div class="row">
            <main class="col-md-12">
                <div id="vertical-timeline" class="vertical-container dark-timeline" style="width: 700px;">

                    <div class="vertical-timeline-block">
                        <div class="vertical-timeline-icon blue-bg">
                            <i class="fa fa-file-text-o"></i>
                        </div>
                        <div class="vertical-timeline-content">
                            <h2>2017/05/04 迁移阿里云，网站大改版，Itweet-boot项目首发</h2>
                        </div>
                    </div>

                    <div class="vertical-timeline-block">
                        <div class="vertical-timeline-icon blue-bg">
                            <i class="fa fa-clock-o"></i>
                        </div>
                        <div class="vertical-timeline-content">
                            <h2>2016/08/15 博客迁移至hexo,数据0丢失,博客标签丢失50%</h2>
                        </div>
                    </div>

                    <div class="vertical-timeline-block">
                        <div class="vertical-timeline-icon blue-bg">
                            <i class="fa fa-clock-o"></i>
                        </div>
                        <div class="vertical-timeline-content">
                            <h2>2014/12/30 itweet.cn域名正式上线，托管于Github免费空间</h2>
                        </div>
                    </div>

                    <div class="vertical-timeline-block">
                        <div class="vertical-timeline-icon blue-bg">
                            <i class="fa fa-clock-o"></i>
                        </div>
                        <div class="vertical-timeline-content">
                            <h2>2014/11/27 购买itweet.cn域名，专属自己的推特。。。</h2>
                        </div>
                    </div>


                    <div class="vertical-timeline-block">
                        <div class="vertical-timeline-icon blue-bg">
                            <i class="fa fa-clock-o"></i>
                        </div>
                        <div class="vertical-timeline-content">
                            <h2>2014/02/04 自学编程，半年有余，从此。。。</h2>
                        </div>
                    </div>

                    <div class="vertical-timeline-block">
                        <div class="vertical-timeline-icon blue-bg">
                            <i class="fa fa-github"></i>
                        </div>
                        <div class="vertical-timeline-content">
                            <h2>2014/01/01 Hello World</h2>
                        </div>
                    </div>

                </div>
            </main>
        </div>
    </div>
</div>
<%--End Content--%>

<%--site footer--%>
<jsp:include page="tools/site-footer.jsp"></jsp:include>

<!-- Mobile Menu -->
<jsp:include page="tools/mobile-menu.jsp"></jsp:include>

<script src="<%=basePath%>/js/script.js"></script>
</body>
</html>
