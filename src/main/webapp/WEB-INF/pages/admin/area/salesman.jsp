<%--
  Created by IntelliJ IDEA.
  User: Power
  Date: 2019/8/25
  Time: 15:29
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
    <title>丽星平台 | 片区业务员</title>
    <link href="<%=basePath%>/static/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/dataTables/datatables.min.css" rel="stylesheet">
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
                <h2>片区业务员</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="<%=basePath%>/Admin/Summary/Profile">首页</a>
                    </li>
                    <li>
                        <a>片区管理</a>
                    </li>
                    <li class="active">
                        <strong>片区业务员</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>片区业务员列表</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">刷新</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">添加业务员</button>
                                <a onclick="fnClickAddRow();" href="javascript:void(0);" class="btn btn-success ">下载模板</a>
                                <a onclick="fnClickAddRow();" href="javascript:void(0);" class="btn btn-warning ">批量操作</a>
                            </div>
                            <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content animated bounceInRight">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                                            <i class="fa fa-laptop modal-icon"></i>
                                            <h4 class="modal-title">添加业务员</h4>
                                            <small class="font-bold">添加业务员时，请仔细核对内容信息，一经添加，将同步全系统数据库！</small>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group"><label>业务员名称</label> <input id="salesmanName" type="text" placeholder="请输入业务员名称" class="form-control" value=""></div>
                                            <div class="form-group"><label>手机号</label> <input id="salesmanMobile" type="text" placeholder="请输入手机号" class="form-control" value=""></div>
                                            <div class="form-group"><label>身份证号</label> <input id="salesmanIdCard" type="text" placeholder="请输入身份证号" class="form-control" value=""></div>
                                            <div class="form-group">
                                                <label>选择所在省</label>
                                                <select id="salesmanProvince" class="form-control m-b" name="account">
                                                    <option value="0" selected="selected">请选择省</option>
                                                    <c:forEach items="${ProvinceList}" var="items">
                                                        <option value="${items.id}">${items.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>选择所在市</label>
                                                <select id="salesmanCity" class="form-control m-b" name="account">
                                                    <option value="0" selected="selected">请选择市</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>选择所属片区</label>
                                                <select id="salesmanArea" class="form-control m-b" name="account">
                                                    <option value="0" selected="selected">请选择片区</option>
                                                    <c:forEach items="${AreaList}" var="items">
                                                        <option value="${items.id}">${items.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>选择上级</label>
                                                <select id="salesmanPid" class="form-control m-b" name="account">
                                                    <option value="0" selected="selected">请选择上级业务员,若为顶级业务员可不选</option>
                                                    <%--<c:forEach items="${SalesmanList}" var="items">
                                                        <c:if test="${items.pid == 0}">
                                                            <option value="${items.id}">${items.uName}(顶级业务员)</option>
                                                        </c:if>
                                                        <c:if test="${items.pid != 0}">
                                                            <option value="${items.id}">${items.uName}</option>
                                                        </c:if>
                                                    </c:forEach>--%>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>选择类别</label>
                                                <select id="salesmanKind" class="form-control m-b" name="account">
                                                    <option value="3" selected="selected">顶级业务员</option>
                                                    <option value="1">经销商业务员</option>
                                                    <option value="2">厂商业务员</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>状态</label>
                                                <select id="salesmanStatus" class="form-control m-b" name="account">
                                                    <option value="1" selected="selected">正常</option>
                                                    <option value="0">禁止登陆</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button id="addSalesmanInfo" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">提交</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <table class="table table-striped table-bordered table-hover " id="editable">
                                <thead>
                                <tr>
                                    <th>业务员名称</th>
                                    <th>手机号</th>
                                    <th>所属片区ID</th>
                                    <th>上级ID</th>
                                    <th>身份证号</th>
                                    <th>下级数量</th>
                                    <th>所在省</th>
                                    <th>所在市</th>
                                    <th>类别</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>业务员名称</th>
                                    <th>手机号</th>
                                    <th>所属片区ID</th>
                                    <th>上级ID</th>
                                    <th>身份证号</th>
                                    <th>下级数量</th>
                                    <th>所在省</th>
                                    <th>所在市</th>
                                    <th>类别</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </tfoot>
                            </table>
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
<script src="<%=basePath%>/static/admin/js/plugins/jeditable/jquery.jeditable.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/dataTables/datatables.min.js"></script>

<script src="<%=basePath%>/static/admin/js/inspinia.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/pace/pace.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/spin.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/ladda.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/ladda.jquery.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/cropper/cropper.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/pages/adminJs/areaSalesman.js"></script>
</body>
</html>
