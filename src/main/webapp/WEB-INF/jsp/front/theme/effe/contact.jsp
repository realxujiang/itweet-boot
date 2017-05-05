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
    <title>Contact</title>
    <jsp:include page="tools/style.jsp"></jsp:include>
    <!-- Load contact check -->
    <script type="text/javascript">
        function MM_validateForm() { //v4.0
            if(document.getElementById) {
                var i, p, q, nm, test, num, min, max, errors = '',
                        args = MM_validateForm.arguments;
                for(i = 0; i < (args.length - 2); i += 3) {
                    test = args[i + 2];
                    val = document.getElementById(args[i]);
                    if(val) {
                        nm = val.name;
                        if((val = val.value) != "") {
                            if(test.indexOf('isEmail') != -1) {
                                p = val.indexOf('@');
                                if(p < 1 || p == (val.length - 1)) errors += '- ' + nm + ' must contain an e-mail address.\n';
                            } else if(test != 'R') {
                                num = parseFloat(val);
                                if(isNaN(val)) errors += '- ' + nm + ' must contain a number.\n';
                                if(test.indexOf('inRange') != -1) {
                                    p = test.indexOf(':');
                                    min = test.substring(8, p);
                                    max = test.substring(p + 1);
                                    if(num < min || max < num) errors += '- ' + nm + ' must contain a number between ' + min + ' and ' + max + '.\n';
                                }
                            }
                        } else if(test.charAt(0) == 'R') errors += '- ' + nm + ' is required.\n';
                    }
                }
                if(errors) alert('We are sorry, but there is an error:\n' + errors);
                document.MM_returnValue = (errors == '');
            }
        }
    </script>
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
            <h4>Drop us a line, we don't bite!</h4>
            <h6><a href="<%=URL%>/">Home</a> → Contact Us</h6>
        </div>
    </div>
</div>
<!--END of header-->

<!--This is the START of the menu-->
<jsp:include page="tools/menu.jsp"></jsp:include>


<!--This is the START of the content-->
<div id="content">
    <!--This is the START of the contact section-->
    <div id="contact">
        <h5 style="margin-top:10px;font-family: STXingkai">联系我们</h5>
        <p>你可以通过以下方式联系我们，我们收到邮件会回复你!</p>
        <form name="contact" action="scripts/contact.php" id="contactform" method="post">
            <div class="boxes">
                <h6>名称<span class="required">*</span></h6>
                <div class="box">
                    <input name="name" type="text" class="input" id="sender_name" />
                </div>
                <h6>邮箱<span class="required">*</span></h6>
                <div class="box">
                    <input name="email" type="text" class="input" id="sender_email" />
                </div>
                <h6>消息</h6>
                <div class="msgbox">
                    <textarea name="cf_message" rows="50" cols="30" class="message" id="cf_message"></textarea>
                </div>
                <div class="submitbtn">
                    <input type="submit" class="button btncolor" onClick="MM_validateForm('sender_name','','R');MM_validateForm('sender_email','','RisEmail');return document.MM_returnValue" value="发送邮件" />
                </div>
            </div>
        </form>
    </div>
    <div id="contactinfo">
        <h5 style="font-family: STXingkai">我们的地址:</h5>
        <p>中国&北京</p>
        <p>海淀区西二旗</p>
        <p>邮政编码100000</p>
        <br />
        <h5 style="font-family: STXingkai">我们的联系信息</h5>
        <p>QQ 群1: 457710636</p>
        <p>QQ 群2: 288396468</p>
        <br />
        <h5 style="font-family: STXingkai">我们的网络ID</h5>
        <div class="dribbble">
            <a href="http://weibo.com/sparkjvm">微博</a>
        </div>
        <div class="google">
            <a href="http://www.tudou.com/home/sparkjvm">土豆视频</a>
        </div>
        <div class="twitter_small">
            <a href="https://github.com/itweet">Follow on Github</a>
        </div>
        <div class="facebook_small">
            <a href="http://www.itweet.cn">Follow on Itweet-Boot</a>
        </div>
    </div>
    <!--END of contact section-->
</div>
<!--END of content-->

<!--This is the START of the follow section-->
<%--<jsp:include page="tools/panel.jsp"></jsp:include>--%>

</body>

</html>