<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>List</title>
    <jsp:include page="../../tools/style/admin_common.jsp"></jsp:include>
    <jsp:include page="../../tools/style/admin_style.jsp"></jsp:include>
    <link href="<%=basePath%>style/admin/backstage/css/style.css" rel="stylesheet">

</head>
<body>
<div class="rightinfo">
    <div id="usual1" class="usual">
        <div id="tab2" class="tabson">
            <ul class="seachform">
                <form action="<%=basePath%>/admin/article/select" method="get">
                    <li><label>标题查询</label><input name="title" type="text" class="scinput" value="${title}" /></li>
                    <li><label>&nbsp;</label><input type="submit" class="scbtn" value="查询" /></li>
                </form>
                <li><label>&nbsp;</label><a href="<%=basePath%>/admin/article/add"><input type="button" class="scbtn" value="发布文章" /></a></li>
            </ul>

            <table class="imgtable">

                <thead>
                <tr>
                    <th width="60px;">编号</th>
                    <th width="100px;">缩略图</th>
                    <th>标题</th>
                    <th>作者</th>
                    <th>创建时间</th>
                    <th>修改时间</th>
                    <th>描述</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${articleList.content}" var="article">
                <tr>
                    <td>${article.id}</td>
                    <td class="imgtd"><img src="<%=basePath%>/upload/files/${article.coverPicture}" width="80" height="60"/></td>
                    <td>${article.title}</td>
                    <td>${article.author}</td>
                    <td>${article.createDate}</td>
                    <td>${article.updateDate}</td>
                    <td>${article.description}</td>
                    <td>
                        <a href="<%=basePath%>/admin/article/addContent/${article.id}" class="tablelink">编辑正文</a>
                        <a href="<%=basePath%>/admin/article/view/${article.id}" target="right" class="tablelink">预览</a>
                        <a href="<%=basePath%>/admin/article/edit/${article.id}" class="tablelink">修改</a>
                        <a href="<%=basePath%>/admin/article/delete/${article.id}" class="tablelink" onclick="return del()"> 删除</a>
                        <c:if test="${article.state eq 1}"><a href="<%=basePath%>/admin/article/cancelRelease/${article.id}" class="tablelink">取消发布</a></c:if>
                        <c:if test="${article.state eq 0}"><a href="<%=basePath%>/admin/article/release/${article.id}" class="tablelink">发布</a></c:if>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <jsp:include page="../../tools/page/page2.jsp"></jsp:include>
        </div>
    </div>

</div>
</body>
</html>