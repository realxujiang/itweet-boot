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
<!--This is the START of the header-->
<div id="topcontrol" style="position: fixed; bottom: 5px; left: 960px; opacity: 1; cursor: pointer;" title="Go to Top"></div>
<div id="header-wrapper">
    <div id="header">
        <div id="logo">
            <a href="<%=URL%>/"><img src="<%=basePath%>/images/logo.png" width="100" height="80" alt="logo" /></a>
        </div>
        <div id="header-text">
            <h4>This is just a sample project of ours, you can have as many as you want!</h4>
            <h6><a href="<%=URL%>/">Home</a> → Sample Project</h6>
        </div>
    </div>
</div>
<!--END of header-->

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
            <h3>This is the project title</h3>
            <p>Ut ligula sapien, vulputate nec vulputate eget, semper ac augue. Sed varius ante leo, vel tristique libero. Aenean eros felis, auctor a congue ut, pellentesque vel elit. Vivamus imperdiet ultricies diam sit amet euismod. Duis nec purus quis neque commodo porta sit amet vitae mi. Curabitur vestibulum ante convallis enim fringilla posuere. In ac erat ut magna cursus faucibus.</p>
        </div>
        <ul id="work">
            <li>This is the first item</li>
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
            <h6>24.5.2009</h6>
            <p>Moo cards done.
                <a class="readmore" href="#">read more →</a>
            </p>
        </div>
        <div class="one-third">
            <a class="single_image" rel="gallery2" href="<%=basePath%>/images/sample-project/large/project3.jpg"><img src="<%=basePath%>/images/sample-project/thumbs/project3.jpg" width="220" height="132" alt="sample-project3" /></a>
            <a class="single_image" rel="gallery2" href="<%=basePath%>/images/sample-project/large/project2.jpg"></a>
            <a class="single_image" rel="gallery2" href="<%=basePath%>/images/sample-project/large/project1.jpg"></a>
            <h6>1.6.2009</h6>
            <p>Like printing?
                <a class="readmore" href="#">read more →</a>
            </p>
        </div>
        <div class="one-third-last">
            <a class="single_image" rel="gallery3" href="<%=basePath%>/images/sample-project/large/project2.jpg"><img src="<%=basePath%>/images/sample-project/thumbs/project2.jpg" width="220" height="132" alt="sample-project2" /></a>
            <a class="single_image" rel="gallery3" href="<%=basePath%>/images/sample-project/large/project3.jpg"></a>
            <a class="single_image" rel="gallery3" href="<%=basePath%>/images/sample-project/large/project1.jpg"></a>
            <h6>22.7.2009</h6>
            <p>Sweeeeeet.
                <a class="readmore" href="#">read more →</a>
            </p>
        </div>
    </div>
    <!--END of gallery-->
    <div class="spacer"></div>
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<jsp:include page="tools/panel.jsp"></jsp:include>

</body>
</html>
