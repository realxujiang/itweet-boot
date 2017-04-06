<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>

<head>
    <title>用户列表</title>
    <meta charset="utf-8">
    <link href="<%=basePath%>style/admin/backstage/css/pintuer.css" rel="stylesheet">
    <link href="<%=basePath%>style/admin/backstage/css/admin.css" rel="stylesheet">

    <script src="<%=basePath%>style/admin/backstage/js/jquery.js"></script>
    <script src="<%=basePath%>style/admin/backstage/js/pintuer.js"></script>

</head>

<body class="gray-bg">
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">用户列表</strong></div>
    <div class="padding border-bottom">
        <button type="button" class="button border-yellow" onclick="window.location.href='<%=basePath%>/admin/user/add'"><span class="icon-plus-square-o"></span> 用户添加</button>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th width="10%">编号</th>
            <th width="30%">姓名</th>
            <th width="35%">邮箱</th>
            <th width="25%">操作</th>
        </tr>

        <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>
                <div class="button-group">
                    <a class="button border-main" href="<%=basePath%>/admin/user/edit/${user.id}"><span class="icon-edit"></span> 修改</a>
                    <a class="button border-main" href="<%=basePath%>/admin/user/resetPassword/${user.id}"><span class="icon-edit"></span>重置密码</a>
                    <a class="button border-red" href="<%=basePath%>/admin/user/delete/${user.id}" onclick="return del(1,1)"><span class="icon-trash-o"></span> 删除</a>
                </div>
            </td>
        </tr>

        </c:forEach>

    </table>

    <script type="text/javascript">
        function del(id,mid){
            if(confirm("您确定要删除吗?")){

            }
        }
    </script>
</div>
</body>
</html>
