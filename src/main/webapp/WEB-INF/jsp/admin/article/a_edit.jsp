<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit</title>
    <jsp:include page="../../tools/style/admin_style.jsp"></jsp:include>
    <link href="<%=basePath%>style/admin/backstage/css/style.css" rel="stylesheet">

    <script>
        $(function() {
            $('#categories').chosen({
                no_results_text: '木有找到匹配的项！'
            });
        });
    </script>

</head>
<body>

<div class="formbody">
    <div id="usual1" class="usual">
        <div id="tab1" class="tabson">
            <ul class="forminfo">
                <form action="<%=basePath%>/admin/article/edit" method="post">
                    <input type="hidden" name="id" value="${form.id}">
                    <li style="color: red;">${message}</li>
                    <li><label>文章标题<b>*</b></label><input name="title" type="text" class="dfinput" value="${form.title}" placeholder="标题" style="width:618px;" /></li>
                    <li><label>文章描述<b>*</b></label><input name="description" type="text" class="dfinput" value="${form.description}" placeholder="描述" style="width:618px;" /></li>
                    <li>
                        <label>类别<b>*</b></label>
                        <select id="categories" name="categoriesId" style="width:618px;" class="chosen-select-no-results" tabindex="10">
                            <c:forEach items="${categoriesList}" var="categories">

                                <c:if test="${categories.id eq categoriesId}">
                                    <option value="${categories.id}" selected="true">${categories.name}</option>
                                </c:if>
                                <c:if test="${categories.id ne categoriesId}">
                                    <option value="${categories.id}">${categories.name}</option>
                                </c:if>

                            </c:forEach>
                        </select>
                    </li>
                    <li>
                        <label>标签<b>*</b></label>
                        <input name="tagNames" type="text" class="dfinput" value="${tagNames}" placeholder="以英文逗号分隔的标签, 如：A,B" style="width:618px;" />
                    </li>

                    <li><label>&nbsp;</label><input type="submit" class="btn" value="确定" /></li>
                </form>
            </ul>
        </div>
    </div>
</div>


</body>
</html>