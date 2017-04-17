<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>

<head>
    <title>资源列表</title>
    <jsp:include page="../../tools/style/admin_style.jsp"></jsp:include>

</head>

<body class="gray-bg">
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">资源列表</strong></div>
    <div class="padding border-bottom">
        <button type="button" class="button border-main" onclick="window.location.href='<%=basePath%>/admin/role/add'"><span class="icon-plus-square-o"></span> 资源添加</button>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th width="10%">编号</th>
            <th width="10%">上级菜单名称</th>
            <th width="10%">菜单名称</th>
            <th width="20%">链接</th>
            <th width="25%">描述</th>
            <th width="25%">操作</th>
        </tr>

        <c:forEach items="${permissionList.content}" var="permission">
        <tr>
            <td>${permission.id}</td>
            <td>${permission.pname}</td>
            <td>${permission.name}</td>
            <td>${permission.url}</td>
            <td>${permission.descritpion}</td>
            <td>
                <div class="button-group">
                    <a class="button border-main" href="<%=basePath%>/admin/permission/edit/${permission.id}"><span class="icon-edit"></span> 修改</a>
                    <a class="button border-yellow" href="<%=basePath%>/admin/permission/reset/${permission.id}"><span class="icon-edit"></span>重置资源</a>
                    <a class="button border-red" href="<%=basePath%>/admin/permission/delete/${permission.id}" onclick="return del(1,1)"><span class="icon-trash-o"></span> 删除</a>
                </div>
            </td>
        </tr>

        </c:forEach>
        <tr>
            <td colspan="8">
                <div class="pagelist">
                    <a href="">上一页</a> <span class="current">1</span>
                    <a href="">2</a>
                    <a href="">3</a>
                    <a href="">下一页</a>
                    <a href="">尾页</a>
                </div>
            </td>
        </tr>
    </table>

    <script type="text/javascript">
        function del(id,mid){
            if(confirm("您确定要删除吗?")){}
        }
    </script>
</div>
</body>
</html>
