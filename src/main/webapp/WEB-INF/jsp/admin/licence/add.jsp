<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Licence_Add</title>
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>添加授权</h5>
                </div>
                <div class="ibox-content">
                    <form method="get" class="form-horizontal">

                        <div class="form-group">
                            <label class="col-sm-2 control-label">公司</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control">
                                <span class="help-block m-b-none">申请授权的公司</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">项目</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control">
                                <span class="help-block m-b-none">申请授权的项目</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="password">
                                <span class="help-block m-b-none">接收授权码的邮箱</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">所属产品</label>
                            <div class="col-sm-10">
                                <select class="form-control m-b" name="account">
                                    <option>CRH4.9</option>
                                    <option>CRH5.0</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">节点</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="password">
                                <span class="help-block m-b-none">申请授权节点数</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">版式</label>
                            <div class="col-sm-10">
                                <select class="form-control m-b" name="account">
                                    <option>试用版</option>
                                    <option>正式版</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">单选框
                            </label>
                            <div class="col-sm-10">
                                <div class="radio">
                                    <label>
                                        <input type="radio" checked="" value="option1" id="optionsRadios1" name="optionsRadios">选项1</label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" value="option2" id="optionsRadios2" name="optionsRadios">选项2</label>
                                </div>
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
</div>
</body>

</html>