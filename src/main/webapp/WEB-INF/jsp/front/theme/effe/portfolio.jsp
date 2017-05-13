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
            <c:forEach items="${courseList}" var="course">
                <li data-tags="${course.classify}">
                    <a href="/portfolio/projectSample/${course.id}"><img src="<%=URL%>/upload/files/${course.coverPicture}" width="200px" height="120px" alt="Illustration" /></a>
                    <h6>${course.tag}</h6>
                    <p>${course.description}
                        <a class="readmore" href="/portfolio/projectSample/${course.id}">预览 →</a>
                    </p>
                </li>
            </c:forEach>
        </ul>
    </div>
    <!--END of portfolio section-->
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<%--<jsp:include page="tools/panel.jsp"></jsp:include>--%>

</body>

</html>