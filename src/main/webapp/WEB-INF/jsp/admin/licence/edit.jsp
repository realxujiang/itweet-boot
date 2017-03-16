<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Licence_Edit</title>
    <link href="<%=basePath%>/style/admin/licence/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>/style/admin/licence/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>修改授权</h5>
            </div>
            <div class="ibox-content">
                <div style="text-align: center;color: red;margin-bottom: 10px;">
                    ${errorMessage}
                </div>
                <form action="<%=basePath%>/admin/licence/edit" class="form-horizontal" method="POST">
                    <input type="hidden" name="id" value="${form.id}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">公司</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="company" value="${form.company}">
                            <span class="help-block m-b-none">申请授权的公司&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">项目</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="project" value="${form.project}">
                            <span class="help-block m-b-none">申请授权的项目&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="email" value="${form.email}">
                            <span class="help-block m-b-none">接收授权码的邮箱&nbsp;&nbsp;<b style="color: red;">*</b></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">所属产品</label>
                        <div class="col-sm-10">
                            <select class="form-control m-b" name="products">
                                <option value="CRH4.9" <c:if test="${form.products =='CRH4.9'}">selected</c:if>>CRH4.9</option>
                                <option value="CRH5.0" <c:if test="${form.products =='CRH5.0'}">selected</c:if>>CRH5.0</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">节点</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="node" value="${form.node}">
                            <span class="help-block m-b-none">申请授权节点数</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">版式</label>
                        <div class="col-sm-10">
                            <select class="form-control m-b" name="version">
                                <option value="0" <c:if test="${form.version ==0}">selected</c:if>>试用版</option>
                                <option value="1" <c:if test="${form.version ==1}">selected</c:if>>正式版</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-2">
                            <button class="btn btn-primary" type="submit">保存内容</button>
                            <button class="btn btn-white" type="submit">取消</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>