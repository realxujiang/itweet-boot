<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>


<!--This is the START of the content-->
<div id="content">
    <!--This is the START of the blog section-->
    <div id="blog">
        <c:forEach items="${listArticle.content}" var="article">
            <div class="blog-item">
                <a href="/blog/<fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/>/${article.title}"><img class="single_image" src="<%=URL%>/upload/files/${article.coverPicture}" width="280" height="180" alt="blog1" /></a>
                <div class="blog-item-info">
                    <div class="user">${article.author}</div>
                    <div class="comments">6 comments</div>
                    <div class="tags"><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${article.createDate}"/></div>
                </div>
                <div class="blog-item-content">
                    <a href="/blog/<fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/>/${article.title}">
                        <h5>${article.title}</h5>
                    </a>
                    <p>${article.fullDescription}</p>
                    <a class="readmore" href="/blog/<fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/>/${article.title}">阅读更多 →</a> <br />
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
<%--<jsp:include page="tools/panel.jsp"></jsp:include>--%>

</body>
</html>