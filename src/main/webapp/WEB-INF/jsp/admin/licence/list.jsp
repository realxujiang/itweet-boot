<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html>
<html>

<head>
    <title>表格</title>
    <meta charset="utf-8">
    <link href="<%=basePath%>/style/admin/licence/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>/style/admin/licence/css/style.css?v=4.1.0" rel="stylesheet">
    <script src="<%=basePath%>/style/admin/licence/js/jquery.min.js"></script>
    <style>

        .code{
            max-width: 100px;
            display:block;
            word-break:keep-all;
            white-space: nowrap;
            text-overflow: ellipsis;
            overflow: hidden;
            border: none;
        }

    </style>
    <script type="text/javascript">
        function del() {
            var msg = "您真的确定要删除吗？\n\n请确认！";
            if (confirm(msg)==true){
                return true;
            }else{
                return false;
            }
        }
        $(document).ready(function(){
            $("#sub").click(function(){
                var companyName = $("#companyName").val();
                if(companyName != ""){
                    $("#form").submit
                }
            });
        });

    </script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h4>Licence列表</h4>
        </div>
        <div>
            <div style="float: left;margin-top:8px;margin-bottom: 5px;">
                <span style="margin: 5px 10px;">授权记录共有: &nbsp;<b style="color: red;">${licenceNumber}</b>&nbsp;条</span>
            </div>

            <div style="margin-top:8px;margin-bottom: 5px;float: right;">
                <form id="form" action="<%=basePath%>/admin/licence/select" method="POST">
                    <span>公司查询:<input type="text" name="companyName" style="width: 100px;" value="${companyName}">
                        <button id="sub">查询</button>
                    </span>
                </form>
            </div>
        </div>

        <div class="ibox-content">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>公司</th>
                    <th>项目</th>
                    <th>邮箱</th>
                    <th>所属产品</th>
                    <th>节点数</th>
                    <th>时间</th>
                    <th>授权码</th>
                    <th>版式</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="licence">
                    <tr>
                        <td>${licence.id}</td>
                        <td>${licence.company}</td>
                        <td>${licence.project}</td>
                        <td>${licence.email}</td>
                        <td>${licence.products}</td>
                        <td>${licence.node}</td>
                        <td>${licence.date}</td>
                        <td ><span class="code">${licence.code}</span></td>
                        <c:if test="${licence.version==0}"><td>试用版</td></c:if>
                        <c:if test="${licence.version==1}"><td>正式版</td></c:if>
                        <c:if test="${licence.status==0}"><td><a href="#">点击发送</a></td></c:if>
                        <c:if test="${licence.status==1}"><td>邮件已发送</td></c:if>
                        <td>
                            <a href="<%=basePath%>/admin/licence/delete/${licence.id}" onclick="return del()">删除</a>
                            <a href="<%=basePath%>/admin/licence/edit/${licence.id}">修改</a>
                            <a href="<%=basePath%>/admin/licence/export/${licence.id}">导出</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>

</html>
