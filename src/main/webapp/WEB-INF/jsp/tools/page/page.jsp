<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<tr>
    <td colspan="8">
        <div class="pagelist">
            第${pb.currentPage}页/共${pb.totalPages}页

            <a href="<%=basePath%>/admin/permission/list?page=1">首页</a>

            <c:if test="${pb.currentPage > 1}">
                <a href="<%=basePath%>/admin/permission/list?page=${pb.currentPage-1}">上一页</a>
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
                        <span class="current">${i}</span>
                    </c:when>
                    <c:otherwise>
                        <a href="<%=basePath%>/admin/permission/list?page=${i}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${pb.currentPage < pb.totalPages}">
                <a href="<%=basePath%>/admin/permission/list?page=${pb.currentPage+1}">下一页</a>
            </c:if>

            <a href="<%=basePath%>/admin/permission/list?page=${pb.totalPages}">尾页</a>
        </div>
    </td>
</tr>