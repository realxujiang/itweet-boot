<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!--配置CSS-->
<meta charset="utf-8">
<link href="<%=basePath%>style/admin/backstage/css/pintuer.css" rel="stylesheet">
<link href="<%=basePath%>style/admin/backstage/css/admin.css" rel="stylesheet">
<link href="<%=basePath%>style/admin/backstage/css/toastr.min.css" rel="stylesheet">

<link href="<%=basePath%>/style/admin/backstage/css/amazeui.chosen.css" rel="stylesheet">
<link href="<%=basePath%>/style/admin/backstage/css/amazeui.min.css" rel="stylesheet">

<link href="<%=basePath%>style/admin/backstage/css/style.css" rel="stylesheet">





<script src="<%=basePath%>style/admin/backstage/js/jquery.js"></script>
<script src="<%=basePath%>style/admin/backstage/js/pintuer.js"></script>
<script src="<%=basePath%>style/admin/backstage/js/toastr.min.js"></script>

<script src="<%=basePath%>/style/admin/backstage/js/amazeui.chosen.js"></script>

