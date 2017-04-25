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

    <script>
        $(function() {
            $('#columnd').chosen({
                no_results_text: '木有找到匹配的项！'
            });
        });
    </script>

    <style>
        .a-upload {
            padding: 5px 15px;
            height: 32px;
            line-height: 20px;
            position: relative;
            cursor: pointer;
            color: #888;
            background: #fafafa;
            border: 1px solid #ddd;

            overflow: hidden;
            display: inline-block;
            *display: inline;
            *zoom: 1
        }

        .a-upload  input {
            position: absolute;
            font-size: 100px;
            right: 0;
            top: 0;
            opacity: 0;
            filter: alpha(opacity=0);
            cursor: pointer
        }

        .a-upload:hover {
            color: #444;
            background: #eee;
            border-color: #ccc;
            text-decoration: none
        }
    </style>

</head>
<body>

<div class="formbody">
    <div id="usual1" class="usual">
        <div id="tab1" class="tabson">
            <ul class="forminfo">
                <form action="<%=basePath%>/admin/document/add" enctype="multipart/form-data" method="post">
                    <li style="color: red;">${message}</li>
                    <li>
                        <label>所属栏目<b>*</b></label>
                        <select id="columnd" name="columnd" style="width:160px;border-radius: 5px;" class="chosen-select-no-results" tabindex="10">
                            <option value="cover" selected="selected">封面</option>
                            <option value="article">文章</option>
                            <option value="index">首页</option>
                        </select>


                        <%--<input name="columnName" type="text" class="dfinput" value="${columnName}" placeholder="栏目名称" style="width:160px;border-radius: 5px;" />--%>
                    </li>
                    <li>
                        <label>上传文件<b>*</b></label>
                        <span class="a-upload"><input name="file" type="file" />点击这里上传文件</span>
                    </li>

                    <li><label>&nbsp;</label><input type="submit" class="btn" value="确定" /></li>
                </form>
            </ul>
        </div>
    </div>
</div>


</body>
</html>