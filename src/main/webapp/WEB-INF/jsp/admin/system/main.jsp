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
	<jsp:include page="../../tools/style/admin_style.jsp"></jsp:include>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><span>Itweet </span> 后台管理系统</a>
			<ul class="user-menu">
				<li class="dropdown pull-right">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Admin <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-cog"></span> 设置</a></li>
						<li><a href="<%=basePath%>admin/logout"><span class="glyphicon glyphicon-log-out"></span> 注销</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div><!-- /.container-fluid -->
</nav>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
	<form role="search">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Search">
		</div>
	</form>
	<ul class="nav menu">
		<li class="active"><a href="<%=basePath%>admin/system/body" target="main"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
		<li class="parent ">
			<a href="#sub-item-1" data-toggle="collapse">
				<span class="glyphicon glyphicon-cog"></span>
				系统管理
			</a>
			<ul class="children collapse" id="sub-item-1">
				<li>
					<a class="" href="<%=basePath%>admin/user/list" target="main">
						<span class="glyphicon glyphicon-share-alt"></span> 用户管理
					</a>
				</li>
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 角色管理
					</a>
				</li>
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 权限管理
					</a>
				</li>
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 菜单管理
					</a>
				</li>
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 系统日志
					</a>
				</li>
			</ul>
		</li>
		<li class="parent ">
			<a href="#sub-item-2" data-toggle="collapse">
				<span class="glyphicon glyphicon-book"></span>
				文章管理
			</a>
			<ul class="children collapse" id="sub-item-2">
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 发布文章
					</a>
				</li>
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 列表文章
					</a>
				</li>
			</ul>
		</li>



		<li class="parent ">
			<a href="#sub-item-3" data-toggle="collapse">
				<span class="glyphicon glyphicon-folder-open"></span>
				文件管理
			</a>
			<ul class="children collapse" id="sub-item-3">
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 文件上传
					</a>
				</li>
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 文件列表
					</a>
				</li>
			</ul>
		</li>
		<li class="parent ">
			<a href="#sub-item-4" data-toggle="collapse">
				<span class="glyphicon glyphicon-tags"></span>
				标签管理
			</a>
			<ul class="children collapse" id="sub-item-4">
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 标签列表
					</a>
				</li>
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 标签统计
					</a>
				</li>
			</ul>
		</li>
		<li class="parent ">
			<a href="#sub-item-5" data-toggle="collapse">
				<span class="glyphicon glyphicon-comment"></span>
				评论管理
			</a>
			<ul class="children collapse" id="sub-item-5">
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 评论列表
					</a>
				</li>
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 评论统计
					</a>
				</li>
			</ul>
		</li>

		<li class="parent ">
			<a href="#sub-item-6" data-toggle="collapse">
				<span class="glyphicon glyphicon-align-justify"></span>
				授权管理
			</a>
			<ul class="children collapse" id="sub-item-6">
				<li>
					<a class="" href="<%=basePath%>admin/licence/list" target="main">
						<span class="glyphicon glyphicon-share-alt"></span> Licence列表
					</a>
				</li>
				<li>
					<a class="" href="<%=basePath%>admin/licence/add" target="main">
						<span class="glyphicon glyphicon-share-alt"></span> Licence添加
					</a>
				</li>
			</ul>
		</li>

		<li role="presentation" class="divider"></li>
		<li><a href="login.html"><span class="glyphicon glyphicon-th-list"></span> 网站设置</a></li>
		<li><a href="login.html"><span class="glyphicon glyphicon-link"></span> 友情链接</a></li>
		<li><a href="login.html"><span class="glyphicon glyphicon-link"></span> 关于我们</a></li>
	</ul>

	<ul class="">
		<span>© 2017 Github, Inc.</span>
	</ul>
</div><!--/.sidebar-->

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">

	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
			<li class="active"><a href="<%=basePath%>admin/system/body" target="main">Dashboard</a></li>
		</ol>
	</div>

	<iframe src="<%=basePath%>admin/system/body" name="main" frameborder="0" scrolling="auto" style="width: 100%;height: 650px;"></iframe>
</div>
</body>

</html>