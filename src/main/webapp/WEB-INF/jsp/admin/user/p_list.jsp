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
    <jsp:include page="../../tools/style/admin_style.jsp"></jsp:include>
    <link href="<%=basePath%>style/admin/backstage/css/style.css" rel="stylesheet">

</head>
<body>
<div class="formbody">
    <div id="usual1" class="usual">
        <div id="tab2" class="tabson">
            <ul class="seachform">
                <li><label>&nbsp;</label><a href="<%=basePath%>/admin/permission/add"><input name="" type="button" class="scbtn" value="刷新资源" /></a></li>
            </ul>
            <table class="tablelist">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>上级菜单</th>
                    <th>菜单名称</th>
                    <th>链接</th>
                    <th>描述</th>
                    <%--<th>操作</th>--%>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${permissionList.content}" var="permission">
                    <tr>
                        <td>${permission.id}</td>
                        <td>${permission.pname}</td>
                        <td>${permission.name}</td>
                        <td>${permission.url}</td>
                        <td>${permission.descritpion}</td>
                       <%-- <td>
                            <a href="<%=basePath%>/admin/permission/edit/${permission.id}" class="tablelink">修改</a>
                            <a href="<%=basePath%>/admin/permission/delete/${permission.id}" class="tablelink" onclick="return del()"> 删除</a>
                        </td>--%>
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