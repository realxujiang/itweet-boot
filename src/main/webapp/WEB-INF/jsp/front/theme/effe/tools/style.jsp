<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/style/front/theme/effe";
%>
<meta charset="UTF-8" name="keywords" content="Hadoop，Openstack，Cloud，itweet.cn，ITweet，许江，HDFS，MapReduce，HBase，Hive，Zookeeper，Pig，Ambari，Sqoop">
<meta charset="UTF-8" name="description" content="ITweet技术博文，全部原创，沉淀技术，提供企业级大数据、云计算、DevOps ，Spring Boot的最佳实践教程。" />

<!--Load CSS-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/nivo-slider.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/nivo-theme.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/jquery.fancybox-1.3.4.css" />

<%--Load JS--%>
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
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?9f87ba0a79ac9ebd14bee7c28593411a";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>



