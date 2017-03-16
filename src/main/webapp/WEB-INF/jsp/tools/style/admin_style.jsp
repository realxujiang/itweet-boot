<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!--配置CSS-->
<link href="<%=basePath%>style/admin/system/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>style/admin/system/css/styles.css" rel="stylesheet">


<script src="<%=basePath%>style/admin/system/js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>style/admin/system/js/bootstrap.min.js"></script>

