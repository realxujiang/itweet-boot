<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!--配置CSS-->
<link href="<%=basePath%>/admin/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>/admin/css/styles.css" rel="stylesheet">


<script src="<%=basePath%>/admin/js/jquery-1.11.1.min.js"></script>
<script src="<%=basePath%>/admin/js/bootstrap.min.js"></script>



