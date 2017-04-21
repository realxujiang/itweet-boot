<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>List</title>
    <meta charset="utf-8">
    <link href="<%=basePath%>style/admin/backstage/css/style.css" rel="stylesheet">
    <script src="<%=basePath%>style/admin/backstage/js/jquery.js"></script>

    <script type="text/javascript">
        KE.show({
            id: 'content7',
            cssPath: './index.css'
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width: 345
            });
            $(".select2").uedSelect({
                width: 167
            });
            $(".select3").uedSelect({
                width: 100
            });
        });
        function del() {
            var msg = "您真的确定要删除吗？\n\n请确认！";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        }
    </script>
</head>
<body>
<div class="formbody">
    <div id="usual1" class="usual">
        <div id="tab2" class="tabson">
            <ul class="seachform">
                <form action="<%=basePath%>/admin/tag/select" method="post">
                    <li><label>名称查询</label><input name="name" type="text" class="scinput" value="${title}" /></li>
                    <li><label>&nbsp;</label><input type="submit" class="scbtn" value="查询" /></li>
                </form>
                <li><label>&nbsp;</label><a href="<%=basePath%>/admin/tag/add"><input name="" type="button" class="scbtn" value="添加标签" /></a></li>
            </ul>
            <table class="tablelist">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>标签名称</th>
                    <th>添加时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${tagList.content}" var="tag">
                    <tr>
                        <td>${tag.id}</td>
                        <td>${tag.name}</td>
                        <td>${tag.date}</td>
                        <td>
                            <a href="<%=basePath%>/admin/tag/edit/${tag.name}" class="tablelink">修改</a>
                            <a href="<%=basePath%>/admin/tag/delete/${tag.id}" class="tablelink" onclick="return del()"> 删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <jsp:include page="../../tools/page/page2.jsp"></jsp:include>
        </div>
    </div>
    <script type="text/javascript">
        $("#usual1 ul").idTabs();
    </script>
    <script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
    </script>
</div>
</body>
</html>