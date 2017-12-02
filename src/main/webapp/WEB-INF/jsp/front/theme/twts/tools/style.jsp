<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/style/front/theme/twts";
%>

<!-- meta -->
<meta  charset="UTF-8" name="keywords" content="Hadoop，Openstack，Cloud，itweet.cn，ITweet，许江，HDFS，MapReduce，HBase，Hive，Zookeeper，Pig，Ambari，Sqoop">
<meta  charset="UTF-8" name="description" content="ITweet技术博文，全部原创，沉淀技术，提供企业级大数据、云计算、DevOps ，Spring Boot的最佳实践教程。" />

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
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?9f87ba0a79ac9ebd14bee7c28593411a";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>



