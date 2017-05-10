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
            <li data-tags="Big Data Architecture">
                <a href="/portfolio/projectSample"><img src="<%=basePath%>/images/portfolio/thumbs/image(1).jpg" alt="Illustration" /></a>
                <h6>Hadoop</h6>
                <p>企业级Hadoop解决方案?
                    <a class="readmore" href="/portfolio/projectSample">view →</a>
                </p>
            </li>
            <li data-tags="Cloud,Big Data Architecture">
                <a href="/portfolio/projectSample"><img src="<%=basePath%>/images/portfolio/thumbs/image(2).jpg" alt="Illustration" /></a>
                <h6>Openstack</h6>
                <p>企业级私有云解决方案.
                    <a class="readmore" href="/portfolio/projectSample">view →</a>
                </p>
            </li>
            <li data-tags="Web Design,Cloud">
                <a href="/portfolio/projectSample"><img src="<%=basePath%>/images/portfolio/thumbs/image(3).jpg" alt="Illustration" /></a>
                <h6>skynet</h6>
                <p>大型分布式监控系统!
                    <a class="readmore" href="/portfolio/projectSample">view →</a>
                </p>
            </li>
            <li data-tags="Web Design,Big Data Architecture">
                <a href="/projectSample"><img src="<%=basePath%>/images/portfolio/thumbs/image(4).jpg" alt="Illustration" /></a>
                <h6>Spark</h6>
                <p>企业级数据分析利器.
                    <a class="readmore" href="/projectSample">view →</a>
                </p>
            </li>
            <li data-tags="Cloud">
                <a href="/projectSample"><img src="<%=basePath%>/images/portfolio/thumbs/image(5).jpg" alt="Illustration" /></a>
                <h6>Docker</h6>
                <p>快速部署应用.
                    <a class="readmore" href="/projectSample">view →</a>
                </p>
            </li>
            <li data-tags="Web Design,Cloud,Big Data Architecture">
                <a href="/projectSample"><img src="<%=basePath%>/images/portfolio/thumbs/image(6).jpg" alt="Illustration" /></a>
                <h6>StreamSQL</h6>
                <p>企业流式数据分析解决方案.
                    <a class="readmore" href="/projectSample">view →</a>
                </p>
            </li>
            <li data-tags="Cloud,Big Data Architecture">
                <a href="/projectSample"><img src="<%=basePath%>/images/portfolio/thumbs/image(7).jpg" alt="Illustration" /></a>
                <h6>Sahara</h6>
                <p>云端大数据解决方案.
                    <a class="readmore" href="/projectSample">view →</a>
                </p>
            </li>
            <li data-tags="Web Design">
                <a href="/projectSample"><img src="<%=basePath%>/images/portfolio/thumbs/image(8).jpg" alt="Illustration" /></a>
                <h6>itweet-boot</h6>
                <p>个人博客开源项目.
                    <a class="readmore" href="/projectSample">view →</a>
                </p>
            </li>
        </ul>
    </div>
    <!--END of portfolio section-->
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<%--<jsp:include page="tools/panel.jsp"></jsp:include>--%>

</body>

</html>