<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Itweet - 后台管理系统</title>

	<link href="<%=basePath%>/admin/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=basePath%>/admin/css/datepicker3.css" rel="stylesheet">
	<link href="<%=basePath%>/admin/css/styles.css" rel="stylesheet">

	<!-- 图标库地址 icon: http://holdirbootstrap.de/komponenten/ -->

	<!--[if lt IE 9]>
	<script src="<%=basePath%>/admin/js/html5shiv.js"></script>
	<script src="<%=basePath%>/admin/js/respond.min.js"></script>
	<![endif]-->

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
						<li><a href="#"><span class="glyphicon glyphicon-log-out"></span> 注销</a></li>
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
		<li class="active"><a href="index.html"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
		<li class="parent ">
			<a href="#sub-item-1" data-toggle="collapse">
				<span class="glyphicon glyphicon-cog"></span>
				系统管理
			</a>
			<ul class="children collapse" id="sub-item-1">
				<li>
					<a class="" href="#">
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
				<span class="glyphicon glyphicon-picture"></span>
				图片管理
			</a>
			<ul class="children collapse" id="sub-item-3">
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 图片上传
					</a>
				</li>
				<li>
					<a class="" href="#">
						<span class="glyphicon glyphicon-share-alt"></span> 图片列表
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
		<li role="presentation" class="divider"></li>
		<li><a href="login.html"><span class="glyphicon glyphicon-th-list"></span> 网站设置</a></li>
		<li><a href="login.html"><span class="glyphicon glyphicon-link"></span> 友情链接</a></li>
	</ul>
</div><!--/.sidebar-->

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">

	<div class="row">
		<ol class="breadcrumb">
			<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
			<li class="active">Dashboard</li>
		</ol>
	</div><!--/.row-->

	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Dashboard</h1>
		</div>
	</div><!--/.row-->

	<div>
		欢迎XXX登陆系统。
	</div>

</div>	<!--/.main-->

<script src="<%=basePath%>/admin/js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>/admin/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/admin/js/chart.min.js"></script>
<script src="<%=basePath%>/admin/js/chart-data.js"></script>
<script src="<%=basePath%>/admin/js/easypiechart.js"></script>
<script src="<%=basePath%>/admin/js/easypiechart-data.js"></script>
<script src="<%=basePath%>/admin/js/bootstrap-datepicker.js"></script>
<script>
    $('#calendar').datepicker({
    });

    !function ($) {
        $(document).on("click","ul.nav li.parent > a > span.icon", function(){
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
</body>

</html>