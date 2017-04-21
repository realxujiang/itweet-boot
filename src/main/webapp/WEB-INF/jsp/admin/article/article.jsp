<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Article</title>
    <jsp:include page="../../tools/style/admin_style.jsp"></jsp:include>

    <link href="<%=basePath%>style/admin/makedown/css/editormd.min.css" rel="stylesheet">
    <script src="<%=basePath%>style/admin/makedown/js/editormd.min.js"></script>

</head>
<body>

<form action="<%=basePath%>/admin/article/addContent/${form.id}" method="post">
    <input type="hidden" name="id" value="${form.id}">
    <div id="editormd-content">
        <textarea class="editormd-markdown-textarea" name="editormd-makedown-doc"></textarea>
        <textarea class="editormd-html-textarea" name="content"></textarea>
    </div>
    <input type="submit" class="btn" value="确定" />
</form>

<script>

    $(function(){
        editormd({
            id:"editormd-content",
            width:"93%",
            height  : 550,
            syncScrolling : "single",
            path: "<%=basePath%>style/admin/makedown/lib/",
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            emoji:true,
            previewTheme : "dark",
            saveHTMLToTextarea : true
        });
    });

</script>

</body>
</html>