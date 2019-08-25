<%--
  Created by IntelliJ IDEA.
  User: Power
  Date: 2019/8/25
  Time: 12:15
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
    <title>丽星平台 | 片区负责人</title>
    <link href="<%=basePath%>/static/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/codemirror/codemirror.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/codemirror/ambiance.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/ladda/ladda-themeless.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/style.css" rel="stylesheet">
    <script src="<%=basePath%>/static/admin/js/jquery-2.1.1.js"></script>
</head>
<body class="fixed-sidebar no-skin-config full-height-layout">
<div id="wrapper">
    <%@include file="../navigation.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <%@include file="../header.jsp"%>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>片区负责人</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="<%=basePath%>/Admin/Summary/Profile">首页</a>
                    </li>
                    <li>
                        <a>片区管理</a>
                    </li>
                    <li class="active">
                        <strong>片区负责人</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>
        <div class="fh-breadcrumb">
            <div class="fh-column">
                <div class="full-height-scroll">
                    <ul class="list-group elements-list">
                        <c:forEach items="${AreaList}" var="items">
                            <li class="list-group-item">
                                <a data-toggle="tab" href="#tab-${items.principalId}">
                                    <small class="pull-right text-muted"> ${items.addTime.toLocaleString()}</small>
                                    <strong>${items.name}</strong>
                                    <div class="small m-t-xs">
                                        <p>
                                                ${items.description}
                                        </p>
                                        <p class="m-b-none">
                                            <i class="fa fa-user"></i> 经销商数 ${items.userCount}
                                            <i class="fa fa-group"></i> 业务员数 ${items.salesmanCount}
                                        </p>
                                    </div>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="full-height">
                <div class="full-height-scroll white-bg border-left">
                    <div class="element-detail-box">
                        <div class="tab-content">
                            <c:forEach items="${SalesmanTopList}" var="items">
                                <div id="tab-${items.id}" class="tab-pane">
                                    <div class="small text-muted">
                                        <i class="fa fa-clock-o"></i> Friday, 12 April 2014, 12:32 am
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">头像</label>
                                        <div class="col-sm-4"><img class="img-circle" width="100px" height="100px" src="${items.image}"></div>
                                        <div class="col-sm-4">
                                            <c:if test="${items.status == 0}">
                                                <i class="fa fa-times text-navy"></i>
                                            </c:if>
                                            <c:if test="${items.status == 1}">
                                                <i class="fa fa-check text-navy"></i>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">姓名</label>
                                        <div class="col-sm-10">${items.name}</div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">手机号</label>
                                        <div class="col-sm-10">${items.mobile}</div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">邮箱</label>
                                        <div class="col-sm-10">${items.email}</div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">身份证号</label>
                                        <div class="col-sm-10">${items.idCard}</div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">下级业务员数量</label>
                                        <div class="col-sm-10">${items.lowerCount}</div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">所在省市</label>
                                        <div class="col-sm-4">${items.province}</div>
                                        <div class="col-sm-4">${items.city}</div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">个人简述</label>
                                        <div class="col-sm-10">${items.province}</div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">身份证正反面</label>
                                        <div class="col-sm-4">${items.idcardFphoto}</div>
                                        <div class="col-sm-4">${items.idcardBphoto}</div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../footer.jsp"%>
    </div>
</div>
<script src="<%=basePath%>/static/admin/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/spin.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/ladda.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/ladda.jquery.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="<%=basePath%>/static/admin/js/inspinia.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/pace/pace.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/pages/adminJs/areaPrincipal.js"></script>
</body>
</html>

