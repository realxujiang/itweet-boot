<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/style/front/theme/effe";
%>

<!--配置CSS-->
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/nivo-slider.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/nivo-theme.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/jquery.fancybox-1.3.4.css" />

<script type="text/javascript" src="<%=basePath%>/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/panelslide.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/custom.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/scrolltopcontrol.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.quicksand.js" ></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/nivo-options.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.easing-1.3.pack.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.mousewheel-3.0.4.pack.js"></script>



