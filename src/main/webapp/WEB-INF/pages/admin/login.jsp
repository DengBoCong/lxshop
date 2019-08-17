<%--
  Created by IntelliJ IDEA.
  User: Power
  Date: 2019/8/16
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" +
            request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>丽星平台 | 登录</title>
    <link href="<%=basePath%>/static/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/ladda/ladda-themeless.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/style.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="loginColumns animated fadeInDown">
    <div class="row">
        <div class="col-md-6">
            <h2 class="font-bold">欢迎使用丽星家具平台</h2>
            <p>
                打造全国一体化在线家具交易平台，实现线上下辖一体化的自由交易模式，安全、便捷、快捷.
            </p>
            <p>
                O2O综合家居购物平台，提供美式家具，欧式家具，韩式家具，现代家具，中式家具，儿童家具，美国进口床垫，建材，家纺，家电等商品。全球采购，正品保证，限时送达，售后无忧，万千家庭共同选择！
            </p>
            <p>
                一站式家居装修建材家具生活服务平台。是中国最大、最专业、最诚信的家居家具网上商城。
            </p>
            <p>
                <small>定制家具品牌尚品宅配官方网上商城--新居网，整体定制家具直销网。提供卧房、厨房、书房、客厅、餐厅的全屋家具定制服务。</small>
            </p>
        </div>
        <div class="col-md-6">
            <div class="ibox-content">
                <form class="m-t" role="form" action="index.html">
                    <div class="form-group">
                        <input id="mobile" type="text" class="form-control" placeholder="请输入登录账号" required="" value="">
                    </div>
                    <div class="form-group">
                        <input id="password" type="password" class="form-control" placeholder="请输入登录密码" required="" value="">
                    </div>
                    <button type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">登录</button>
                    <a id="forget" href="#">
                        <small>忘记密码?</small>
                    </a>
                    <p class="text-muted text-center">
                        <small>你目前还没有工作人员账号?</small>
                    </p>
                    <button type="button" id="create" class="btn btn-sm btn-white btn-block">申请创建一个账号</button>
                </form>
                <p class="m-t">
                    <small>丽星家具商城系统工作人员登录入口</small>
                </p>
            </div>
        </div>
    </div>
    <hr />
    <div class="row">
        <div class="col-md-6">
            江西陌梦教育科技有限公司保留所有权利
        </div>
        <div class="col-md-6 text-right">
            <small>&copy; 2019</small>
        </div>
    </div>
</div>
<script src="<%=basePath%>/static/admin/js/jquery-2.1.1.js"></script>
<script src="<%=basePath%>/static/admin/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<script src="<%=basePath%>/static/admin/js/inspinia.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/pace/pace.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/spin.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/ladda.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/ladda.jquery.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="<%=basePath%>/pages/adminJs/login.js"></script>
</body>
</html>
