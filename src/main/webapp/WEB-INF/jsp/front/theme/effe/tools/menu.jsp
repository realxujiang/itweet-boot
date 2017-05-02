<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!--This is the START of the header-->
<div id="topcontrol" style="position: fixed; bottom: 5px; left: 960px; opacity: 1; cursor: pointer;" title="Go to Top"></div>
<div id="header-wrapper">
    <div id="header">
        <div id="logo">
            <a href="<%=basePath%>/"><img src="<%=basePath%>/style/front/theme/effe/images/logo.png" width="100" height="80" alt="logo" /></a>
        </div>
        <div id="header-text">
            <h4>You are already naked. There is no reason not to follow your heart!</h4>
        </div>
    </div>
</div>
<!--END of header-->

<%--<a class="selected" href="<%=basePath%>/front/theme/effe/about">About</a>--%>

<!--This is the START of the menu-->
<div id="menu-wrapper">
    <div id="main-menu">
        <ul>
            <li>
                <a class="${home}" href="<%=basePath%>/">Home →</a>
            </li>
            <li>
                <a class="${about}" href="<%=basePath%>/about">About</a>
            </li>
            <li>
                <a class="${portfolio}" href="<%=basePath%>/portfolio">Portfolio</a>
            </li>
            <li>
                <a class="${blog}" href="<%=basePath%>/blog">Blog</a>
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
        <h6>Copyright © 2017 - effe</h6>
    </div>
    <!--END of footer-->
</div>
<!--This is the End of the menu-->