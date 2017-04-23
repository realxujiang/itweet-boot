<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>Body</title>
	<meta charset="utf-8">
	<jsp:include page="../../tools/style/admin_style.jsp"></jsp:include>
</head>
<body>

<div>
	<h1 class="col-lg-12">Dashboard</h1>
</div>

<div>
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Advanced Table</div>
			<div class="panel-body">
				测试<br/>
				测试<br/>
				测试<br/>
				测试<br/>
				测试<br/>
				测试<br/>
				测试<br/>
				测试<br/>
				测试<br/>
			</div>
		</div>
	</div>
</div>

</body>
</html>