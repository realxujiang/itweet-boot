<%--
  Created by IntelliJ IDEA.
  User: whoami
  Date: 05/05/2017
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String URL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<aside class="col-md-4">

    <div class="widget widget-category">
        <h3 class="widget-title" style="font-family: STXingkai">分类</h3>
        <ul>
            <c:forEach items="${categoriesList}" var="categoriesDto">
                <li>
                    <a href="<%=URL%>/blog/categories/${categoriesDto.id}">${categoriesDto.name} (${categoriesDto.count})</a>
                </li>
            </c:forEach>
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