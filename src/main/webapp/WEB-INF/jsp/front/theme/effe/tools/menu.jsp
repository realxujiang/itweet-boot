<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<%--<a class="selected" href="<%=basePath%>/front/theme/effe/about">About</a>--%>

<div id="menu-wrapper">
    <div id="main-menu">
        <ul>
            <li>
                <a class="${home}" href="<%=basePath%>/">Home</a>
            </li>
            <li>
                <a class="${about}" href="<%=basePath%>/about">About</a>
            </li>
            <li>
                <a class="${portfolio}" href="<%=basePath%>/portfolio">Portfolio</a>
            </li>
            <li>
                <a class="${blog}" href="<%=basePath%>/blogArticle">Blog</a>
            </li>
            <li>
                <a class="${contact}" href="<%=basePath%>/contact">Contact</a>
            </li>
            <li>
                <a class="${features}" href="<%=basePath%>/features">Features</a>
            </li>
        </ul>
    </div>
    <!--This is the START of the footer-->
    <div id="footer">
        <div id="social-box">
            <ul>
                <li>
                    <div class="facebook">
                        <a href="#"></a>
                    </div>
                </li>
                <li>
                    <div class="twitter">
                        <a href="#"></a>
                    </div>
                </li>
                <li>
                    <div class="rss">
                        <a href="#"></a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <!--END of footer-->
</div>
