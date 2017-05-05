<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
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
                <a href="/tweet/<fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/>/${article.title}"><img class="single_image" src="<%=URL%>/upload/files/${article.coverPicture}" width="280" height="180" alt="blog1" /></a>
                <div class="blog-item-info">
                    <div class="user">${article.author}</div>
                    <div class="comments">6 comments</div>
                    <div class="tags"><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${article.createDate}"/></div>
                </div>
                <div class="blog-item-content">
                    <a href="/tweet/<fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/>/${article.title}">
                        <h5>${article.title}</h5>
                    </a>
                    <p>${article.fullDescription}</p>
                    <a class="readmore" href="/blog/<fmt:formatDate pattern="yyyy/MM/dd" value="${article.createDate}"/>/${article.title}">阅读更多 →</a> <br />
                </div>
            </div>
        </c:forEach>

        <div id="pagination">

            <a href="<%=URL%>${pb.url}?page=1">首页</a>&emsp;

            <c:if test="${pb.currentPage > 1}">
                <a href="<%=URL%>/${pb.url}?page=${pb.currentPage-1}">上一页</a>&emsp;
            </c:if>

            <c:choose>
                <c:when test="${pb.totalPages<=10}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${pb.totalPages}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${pb.currentPage-5}"/>
                    <c:set var="end" value="${pb.currentPage+4}"/>

                    <c:if test="${begin < 1}">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="10"/>
                    </c:if>

                    <c:if test="${end > pb.totalPages}">
                        <c:set var="begin" value="${pb.totalPages-9}"/>
                        <c:set var="end" value="${pb.totalPages}"/>
                    </c:if>
                </c:otherwise>
            </c:choose>

            <c:forEach var="i" begin="${begin}" end="${end}">
                <c:choose>
                    <c:when test="${i eq pb.currentPage}">
                       <a class="active">${i}</a>&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<%=URL%>${pb.url}?page=${i}">${i}</a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${pb.currentPage < pb.totalPages}">
                &emsp;<a href="<%=URL%>${pb.url}?page=${pb.currentPage+1}">下一页</a>
            </c:if>

            &emsp;<a href="<%=URL%>${pb.url}?page=${pb.totalPages}">尾页</a>

        </div>
    </div>
    <!--END of blog section-->
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<%--<jsp:include page="tools/panel.jsp"></jsp:include>--%>

</body>
</html>