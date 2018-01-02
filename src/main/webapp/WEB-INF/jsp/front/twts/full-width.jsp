<%--
  Created by IntelliJ IDEA.
  User: whoami
  Date: 03/05/2017
  Time: 11:04
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
</head>

<body>

<%--Nav Menu--%>
<jsp:include page="tools/navbar.jsp"></jsp:include>

<div class="content-body">
    <div class="container">
        <div class="row">
            <main class="col-md-12">
                <article class="post post-1">
                    <header class="entry-header">
                        <c:forEach items="${mapArticle}" var="articles">
                            <h1 class="entry-title" style="text-align: left">
                                <a href="/blog/${articles.key}">${articles.key}</a>
                            </h1>
                            <c:forEach items="${articles.value}" var="article">
                                <div class="entry-meta" style="text-align: left;margin-left: 80px;">
                                    <span class="post-category"></span><a href="/blog/<fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/>/${article.title}"> &ensp; <fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/> &ensp; ${article.title}</a>
                                </div>
                            </c:forEach>
                        </c:forEach>
                    </header>
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