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
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/style/front/theme/twts";
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
            <main class="col-md-8">
                <c:forEach items="${listArticle.content}" var="article">
                    <article class="post post-1">
                        <header class="entry-header">
                            <h1 class="entry-title">
                                <a href="/blog/<fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/>/${article.title}">${article.title}</a>
                            </h1>
                            <div class="entry-meta">
                                <span class="post-category"><a href="#">Web Design</a></span>

                                <span class="post-date"><a href="#"><time class="entry-date">日期：<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${article.createDate}"/></time></a></span>

                                <span class="post-author"><a href="#">作者：${article.author}</a></span>

                                <span class="comments-link"><a href="#">评论：4 Comments</a></span>
                            </div>
                        </header>

                        <div class="entry-content clearfix">
                            <p>${article.fullDescription}</p>
                            <div class="read-more cl-effect-14">
                                <a href="/blog/<fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/>/${article.title}" class="more-link">继续阅读 <span class="meta-nav">→</span></a>
                            </div>
                        </div>

                    </article>
                </c:forEach>
            </main>

            <aside class="col-md-4">

                <div class="widget widget-category">
                    <h3 class="widget-title" style="font-family: STXingkai">分类</h3>
                    <ul>
                        <c:forEach items="${categoriesList}" var="categories">
                            <li>
                                <a href="#">${categories.name}</a>
                            </li>
                        </c:forEach>
                        <li>
                            <a href="#">Web Development</a>
                        </li>
                        <li>
                            <a href="#">SEO</a>
                        </li>
                    </ul>
                </div>

                <div class="widget widget-recent-posts">
                    <h3 class="widget-title" style="font-family: STXingkai">最新文章</h3>
                    <ul>
                        <c:forEach items="${topArticle}" var="article">
                            <li>
                                <a href="/blog/<fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/>/${article.title}">${article.title}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

                <div class="widget widget-archives">
                    <h3 class="widget-title" style="font-family: STXingkai">友情链接</h3>
                    <ul>
                        <li>
                            <a href="http://www.itweet.cn/">Itweet's Blog</a>
                        </li>
                        <li>
                            <a href="http://www.server-world.info/en/">Server World Japanese</a>
                        </li>
                        <li>
                            <a href="https://github.com/commaai/research">comma.ai</a>
                        </li>
                    </ul>
                </div>
            </aside>

        </div>
    </div>
</div>

<footer id="site-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p class="copyright">&copy; 2017 itweet.cn</p>
            </div>
        </div>
    </div>
</footer>

<!-- Mobile Menu -->
<jsp:include page="tools/mobile-menu.jsp"></jsp:include>

<script src="<%=basePath%>/js/script.js"></script>

</body>
</html>
