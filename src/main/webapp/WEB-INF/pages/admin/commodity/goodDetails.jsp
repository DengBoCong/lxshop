<%--
  Created by IntelliJ IDEA.
  User: Power
  Date: 2019/8/20
  Time: 23:38
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
                <h2>商品详情</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="<%=basePath%>/Admin/Summary/Profile">首页</a>
                    </li>
                    <li>
                        <a>商品</a>
                    </li>
                    <li>
                        <a>商品档案</a>
                    </li>
                    <li class="active">
                        <strong>商品详情</strong>
                    </li>
                </ol>
            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight ecommerce">
            <div class="row">
                <div class="col-lg-12">
                    <div class="tabs-container">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#tab-1"> 电脑端详情</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-2"> 详情数据</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-3"> 封面图</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-4"> 首页推荐图</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-5"> 商品尺寸库存</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-6"> 商品所属分类</a></li>
                            <li class=""><a data-toggle="tab" href="#tab-7"> 商品图片</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="tab-1" class="tab-pane active">
                                <div class="panel-body">
                                    <fieldset class="form-horizontal">
                                        <div class="form-group"><label class="col-sm-2 control-label">特别说明:</label>
                                            <div class="col-sm-10">这里修改商品在经销商端的商品详情页面，一经上传，及同步至经销商端</div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">商品详情:</label>
                                            <div class="col-sm-10">
                                                <div id="summernote">${CommodityInfo.contentWeb}</div>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label"></label>
                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <button id="modifyCommodityDetailsEditSubmit" data-id="${GOOD_ID}" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">编辑</button>
                                                </div>
                                                <div class="col-sm-4">
                                                    <button id="modifyCommodityDetailsSaveSubmit" data-id="${GOOD_ID}" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">保存</button>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                </div>
                            </div>
                            <div id="tab-2" class="tab-pane">
                                <div class="panel-body">
                                    <fieldset class="form-horizontal">
                                        <div class="form-group"><label class="col-sm-2 control-label">商品名称:</label>
                                            <div class="col-sm-10">${CommodityInfo.title}</div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">(可留空，即保留原名):</label>
                                            <div class="col-sm-10"><input id="goodTitle" type="text" class="form-control" placeholder="填入需要修改商品的新名称" value=""></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">售后说明:</label>
                                            <div class="col-sm-10"><input id="goodAfterSale" type="text" class="form-control" placeholder="请输入售后说明" value="${CommodityInfo.afterSalesInstruction}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">种类:</label>
                                            <div class="col-sm-10"><input id="goodKindName" type="text" class="form-control" placeholder="请输入商品种类" value="${CommodityInfo.kindName}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">型号:</label>
                                            <div class="col-sm-10"><input id="goodModel" type="text" class="form-control" placeholder="请输入商品型号" value="${CommodityInfo.model}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">材质:</label>
                                            <div class="col-sm-10"><input id="goodMaterial" type="text" class="form-control" placeholder="请输入商品材质" value="${CommodityInfo.material}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">结构工艺:</label>
                                            <div class="col-sm-10"><input id="goodStructure" type="text" class="form-control" placeholder="请输入商品结构工艺" value="${CommodityInfo.structure}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">风格:</label>
                                            <div class="col-sm-10"><input id="goodStyle" type="text" class="form-control" placeholder="请输入商品风格" value="${CommodityInfo.gStyle}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">用途:</label>
                                            <div class="col-sm-10"><input id="goodUse" type="text" class="form-control" placeholder="请输入商品用途" value="${CommodityInfo.gUse}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">售卖方式:</label>
                                            <div class="col-sm-10"><input id="goodSaleMethod" type="text" class="form-control" placeholder="请输入商品售卖方式" value="${CommodityInfo.saleMethod}"></div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">库存单位:</label>
                                            <div class="col-sm-10">
                                                <select id="goodUnit" class="form-control">
                                                    <c:if test="${CommodityInfo.inventoryUnit.equals('件')}">
                                                        <option value="件" selected="selected">件</option>
                                                        <option value="匹">匹</option>
                                                        <option value="个">个</option>
                                                        <option value="张">张</option>
                                                    </c:if>
                                                    <c:if test="${CommodityInfo.inventoryUnit.equals('匹')}">
                                                        <option value="件">件</option>
                                                        <option value="匹" selected="selected">匹</option>
                                                        <option value="个">个</option>
                                                        <option value="张">张</option>
                                                    </c:if>
                                                    <c:if test="${CommodityInfo.inventoryUnit.equals('个')}">
                                                        <option value="件">件</option>
                                                        <option value="匹">匹</option>
                                                        <option value="个" selected="selected">个</option>
                                                        <option value="张">张</option>
                                                    </c:if>
                                                    <c:if test="${CommodityInfo.inventoryUnit.equals('张')}">
                                                        <option value="件">件</option>
                                                        <option value="匹">匹</option>
                                                        <option value="个">个</option>
                                                        <option value="张" selected="selected">张</option>
                                                    </c:if>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">是否上架:</label>
                                            <div class="col-sm-10">
                                                <select id="goodShelves" class="form-control">
                                                    <c:if test="${CommodityInfo.isShelves==1}">
                                                        <option value="1" selected="selected">是</option>
                                                        <option value="0">否</option>
                                                    </c:if>
                                                    <c:if test="${CommodityInfo.isShelves==0}">
                                                        <option value="1">是</option>
                                                        <option value="0" selected="selected">否</option>
                                                    </c:if>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group"><label class="col-sm-2 control-label">是否上首页推荐:</label>
                                            <div class="col-sm-10">
                                                <select id="goodHome" class="form-control">
                                                    <c:if test="${CommodityInfo.isHomeRecommended==1}">
                                                        <option value="1" selected="selected">是</option>
                                                        <option value="0">否</option>
                                                    </c:if>
                                                    <c:if test="${CommodityInfo.isHomeRecommended==0}">
                                                        <option value="1">是</option>
                                                        <option value="0" selected="selected">否</option>
                                                    </c:if>
                                                </select>
                                            </div>
                                        </div>
                                        <button id="modifyCommodityInfoSubmit" data-id="${GOOD_ID}" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">提交</button>
                                    </fieldset>
                                </div>
                            </div>
                            <div id="tab-3" class="tab-pane">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <c:if test="${CommodityInfo.images.equals(\" \")}">
                                                <div id="coverImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${!CommodityInfo.images.equals(\" \")}">
                                                <div id="coverImage" class="image-crop">
                                                    <img src="${CommodityInfo.images}">
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
                                                <button data-id="${GOOD_ID}" class="btn btn-primary"id="coverUpload" type="button" disabled="disabled">上传</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="tab-4" class="tab-pane">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <c:if test="${CommodityInfo.homeRecommendedImages.equals(\" \")}">
                                                <div id="recommendImage" class="image-crop">
                                                    <img src="<%=basePath%>/static/admin/img/link.gif">
                                                </div>
                                            </c:if>
                                            <c:if test="${!CommodityInfo.homeRecommendedImages.equals(\" \")}">
                                                <div id="recommendImage" class="image-crop">
                                                    <img src="${CommodityInfo.homeRecommendedImages}">
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
                                                <button data-id="${GOOD_ID}" class="btn btn-primary"id="recommendUpload" type="button" disabled="disabled">上传</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="tab-5" class="tab-pane">
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">添加商品</button>
                                        <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content animated bounceInRight">
                                                    <div class="modal-header">
                                                        <button id="addCloseButton" type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                                                        <i class="fa fa-laptop modal-icon"></i>
                                                        <h4 class="modal-title">添加商品属性</h4>
                                                        <small class="font-bold">添加商品信息时，请仔细核对内容信息，一经添加，将同步全系统数据库！</small>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-group"><label>商品尺寸</label> <input id="goodMeasure" type="text" placeholder="请输入商品尺寸" class="form-control" value=""></div>
                                                        <div class="form-group"><label>商品颜色</label> <input id="goodColor" type="text" placeholder="请输入商品颜色" class="form-control" value=""></div>
                                                        <div class="form-group"><label>库存</label> <input id="goodInventory" type="text" placeholder="请输入库存" class="form-control" value=""></div>
                                                        <div class="form-group"><label>出厂价</label> <input id="goodFactoryPrice" type="text" placeholder="请输入出厂价" class="form-control" value=""></div>
                                                        <div class="form-group"><label>原价</label> <input id="goodOriginPrice" type="text" placeholder="请输入原价" class="form-control" value=""></div>
                                                        <div class="form-group"><label>指导价</label> <input id="goodGuidePrice" type="text" placeholder="请输入指导价" class="form-control" value=""></div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button id="goodMeasureColorSubmit" data-id="${GOOD_ID}" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">提交</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <table class="table table-bordered table-stripped">
                                            <thead>
                                            <tr>
                                                <th>尺寸</th>
                                                <th>颜色</th>
                                                <th>库存</th>
                                                <th>出厂价(元)</th>
                                                <th>原价(元)</th>
                                                <th>指导价(元)</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody id="tableMeasureColor">
                                            <c:forEach items="${CommodityStandradList}" var="items">
                                                <tr id="mesaureColorTr${items.id}">
                                                    <td><input id="measure${items.id}" type="text" class="form-control" value="${items.measure}" name="measure"></td>
                                                    <td><input id="color${items.id}" type="text" class="form-control" value="${items.color}" name="color"></td>
                                                    <td><input class="inventory" id="inventory${items.id}" type="text" value="${items.inventory}" name="inventory"></td>
                                                    <td><input class="factoryPrice" id="factoryPrice${items.id}" type="text" value="${items.factoryPrice}" name="factoryPrice"></td>
                                                    <td><input class="originPrice" id="originPrice${items.id}" type="text" value="${items.originPrice}" name="originPrice"></td>
                                                    <td><input class="guidePrice" id="guidePrice${items.id}" type="text" value="${items.guidePrice}" name="guidePrice"></td>
                                                    <td>
                                                        <button data-id="${items.id}" class="btn btn-white measureColorDelete"><i class="fa fa-trash"></i> </button>
                                                        <button data-id="${items.id}" class="btn btn-white measureColorEdit"><i class="fa fa-edit"></i> </button>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div id="tab-6" class="tab-pane">
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <div class="row">
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>一级分类</label>
                                                    <select id="commodityCategoryFirst" class="form-control m-b" name="account">
                                                        <option value="">请选择一级分类</option>
                                                        <c:forEach items="${CommodityCategoryFirstList}" var="items">
                                                            <option value="${items.id}">${items.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <label>二级分类</label>
                                                    <select id="commodityCategorySecond" class="form-control m-b" name="account"></select>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <button data-id="${GOOD_ID}" id="addCommodityCatetory" type="button" class="btn btn-primary center-block">添加分类</button>
                                            </div>
                                        </div>
                                        <table class="table table-bordered table-stripped">
                                            <thead>
                                            <tr>
                                                <th>所属分类编号</th>
                                                <th>操作</th>
                                            </tr>
                                            </thead>
                                            <tbody id="tableCommodityCategory">
                                            <c:forEach items="${CommodityCategoryList}" var="items">
                                                <tr id="commodityCategoryTr${items.id}">
                                                    <td>${items.categoryId}</td>
                                                    <td>
                                                        <button data-id="${items.id}" class="btn btn-white commodityCategoryDelete"><i class="fa fa-trash"></i> </button>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="row">
                                        <p>特别说明</p>
                                    </div>
                                </div>
                            </div>
                            <div id="tab-7" class="tab-pane">
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#photoModal">添加商品</button>
                                        <div class="modal inmodal" id="photoModal" tabindex="-1" role="dialog" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content animated bounceInRight">
                                                    <div class="modal-header">
                                                        <button id="photoAddCloseButton" type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                                                        <i class="fa fa-laptop modal-icon"></i>
                                                        <h4 class="modal-title">添加商品图片</h4>
                                                        <small class="font-bold">添加商品图片时，请仔细核对内容信息，一经添加，将同步全系统数据库！</small>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-group"><label>商品图片排序</label> <input id="goodPhotoSort" type="text" placeholder="请输入商品图片排序(默认1)" class="form-control" value="1"></div>
                                                        <div class="btn-group">
                                                            <label title="Upload image file" for="goodPhotoInputImage" class="btn btn-primary">
                                                                <input type="file" accept="image/*" name="file" id="goodPhotoInputImage" class="hide">
                                                                选择图片
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button id="goodPhotoSubmit" data-id="${GOOD_ID}" type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b" disabled="disabled"  data-style="zoom-in">提交</button>
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
                                            <c:forEach items="${CommodityPhotoList}" var="items">
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
<script type="text/javascript" src="<%=basePath%>/pages/adminJs/commodityGoodDetails.js"></script>
</body>
</html>



