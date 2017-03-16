<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>

<head>
    <title>表格</title>
    <meta charset="utf-8">
    <link href="<%=basePath%>/style/admin/licence/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>/style/admin/licence/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="ibox-title">
            <h5>Licence列表</h5>
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
                        <td>${licence.code}</td>
                        <td>${licence.version}</td>
                        <td>${licence.status}</td>
                        <td>
                            <a href="">删除</a>
                            <a href="">修改</a>
                            <a href="">导出</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>1</td>
                    <td>红象云腾</td>
                    <td>高峰4号</td>
                    <td>893040831@qq.com</td>
                    <td>CRH4.9</td>
                    <td>4</td>
                    <td>2017-3-14</td>
                    <td>sdfsderbtyhtntyjytuymhjky</td>
                    <td>试用版</td>
                    <td>已发送</td>
                    <td>
                        <a href="">删除</a>
                        <a href="">修改</a>
                        <a href="">导出</a>
                    </td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>红象云腾</td>
                    <td>高峰4号</td>
                    <td>893040831@qq.com</td>
                    <td>CRH4.9</td>
                    <td>4</td>
                    <td>2017-3-14</td>
                    <td>sdfsderbtyhtntyjytuymhjky</td>
                    <td>试用版</td>
                    <td>已发送</td>
                    <td>
                        <a href="">删除</a>
                        <a href="">修改</a>
                        <a href="">导出</a>
                    </td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>红象云腾</td>
                    <td>高峰4号</td>
                    <td>893040831@qq.com</td>
                    <td>CRH4.9</td>
                    <td>4</td>
                    <td>2017-3-14</td>
                    <td>sdfsderbtyhtntyjytuymhjky</td>
                    <td>试用版</td>
                    <td>已发送</td>
                    <td>
                        <a href="">删除</a>
                        <a href="">修改</a>
                        <a href="">导出</a>
                    </td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>红象云腾</td>
                    <td>高峰4号</td>
                    <td>893040831@qq.com</td>
                    <td>CRH4.9</td>
                    <td>4</td>
                    <td>2017-3-14</td>
                    <td>sdfsderbtyhtntyjytuymhjky</td>
                    <td>试用版</td>
                    <td>已发送</td>
                    <td>
                        <a href="">删除</a>
                        <a href="">修改</a>
                        <a href="">导出</a>
                    </td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>红象云腾</td>
                    <td>高峰4号</td>
                    <td>893040831@qq.com</td>
                    <td>CRH4.9</td>
                    <td>4</td>
                    <td>2017-3-14</td>
                    <td>sdfsderbtyhtntyjytuymhjky</td>
                    <td>试用版</td>
                    <td>已发送</td>
                    <td>
                        <a href="">删除</a>
                        <a href="">修改</a>
                        <a href="">导出</a>
                    </td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>红象云腾</td>
                    <td>高峰4号</td>
                    <td>893040831@qq.com</td>
                    <td>CRH4.9</td>
                    <td>4</td>
                    <td>2017-3-14</td>
                    <td>sdfsderbtyhtntyjytuymhjky</td>
                    <td>试用版</td>
                    <td>已发送</td>
                    <td>
                        <a href="">删除</a>
                        <a href="">修改</a>
                        <a href="">导出</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

    </div>

</div>
</body>

</html>
