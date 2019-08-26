<%--
  Created by IntelliJ IDEA.
  User: Power
  Date: 2019/8/25
  Time: 16:48
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
    <title>丽星平台 | 业务员详情</title>
    <link href="<%=basePath%>/static/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/cropper/cropper.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/touchspin/jquery.bootstrap-touchspin.min.css" rel="stylesheet">
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
                <h2>业务员详情</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="<%=basePath%>/Admin/Summary/Profile">首页</a>
                    </li>
                    <li>
                        <a>片区管理</a>
                    </li>
                    <li>
                        <a>片区业务员</a>
                    </li>
                    <li class="active">
                        <strong>业务员详情</strong>
                    </li>
                </ol>
            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight ecommerce">
            <div class="row">
                <div class="col-lg-12">
                    <div class="tabs-container">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#tab-1"> 详情数据</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-2"> 上传头像</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-3"> 身份证正反面</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="tab-1" class="tab-pane active">
                                <div class="panel-body">
                                    <fieldset class="form-horizontal">
                                        <div class="form-group"><label class="col-sm-2 control-label">业务员手机号(即登录账号):</label>
                                            <div class="col-sm-10">${SalesmanInfo.mobile}</div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">(可留空，即保留原登录账号):</label>
                                            <div class="col-sm-10"><input id="salesmanMobile" type="text" class="form-control" placeholder="填入新手机号" value=""></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">业务员名称:</label>
                                            <div class="col-sm-10"><input id="salesmanName" type="text" class="form-control" placeholder="请输入业务员名称" value="${SalesmanInfo.uName}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">身份证号:</label>
                                            <div class="col-sm-10"><input id="salesmanIdCard" type="text" class="form-control" placeholder="请输入身份证号" value="${SalesmanInfo.idCard}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">选择所在省:</label>
                                            <div class="col-sm-10">
                                                <select id="salesmanProvince" class="form-control m-b" name="account">
                                                    <option value="0" selected="selected">请选择省</option>
                                                    <c:forEach items="${ProvinceList}" var="items">
                                                        <option value="${items.id}">${items.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">选择所在市:</label>
                                            <div class="col-sm-10">
                                                <select id="salesmanCity" class="form-control m-b" name="account">
                                                    <option value="0" selected="selected">请选择市</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">选择所属片区:</label>
                                            <div class="col-sm-10">
                                                <select id="salesmanArea" class="form-control m-b" name="account">
                                                    <option value="0" selected="selected">请选择片区</option>
                                                    <c:forEach items="${AreaList}" var="items">
                                                        <option value="${items.id}">${items.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">选择上级:</label>
                                            <div class="col-sm-10">
                                                <select id="salesmanPid" class="form-control m-b" name="account">
                                                    <option value="0" selected="selected">请选择上级业务员,若为顶级业务员可不选</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">选择类别:</label>
                                            <div class="col-sm-10">
                                                <select id="salesmanKind" class="form-control m-b" name="account">
                                                    <option value="3" selected="selected">顶级业务员</option>
                                                    <option value="1">经销商业务员</option>
                                                    <option value="2">厂商业务员</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">状态:</label>
                                            <div class="col-sm-10">
                                                <select id="salesmanStatus" class="form-control m-b" name="account">
                                                    <option value="1" selected="selected">正常</option>
                                                    <option value="0">禁止登陆</option>
                                                </select>
                                            </div>
                                        </div>
                                        <button id="modifySalesmanInfo" data-id="${SALESMAN_ID}" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">提交</button>
                                    </fieldset>
                                </div>
                            </div>
                            <div id="tab-2" class="tab-pane">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <c:if test="${SalesmanInfo.image.equals(\" \")}">
                                                <div id="imageImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${!SalesmanInfo.image.equals(\" \")}">
                                                <div id="imageImage" class="image-crop">
                                                    <img src="${SalesmanInfo.image}">
                                                </div>
                                            </c:if>
                                        </div>
                                        <div class="col-md-6">
                                            <h4>效果图</h4>
                                            <div id="imagePreviewImg" class="img-preview img-preview-sm"></div>
                                            <h4>注意说明</h4>
                                            <p>
                                                请注意效果图会有一定的质量损失，放大缩小时同样存在质量损失。
                                            </p>
                                            <div class="btn-group">
                                                <label title="Upload image file" for="imageInputImage" class="btn btn-primary">
                                                    <input type="file" accept="image/*" name="file" id="imageInputImage" class="hide">
                                                    选择图片
                                                </label>
                                            </div>
                                            <div class="btn-group">
                                                <button class="btn btn-white" id="imageZoomIn" type="button">放大</button>
                                                <button class="btn btn-white" id="imageZoomOut" type="button">缩小</button>
                                                <button data-id="${SALESMAN_ID}" class="btn btn-primary"id="imageUpload" type="button" disabled="disabled">上传</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="tab-3" class="tab-pane">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <c:if test="${SalesmanInfo.idcardFphoto.equals(\" \")}">
                                                <div id="coverImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${!SalesmanInfo.idcardFphoto.equals(\" \")}">
                                                <div id="coverImage" class="image-crop">
                                                    <img src="${SalesmanInfo.idcardFphoto}">
                                                </div>
                                            </c:if>
                                        </div>
                                        <div class="col-md-6">
                                            <h4>效果图</h4>
                                            <div id="coverPreviewImg" class="img-preview img-preview-sm"></div>
                                            <h4>注意说明</h4>
                                            <p>
                                                请注意效果图会有一定的质量损失，放大缩小时同样存在质量损失。
                                            </p>
                                            <div class="btn-group">
                                                <label title="Upload image file" for="coverInputImage" class="btn btn-primary">
                                                    <input type="file" accept="image/*" name="file" id="coverInputImage" class="hide">
                                                    选择图片
                                                </label>
                                            </div>
                                            <div class="btn-group">
                                                <button class="btn btn-white" id="coverZoomIn" type="button">放大</button>
                                                <button class="btn btn-white" id="coverZoomOut" type="button">缩小</button>
                                                <button data-id="${SALESMAN_ID}" class="btn btn-primary"id="coverUpload" type="button" disabled="disabled">上传</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <c:if test="${SalesmanInfo.idcardBphoto.equals(\" \")}">
                                                <div id="recommendImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${!SalesmanInfo.idcardBphoto.equals(\" \")}">
                                                <div id="recommendImage" class="image-crop">
                                                    <img src="${SalesmanInfo.idcardBphoto}">
                                                </div>
                                            </c:if>
                                        </div>
                                        <div class="col-md-6">
                                            <h4>效果图</h4>
                                            <div id="recommendPreviewImg" class="img-preview img-preview-sm"></div>
                                            <h4>注意说明</h4>
                                            <p>
                                                请注意效果图会有一定的质量损失，放大缩小时同样存在质量损失。
                                            </p>
                                            <div class="btn-group">
                                                <label title="Upload image file" for="recommendInputImage" class="btn btn-primary">
                                                    <input type="file" accept="image/*" name="file" id="recommendInputImage" class="hide">
                                                    选择图片
                                                </label>
                                            </div>
                                            <div class="btn-group">
                                                <button class="btn btn-white" id="recommendZoomIn" type="button">放大</button>
                                                <button class="btn btn-white" id="recommendZoomOut" type="button">缩小</button>
                                                <button data-id="${SALESMAN_ID}" class="btn btn-primary"id="recommendUpload" type="button" disabled="disabled">上传</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
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

<script src="<%=basePath%>/static/admin/js/inspinia.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/pace/pace.min.js"></script>

<script src="<%=basePath%>/static/admin/js/plugins/summernote/summernote.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/summernote/summernote-zh-CN.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/spin.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/ladda.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/ladda.jquery.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/cropper/cropper.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/touchspin/jquery.bootstrap-touchspin.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/pages/adminJs/areaSalesmanDetails.js"></script>
</body>
</html>
