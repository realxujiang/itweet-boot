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

    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- css -->
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/css/ionicons.min.css">
    <link rel="stylesheet" href="<%=basePath%>/css/pace.css">
    <link rel="stylesheet" href="<%=basePath%>/css/custom.css">

    <!-- js -->
    <script src="<%=basePath%>/js/jquery-2.1.3.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/js/pace.min.js"></script>
    <script src="<%=basePath%>/js/modernizr.custom.js"></script>
    <style>
        img {
            width: 720px;
        }
    </style>
</head>

<body id="single">
<div class="container">
    <header id="site-header">
        <div class="row">
            <div class="col-md-4 col-sm-5 col-xs-8">
                <div class="logo">
                    <h1><a href="/"><b>Itweet</b> &amp; Boot</a></h1>
                </div>
            </div><!-- col-md-4 -->
            <div class="col-md-8 col-sm-7 col-xs-4">
                <nav class="main-nav" role="navigation">
                    <div class="navbar-header">
                        <button type="button" id="trigger-overlay" class="navbar-toggle">
                            <span class="ion-navicon"></span>
                        </button>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="cl-effect-11"><a href="/" data-hover="Home">Home</a></li>
                            <li class="cl-effect-11"><a href="/blog" data-hover="Blog">Blog</a></li>
                            <li class="cl-effect-11"><a href="/about" data-hover="About">About</a></li>
                            <li class="cl-effect-11"><a href="/contact" data-hover="Contact">Contact</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </nav>
                <div id="header-search-box">
                    <a id="search-menu" href="#"><span id="search-icon" class="ion-ios-search-strong"></span></a>
                    <div id="search-form" class="search-form">
                        <form role="search" method="get" id="searchform" action="#">
                            <input type="search" placeholder="Search" required>
                            <button type="submit"><span class="ion-ios-search-strong"></span></button>
                        </form>
                    </div>
                </div>
            </div><!-- col-md-8 -->
        </div>
    </header>
</div>

<div class="content-body">
    <div class="container">
        <div class="row">
            <main class="col-md-8">
                <article class="post post-1">
                    <header class="entry-header">
                        <h1 class="entry-title">${article.title}</h1>
                        <div class="entry-meta">
                            <span class="post-category"><a href="#">${tagsList}</a></span>

                            <span class="post-date"><a href="#"><time class="entry-date" datetime="2012-11-09T23:15:57+00:00">${article.createDate}</time></a></span>

                            <span class="post-author"><a href="#">${article.author}</a></span>

                            <span class="comments-link"><a href="#">4 Comments</a></span>
                        </div>
                    </header>
                    <div class="entry-content clearfix">
                        ${article.htmlContent}
                    </div>
                </article>
            </main>
            <aside class="col-md-4">
                <div class="widget widget-recent-posts">
                    <h3 class="widget-title">Recent Posts</h3>
                    <ul>
                        <li>
                            <a href="#">Adaptive Vs. Responsive Layouts And Optimal Text Readability</a>
                        </li>
                        <li>
                            <a href="#">Web Design is 95% Typography</a>
                        </li>
                        <li>
                            <a href="#">Paper by FiftyThree</a>
                        </li>
                    </ul>
                </div>
                <div class="widget widget-archives">
                    <h3 class="widget-title">Archives</h3>
                    <ul>
                        <li>
                            <a href="#">November 2014</a>
                        </li>
                        <li>
                            <a href="#">September 2014</a>
                        </li>
                        <li>
                            <a href="#">January 2013</a>
                        </li>
                    </ul>
                </div>

                <div class="widget widget-category">
                    <h3 class="widget-title">Category</h3>
                    <ul>
                        <li>
                            <a href="#">Web Design</a>
                        </li>
                        <li>
                            <a href="#">Web Development</a>
                        </li>
                        <li>
                            <a href="#">SEO</a>
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
                <p class="copyright">&copy; 2019 itweet.cn</p>
            </div>
        </div>
    </div>
</footer>

<!-- Mobile Menu -->
<div class="overlay overlay-hugeinc">
    <button type="button" class="overlay-close"><span class="ion-ios-close-empty"></span></button>
    <nav>
        <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="full-width.html">Blog</a></li>
            <li><a href="about.html">About</a></li>
            <li><a href="contact.html">Contact</a></li>
        </ul>
    </nav>
</div>

<script src="<%=basePath%>/js/script.js"></script>

</body>
</html>
