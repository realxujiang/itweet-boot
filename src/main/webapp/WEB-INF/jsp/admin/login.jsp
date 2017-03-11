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
<title>Itweet backstage management system</title>
<link href="<%=basePath%>/admin/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>/admin/css/datepicker3.css" rel="stylesheet">
<link href="<%=basePath%>/admin/css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="<%=basePath%>/admin/static/js/html5shiv.js"></script>
<script src="<%=basePath%>/admin/static/js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Log in</div>
				<div class="panel-body">
					<form role="form" action="/admin/login" method="post">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Username" name="username" type="text" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password" name="password" type="password" value="">
							</div>
							<div class="checkbox">
								<label>
									<input name="remember" type="checkbox" value="Remember Me">Remember Me
								</label>
							</div>
							<input type="submit" class="btn btn-primary" value="Login"/>
							<c:if test="${param.error ne null}">
								<div class="alert-danger">Invalid username and password.</div>
							</c:if>
						</fieldset>
						<input type="hidden" name="${_csrf.parameterName}"
							   value="${_csrf.token}" />
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	
	<script>

	</script>
</body>

</html>
