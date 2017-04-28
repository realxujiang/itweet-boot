<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Add</title>
    <jsp:include page="../../tools/style/admin_style.jsp"></jsp:include>
    <link href="<%=basePath%>style/admin/makedown/css/bootstrap.min.css" rel="stylesheet">

    <script src="<%=basePath%>style/admin/makedown/js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>style/admin/makedown/js/bootstrap.min.js"></script>


    <script>
        $(function() {
            $('#columnd').chosen({
                no_results_text: '木有找到匹配的项！'
            });
        });
    </script>

    <style>
        .container {
            margin-top: 20px;
        }

        .image-preview-input {
            position: relative;
            overflow: hidden;
            margin: 0px;
            color: #333;
            background-color: #fff;
            border-color: #ccc;
        }

        .image-preview-input input[type=file] {
            position: absolute;
            top: 0;
            right: 0;
            margin: 0;
            padding: 0;
            font-size: 20px;
            cursor: pointer;
            opacity: 0;
            filter: alpha(opacity=0);
        }

        .image-preview-input-title {
            margin-left: 2px;
        }
    </style>

</head>
<body>

<form action="<%=basePath%>/admin/document/add" enctype="multipart/form-data" method="post">

<div class="container" style="float: left;">
    ${message}

    <div class="row">
        <div class="col-xs-6 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">

            <select id="columnd" name="columnd" style="width:100%;height:35px;min-width: 120px; border-radius: 5px;" class="chosen-select-no-results" tabindex="10">
                <option value="cover" selected="selected">封面</option>
                <option value="article">文章</option>
                <option value="index">首页</option>
            </select>

        </div>
        <br/>
        <br/>
        <br/>
        <div class="col-xs-6 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <!-- image-preview-filename input [CUT FROM HERE]-->
            <div class="input-group image-preview">
                <input type="text" class="form-control image-preview-filename" disabled="disabled">
                <!-- don't give a name === doesn't send on POST/GET -->
                <span class="input-group-btn">
                    <!-- image-preview-button button -->
                    <button type="button" class="btn btn-default image-preview-button" style="display:none;">
                        <span class="glyphicon glyphicon-picture"></span> Preview
						</button>

                    <!-- image-preview-clear button -->
						<button type="button" class="btn btn-default image-preview-clear" style="display:none;">
                        <span class="glyphicon glyphicon-remove"></span> Clear
                    </button>

                    <!-- image-preview-input -->
						<div class="btn btn-default image-preview-input">
							<span class="glyphicon glyphicon-folder-open"></span>
							<span class="image-preview-input-title">Browse</span>
							<input type="file" accept="image/png, image/jpeg, image/gif, image/jpg" name="file" />
						</div>
                </span>
            </div>
            <!-- /input-group image-preview [TO HERE]-->
        </div>

        <br/>
        <br/>
        <br/>
        <div class="col-xs-6 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <input type="submit" class="btn" value="确定" />
        </div>
    </div>
</div>
</form>

<script>
    function closePreview() {
        $('.image-preview').popover('hide');
    }

    $(document).ready(function() {
        // Set the close button
        var closebtn = $('<button/>', {
            type: "button",
            text: 'x',
            id: 'close-preview',
            style: 'font-size: initial;',
        });
        closebtn.attr("class", "close pull-right");
        closebtn.attr("onclick", "closePreview();");
        // Set the popover default content
        $('.image-preview').popover({
            trigger: 'manual',
            html: true,
            title: "<strong>Preview</strong>" + $(closebtn)[0].outerHTML,
            content: 'Loading...',
            placement: 'bottom'
        });
        // Set the clear onclick function
        $('.image-preview-clear').click(function() {
            $('.image-preview').popover('hide');
            $('.image-preview-filename').val("");
            $('.image-preview-clear').hide();
            $('.image-preview-button').hide();
            $('.image-preview-input input:file').val("");
            $(".image-preview-input-title").text("Browse");
        });

        $('.image-preview-button').on('click', function() {
            $('.image-preview').popover('toggle');
        });
    });

    $(function() {
        $(".image-preview-input input:file").change(function() {
            // Create the preview image
            var img = $('<img/>', {
                id: 'dynamic',
                width: 250,
                height: 230
            });
            var file = this.files[0];
            var reader = new FileReader();
            reader.onload = function(e) {
                $(".image-preview-input-title").text("Change");
                $(".image-preview-clear").show();
                $(".image-preview-button").show();
                $(".image-preview-filename").val(file.name);
                // Set preview image into the popover data-content
                img.attr('src', e.target.result);
                $(".image-preview").attr("data-content", $(img)[0].outerHTML).popover("show");
            }
            reader.readAsDataURL(file);
        });
    });
</script>
</body>
</html>