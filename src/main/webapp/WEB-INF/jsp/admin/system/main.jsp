<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<!-- 图标库地址 icon: http://holdirbootstrap.de/komponenten/ -->
	<title>Main</title>
	<meta charset="utf-8">
	<link href="<%=basePath%>style/admin/backstage/css/pintuer.css" rel="stylesheet">
	<link href="<%=basePath%>style/admin/backstage/css/admin.css" rel="stylesheet">

	<script src="<%=basePath%>style/admin/backstage/js/jquery.js"></script>

</head>

<body style="background-color:#f2f9fd;">
<div class="header bg-main">
	<div class="logo margin-big-left fadein-top">
		<h1><img src="<%=basePath%>style/admin/backstage/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />Itweet管理中心</h1>
	</div>
	<div class="head-l">
		<a class="button button-little bg-green" href="http://www.itweet.cn" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;
		<a class="button button-little bg-red" href="<%=basePath%>admin/logout"><span class="icon-power-off"></span> 退出登录</a>
	</div>
</div>
<div class="leftnav">
	<div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>

	<h2><span class="icon-user"></span>系统设置</h2>
	<ul style="display:block">
		<li><a href="<%=basePath%>admin/user/list" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
		<li><a href="<%=basePath%>admin/role/list" target="right"><span class="icon-caret-right"></span>角色管理</a></li>
		<li><a href="<%=basePath%>admin/permission/list" target="right"><span class="icon-caret-right"></span>资源管理</a></li>
		<li><a href="adv.html" target="right"><span class="icon-caret-right"></span>系统设置</a></li>
		<li><a href="adv.html" target="right"><span class="icon-caret-right"></span>首页轮播</a></li>
		<li><a href="adv.html" target="right"><span class="icon-caret-right"></span>系统日志</a></li>
	</ul>

	<h2><span class="icon-pencil-square-o"></span>文章管理</h2>
	<ul>
		<li><a href="<%=basePath%>admin/article/add" target="right"><span class="icon-caret-right"></span>文章发布</a></li>
		<li><a href="<%=basePath%>admin/article/list" target="right"><span class="icon-caret-right"></span>文章列表</a></li>
	</ul>

	<h2><span class="icon-file-o"></span>文件管理</h2>
	<ul>
		<li><a href="list.html" target="right"><span class="icon-caret-right"></span>文件上传</a></li>
		<li><a href="add.html" target="right"><span class="icon-caret-right"></span>文件列表</a></li>
	</ul>

	<h2><span class="icon-pencil-square-o"></span>标签管理</h2>
	<ul>
		<li><a href="<%=basePath%>admin/tag/list" target="right"><span class="icon-caret-right"></span>标签列表</a></li>
		<li><a href="<%=basePath%>admin/categories/list" target="right"><span class="icon-caret-right"></span>类别列表</a></li>
	</ul>

	<h2><span class="icon-pencil-square-o"></span>评论管理</h2>
	<ul>
		<li><a href="list.html" target="right"><span class="icon-caret-right"></span>评论列表</a></li>
		<li><a href="add.html" target="right"><span class="icon-caret-right"></span>评论统计</a></li>
	</ul>

</div>

<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
	<li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
	<li><a href="##" id="a_leader_txt">网站信息</a></li>
</ul>
<div class="admin">
	<iframe scrolling="auto" rameborder="0" src="<%=basePath%>admin/system/body" name="right" width="100%" height="100%"></iframe>
</div>

</body>
</html>