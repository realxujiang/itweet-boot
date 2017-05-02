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
    <title>Features</title>
    <jsp:include page="tools/style.jsp"></jsp:include>
</head>

<body>


<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>


<!--This is the START of the content-->
<div id="content">
    <!--This is the START of the features-->
    <div id="features">
        <div class="spacer"></div>
        <div id="recent-text1">
            <h2 style="text-align: center">The little plus sign in the top right corner...</h2>
            <img class="star-divider" src="<%=basePath%>/images/subscribe_divider.png" />
            <h5 style="text-align: center">It can hold any HTML you want!</h5>
        </div>
        <div class="spacer"></div>
        <div id="recent-text2">
            <h2 style="text-align: center">This is a sample fancybox gallery...</h2>
            <h5 style="text-align: center">You can add more galleries easily!</h5>
        </div>
        <div class="recent-gallery">
            <a class="single_image" href="<%=basePath%>/images/gallery/large/img1.jpg"><img src="<%=basePath%>/images/gallery/thumbs/img1.jpg" width="160" height="96" alt="portfolio1" /></a>
            <a class="single_image" href="<%=basePath%>/images/gallery/large/img2.jpg"><img src="<%=basePath%>/images/gallery/thumbs/img2.jpg" width="160" height="96" alt="portfolio2" /></a>
            <a class="single_image" href="<%=basePath%>/images/gallery/large/img3.jpg"><img src="<%=basePath%>/images/gallery/thumbs/img3.jpg" width="160" height="96" alt="portfolio3" /></a>
            <a class="single_image" href="<%=basePath%>/images/gallery/large/img4.jpg"><img src="<%=basePath%>/images/gallery/thumbs/img4.jpg" width="160" height="96" alt="portfolio4" /></a>
            <a class="single_image" href="<%=basePath%>/images/gallery/large/img5.jpg"><img src="<%=basePath%>/images/gallery/thumbs/img5.jpg" width="160" height="96" alt="portfolio5" /></a>
            <a class="single_image" href="<%=basePath%>/images/gallery/large/img6.jpg"><img src="<%=basePath%>/images/gallery/thumbs/img6.jpg" width="160" height="96" alt="portfolio6" /></a>
            <a class="single_image" href="<%=basePath%>/images/gallery/large/img7.jpg"><img src="<%=basePath%>/images/gallery/thumbs/img7.jpg" width="160" height="96" alt="portfolio7" /></a>
            <a class="single_image" href="<%=basePath%>/images/gallery/large/img8.jpg"><img src="<%=basePath%>/images/gallery/thumbs/img8.jpg" width="160" height="96" alt="portfolio8" /></a>
        </div>
        <div class="spacer"></div>
        <div id="recent-text">
            <h2>When you scroll down, a button appears...</h2>
            <h5>That one takes you right back up!</h5>
        </div>
        <div class="spacer"></div>
        <blockquote>So let's see how you can work with typography and features in this premium portfolio template...</blockquote>
        <div class="one">
            <h4>A couple paragraphs of text</h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam blandit mi ac felis facilisis ac bibendum nibh consectetur. Curabitur porttitor mauris vel dui laoreet ut bibendum augue condimentum. Donec massa tortor, rutrum id vehicula in, porttitor et mauris. Curabitur justo velit, consectetur vel porttitor quis, placerat ut eros. Fusce ut mi a magna ultrices blandit id eu quam. Sed semper nunc sed magna condimentum mattis. Duis id elit vel sapien tristique dignissim. Proin mauris turpis, congue ac tincidunt non, feugiat a nisl. In lacinia nisi et orci convallis ornare. Sed a justo dui, quis tristique metus. Mauris quis nibh ligula, ut lacinia magna. Nulla in erat nec quam euismod faucibus. Integer gravida dolor et orci laoreet mattis. Fusce hendrerit faucibus metus ac lacinia. Aenean sed turpis magna. In vel tortor velit, vel mollis felis.</p>
            &nbsp;
            <p>Vestibulum aliquam nisi nec metus pulvinar ut dignissim erat placerat. Praesent quis urna lorem. Cras nec facilisis nisi. Morbi sollicitudin convallis porta. Cras condimentum mattis massa sit amet vulputate. Morbi sed erat arcu. Sed sollicitudin, augue quis laoreet sagittis, eros augue lacinia nulla, id tristique ligula lectus ut mauris. Suspendisse egestas faucibus vestibulum. Morbi gravida augue mattis enim mattis eget dapibus ante fringilla. Mauris condimentum dui nec orci feugiat congue. Proin suscipit, enim non iaculis pretium, ligula elit pharetra tortor, et placerat nibh mauris ut tellus.</p>
            &nbsp;
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat. Quisque adipiscing ante non augue blandit convallis. Aenean eu tellus sem. Praesent vehicula feugiat nunc, nec ornare felis tristique at. Integer non quam erat, in adipiscing ligula. Quisque lobortis sagittis sem vel condimentum. Cras viverra, tellus eget mollis malesuada, magna massa laoreet nisi, ac pulvinar mi quam sed dolor.</p>
        </div>
        <div class="spacer"></div>
        <div class="one-half">
            <h4>Split it up</h4>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat. Quisque adipiscing ante non augue blandit convallis. Aenean eu tellus sem. Praesent vehicula feugiat nunc, nec ornare felis tristique at. Integer non quam erat, in adipiscing ligula. Quisque lobortis sagittis sem vel condimentum. Cras viverra, tellus eget mollis malesuada, magna massa laoreet nisi, ac pulvinar mi quam sed dolor.</p>
        </div>
        <div class="one-half-last">
            <h4>In half</h4>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat. Quisque adipiscing ante non augue blandit convallis. Aenean eu tellus sem. Praesent vehicula feugiat nunc, nec ornare felis tristique at. Integer non quam erat, in adipiscing ligula. Quisque lobortis sagittis sem vel condimentum. Cras viverra, tellus eget mollis malesuada, magna massa laoreet nisi, ac pulvinar mi quam sed dolor.</p>
        </div>
        <div class="spacer"></div>
        <div class="one-third">
            <h4>Split it up</h4>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat. Quisque adipiscing ante non augue blandit convallis. Aenean eu tellus sem. Praesent vehicula feugiat nunc, nec ornare felis tristique at. Integer non quam erat, in adipiscing ligula. Quisque lobortis sagittis sem vel condimentum. Cras viverra, tellus eget mollis malesuada, magna massa laoreet nisi, ac pulvinar mi quam sed dolor.</p>
        </div>
        <div class="one-third">
            <h4>Into a couple of pieces</h4>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat. Quisque adipiscing ante non augue blandit convallis. Aenean eu tellus sem. Praesent vehicula feugiat nunc, nec ornare felis tristique at. Integer non quam erat, in adipiscing ligula. Quisque lobortis sagittis sem vel condimentum. Cras viverra, tellus eget mollis malesuada, magna massa laoreet nisi, ac pulvinar mi quam sed dolor.</p>
        </div>
        <div class="one-third-last">
            <h4>Well three wil do!</h4>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat. Quisque adipiscing ante non augue blandit convallis. Aenean eu tellus sem. Praesent vehicula feugiat nunc, nec ornare felis tristique at. Integer non quam erat, in adipiscing ligula. Quisque lobortis sagittis sem vel condimentum. Cras viverra, tellus eget mollis malesuada, magna massa laoreet nisi, ac pulvinar mi quam sed dolor.</p>
        </div>
        <div class="spacer"></div>
        <div class="one-fourth">
            <h4>Split it up</h4>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu.</p>
        </div>
        <div class="one-fourth">
            <h4>Into a couple of pieces</h4>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu.</p>
        </div>
        <div class="one-fourth">
            <h4>And some more...</h4>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu.</p>
        </div>
        <div class="one-fourth-last">
            <h4>Well four wil do!</h4>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu.</p>
        </div>
        <div class="spacer"></div>
        <div class="one-third">
            <h1>Heading</h1>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat.</p>
        </div>
        <div class="one-third">
            <h2>This is a heading</h2>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat.</p>
        </div>
        <div class="one-third-last">
            <h3>This is a heading</h3>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat.</p>
        </div>
        <div class="spacer"></div>
        <div class="one-third">
            <h4>This is a heading</h4>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat.</p>
        </div>
        <div class="one-third">
            <h5>This is a heading</h5>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat.</p>
        </div>
        <div class="one-third-last">
            <h6>This is a heading</h6>
            <p>Proin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat.</p>
        </div>
        <div class="spacer"></div>
        <div class="one-third">
            <p><span class="dropcap">P</span>roin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat.</p>
        </div>
        <div class="one-third">
            <p><span class="dropcap">Z</span>roin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat.</p>
        </div>
        <div class="one-third-last">
            <p><span class="dropcap">V</span>roin vel interdum massa. Nunc pharetra vehicula erat, in faucibus orci porttitor ultricies. Pellentesque id fringilla justo. Suspendisse ut suscipit nisl. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut a velit id leo eleifend ullamcorper. Ut nulla odio, luctus sit amet volutpat ac, dapibus et ligula. Sed quis convallis sapien. Morbi sodales aliquet tortor, id lacinia nisl aliquet eu. Sed dapibus, magna et malesuada tempor, enim tortor hendrerit diam, vitae suscipit nibh felis vitae erat.</p>
        </div>
        <div class="spacer"></div>
        <div class="one-third">
            <ul class="styled-list-check">
                <h5>The checklist:</h5>
                <li>This is the first item</li>
                <li>This is the second item</li>
                <li>This is the third item</li>
                <li>This is the fourth item</li>
            </ul>
        </div>
        <div class="one-third">
            <ul class="styled-list-star">
                <h5>The checklist:</h5>
                <li>This is the first item</li>
                <li>This is the second item</li>
                <li>This is the third item</li>
                <li>This is the fourth item</li>
            </ul>
        </div>
        <div class="one-third-last">
            <ul class="styled-list-dot">
                <h5>The checklist:</h5>
                <li>This is the first item</li>
                <li>This is the second item</li>
                <li>This is the third item</li>
                <li>This is the fourth item</li>
            </ul>
        </div>
    </div>
    <!--This is the END of the features-->
    <div class="spacer"></div>
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<%--<jsp:include page="tools/panel.jsp"></jsp:include>--%>


</body>

</html>