<%--
  Created by IntelliJ IDEA.
  User: Power
  Date: 2019/8/24
  Time: 23:06
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
    <title>丽星平台 | 片区划分</title>
    <link href="<%=basePath%>/static/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="<%=basePath%>/static/admin/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/ladda/ladda-themeless.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/style.css" rel="stylesheet">
    <script src="<%=basePath%>/static/admin/js/jquery-2.1.1.js"></script>
</head>
<body>
<div id="wrapper">
    <%@include file="../navigation.jsp"%>
    <div id="page-wrapper" class="gray-bg">
        <%@include file="../header.jsp"%>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>片区划分</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="<%=basePath%>/Admin/Summary/Profile">首页</a>
                    </li>
                    <li>
                        <a>片区管理</a>
                    </li>
                    <li class="active">
                        <strong>片区划分</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>
        <div id="areaListContent" class="wrapper wrapper-content animated fadeInRight">
            <button type="button" class="btn btn-primary center-block" data-toggle="modal" data-target="#addModal">添加</button>
            <div class="modal inmodal" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content animated bounceInRight">
                        <div class="modal-header">
                            <button id="addCloseButton" type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                            <i class="fa fa-laptop modal-icon"></i>
                            <h4 class="modal-title">添加片区</h4>
                            <small class="font-bold">添加片区信息时，请仔细核对内容信息，一经添加，将同步全系统数据库！</small>
                        </div>
                        <div class="modal-body">
                            <div class="form-group"><label>片区名称</label> <input id="areaName" type="text" placeholder="请输入片区名称" class="form-control" value=""></div>
                            <div class="form-group"><label>片区简短描述</label> <input id="areaDescription" type="text" placeholder="请输入片区简短描述" class="form-control" value=""></div>
                            <div class="form-group">
                                <label>选择顶级业务员(注：若选择非顶级业务员，则其上级信息将全部清空)</label>
                                <select id="areaSalesman" class="form-control m-b" name="account">
                                    <option value="0" selected="selected">请选择片区负责人</option>
                                    <c:forEach items="${SalesmanList}" var="items">
                                        <c:if test="${items.pid == 0}">
                                            <option value="${items.id}">${items.uName}(顶级业务员)</option>
                                        </c:if>
                                        <c:if test="${items.pid != 0}">
                                            <option value="${items.id}">${items.uName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button id="addAreaInfo" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">提交</button>
                        </div>
                    </div>
                </div>
            </div>
            <c:forEach items="${AreaList}" var="items">
                <div id="areaBox${items.id}" class="ibox">
                    <div class="ibox-title">
                        <button data-id="${items.id}" type="button" class="btn btn-primary pull-right modifyAreaInfo" data-toggle="modal" data-target="#myModal">修改</button>
                        <button data-id="${items.id}" type="button" class="btn btn-primary pull-right deleteAreaInfo">删除</button>
                        <h5>IT-${items.id} - Team</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="team-members">
                            <c:if test="${items.principalId == 0}">
                                <a href="#">该片区暂无负责人<i class="fa fa-exclamation-circle"></i>点击修改设置负责人</a>
                            </c:if>
                            <c:if test="${items.principalId != 0}">
                                <a href="#">${items.ownerName}<img alt="暂无负责人头像" class="img-circle" src="${items.ownerImage}"></a>
                            </c:if>
                        </div>
                        <h4>${items.name}</h4>
                        <p>
                            ${items.description}
                        </p>
                        <div>
                            <span>占总业务员人数百分比</span>
                            <div class="stat-percent">${items.countPrecent} %</div>
                            <div class="progress progress-mini">
                                <div style="width: ${items.countPrecent}%;" class="progress-bar"></div>
                            </div>
                        </div>
                        <div class="row  m-t-sm">
                            <div class="col-sm-4">
                                <div class="font-bold">业务员人数</div>
                                ${items.salesmanCount}
                            </div>
                            <div class="col-sm-4">
                                <div class="font-bold">经销商人数</div>
                                ${items.userCount}
                            </div>
                            <div class="col-sm-4 text-right">
                                <div class="font-bold">创建时间</div>
                                ${items.addTime.toLocaleString()} <i class="fa fa-level-up text-navy"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content animated bounceInRight">
                        <div class="modal-header">
                            <button id="modifyCloseButton" type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                            <i class="fa fa-laptop modal-icon"></i>
                            <h4 class="modal-title">修改片区</h4>
                            <small class="font-bold">修改片区信息时，请仔细核对内容信息，一经添加，将同步全系统数据库！</small>
                        </div>
                        <div class="modal-body">
                            <div class="form-group"><label>片区名称(留空则不修改)</label> <input id="modifyAreaName" type="text" placeholder="请输入片区名称" class="form-control" value=""></div>
                            <div class="form-group"><label>片区简短描述(留空则不修改)</label> <input id="modifyAreaDescription" type="text" placeholder="请输入片区简短描述" class="form-control" value=""></div>
                            <div class="form-group">
                                <label>选择顶级业务员(注：若选择非顶级业务员，则其上级信息将全部清空，不能留空)</label>
                                <select id="modiffyAreaSalesman" class="form-control m-b" name="account">
                                    <option value="0" selected="selected">请选择片区负责人</option>
                                    <c:forEach items="${SalesmanList}" var="items">
                                        <c:if test="${items.pid == 0}">
                                            <option value="${items.id}">${items.uName}(顶级业务员)</option>
                                        </c:if>
                                        <c:if test="${items.pid != 0}">
                                            <option value="${items.id}">${items.uName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button id="modiffyAreaInfoSubmit" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">提交</button>
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
<script type="text/javascript" src="<%=basePath%>/pages/adminJs/areaDivide.js"></script>
</body>
</html>

