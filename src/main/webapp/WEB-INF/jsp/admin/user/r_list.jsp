<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>角色</title>
    <meta charset="utf-8">
    <link href="<%=basePath%>/style/admin/licence/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>/style/admin/licence/css/style.css?v=4.1.0" rel="stylesheet">
    <script src="<%=basePath%>/style/admin/licence/js/jquery.min.js"></script>

    <script type="text/javascript">
        function del() {
            var msg = "您真的确定要删除吗？\n\n请确认！";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        }
    </script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <span>
                <a href="<%=basePath%>/admin/role/list" target="main"><b>角色列表</b></a>&nbsp;&nbsp;
                <a href="<%=basePath%>/admin/role/add" target="main"><b>角色添加</b></a>
            </span>
        </div>

        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>描述</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${roleList}" var="role">
                    <tr>
                        <td>${role.id}</td>
                        <td>${role.name}</td>
                        <td>${role.description}</td>
                        <td>
                            <a href="<%=basePath%>/admin/role/edit/${role.id}">修改</a>
                            <a href="<%=basePath%>/admin/role/authorization/${role.id}">授权</a>
                            <a href="<%=basePath%>/admin/role/delete/${role.id}" onclick="return del()">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>

</html>
