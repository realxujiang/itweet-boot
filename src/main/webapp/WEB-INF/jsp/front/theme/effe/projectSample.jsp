<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/style/front/theme/effe";
    String URL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>

<head>
    <title>Project-Sample</title>
    <jsp:include page="tools/style.jsp"></jsp:include>
</head>

<body>


<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>


<!--This is the START of the content-->
<div id="content">
    <!--This is the START of the NIVO slider-->
    <div class="slider-wrapper theme-effe">
        <div id="slider" class="nivoSlider"> <img src="<%=basePath%>/images/sample-project/slider/slide1.jpg" alt="" title="#img1" /> <img src="<%=basePath%>/images/sample-project/slider/slide2.jpg" alt="" title="#img2" /> </div>
        <div id="slider-shadow"></div>
    </div>
    <!--END of NIVO Slider-->
    <!--This is the START of the project-->
    <div class="project">
        <div id="description">
            <h3>Hadoop企业级实战应用案例探究</h3>
            <p>录制视频是因为,Hadoop十周年庆自己写了两篇文章,没想到收到大量关注,在大数据日报，头条推荐栏目，所以打算录制一套Hadoop企业级应用公益性质教程,本内容重在和大家一起探究Hadoop企业级应用案例,请勿用于任何商业用途。 内容涉及Hadoop基础的Linux系统优化,Hadoop存储规划,集群规模评估，从零开始构建企业级大数据平台，以及技术选型，集群构建的思考，集群资源分配;SQL-on-Hadoop企业级解决方案，TPC性能测试，SQL-on-Hadoop性能优化案例，集群性能优化以及各种调优参数，一切看上去都那么美好，还有各种大坑，哈哈，精彩内容请移步后面课程目录预览，百度云干货.
                PS: 由于本人水平有限，内容难免错漏，还望见谅。</p>
            <p>@群讨论 : 457710636</p>

            <p>第一季 SQL-on-Hadoop</p>

            <p>教程目录：
                D:\ENTERPRISE_HADOOP_SOLUTIONS
                ├─0、Hadoop企业级应用实战之Centos安装&&Hadoop存储规划
                ├─1、Hadoop企业级应用实战之Apache-Hadoop介绍
                ├─2、Hadoop企业级应用实战之Hadoop前世今生
                ├─3、Hadoop企业级应用实战之动物园管理员zookeeper
                ├─4、Hadoop企业级应用实战之Hadoop集群构建思考_CDH集群构建
                ├─5、Hadoop企业级实战之集群资源分配和进阶使用&&HDP集群构建(new)
                ├─6、Hadoop企业级应用实战之SQL-on-Hadoop
                │  ├─Drill
                │  ├─Hbase-phoenix
                │  ├─Hive
                │  │  └─tez
                │  ├─Impala
                │  ├─presto
                │  ├─sparksql
                │  └─Tez
                └─大数据十周年纪念日
            </p>
            <p>百度云：链接：http://pan.baidu.com/s/1dDnpT6p 密码：rg03</p>

            <p>课程PPT：https://github.com/itweet/course</p>
            <p>土 豆：http://www.tudou.com/home/sparkjvm/</p>
        </div>
        <ul id="work">
            <li>第一季 SQL-on-Hadoop</li>
            <li>This is the second item</li>
            <li>This is the third item</li>
            <li>This is the fourth item</li>
        </ul>
    </div>
    <!--END of project-->
    <!--This is the START of the gallery-->
    <div class="spacer"></div>
    <div class="project-summary">
        <div class="one-third">
            <a class="single_image" rel="gallery1" href="<%=basePath%>/images/sample-project/large/project1.jpg"><img src="<%=basePath%>/images/sample-project/thumbs/project1.jpg" width="220" height="132" alt="sample-project1" /></a>
            <a class="single_image" rel="gallery1" href="<%=basePath%>/images/sample-project/large/project2.jpg"></a>
            <a class="single_image" rel="gallery1" href="<%=basePath%>/images/sample-project/large/project3.jpg"></a>
            <h6>2017.10.11</h6>
            <p>Moo cards done.
                <a class="readmore" href="#">read more →</a>
            </p>
        </div>
        <div class="one-third">
            <a class="single_image" rel="gallery2" href="<%=basePath%>/images/sample-project/large/project3.jpg"><img src="<%=basePath%>/images/sample-project/thumbs/project3.jpg" width="220" height="132" alt="sample-project3" /></a>
            <a class="single_image" rel="gallery2" href="<%=basePath%>/images/sample-project/large/project2.jpg"></a>
            <a class="single_image" rel="gallery2" href="<%=basePath%>/images/sample-project/large/project1.jpg"></a>
            <h6>2010.10.11</h6>
            <p>Like printing?
                <a class="readmore" href="#">阅读更多 →</a>
            </p>
        </div>
        <div class="one-third-last">
            <a class="single_image" rel="gallery3" href="<%=basePath%>/images/sample-project/large/project2.jpg"><img src="<%=basePath%>/images/sample-project/thumbs/project2.jpg" width="220" height="132" alt="sample-project2" /></a>
            <a class="single_image" rel="gallery3" href="<%=basePath%>/images/sample-project/large/project3.jpg"></a>
            <a class="single_image" rel="gallery3" href="<%=basePath%>/images/sample-project/large/project1.jpg"></a>
            <h6>2009.10.11</h6>
            <p>Sweeeeeet.
                <a class="readmore" href="#">阅读更多 →</a>
            </p>
        </div>
    </div>
    <!--END of gallery-->
    <div class="spacer"></div>
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<%--<jsp:include page="tools/panel.jsp"></jsp:include>--%>

</body>
</html>
