<%--
  Created by IntelliJ IDEA.
  User: whoami
  Date: 03/05/2017
  Time: 11:04
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

<body>

<%--Nav Menu--%>
<jsp:include page="tools/navbar.jsp"></jsp:include>

<div class="content-body">
    <div class="container">
        <div class="row">
            <main class="col-md-12">
                <article class="post post-1">
                    <header class="entry-header">
                        <h1 class="entry-title">
                            <a href="single.html">Adaptive Vs. Responsive Layouts And Optimal Text Readability</a>
                        </h1>
                        <div class="entry-meta">
                            <span class="post-category"><a href="#">Web Design</a></span>

                            <span class="post-date"><a href="#"><time class="entry-date" datetime="2012-11-09T23:15:57+00:00">February 2, 2013</time></a></span>

                            <span class="post-author"><a href="#">Albert Einstein</a></span>

                            <span class="comments-link"><a href="">4 Comments</a></span>
                        </div>
                    </header>
                    <div class="entry-content clearfix">
                        <p>Responsive web design offers us a way forward, finally allowing us to design for the ebb and flow of things. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don’t look even slightly.</p>
                        <div class="read-more cl-effect-14">
                            <a href="#" class="more-link">Continue reading <span class="meta-nav">→</span></a>
                        </div>
                    </div>
                </article>

                <article class="post post-2">
                    <header class="entry-header">
                        <h1 class="entry-title">
                            <a href="single.html">Adaptive Vs. Responsive Layouts And Optimal Text Readability</a>
                        </h1>
                        <div class="entry-meta">
                            <span class="post-category"><a href="#">Web Design</a></span>

                            <span class="post-date"><a href="#"><time class="entry-date" datetime="2012-11-09T23:15:57+00:00">February 2, 2013</time></a></span>

                            <span class="post-author"><a href="#">Albert Einstein</a></span>

                            <span class="comments-link"><a href="#">4 Comments</a></span>
                        </div>
                    </header>
                    <div class="entry-content clearfix">
                        <p>Responsive web design offers us a way forward, finally allowing us to design for the ebb and flow of things. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don’t look even slightly.</p>
                        <div class="read-more cl-effect-14">
                            <a href="#" class="more-link">Continue reading <span class="meta-nav">→</span></a>
                        </div>
                    </div>
                </article>

                <article class="post post-3">
                    <header class="entry-header">
                        <h1 class="entry-title">
                            <a href="single.html">Adaptive Vs. Responsive Layouts And Optimal Text Readability</a>
                        </h1>
                        <div class="entry-meta">
                            <span class="post-category"><a href="#" rel="category tag">Web Design</a></span>

                            <span class="post-date"><a href="#"><time class="entry-date" datetime="2012-11-09T23:15:57+00:00">February 2, 2013</time></a></span>

                            <span class="post-author"><a href="#">Albert Einstein</a></span>

                            <span class="comments-link"><a href="#">4 Comments</a></span>
                        </div>
                    </header>
                    <div class="entry-content clearfix">
                        <p>Responsive web design offers us a way forward, finally allowing us to design for the ebb and flow of things. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don’t look even slightly.</p>
                        <div class="read-more cl-effect-14">
                            <a href="#" class="more-link">Continue reading <span class="meta-nav">→</span></a>
                        </div>
                    </div>
                </article>

                <article class="post post-4">
                    <header class="entry-header">
                        <h1 class="entry-title">
                            <a href="single.html">Adaptive Vs. Responsive Layouts And Optimal Text Readability</a>
                        </h1>
                        <div class="entry-meta">
                            <span class="post-category"><a href="#" rel="category tag">Web Design</a></span>

                            <span class="post-date"><a href="#"><time class="entry-date" datetime="2012-11-09T23:15:57+00:00">February 2, 2013</time></a></span>

                            <span class="post-author"><a href="#">Albert Einstein</a></span>

                            <span class="comments-link"><a href="#">4 Comments</a></span>
                        </div>
                    </header>
                    <div class="entry-content clearfix">
                        <p>Responsive web design offers us a way forward, finally allowing us to design for the ebb and flow of things. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don’t look even slightly.</p>
                        <div class="read-more cl-effect-14">
                            <a href="#" class="more-link">Continue reading <span class="meta-nav">→</span></a>
                        </div>
                    </div>
                </article>
            </main>
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