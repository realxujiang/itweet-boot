<%--
  Created by IntelliJ IDEA.
  User: whoami
  Date: 03/05/2017
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path+"/style/front/twts";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Itweet &amp; Boot</title>
    <%--style--%>
    <jsp:include page="tools/style.jsp"></jsp:include>

    <%--畅言--%>
    <script type="text/javascript">
        (function(){
            var appid = 'cyt1SoANh';
            var conf = 'prod_f1122db7ae1d42036c646ea61c3ae363';
            var width = window.innerWidth || document.documentElement.clientWidth;
            if (width < 960) {
                window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("https://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })();
    </script>
</head>

<body id="page">

<%--Nav Menu--%>
<jsp:include page="tools/navbar.jsp"></jsp:include>

<div class="content-body">
    <div class="container">
        <div class="row">
            <main class="col-md-12">
                <h1 class="page-title" style="font-family: STXingkai">关于我</h1>
                <article class="post">
                    <div class="entry-content clearfix">
                        <figure class="img-responsive-center">
                            <img class="img-responsive" src="<%=basePath%>/img/me.jpg" alt="Developer Image">
                        </figure>
                        <p>
                            小码农一枚,终日沉迷于计算机世界,始终坚信技术能改变世界；越深入了解，越感觉自己知识浅薄，跟着好奇心走，故事到这时候应该出现未知力量指引迷途中的人，又或在蜿蜒无边的道路上寻求上师的启示，光明或黑暗之路该如何抉择；有人选择去流浪，有人跟着自己的直觉和好奇心走，哪怕离经叛道也决不止步；每个人都在寻找真相，我呢？
                        </p>
                        <p>
                            有些东西是超越日常忙碌琐碎的生活的，生活不仅仅是工作、家庭、财产、职业。它更丰富，就像硬币还有另一面，虽然大家嘴上不说，但在生活的间隙，尤其是在不如意的时候，我们都能感受到某种冲动，许多人想找回生活的意义，有人去流浪，有人在印度神秘仪式里寻找答案。他们想寻找生活的真相。生活不应该是父母过的那样，正因为这种精神，有人宁愿当诗人也不愿做银行家。
                        </p>
                        <p>
                            我的结论是实干家首先是思想家，改变行业的人，往往集两者于一身，很难想象有人帮助达芬奇构思五年以后画什么，用什么作画，达芬奇既是艺术家又精通化学和配色，还懂人体解剖，他将艺术和科学，思考与实践结合，才创作出杰出的画作。我们的行业也一样,杰出的人既是思想家又是实干家。很多人把一切归功于思考，其实行动更困难，常有人说这点子我三年前就想到了，但稍加分析你会发现，有实际行动的人必定努力思考过。
                        </p>
                        <p>
                            逝者如斯夫，和所有以梦为马的诗人一样，岁月易逝， 一滴不剩！ 君不见高堂明镜悲白发，朝如青丝暮成雪！
                        </p>
                        <h4>电影</h4>
                        <p>
                            01.The.Fifth.Estate.2013 <br>
                            02.The.Snowden.Files.2016   <br>
                            03.The Internet’s Own Boy: The Story of Aaron Swartz.2014 <br>
                            04.Citizenfour.2014(Edward Snowden) <br>
                            05.We Steal Secrets: The Story of WikiLeaks (2013)
                        </p>
                        <div class="height-40px"></div>
                        <h2 class="title text-center" style="font-family: STXingkai">关注我</h2>
                        <ul class="social">
                            <li class="facebook"><a href="https://www.facebook.com/realxujiang"><span class="ion-social-facebook"></span></a></li>
                            <li class="twitter"><a href="https://twitter.com/realxujiang"><span class="ion-social-twitter"></span></a></li>
                            <li class="google-plus"><a href="https://weibo.com/sparkjvm"><span class="ion-social-googleplus"></span></a></li>
                            <li class="tumblr"><a href="https://github.com/realxujiang"><span class="ion-social-github"></span></a></li>
                        </ul>
                    </div>
                </article>
            </main>
        </div>

    </div>
    <!--PC和WAP自适应版-->
    <div id="SOHUCS" sid="twts-about"></div>
</div>

<%--site footer--%>
<jsp:include page="tools/site-footer.jsp"></jsp:include>

<!-- Mobile Menu -->
<jsp:include page="tools/mobile-menu.jsp"></jsp:include>

<script src="<%=basePath%>/js/script.js"></script>

</body>
</html>
