<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<p class="slide">
    <a href="#" class="btn-slide"></a>
</p>
<div id="slide-panel">
    <!--This is the START of the follow section-->
    <div id="follow">
        <h3>Get Notified About My Newest Freebies & Upcoming Themes!</h3>
        <h5>
            <p>I do make some awesome freebies for you to use... All of them are FREE and pixel perfect!</p>
            <p>Thanks for showing me the support by subscribing, and I'll try not to disappoint you...</p>
        </h5>
        <img class="star-divider" src="<%=basePath%>/style/front/theme/effe/images/subscribe_divider.png" />
        <a href="http://www.twitter.com/92_five">
            <div id="follow-twitter"><img src="<%=basePath%>/style/front/theme/effe/images/tweet_top.png" />
                <h4>Follow me on twitter</h4>
            </div>
        </a>
        <a href="http://eepurl.com/dqtGj">
            <div id="follow-mail"><img src="<%=basePath%>/style/front/theme/effe/images/mail_top.png" />
                <h4>Subscribe to my newsletter</h4>
            </div>
        </a>
        <h1>Thanks for that!</h1>
    </div>
    <!--END of follow section-->
</div>

