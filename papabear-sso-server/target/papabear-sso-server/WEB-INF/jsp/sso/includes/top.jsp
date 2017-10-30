<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta property="qc:admins" content="36451163711661211017676375" />
    <link href="${basePath}/resources/papabear-admin/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/papabear-admin/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/papabear-admin/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/papabear-admin/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/papabear-admin/plugins/checkbix/css/checkbix.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/papabear-admin/css/login.css" rel="stylesheet" type="text/css">
    <%--<script src="../plug/jQuery/jquery-1.8.3.min.js" type="text/javascript" ></script>--%>
    <script src="${basePath}/resources/papabear-admin/js/login.js" type="text/javascript" ></script>
    <script src="${basePath}/resources/papabear-admin/plugins/jquery.1.12.4.min.js"></script>
    <script src="${basePath}/resources/papabear-admin/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
    <script src="${basePath}/resources/papabear-admin/plugins/waves-0.7.5/waves.min.js"></script>
    <script src="${basePath}/resources/papabear-admin/plugins/checkbix/js/checkbix.min.js"></script>
    <title>登录</title>
</head>
<body> 
<div class="content">
    <a class="index_black" href="http://www.ibaixiong.com"><img src="http://fe.ibaixiong.com/common/image/logo01.png" class="indexlogo"></a>