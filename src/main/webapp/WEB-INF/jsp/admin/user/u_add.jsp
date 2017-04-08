<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>

<head>
    <title>用户添加</title>
    <jsp:include page="../../tools/style/admin_style.jsp"></jsp:include>
    <script>
        $(function() {
            $('#my-select').chosen();
        });
    </script>
</head>

<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加用户</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=basePath%>/admin/user/add">
            <div class="form-group">
                <div class="label">
                    <label>用户名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="username" data-validate="required:请输入用户名" value="${form.username}"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>邮箱：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="email" data-validate="required:请输入邮箱" value="${form.email}" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>密码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50"  name="password" value="123456" disabled="disabled" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>角色：</label>
                </div>
                <div class="field">
                    <select name="rIds" id="my-select" multiple="multiple" data-placeholder="选定角色" multiple class="chosen-select-width" style="width: 212px;" tabindex="18">
                        <c:forEach items="${roleList}" var="role">
                            <option value="${role.id}">${role.name}</option>
                        </c:forEach>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body></html>