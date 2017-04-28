<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/style/front/theme/effe";
    String URL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <title>Blog</title>
    <jsp:include page="tools/style.jsp"></jsp:include>
</head>

<body>
<!--This is the START of the header-->
<div id="topcontrol" style="position: fixed; bottom: 5px; left: 960px; opacity: 1; cursor: pointer;" title="Go to Top"></div>
<div id="header-wrapper">
    <div id="header">
        <div id="logo">
            <a href="<%=URL%>/"><img src="<%=basePath%>/images/logo.png" width="100" height="80" alt="logo" /></a>
        </div>
        <div id="header-text">
            <h4>This is our blog, check out our latest posts!</h4>
            <h6><a href="<%=URL%>/">Home</a> → Blog</h6>
        </div>
    </div>
</div>
<!--END of header-->


<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>


<!--This is the START of the content-->
<div id="content">
    <!--This is the START of the blog section-->
    <div id="blog">
        <c:forEach items="${listArticle.content}" var="article">
            <div class="blog-item">
                <a href="/blogSingle"><img class="single_image" src="<%=URL%>/upload/files/${article.coverPicture}" width="280" height="180" alt="blog1" /></a>
                <div class="blog-item-info">
                    <div class="user">${article.author}</div>
                    <div class="comments">6 comments</div>
                    <div class="tags">psd news blog post</div>
                </div>
                <div class="blog-item-content">
                    <a href="/blogSingle">
                        <h5>${article.title}</h5>
                    </a>
                    <p>${article.description}</p>
                    <a class="readmore" href="/blogSingle">阅读更多 →</a> <br />
                </div>
            </div>
        </c:forEach>

        <div id="pagination">
            <a class="active" href="#">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">...</a>
            <a href="#">→</a>
        </div>
    </div>
    <!--END of blog section-->
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<jsp:include page="tools/panel.jsp"></jsp:include>

</body>
</html>