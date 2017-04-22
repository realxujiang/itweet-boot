<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit</title>
    <jsp:include page="../../tools/style/admin_style.jsp"></jsp:include>
    <link href="<%=basePath%>style/admin/backstage/css/style.css" rel="stylesheet">

    <script>
        $(function() {
            $('#user').chosen();
        });
    </script>

</head>
<body>

<div class="formbody">
    <div id="usual1" class="usual">
        <div id="tab1" class="tabson">
            <ul class="forminfo">
                <form action="<%=basePath%>/admin/user/edit" method="post">
                    <li style="color: red;">${message}</li>
                    <input type="hidden" name="id" value="${form.id}">
                    <li><label>姓名<b>*</b></label><input name="username" type="text" class="dfinput" value="${form.username}" placeholder="用户名称" style="width:618px;" /></li>
                    <li><label>邮箱<b>*</b></label><input name="email" type="text" class="dfinput" value="${form.email}" placeholder="用户邮箱" style="width:618px;" /></li>
                    <li><label>密码<b>*</b></label><input name="password" type="text" class="dfinput" value="${form.password}" style="width:618px;" /></li>
                    <li>
                        <label>角色<b>*</b></label>
                        <select id="user" name="rIds" data-placeholder="选择角色" style="width:618px;" multiple class="chosen-select-no-results" tabindex="11">
                            <c:forEach items="${rids}" var="ids">
                                <c:forEach items="${roleList}" var="role">

                                    <c:if test="${ids eq role.id}">
                                        <option value="${role.id}" selected="true">${role.name}</option>
                                    </c:if>
                                    <c:if test="${ids ne role.id}">
                                        <option value="${role.id}">${role.name}</option>
                                    </c:if>

                                </c:forEach>
                            </c:forEach>
                        </select>
                    </li>

                    <li><label>&nbsp;</label><input type="submit" class="btn" value="确定" /></li>
                </form>
            </ul>
        </div>
    </div>
</div>

</body>
</html>