<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>

<head>
    <title>角色添加</title>
    <meta charset="utf-8">
    <link href="<%=basePath%>style/admin/backstage/css/pintuer.css" rel="stylesheet">
    <link href="<%=basePath%>style/admin/backstage/css/admin.css" rel="stylesheet">
    <link href="<%=basePath%>style/admin/backstage/css/toastr.min.css" rel="stylesheet">

    <script src="<%=basePath%>style/admin/backstage/js/jquery.js"></script>
    <script src="<%=basePath%>style/admin/backstage/js/pintuer.js"></script>
    <script src="<%=basePath%>style/admin/backstage/js/toastr.min.js"></script>

</head>

<body>
<script>
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "progressBar": true,
        "positionClass": "toast-top-right",
        "showDuration": "400",
        "hideDuration": "1000",
        "timeOut": "7000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }
    ${message}
</script>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加角色</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=basePath%>/admin/role/add">

            <div class="form-group">
                <div class="label">
                    <label>名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="name" data-validate="required:请输入角色名称" value="${form.name}"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>描述：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="description" data-validate="required:请输入角色描述" value="${form.description}" />
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