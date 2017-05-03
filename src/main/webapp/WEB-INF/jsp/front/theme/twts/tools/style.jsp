<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/style/front/theme/twts";
%>

<!-- meta -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- css -->
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>/css/ionicons.min.css">
<link rel="stylesheet" href="<%=basePath%>/css/pace.css">
<link rel="stylesheet" href="<%=basePath%>/css/custom.css">

<!-- js -->
<script src="<%=basePath%>/js/jquery-2.1.3.min.js"></script>
<script src="<%=basePath%>/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/js/pace.min.js"></script>
<script src="<%=basePath%>/js/modernizr.custom.js"></script>



