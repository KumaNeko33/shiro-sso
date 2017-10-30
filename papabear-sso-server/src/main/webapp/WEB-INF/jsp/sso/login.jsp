<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<title>权限管理系统</title>--%>
    <title>登录</title>

    <link href="${basePath}/resources/papabear-admin/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/papabear-admin/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/papabear-admin/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/papabear-admin/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/papabear-admin/plugins/checkbix/css/checkbix.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/papabear-admin/css/login.css" rel="stylesheet"/>
</head>
<body>
<div class="content">
    <a class="index_black" href="###"><img src="http://fe.ibaixiong.com/common/image/logo01.png" class="indexlogo"></a>
    <div id="login-window" class="content-login">
        <img src="${basePath}/resources/papabear-admin/images/baixiong.png" class="baixiong">
        <div class="row linkhov">
            <a href="#" style="margin: 0 auto;" class="loginlink on">登录</a>
            <!-- <a href="http://user.ibaixiong.com/register.html" class="registerlink">注册</a> -->
        </div>
        <form id="loginData" >
            <div class="row">
                <input id="username" name="username" class="username" tabindex="1" placeholder="帐号" type="text" value="" size="25" autocomplete="off" data-form-un="1508467631551.09">

                <p class="remind name-null"></p>
                <%--<p class="remind format">手机格式错误</p>--%>
            </div>
            <div class="row">
                <input id="password" name="password" class="userpassword" tabindex="2" placeholder="密码" type="password" value="" size="25" autocomplete="off" data-form-pw="1508467631551.09">
                <p class="remind pass-null"></p>
            </div>
            <%--<div class="row coderow">--%>
            <%--<input id="captcha" name="captcha" class="code" tabindex="3" placeholder="验证码" type="text" value="" size="25" data-form-vc="1508467631551.09">--%>
            <%--<a id="changeCaptcha" href="javascript:void(0);"><img class="code-image" id="kaptcha" src="kaptcha.jpg"></a>--%>
            <%--<img class="code-image" id="kaptcha" src="kaptcha.jpg">--%>
            <%--</div>--%>
            <p><a href="http://user.ibaixiong.com/findpwd.html" class="forgetpassword link">忘记密码？</a><a id="changeCaptcha" href="javascript:void(0);" class="changecode link">看不清，换一个？</a> </p>
            <%--<div class="input-group m-b-20">--%>
            <%--<span class="input-group-addon"><i class="zmdi zmdi-account"></i></span>--%>
            <%--<div class="fg-line">--%>
            <%--<input id="username" type="text" class="form-control" name="username" placeholder="帐号" required autofocus value="admin">--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--<div class="input-group m-b-20">--%>
            <%--<span class="input-group-addon"><i class="zmdi zmdi-male"></i></span>--%>
            <%--<div class="fg-line">--%>
            <%--<input id="password" type="password" class="form-control" name="password" placeholder="密码" required value="123456">--%>
            <%--</div>--%>
            <%--</div>--%>
            <div class="clearfix">
            </div>
            <div class="checkbox">
                <input id="rememberMe" type="checkbox" class="checkbix" data-text="自动登录" name="rememberMe">
            </div>
            <%--<a id="login-bt" href="javascript:;" class="waves-effect waves-button waves-float"><i class="zmdi zmdi-arrow-forward"></i></a>--%>
            <div class="row">
                <input id="login-bt" type="submit" class="loginbtn" value="登录" data-form-sbm="1508467631551.09" style="pointer-events: auto;">
            </div>
        </form>
        <div class="row security_user">
            <a href="https://graph.qq.com/oauth2.0/authorize?response_type=code&amp;client_id=101294624&amp;client_secret=75d66638517e45649b6ca105e3cc8e47&amp;redirect_uri=http%3A%2F%2Flogin.ibaixiong.com%2Flogin%3Fclient_name%3DTencentClient&amp;state=mixiTcapM4&amp;scope=get_user_info" class="qq-link"><img src="${basePath}/resources/papabear-admin/images/qq2.png"> </a>
            <a href="https://open.weixin.qq.com/connect/qrconnect?appid=wx4ab8a369dd06a258&amp;redirect_uri=http%3A%2F%2Flogin.ibaixiong.com%2Flogin%3Fclient_name%3DWeiXinClient&amp;response_type=code&amp;scope=snsapi_login&amp;state=cAWKkYAprq" class="wx-link"><img src="${basePath}/resources/papabear-admin/images/wx.png"> </a>
            <!--MOB SHARE BEGIN 分享界面-->
            <%--<div class="-mob-share-ui-button -mob-share-open">分享</div>--%>
            <%--<div class="-mob-share-ui" style="display: none">--%>
                <%--<ul class="-mob-share-list">--%>
                    <%--<li class="-mob-share-weibo"><p>新浪微博</p></li>--%>
                    <%--<li class="-mob-share-qzone"><p>QQ空间</p></li>--%>
                    <%--<li class="-mob-share-qq"><p>QQ好友</p></li>--%>
                    <%--<li class="-mob-share-douban"><p>豆瓣</p></li>--%>
                    <%--<li class="-mob-share-facebook"><p>Facebook</p></li>--%>
                    <%--<li class="-mob-share-twitter"><p>Twitter</p></li>--%>
                <%--</ul>--%>
                <%--<div class="-mob-share-close">取消</div>--%>
            <%--</div>--%>
            <%--<div class="-mob-share-ui-bg"></div>--%>
            <%--<script id="-mob-share" src="http://f1.webshare.mob.com/code/mob-share.js?appkey=21e30a96a5644"></script>--%>
            <!--MOB SHARE END-->
        </div>
    </div>
    <p class="copyright">2015 Hangzhou Baixiong Technology Co.Ltd。ALLrights reserver. 备案号：浙ICP备15024007号-1. <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=33010402000428" style="display:inline-block;text-decoration:none;height:20px;line-height:20px;color:#999;"><img src="http://fe.ibaixiong.com/common/image/ghs.png" style="float:left;">浙公网安备 33010402000428号</a></p>
</div>
<script src="${basePath}/resources/papabear-admin/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/papabear-admin/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/resources/papabear-admin/plugins/waves-0.7.5/waves.min.js"></script>
<script src="${basePath}/resources/papabear-admin/plugins/checkbix/js/checkbix.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script>var BASE_PATH = '${basePath}';</script>
<script>var BACK_URL = '${param.backurl}';</script>
<script src="${basePath}/resources/papabear-admin/js/login.js"></script>
<script>
<c:if test="${param.forceLogout == 1}">
alert('您已被强制下线！');
top.location.href = '${basePath}/sso/login';
</c:if>
//解决iframe下系统超时无法跳出iframe框架的问题
if (window != top){
    top.location.href = location.href;
}
</script>
</body>
</html>
