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
    <title>BlogSingle</title>
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
            <h4>We make a bunch of cool stuff, have a look around!</h4>
            <h6><a href="<%=URL%>/">Home</a> → Blog Post</h6>
        </div>
    </div>
</div>
<!--END of header-->

<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>


<!--This is the START of the content-->
<div id="content">
    <!--This is the START of the blog section-->
    <div id="blog">
        <div class="blog-item-single">
            <h3>This is our first juicy tidbit</h3>
            <div class="blog-item-single-info">
                <div class="user">admin</div>
                <div class="comments">6 comments</div>
                <div class="tags">psd news blog post</div>
            </div>
            <div class="blog-item-single-content">
                <a class="single_image" href="<%=basePath%>/images/blog/large/blog1.jpg"><img src="<%=basePath%>/images/blog/single/blog1.jpg" width="720" height="280" alt="blog1" /></a>
                <p>Aenean porttitor sem est. Donec at risus lacus. Sed id ligula ipsum, non placerat turpis. Donec interdum egestas ante. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque ullamcorper sagittis faucibus. Pellentesque convallis erat in leo pellentesque dapibus. Suspendisse non dui dolor, at tempor est. Phasellus adipiscing nisi sed ante consequat posuere. Etiam mollis, est eu vestibulum eleifend, dolor risus egestas tortor, vestibulum fringilla urna libero eget est. Sed a erat justo, eu suscipit nunc. In faucibus adipiscing quam, id gravida libero fringilla in. Cras consectetur porttitor lorem, sed egestas elit laoreet ac. Proin at sapien at velit scelerisque auctor quis eget purus. Cras nec arcu eleifend quam condimentum feugiat.</p>
                <p>Fusce quis nibh eu erat pellentesque eleifend. Nunc tempus iaculis interdum. Aenean felis nisi, tempus ullamcorper ullamcorper sit amet, sodales eu nibh. Curabitur porta porta egestas. Nulla porta diam at augue facilisis ultricies posuere felis ultrices. Phasellus bibendum, orci facilisis ultrices scelerisque, risus arcu tristique turpis, sit amet viverra neque velit eu ligula. Aliquam erat volutpat. Phasellus in vulputate urna. Vestibulum est erat, pretium ac suscipit et, blandit id enim. Pellentesque hendrerit suscipit tortor, vel euismod elit euismod at. Mauris arcu dolor, rutrum ac convallis eget, porta ac quam. Maecenas id sem urna. Nunc dignissim est non libero vehicula vel faucibus tellus congue. </p>
            </div>
            <div class="social-blog-buttons">
                <a href="http://twitter.com/share" class="twitter-share-button" data-count="horizontal" data-via="92_Five">Tweet</a>
                <script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
                <iframe src="http://www.facebook.com/plugins/like.php?app_id=108550772584353&amp;href=http%3A%2F%2Fwww.92five.net&amp;send=false&amp;layout=button_count&amp;width=450&amp;show_faces=true&amp;action=like&amp;colorscheme=light&amp;font&amp;height=21" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:450px; height:21px;"></iframe>
            </div>
            <div class="comments-block">
                <h3 class="comments-title">Comments (2)</h3>
                <div class="spacer"></div>
                <div class="comment"> <img class="avatar" alt="" src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm" width="50" height="35" />
                    <div class="comment-info">
                        <a class="post-author">John Doe</a>
                        <p>January 21, 2011</p>
                    </div>
                    <div class="comment-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In in vestibulum eros. Praesent at cursus orci. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vitae sagittis dolor. Proin iaculis suscipit quam non suscipit. Vestibulum vestibulum semper tortor...</p>
                        <a class="reply" href="#">Reply</a>
                    </div>
                </div>
                <div class="spacer"></div>
                <div class="comment"><img class="avatar" alt="" src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm" width="50" height="35" />
                    <div class="comment-info">
                        <a class="post-author">Jane Doe</a>
                        <p>January 21, 2011</p>
                    </div>
                    <div class="comment-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In in vestibulum eros. Praesent at cursus orci. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vitae sagittis dolor. Proin iaculis suscipit quam non suscipit. Vestibulum vestibulum semper tortor...</p>
                        <a class="reply" href="#">Reply</a>
                    </div>
                </div>
                <div class="spacer"></div>
            </div>
            <div class="response">
                <h3>Leave a Comment</h3>
                <h6 class="required-comment">* required</h6>
                <div id="comment-form" class="form">
                    <div class="input-block">
                        <h6 class="short-label">Name*</h6>
                        <input class="short-field" id="name" type="text" name="name" value="" />
                    </div>
                    <div class="input-block">
                        <h6 class="short-label">Email*</h6>
                        <input class="short-field" id="email" type="text" name="email" value="" />
                    </div>
                    <div class="input-block-long">
                        <h6 class="short-label">Web</h6>
                        <input class="long-field" id="url" type="text" placeholder="http://" name="url" value="" />
                    </div>
                    <div class="textarea-block">
                        <h6>Comments*</h6>
                        <textarea id="comment" rows="10" cols="70" name="comment"></textarea>
                    </div>
                    <div class="clear"></div>
                    <input id="comment-button" type="submit" value="Submit" name="submit" />
                </div>
                <div class="spacer"></div>
            </div>
        </div>
    </div>
    <!--END of blog section-->
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<jsp:include page="tools/panel.jsp"></jsp:include>

</div>
</body>

</html>