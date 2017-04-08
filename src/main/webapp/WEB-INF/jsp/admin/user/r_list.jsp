<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>

<head>
    <title>角色列表</title>
    <jsp:include page="../../tools/style/admin_style.jsp"></jsp:include>

</head>

<body class="gray-bg">
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">角色列表</strong></div>
    <div class="padding border-bottom">
        <button type="button" class="button border-main" onclick="window.location.href='<%=basePath%>/admin/role/add'"><span class="icon-plus-square-o"></span> 角色添加</button>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th width="10%">编号</th>
            <th width="30%">名称</th>
            <th width="35%">描述</th>
            <th width="25%">操作</th>
        </tr>

        <c:forEach items="${roleList}" var="role">
        <tr>
            <td>${role.id}</td>
            <td>${role.name}</td>
            <td>${role.description}</td>
            <td>
                <div class="button-group">
                    <a class="button border-main" href="<%=basePath%>/admin/role/edit/${role.id}"><span class="icon-edit"></span> 修改</a>
                    <a class="button border-yellow" href="<%=basePath%>/admin/role/authorization/${role.id}"><span class="icon-edit"></span>授权</a>
                    <a class="button border-red" href="<%=basePath%>/admin/role/delete/${role.id}" onclick="return del(1,1)"><span class="icon-trash-o"></span> 删除</a>
                </div>
            </td>
        </tr>

        </c:forEach>

    </table>

    <script type="text/javascript">
        function del(id,mid){
            if(confirm("您确定要删除吗?")){}
        }
    </script>
</div>
</body>
</html>
