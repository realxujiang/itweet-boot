<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
    <title>Add</title>
    <meta charset="utf-8">
    <link href="<%=basePath%>/style/admin/backstage/css/style.css" rel="stylesheet">

    <link href="<%=basePath%>/style/admin/makedown/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/style/admin/backstage/css/reveal.css" rel="stylesheet">

    <link href="<%=basePath%>/style/admin/backstage/css/amazeui.chosen.css" rel="stylesheet">
    <link href="<%=basePath%>/style/admin/backstage/css/amazeui.min.css" rel="stylesheet">

    <script src="<%=basePath%>/style/admin/backstage/js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>/style/admin/makedown/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/style/admin/backstage/js/amazeui.chosen.js"></script>

    <script>
        $(function() {
            $('#categories').chosen({
                no_results_text: '木有找到匹配的项！'
            });
        });

        $(function() {
            $('#type').chosen({
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
                <form action="<%=basePath%>/admin/course/add" method="post">
                    <li style="color: red;">${message}</li>
                    <li>
                        <label>标题<b>*</b></label>
                        <input name="title" type="text" class="dfinput" value="${form.title}" placeholder="标题" style="width:618px;" />
                    </li>
                    <li>
                        <label>标签<b>*</b></label>
                        <input name="tag" type="text" class="dfinput" value="${form.tag}" placeholder="标签" style="width:618px;" />
                    </li>
                    <li>
                        <label>描述<b>*</b></label>
                        <input name="description" type="text" class="dfinput" value="${form.description}" placeholder="描述" style="width:618px;" />
                    </li>
                    <li>
                        <label>类别<b>*</b></label>
                        <select id="type" name="classify" style="width:618px;" class="chosen-select-no-results" tabindex="10">
                            <option value="Big Data Architecture" selected="selected">Big Data Architecture</option>
                            <option value="Cloud">Cloud</option>
                            <option value="Web Desig">Web Design</option>
                        </select>
                    </li>
                    <li>
                        <label>介绍<b>*</b></label>
                        <input name="content" type="text" class="dfinput" value="${form.content}" placeholder="教程介绍" style="width:618px;" />
                    </li>
                    <li>
                        <label>封面<b>*</b></label>
                        <input name="coverPicture" type="text" class="dfinput" value="${form.coverPicture}" placeholder="选择图片 默认: no-images.png" style="width:618px;" />
                        <%--<input type="text" name="coverPicture" value="${form.coverPicture}" class="dfinput" style="width:618px;" data-toggle="modal" data-target="#myModal" placeholder="选择图片" />--%>
                    </li>
                    <li>
                        <label>滚动图1<b>*</b></label>
                        <input name="slideOne" type="text" class="dfinput" value="${form.slideOne}" placeholder="选择图片 默认: no-images.png" style="width:618px;" />
                    </li>
                    <li>
                        <label>滚动图2<b>*</b></label>
                        <input name="slideTwo" type="text" class="dfinput" value="${form.slideTwo}" placeholder="选择图片 默认: no-images.png" style="width:618px;" />
                    </li>
                    <li>
                        <label>特点<b>*</b></label>
                        <input name="work" type="text" class="dfinput" value="${form.work}" placeholder="特点" style="width:618px;" />
                    </li>
                    <li><label>&nbsp;</label>
                        <button type="submit" class="btn btn-primary">
                            确定
                        </button>
                    </li>
                </form>
            </ul>
        </div>
    </div>
</div>

<%--modal frame--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="height: 600px;top: 40px;  width: 120%;min-width: 830px;">
            <div class="modal-header" style="background-color: #F1F2F7;border-radius: 5px;">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    <span style="font-size: 20px; margin-left: 25px;">选择图片</span>
                </h4>
            </div>
            <div class="modal-body" style="height: 80%;padding: 0px;">

                <div class="modal-body-left">
                    <ul>
                        <br />
                        <li>
                            <a href="<%=basePath%>admin/article/all" target="right">全部图片()</a>
                        </li><br />
                        <li>
                            <a href="<%=basePath%>admin/article/list" target="right">未分组()</a>
                        </li><br />
                        <li>
                            <a href="<%=basePath%>admin/article/list" target="right">文章配图()</a>
                        </li><br />
                        <li>
                            <a href="<%=basePath%>admin/article/list" target="right">二维码()</a>
                        </li><br />
                        <li>
                            <a href="<%=basePath%>admin/article/add" target="right">新建分组()</a>
                        </li>
                    </ul>
                </div>

                <div class="modal-body-right">

                    <div class="modal-body-right-pic">
                        <div class="modal-body-right-box">
                            <div class="box-up">
                                <img src="<%=basePath%>style/admin/backstage/images/a3.jpg" />
                            </div>
                            <div class="box-down">
                                <span>大钟寺大钟寺大钟寺大钟寺</span>
                            </div>
                        </div>
                        <div class="modal-body-right-box">
                            <div class="box-up">
                                <img src="<%=basePath%>style/admin/backstage/images/a3.jpg" />
                            </div>
                            <div class="box-down">
                                <span>大钟寺</span>
                            </div>
                        </div>
                        <div class="modal-body-right-box">
                            <div class="box-up">
                                <img src="<%=basePath%>style/admin/backstage/images/a3.jpg" />
                            </div>
                            <div class="box-down">
                                <span>大钟寺</span>
                            </div>
                        </div>
                        <div class="modal-body-right-box">
                            <div class="box-up">
                                <img src="<%=basePath%>style/admin/backstage/images/a3.jpg" />
                            </div>
                            <div class="box-down">
                                <span>大钟寺</span>
                            </div>
                        </div>

                        <div class="modal-body-right-box">
                            <div class="box-up">
                                <img src="<%=basePath%>style/admin/backstage/images/a3.jpg" />
                            </div>
                            <div class="box-down">
                                <span>大钟寺</span>
                            </div>
                        </div>
                        <div class="modal-body-right-box">
                            <div class="box-up">
                                <img src="<%=basePath%>style/admin/backstage/images/a3.jpg" />
                            </div>
                            <div class="box-down">
                                <span>大钟寺</span>
                            </div>
                        </div>

                        <div class="modal-body-right-box">
                            <div class="box-up">
                                <img src="<%=basePath%>style/admin/backstage/images/a3.jpg" />
                            </div>
                            <div class="box-down">
                                <span>大钟寺</span>
                            </div>
                        </div>
                        <div class="modal-body-right-box">
                            <div class="box-up">
                                <img src="<%=basePath%>style/admin/backstage/images/a3.jpg" />
                            </div>
                            <div class="box-down">
                                <span>大钟寺</span>
                            </div>
                        </div>


                    </div>

                    <div class="modal-body-right-page">
                        <div class="right-page">

                            <a href="#"><img src="<%=basePath%>style/admin/backstage/images/forward.jpg" height="35" /></a>
                            <span style="margin-left: 15px;top: 13px;display: inline;">1/18</span>
                            <a href="#"><img src="<%=basePath%>style/admin/backstage/images/backwards.jpg" height="35" style="margin-left: 15px;" /></a>
                            <input type="text" name="nowPage" style="width: 60px; height: 34px; border: solid #e3e3e3 1px;  margin-left: 15px;" />
                            <input type="submit" value="跳转" style="width: 60px; height: 34px; background-color: #FFFFFF; border: solid #e3e3e3 1px; margin-left: 15px; margin-right: 15px;" />

                        </div>
                    </div>

                </div>

            </div>
            <div class="modal-footer" style="text-align: center;background-color: #F1F2F7;border-radius: 5px;">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    确定
                </button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>


</body>
</html>