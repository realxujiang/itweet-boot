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
                <c:forEach items="${listArticle}" var="article">
                    <article class="post post-1">
                        <header class="entry-header">
                            <h1 class="entry-title">
                                <a href="/blog/<fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/>/${article.title}">
                                    <c:if test="${article.typeArticle eq 1}">
                                        [Tweet] ${article.title}
                                    </c:if>
                                    <c:if test="${article.typeArticle eq 0}">
                                        ${article.title}
                                    </c:if>
                                </a>
                            </h1>
                            <div class="entry-meta">
                                <span class="post-category"><a href="#">Web Design</a></span>

                                <span class="post-date"><a href="#"><time class="entry-date">日期：<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${article.createDate}"/></time></a></span>

                                <span class="post-author"><a href="#">作者：${article.author}</a></span>

                                <span class="comments-link"><a href="#">评论：4 Comments</a></span>
                            </div>
                        </header>

                        <div class="entry-content clearfix">
                            <p>${article.description}</p>
                            <div class="read-more cl-effect-14">
                                <a href="/blog/<fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/>/${article.title}" class="more-link">继续阅读 <span class="meta-nav">→</span></a>
                            </div>
                        </div>

                    </article>
                </c:forEach>
            </main>

            <%-- Left Menu --%>
            <jsp:include page="tools/left-menu.jsp"></jsp:include>

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
