<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <style>
        #description img {
            width: 100%;
        }
    </style>
</head>

<body>


<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>


<!--This is the START of the content-->
<div id="content">
    <!--This is the START of the NIVO slider-->
    <div class="slider-wrapper theme-effe">
        <div id="slider" class="nivoSlider">
            <img src="<%=URL%>/upload/files/${course.slideOne}" width="100%" height="100%" alt="slideOne" title="#img1" />
            <img src="<%=URL%>/upload/files/${course.slideTwo}" width="100%" height="100%" alt="slideTwo" title="#img2" />
        </div>
        <div id="slider-shadow"></div>
    </div>
    <!--END of NIVO Slider-->

    <!--This is the START of the project-->
    <div class="project">
        <div id="description">
            <h3>${course.title}</h3>
            <div>
                ${course.content}
            </div>
        </div>
        <ul id="work">
            <li>${course.work}</li>
            <li>This is the second item</li>
            <li>This is the third item</li>
            <li>This is the fourth item</li>
        </ul>
    </div>
    <!--END of project-->

    <!--This is the START of the gallery-->
    <div class="spacer"></div>
    <div class="project-summary">
        <c:forEach items="${courseList}" var="course" varStatus="stat">
            <c:if test="${!stat.last}">
                <div class="one-third">
                    <a class="single_image" rel="gallery1" href="<%=URL%>/upload/files/${course.coverPicture}">
                        <img src="<%=URL%>/upload/files/${course.coverPicture}" width="220" height="132" alt="sample-project1" />
                    </a>
                    <h6><fmt:formatDate pattern="yyyy.MM.dd" value="${course.createDate}"/></h6>
                    <p>${course.description}
                        <a class="readmore" href="/portfolio/projectSample/${course.id}">阅读更多 →</a>
                    </p>
                </div>
            </c:if>
            <c:if test="${stat.last}">
                <div class="one-third-last">
                    <a class="single_image" rel="gallery1" href="<%=URL%>/upload/files/${course.coverPicture}">
                        <img src="<%=URL%>/upload/files/${course.coverPicture}" width="220" height="132" alt="sample-project1" />
                    </a>
                    <h6><fmt:formatDate pattern="yyyy.MM.dd" value="${course.createDate}"/></h6>
                    <p>${course.description}
                        <a class="readmore" href="/portfolio/projectSample/${course.id}">阅读更多 →</a>
                    </p>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <!--END of gallery-->

    <div class="spacer"></div>
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<%--<jsp:include page="tools/panel.jsp"></jsp:include>--%>

</body>
</html>
