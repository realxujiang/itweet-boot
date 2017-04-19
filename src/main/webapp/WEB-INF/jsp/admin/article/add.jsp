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
    <link href="<%=basePath%>style/admin/makedown/css/style.css" rel="stylesheet">
    <link href="<%=basePath%>style/admin/makedown/css/editormd.css" rel="stylesheet">

    <script src="<%=basePath%>style/admin/makedown/js/jquery.min.js"></script>
    <script src="<%=basePath%>style/admin/makedown/js/editormd.min.js"></script>



</head>
<body>
<div class="editormd" id="test-editormd">
    <textarea class="editormd-markdown-textarea" name="test-editormd-markdown-doc"></textarea>
    <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
    <textarea class="editormd-html-textarea" name="text"></textarea>
</div>

<script type="text/javascript">
    $(function() {
        editormd("test-editormd", {
            width: "90%",
            height: 640,
            syncScrolling: "single",
            //你的lib目录的路径，我这边用JSP做测试的
            path: "<%=basePath%>style/admin/makedown/lib/",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea: true
        });
    });
</script>
</body>
</html>