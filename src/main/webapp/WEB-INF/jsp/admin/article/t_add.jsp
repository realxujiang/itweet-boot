<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Add</title>
    <meta charset="utf-8">

    <link href="<%=basePath%>style/admin/backstage/css/style.css" rel="stylesheet">

</head>
<body>

<div class="formbody">
    <div id="usual1" class="usual">
        <div id="tab1" class="tabson">
            <ul class="forminfo">
                <form action="<%=basePath%>/admin/tag/add" method="post">
                    <li style="color: red;">${message}</li>
                    <li><label>标签名称<b>*</b></label><input name="name" type="text" class="dfinput" value="${form.name}" placeholder="名称" style="width:618px;" /></li>
                    <li><label>&nbsp;</label><input type="submit" class="btn" value="确定" /></li>
                </form>
            </ul>
        </div>
    </div>
</div>


</body>
</html>