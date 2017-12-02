<%--
  Created by IntelliJ IDEA.
  User: whoami
  Date: 02/05/2017
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/style/front/theme/twts";
    String URL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
    <title>Itweet &amp; Boot</title>

    <jsp:include page="tools/style.jsp"></jsp:include>
</head>

<body id="page">

<%--Nav Menu--%>
<jsp:include page="tools/navbar.jsp"></jsp:include>

<div class="content-body">
    <div class="container">
        <div class="row">
            <main class="col-md-12">
                <h1 class="page-title" style="font-family: STXingkai">联系我</h1>
                <article class="post">
                    <div class="entry-content clearfix">
                        <form action="#" method="post" class="contact-form">
                            <div class="row">
                                <div class="col-md-6 col-md-offset-3">
                                    <input type="text" name="name" placeholder="名称" required>
                                    <input type="email" name="email" placeholder="邮箱" required>
                                    <input type="text" name="subject" placeholder="主题" required>
                                    <textarea name="message" rows="7" placeholder="消息" required></textarea>
                                    <button class="btn-send btn-5 btn-5b ion-ios-paperplane"><span>发送消息</span></button>
                                </div>
                            </div>	<!-- row -->
                        </form>
                    </div>
                </article>
            </main>
        </div>
    </div>
</div>

<%--site footer--%>
<jsp:include page="tools/site-footer.jsp"></jsp:include>

<!-- Mobile Menu -->
<jsp:include page="tools/mobile-menu.jsp"></jsp:include>

<script src="<%=basePath%>/js/script.js"></script>

</body>
</html>
