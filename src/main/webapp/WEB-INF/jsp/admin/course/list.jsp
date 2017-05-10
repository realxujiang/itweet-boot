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
                <form action="<%=basePath%>/admin/course/select" method="get">
                    <li><label>标题查询</label><input name="title" type="text" class="scinput" value="${title}" /></li>
                    <li><label>&nbsp;</label><input type="submit" class="scbtn" value="查询" /></li>
                </form>
                <li><label>&nbsp;</label><a href="<%=basePath%>/admin/course/add"><input type="button" class="scbtn" value="添加" /></a></li>
            </ul>

            <table class="imgtable">
                <thead>
                <tr>
                    <th width="60px;">编号</th>
                    <th width="100px;">封面</th>
                    <th>标题</th>
                    <th>类别</th>
                    <th>标签</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${courseList.content}" var="course">
                <tr>
                    <td>${course.id}</td>
                    <td class="imgtd"><img src="<%=basePath%>/upload/files/${course.coverPicture}" width="80" height="60"/></td>
                    <td>${course.title}</td>
                    <td>${course.classify}</td>
                    <td>${course.tag}</td>
                    <td>${course.createDate}</td>
                    <td>
                        <a href="<%=basePath%>/admin/course/edit/${course.id}" class="tablelink">修改</a>
                        <a href="<%=basePath%>/admin/course/delete/${course.id}" class="tablelink" onclick="return del()"> 删除</a>
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