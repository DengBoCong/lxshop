<%--
  Created by IntelliJ IDEA.
  User: Power
  Date: 2019/8/20
  Time: 22:11
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
    <title>丽星平台 | 商品分类</title>
    <link href="<%=basePath%>/static/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/static/admin/css/plugins/ladda/ladda-themeless.min.css" rel="stylesheet">
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
                <h2>商品分类</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="<%=basePath%>/Admin/Summary/Profile">首页</a>
                    </li>
                    <li>
                        <a>商品</a>
                    </li>
                    <li class="active">
                        <strong>商品分类</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>
        <div class="wrapper wrapper-content  animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>商品分类列表</h5>
                            <button type="button" id="add" class="pull-right btn btn-info btn-xs mt-5"  data-toggle="modal" data-target="#myModal5"><i class="fa fa-plus"></i>   新增大类</button>
                            <button style="display: none;" type="button" id="new" class="pull-right btn btn-info btn-xs mt-5"  data-toggle="modal" data-target="#myModal6"></button>
                            <button style="display: none;" type="button" id="edit" class="pull-right btn btn-info btn-xs mt-5"  data-toggle="modal" data-target="#myModal7"></button>
                        </div>
                        <div class="ibox-content">
                            <div class="dd" id="nestable2">
                                <ol class="dd-list">
                                    <c:forEach items="${CommodityClassFirst}" var="item">
                                        <li class="dd-item" data-id="${item.id}">
                                            <div class="dd-handle">
                                                <span class="pull-right btn btn-danger btn-xs ml-5 js-delete" data-id="${item.id}"><i class="fa fa-prescription-bottle"></i>   删除</span><span class="pull-right btn btn-primary btn-xs ml-5 js-edit" data-id="${item.id}" data-name="${item.name}" data-sort="${item.sort}" data-isHome="${item.isHomeRecommended}"><i class="fa fa-edit"></i>   编辑</span><span class="pull-right btn btn-primary btn-xs ml-5 js-add" data-id="${item.id}" data-name="${item.name}"><i class="fa fa-plus"></i>   增加子类</span>
                                                <span class="label label-info"><i class="fa fa-folder"></i></span> ${item.name}
                                            </div>
                                            <ol class="dd-list">
                                                <c:forEach items="${CommodityClassSecond}" var="Sitem">
                                                    <c:if test="${Sitem.pid == item.id}">
                                                        <li class="dd-item" data-id="${Sitem.id}">
                                                            <div class="dd-handle">
                                                                <span class="pull-right btn btn-danger btn-xs ml-5 js-delete" data-id="${Sitem.id}"><i class="fa fa-prescription-bottle"></i>   删除</span><span class="pull-right btn btn-primary btn-xs ml-5 js-edit" data-id="${Sitem.id}" data-name="${Sitem.name}" data-sort="${Sitem.sort}" data-isHome="${Sitem.isHomeRecommended}"><i class="fa fa-edit"></i>   编辑</span>
                                                                <span class="label label-info"><i class="fa fa-folder"></i></span> ${Sitem.name}
                                                            </div>
                                                        </li>
                                                    </c:if>
                                                </c:forEach>
                                            </ol>
                                        </li>
                                    </c:forEach>
                                </ol>
                            </div>
                            <div class="modal inmodal fade" id="myModal5" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                                            <h4 class="modal-title">增加大类标签</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form role="form">
                                                <div class="form-group"><input id="FirstName" type="text" placeholder="输入大类标签名称" class="form-control" value=""></div>
                                                <div class="form-group"><input id="FirstSort" type="text" placeholder="输入大类标签排序号" class="form-control" value="1"></div>
                                                <div class="form-group">
                                                    <label>是否上首页推荐</label>
                                                    <select id="isHome" class="form-control m-b" name="account">
                                                        <option value="1" selected="selected">是</option>
                                                        <option value="0">否</option>
                                                    </select>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                                            <button id="submitModify" type="button" class="btn btn-primary">提交</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal inmodal fade" id="myModal6" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <h4 class="modal-title" id="newSubLabel"></h4>
                                        </div>
                                        <div class="modal-body">
                                            <form role="form">
                                                <div class="form-group"><input id="SecondName" type="text" placeholder="输入子类标签名称" class="form-control" value=""></div>
                                                <div class="form-group"><input id="SecondSort" type="text" placeholder="输入子类标签排序号" class="form-control" value="1"></div>
                                                <div class="form-group">
                                                    <label>是否上首页推荐</label>
                                                    <select id="isHomeSecond" class="form-control m-b" name="account">
                                                        <option value="1" selected="selected">是</option>
                                                        <option value="0">否</option>
                                                    </select>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                                            <button id="SecondAdd" type="button" class="btn btn-primary">提交</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal inmodal fade" id="myModal7" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <h4 id="titleModify" class="modal-title"></h4>
                                        </div>
                                        <div class="modal-body">
                                            <form role="form">
                                                <div class="form-group"><input id="editLabel" type="text" placeholder="输入标签名称" class="form-control" value=""></div>
                                                <div class="form-group"><input id="editLabelSort" type="text" placeholder="输入标签排序" class="form-control" value=""></div>
                                                <div class="form-group">
                                                    <label>是否上首页推荐</label>
                                                    <select id="editLabelIsHome" class="form-control m-b" name="account">
                                                        <option value="1" selected="selected">是</option>
                                                        <option value="0">否</option>
                                                    </select>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                                            <button id="modifySecond" type="button" class="btn btn-primary">提交</button>
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

<script src="<%=basePath%>/static/admin/js/plugins/nestable/jquery.nestable.js"></script>

<script src="<%=basePath%>/static/admin/js/inspinia.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/pace/pace.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/spin.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/ladda.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/ladda/ladda.jquery.min.js"></script>
<script src="<%=basePath%>/static/admin/js/plugins/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/pages/adminJs/commodityClassify.js"></script>
</body>
</html>
