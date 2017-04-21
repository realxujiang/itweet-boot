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
    <jsp:include page="../../tools/style/admin_style.jsp"></jsp:include>
    <link href="<%=basePath%>style/admin/backstage/css/style.css" rel="stylesheet">

</head>
<body>

<div class="formbody">
    <div id="usual1" class="usual">
        <div id="tab1" class="tabson">
            <ul class="forminfo">
                <form action="<%=basePath%>/admin/article/add" method="post">
                    <li style="color: red;">${message}</li>
                    <li><label>文章标题<b>*</b></label><input name="title" type="text" class="dfinput" value="${form.title}" placeholder="标题" style="width:618px;" /></li>
                    <li><label>文章描述<b>*</b></label><input name="description" type="text" class="dfinput" value="${form.description}" placeholder="描述" style="width:618px;" /></li>
                    <li><label>类别<b>*</b></label><input name="title" type="text" class="dfinput" value="${title}" placeholder="标题" style="width:618px;" /></li>
                    <li><label>标签<b>*</b></label><input name="picpath" type="text" class="dfinput" value="${description}" placeholder="描述" style="width:618px;" /></li>
                    <li><label>&nbsp;</label><input type="submit" class="btn" value="确定" /></li>
                </form>
            </ul>
        </div>
    </div>
</div>


</body>
</html>