<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="pagin">
    <div class="message">共<i class="blue">${pb.totalRecored}</i>条,<i class="blue">${pb.currentPage}</i>页，当前显示第&nbsp;<i class="blue">${pb.currentPage}&nbsp;</i>页</div>
    <ul class="paginList">

        <li class="paginItem"><a href="<%=basePath%>/admin/permission/list?page=1"><span>首</span></a></li>

        <c:if test="${pb.currentPage > 1}">
            <li class="paginItem"><a href="<%=basePath%>/admin/permission/list?page=${pb.currentPage-1}"><span class="pagepre"></span></a></li>
        </c:if>

        <c:choose>
            <c:when test="${pb.totalPages<=10}">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="${pb.totalPages}"/>
            </c:when>
            <c:otherwise>
                <c:set var="begin" value="${pb.currentPage-5}"/>
                <c:set var="end" value="${pb.currentPage+4}"/>

                <c:if test="${begin < 1}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="10"/>
                </c:if>
                <c:if test="${end > pb.totalPages}">
                    <c:set var="begin" value="${pb.totalPages-9}"/>
                    <c:set var="end" value="${pb.totalPages}"/>
                </c:if>

            </c:otherwise>
        </c:choose>

        <c:forEach var="i" begin="${begin}" end="${end}">
            <c:choose>
                <c:when test="${i eq pb.currentPage}">
                    <li class="paginItem current"><a>${i}</a></li>
                </c:when>
                <c:otherwise>
                    <li class="paginItem"><a href="<%=basePath%>/admin/permission/list?page=${i}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${pb.currentPage < pb.totalPages}">
            <li class="paginItem"><a href="<%=basePath%>/admin/permission/list?page=${pb.currentPage+1}"><span class="pagenxt"></span></a></li>
        </c:if>

        <li class="paginItem"><a href="<%=basePath%>/admin/permission/list?page=${pb.totalPages}"><span>尾</span></a></li>
    </ul>
</div>