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

<%--<link href="<%=basePath%>style/admin/backstage/css/style.css" rel="stylesheet">--%>





<script src="<%=basePath%>style/admin/backstage/js/jquery.js"></script>
<script src="<%=basePath%>style/admin/backstage/js/pintuer.js"></script>
<script src="<%=basePath%>style/admin/backstage/js/toastr.min.js"></script>

<script src="<%=basePath%>/style/admin/backstage/js/amazeui.chosen.js"></script>


<script type="text/javascript">
    function del() {
        var msg = "您真的确定要删除吗？\n\n请确认！";
        if (confirm(msg)==true){
            return true;
        }else{
            return false;
        }
    }
</script>


<script type="text/javascript">
    $("#usual1 ul").idTabs();
</script>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

