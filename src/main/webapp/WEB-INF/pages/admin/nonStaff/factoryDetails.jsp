<%--
  Created by IntelliJ IDEA.
  User: Power
  Date: 2019/8/26
  Time: 15:23
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
    <title>丽星平台 | 商品详情</title>
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
                <h2>厂商详情</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="<%=basePath%>/Admin/Summary/Profile">首页</a>
                    </li>
                    <li>
                        <a>非工作人员管理</a>
                    </li>
                    <li>
                        <a>厂商档案</a>
                    </li>
                    <li class="active">
                        <strong>厂商详情</strong>
                    </li>
                </ol>
            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight ecommerce">
            <div class="row">
                <div class="col-lg-12">
                    <div class="tabs-container">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#tab-1"> 综合评估</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-2"> 财务信息</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-3"> 详情数据</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-4"> 头像</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-5"> 营业执照信息</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-6"> 店面实景图</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="tab-1" class="tab-pane active">
                                <div class="panel-body">
                                    <fieldset class="form-horizontal">
                                        <div class="form-group"><label class="col-sm-2 control-label">生产能力:</label>
                                            <div class="col-sm-10">
                                                <textarea id="factoryCapacity" class="form-control" placeholder="填入生产能力" rows="10"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">产品质量:</label>
                                            <div class="col-sm-10">
                                                <textarea id="factoryQuality" class="form-control" placeholder="填入产品质量" rows="10"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">关系稳定性:</label>
                                            <div class="col-sm-10">
                                                <textarea id="factoryStability" class="form-control" placeholder="填入关系稳定性" rows="10"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">经营状况:</label>
                                            <div class="col-sm-10">
                                                <textarea id="factoryCircumstance" class="form-control" placeholder="填入经营状况" rows="10"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">详细报告文件地址:</label>
                                            <div class="col-sm-10">
                                                <textarea id="factoryReport" class="form-control" placeholder="填入详细报告文件地址" rows="10"></textarea>
                                            </div>
                                        </div>

                                        <button id="modifyAnayInfoSubmit" data-id="${AGENCYUSER_ID}" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">提交</button>
                                    </fieldset>
                                </div>
                            </div>
                            <div id="tab-2" class="tab-pane">
                                <div class="panel-body">
                                    <fieldset class="form-horizontal">
                                        <div class="form-group"><label class="col-sm-2 control-label">支付宝账号:</label>
                                            <div class="col-sm-10">${AgencyInfo.alipayAccount}</div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">支付宝账号:</label>
                                            <div class="col-sm-10"><input id="agencyAlipayAcount" type="text" class="form-control" placeholder="填入需要修改支付宝账号" value="${AgencyInfo.alipayAccount}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">银行卡账号:</label>
                                            <div class="col-sm-10"><input id="agencyBankAccount" type="text" class="form-control" placeholder="请输入银行卡账号" value="${AgencyInfo.bankAccount}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">交易验证姓名:</label>
                                            <div class="col-sm-10"><input id="agencyBankName" type="text" class="form-control" placeholder="请输入交易验证姓名" value="${AgencyInfo.bankName}"></div>
                                        </div>

                                        <button id="modifyFinacialInfoSubmit" data-id="${AGENCYUSER_ID}" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">提交</button>
                                    </fieldset>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <c:if test="${AgencyInfo.wechatCode.equals(\" \")}">
                                                <div id="wechatCodeImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${!AgencyInfo.wechatCode.equals(\" \")}">
                                                <div id="wechatCodeImage" class="image-crop">
                                                    <img src="${AgencyInfo.wechatCode}">
                                                </div>
                                            </c:if>
                                        </div>
                                        <div class="col-md-6">
                                            <h4>效果图</h4>
                                            <div id="wechatCodePreviewImg" class="img-preview img-preview-sm"></div>
                                            <h4>注意说明</h4>
                                            <p>
                                                请注意效果图会有一定的质量损失，放大缩小时同样存在质量损失。
                                            </p>
                                            <div class="btn-group">
                                                <label title="Upload image file" for="wechatCodeInputImage" class="btn btn-primary">
                                                    <input type="file" accept="image/*" name="file" id="wechatCodeInputImage" class="hide">
                                                    选择图片
                                                </label>
                                            </div>
                                            <div class="btn-group">
                                                <button class="btn btn-white" id="wechatCodeZoomIn" type="button">放大</button>
                                                <button class="btn btn-white" id="wechatCodeZoomOut" type="button">缩小</button>
                                                <button data-id="${AGENCYUSER_ID}" class="btn btn-primary"id="wechatCodeUpload" type="button" disabled="disabled">上传</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="tab-3" class="tab-pane">
                                <div class="panel-body">
                                    <fieldset class="form-horizontal">
                                        <div class="form-group"><label class="col-sm-2 control-label">经销商名称:</label>
                                            <div class="col-sm-10"><input id="agencyName" type="text" class="form-control" placeholder="填入需要修改商品的新名称" value="${AgencyInfo.name}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">手机号:</label>
                                            <div class="col-sm-10"><input id="agencyMobile" type="text" class="form-control" placeholder="请输入售后说明" value="${AgencyInfo.mobile}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">邮箱号:</label>
                                            <div class="col-sm-10"><input id="agencyEmail" type="text" class="form-control" placeholder="请输入商品种类" value="${AgencyInfo.email}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">详细地址:</label>
                                            <div class="col-sm-10"><input id="agencyAdress" type="text" class="form-control" placeholder="请输入商品型号" value="${AgencyInfo.address}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">选择所在省(当前值${AgencyInfo.province}):</label>
                                            <div class="col-sm-10">
                                                <select id="agencyProvince" class="form-control m-b" name="account">
                                                    <option value="0" selected="selected">请选择省</option>
                                                    <c:forEach items="${ProvinceList}" var="items">
                                                        <option value="${items.id}">${items.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">选择所在市(当前值${AgencyInfo.city}):</label>
                                            <div class="col-sm-10">
                                                <select id="agencyCity" class="form-control m-b" name="account">
                                                    <option value="0" selected="selected">请选择市</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">选择所属片区(当前值${AgencyInfo.areaId}):</label>
                                            <div class="col-sm-10">
                                                <select id="agencyArea" class="form-control m-b" name="account">
                                                    <option value="0" selected="selected">请选择片区</option>
                                                    <c:forEach items="${AreaList}" var="items">
                                                        <option value="${items.id}">${items.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">选择上级(当前值${AgencyInfo.salesmanId}):</label>
                                            <div class="col-sm-10">
                                                <select id="agencyPid" class="form-control m-b" name="account">
                                                    <option value="0" selected="selected">请选择上级业务员,可不选</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">状态:</label>
                                            <div class="col-sm-10">
                                                <select id="agencyStatus" class="form-control m-b" name="account">
                                                    <c:if test="${AgencyInfo.status == 1}">
                                                        <option value="1" selected="selected">正常</option>
                                                        <option value="0">禁止登陆</option>
                                                    </c:if>
                                                    <c:if test="${AgencyInfo.status == 0}">
                                                        <option value="1">正常</option>
                                                        <option value="0" selected="selected">禁止登陆</option>
                                                    </c:if>
                                                </select>
                                            </div>
                                        </div>
                                        <button id="modifyAgencyInfoSubmit" data-id="${AGENCYUSER_ID}" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">提交</button>
                                        <button id="modifyAgencyResetPwd" data-id="${AGENCYUSER_ID}" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">重置密码</button>
                                    </fieldset>
                                </div>
                            </div>
                            <div id="tab-4" class="tab-pane">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <c:if test="${AgencyInfo.avatar.equals(\" \")}">
                                                <div id="coverImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${!AgencyInfo.avatar.equals(\" \")}">
                                                <div id="coverImage" class="image-crop">
                                                    <img src="${AgencyInfo.avatar}">
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
                                                <button data-id="${AGENCYUSER_ID}" class="btn btn-primary"id="coverUpload" type="button" disabled="disabled">上传</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="tab-5" class="tab-pane">
                                <div class="panel-body">
                                    <fieldset class="form-horizontal">
                                        <div class="form-group"><label class="col-sm-2 control-label">营业执照编号:</label>
                                            <div class="col-sm-10"><input id="agencyLicenceNumber" type="text" class="form-control" placeholder="填入需要修改营业执照编号" value="${LicenceInfo.licenceNumber}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">营业执照名称:</label>
                                            <div class="col-sm-10"><input id="agencyLicenceName" type="text" class="form-control" placeholder="请输入营业执照名称" value="${LicenceInfo.licenceName}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">法人代表:</label>
                                            <div class="col-sm-10"><input id="agencyLegalPerson" type="text" class="form-control" placeholder="请输入法人代表" value="${LicenceInfo.legalPerson}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">法人联系方式:</label>
                                            <div class="col-sm-10"><input id="agencyLegalPersonTel" type="text" class="form-control" placeholder="请输入法人联系方式" value="${LicenceInfo.legalPersonTel}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">法人身份证号:</label>
                                            <div class="col-sm-10"><input id="agencyLegalPersonIdCard" type="text" class="form-control" placeholder="请输入法人身份证号" value="${LicenceInfo.legalPersonIdcard}"></div>
                                        </div>
                                        <button id="modifyLicenceInfoSubmit" data-id="${AgencyInfo.licenceId}" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">修改</button>
                                    </fieldset>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <c:if test="${LicenceInfo.legalPersonFphoto.equals(\" \")}">
                                                <div id="recommendImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${LicenceInfo.legalPersonFphoto == null}">
                                                <div id="recommendImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${!LicenceInfo.legalPersonFphoto.equals(\" \")}">
                                                <div id="recommendImage" class="image-crop">
                                                    <img src="${LicenceInfo.legalPersonFphoto}">
                                                </div>
                                            </c:if>
                                        </div>
                                        <div class="col-md-6">
                                            <h4>身份证正面效果图</h4>
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
                                                <button data-id="${AGENCYUSER_ID}" class="btn btn-primary"id="recommendUpload" type="button" disabled="disabled">上传</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <c:if test="${LicenceInfo.legalPersonBphoto.equals(\" \")}">
                                                <div id="personBphotoImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${LicenceInfo.legalPersonBphoto == null}">
                                                <div id="personBphotoImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${!LicenceInfo.legalPersonBphoto.equals(\" \")}">
                                                <div id="personBphotoImage" class="image-crop">
                                                    <img src="${LicenceInfo.legalPersonBphoto}">
                                                </div>
                                            </c:if>
                                        </div>
                                        <div class="col-md-6">
                                            <h4>身份证反面效果图</h4>
                                            <div id="personBphotoPreviewImg" class="img-preview img-preview-sm"></div>
                                            <h4>注意说明</h4>
                                            <p>
                                                请注意效果图会有一定的质量损失，放大缩小时同样存在质量损失。
                                            </p>
                                            <div class="btn-group">
                                                <label title="Upload image file" for="personBphotoInputImage" class="btn btn-primary">
                                                    <input type="file" accept="image/*" name="file" id="personBphotoInputImage" class="hide">
                                                    选择图片
                                                </label>
                                            </div>
                                            <div class="btn-group">
                                                <button class="btn btn-white" id="personBphotoZoomIn" type="button">放大</button>
                                                <button class="btn btn-white" id="personBphotoZoomOut" type="button">缩小</button>
                                                <button data-id="${AGENCYUSER_ID}" class="btn btn-primary"id="personBphotoUpload" type="button" disabled="disabled">上传</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <c:if test="${LicenceInfo.licencePhoto.equals(\" \")}">
                                                <div id="licencePhotoImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${LicenceInfo.licencePhoto == null}">
                                                <div id="licencePhotoImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${!LicenceInfo.licencePhoto.equals(\" \")}">
                                                <div id="licencePhotoImage" class="image-crop">
                                                    <img src="${LicenceInfo.licencePhoto}">
                                                </div>
                                            </c:if>
                                        </div>
                                        <div class="col-md-6">
                                            <h4>营业执照效果图</h4>
                                            <div id="licencePhotoPreviewImg" class="img-preview img-preview-sm"></div>
                                            <h4>注意说明</h4>
                                            <p>
                                                请注意效果图会有一定的质量损失，放大缩小时同样存在质量损失。
                                            </p>
                                            <div class="btn-group">
                                                <label title="Upload image file" for="licencePhotoInputImage" class="btn btn-primary">
                                                    <input type="file" accept="image/*" name="file" id="licencePhotoInputImage" class="hide">
                                                    选择图片
                                                </label>
                                            </div>
                                            <div class="btn-group">
                                                <button class="btn btn-white" id="licencePhotoZoomIn" type="button">放大</button>
                                                <button class="btn btn-white" id="licencePhotoZoomOut" type="button">缩小</button>
                                                <button data-id="${AGENCYUSER_ID}" class="btn btn-primary"id="licencePhotoUpload" type="button" disabled="disabled">上传</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="tab-6" class="tab-pane">
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#photoModal">添加实景图片</button>
                                        <div class="modal inmodal" id="photoModal" tabindex="-1" role="dialog" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content animated bounceInRight">
                                                    <div class="modal-header">
                                                        <button id="photoAddCloseButton" type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                                                        <i class="fa fa-laptop modal-icon"></i>
                                                        <h4 class="modal-title">添加实景图片</h4>
                                                        <small class="font-bold">添加实景图片时，请仔细核对内容信息，一经添加，将同步全系统数据库！</small>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-group"><label>实景图片排序</label> <input id="goodPhotoSort" type="text" placeholder="请输入实景图片排序(默认1)" class="form-control" value="1"></div>
                                                        <div class="btn-group">
                                                            <label title="Upload image file" for="goodPhotoInputImage" class="btn btn-primary">
                                                                <input type="file" accept="image/*" name="file" id="goodPhotoInputImage" class="hide">
                                                                选择图片
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button id="goodPhotoSubmit" data-id="${AGENCYUSER_ID}" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b" disabled="disabled"  data-style="zoom-in">提交</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <table class="table table-bordered table-stripped">
                                            <thead>
                                            <tr>
                                                <th>预览图</th>
                                                <th>图片地址</th>
                                                <th>排序</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody id="tableCommodityPhoto">
                                            <c:forEach items="${AgencyPhotoList}" var="items">
                                                <tr id="commodityPhotoTr${items.id}">
                                                    <td><img width="100px" height="100px" src="${items.images}"></td>
                                                    <td><input type="text" class="form-control" disabled value="${items.images}"></td>
                                                    <td><input id="commodityPhotoSort${items.id}" type="text" class="form-control" value="${items.sort}"></td>
                                                    <td>
                                                        <button data-id="${items.id}" class="btn btn-white commodityPhotoDelete"><i class="fa fa-trash"></i> </button>
                                                        <button data-id="${items.id}" class="btn btn-white commodityPhotoEdit"><i class="fa fa-edit"></i> </button>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
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
<script type="text/javascript" src="<%=basePath%>/pages/adminJs/nonStaffFactoryDetails.js"></script>
</body>
</html>
