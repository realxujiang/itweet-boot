<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String URL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
    <title>BlogSingle</title>
    <jsp:include page="tools/style.jsp"></jsp:include>
    <style>
        .blog-item-single-content img {
            width: 100%;
        }
    </style>
    <script type="text/javascript">
        (function(){
            var appid = 'cyt1SoANh';
            var conf = 'prod_f1122db7ae1d42036c646ea61c3ae363';
            var width = window.innerWidth || document.documentElement.clientWidth;
            if (width < 960) {
                window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("https://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })();
    </script>
</head>

<body>

<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>


<!--This is the START of the content-->
<div id="content">
    <!--This is the START of the blog section-->
    <div id="blog">
        <div class="blog-item-single">

            <h3>${article.title}</h3>
            <div class="blog-item-single-info">
                <div class="user">${article.author}</div>
                <div class="comments">6 comments</div>
                <div class="tags">${tagsList}</div>
            </div>

            <div class="blog-item-single-content">
                <div class="blog-item-single-content"> <a class="single_image" href="<%=URL%>/upload/files/${article.coverPicture}"><img src="<%=URL%>/upload/files/${article.coverPicture}" width="720" height="280" alt="blog1" /></a>
                    ${article.htmlContent}
                </div>
            </div>

            <!--PC和WAP自适应版-->
            <div id="SOHUCS" sid="${article.id}"></div>

        </div>
    </div>
    <!--END of blog section-->
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<%--<jsp:include page="tools/panel.jsp"></jsp:include>--%>

</div>
</body>

</html>