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

    <link href="<%=basePath%>style/admin/makedown/css/editormd.min.css" rel="stylesheet">

    <script src="<%=basePath%>style/admin/makedown/js/jquery.min.js"></script>
    <script src="<%=basePath%>style/admin/makedown/js/editormd.min.js"></script>



</head>
<body>

<div class="formbody">
    <div id="usual1" class="usual">
        <div id="tab1" class="tabson">
            <ul class="forminfo">
                <form action="<%=basePath%>/admin/new/add" method="post">
                    <li style="color: red;">${message}</li>
                    <li><label>文章标题<b>*</b></label><input name="title" type="text" class="dfinput" value="${title}" placeholder="标题" style="width:618px;" /></li>
                    <li><label>文章标题<b>*</b></label><input name="title" type="text" class="dfinput" value="${title}" placeholder="标题" style="width:618px;" /></li>
                    <li><label>文章标题<b>*</b></label><input name="title" type="text" class="dfinput" value="${title}" placeholder="标题" style="width:618px;" /></li>
                    <li><label>图片名称<b>*</b></label><input name="picpath" type="text" class="dfinput" value="${description}" placeholder="描述" style="width:618px;" /></li>
                    <li><label>&nbsp;</label><input type="submit" class="btn" value="确定" /></li>
                </form>
            </ul>
        </div>
    </div>
</div>


</body>
</html>