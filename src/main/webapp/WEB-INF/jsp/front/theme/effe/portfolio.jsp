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
    <title>Portfolino</title>
    <jsp:include page="tools/style.jsp"></jsp:include>
</head>

<body>
<!--This is the START of the header-->
<div id="topcontrol" style="position: fixed; bottom: 5px; left: 960px; opacity: 1; cursor: pointer;" title="Go to Top"></div>
<div id="header-wrapper">
    <div id="header">
        <div id="logo">
            <a href="<%=URL%>/"><img src="<%=basePath%>/images/logo.png" width="100" height="80" alt="logo" /></a>
        </div>
        <div id="header-text">
            <h4>This is our portfolio, our latest stuff is here!</h4>
            <h6><a href="<%=URL%>/">Home</a> → Portfolio</h6>
        </div>
    </div>
</div>
<!--END of header-->


<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>


<!--This is the START of the content-->
<div id="content">
    <!--This is the START of the portfolio section-->
    <div class="spacer"></div>
    <div id="filter"></div>
    <img class="star-divider" src="<%=basePath%>/images/subscribe_divider.png" />
    <div id="container">
        <ul id="stage">
            <li data-tags="Print Design">
                <a href="project-sample.html"><img src="<%=basePath%>/images/portfolio/thumbs/image(1).jpg" alt="Illustration" /></a>
                <h6>Helvetica</h6>
                <p>Kinda sweet huh?
                    <a class="readmore" href="project-sample.html">view →</a>
                </p>
            </li>
            <li data-tags="Logo Design,Print Design">
                <a href="project-sample.html"><img src="<%=basePath%>/images/portfolio/thumbs/image(2).jpg" alt="Illustration" /></a>
                <h6>Typography</h6>
                <p>Lorem ipsum here.
                    <a class="readmore" href="project-sample.html">view →</a>
                </p>
            </li>
            <li data-tags="Web Design,Logo Design">
                <a href="project-sample.html"><img src="<%=basePath%>/images/portfolio/thumbs/image(3).jpg" alt="Illustration" /></a>
                <h6>Ideas</h6>
                <p>A light bulb!
                    <a class="readmore" href="project-sample.html">view →</a>
                </p>
            </li>
            <li data-tags="Web Design,Print Design">
                <a href="project-sample.html"><img src="<%=basePath%>/images/portfolio/thumbs/image(4).jpg" alt="Illustration" /></a>
                <h6>Rockable press</h6>
                <p>Best books around.
                    <a class="readmore" href="project-sample.html">view →</a>
                </p>
            </li>
            <li data-tags="Logo Design">
                <a href="project-sample.html"><img src="<%=basePath%>/images/portfolio/thumbs/image(5).jpg" alt="Illustration" /></a>
                <h6>Moo Cards</h6>
                <p>Gotta lovem'.
                    <a class="readmore" href="project-sample.html">view →</a>
                </p>
            </li>
            <li data-tags="Web Design,Logo Design,Print Design">
                <a href="project-sample.html"><img src="<%=basePath%>/images/portfolio/thumbs/image(6).jpg" alt="Illustration" /></a>
                <h6>Moo Minicards</h6>
                <p>So small and cool.
                    <a class="readmore" href="project-sample.html">view →</a>
                </p>
            </li>
            <li data-tags="Logo Design,Print Design">
                <a href="project-sample.html"><img src="<%=basePath%>/images/portfolio/thumbs/image(7).jpg" alt="Illustration" /></a>
                <h6>Moo Printing</h6>
                <p>Is inside.
                    <a class="readmore" href="project-sample.html">view →</a>
                </p>
            </li>
            <li data-tags="Web Design">
                <a href="project-sample.html"><img src="<%=basePath%>/images/portfolio/thumbs/image(8).jpg" alt="Illustration" /></a>
                <h6>Just say it!</h6>
                <p>Printed.
                    <a class="readmore" href="project-sample.html">view →</a>
                </p>
            </li>
        </ul>
    </div>
    <!--END of portfolio section-->
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<jsp:include page="tools/panel.jsp"></jsp:include>

</body>

</html>