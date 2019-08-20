<%--
  Created by IntelliJ IDEA.
  User: Power
  Date: 2019/8/17
  Time: 21:28
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
    <title>丽星平台 | 商品档案</title>
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
                <h2>商品档案</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="<%=basePath%>/Admin/Summary/Profile">首页</a>
                    </li>
                    <li>
                        <a>商品</a>
                    </li>
                    <li class="active">
                        <strong>商品档案</strong>
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
                            <h5>商品信息总览</h5>
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
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">添加商品</button>
                                <a onclick="fnClickAddRow();" href="javascript:void(0);" class="btn btn-success ">下载模板</a>
                                <a onclick="fnClickAddRow();" href="javascript:void(0);" class="btn btn-warning ">批量操作</a>
                            </div>
                            <div class="modal inmodal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content animated bounceInRight">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                                            <i class="fa fa-laptop modal-icon"></i>
                                            <h4 class="modal-title">添加商品</h4>
                                            <small class="font-bold">添加商品信息时，请仔细核对内容信息，一经添加，将同步全系统数据库！</small>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group"><label>商品名称</label> <input id="goodTitle" type="text" placeholder="请输入商品名称" class="form-control" value=""></div>
                                            <div class="form-group"><label>售后说明</label> <input id="goodAfterSale" type="text" placeholder="请输入售后说明" class="form-control" value=""></div>
                                            <div class="form-group"><label>种类</label> <input id="goodKindName" type="text" placeholder="请输入种类" class="form-control" value=""></div>
                                            <div class="form-group"><label>型号</label> <input id="goodModel" type="text" placeholder="请输入型号" class="form-control" value=""></div>
                                            <div class="form-group"><label>材质</label> <input id="goodMaterial" type="text" placeholder="请输入材质" class="form-control" value=""></div>
                                            <div class="form-group"><label>结构工艺</label> <input id="goodStructure" type="text" placeholder="请输入结构工艺" class="form-control" value=""></div>
                                            <div class="form-group"><label>风格</label> <input id="goodStyle" type="text" placeholder="请输入风格" class="form-control" value=""></div>
                                            <div class="form-group"><label>用途</label> <input id="goodUse" type="text" placeholder="请输入用途" class="form-control" value=""></div>
                                            <div class="form-group"><label>售卖方式</label> <input id="goodSaleMethod" type="text" placeholder="请输入售卖方式" class="form-control" value=""></div>
                                            <div class="form-group">
                                                <label>库存单位</label>
                                                <select id="goodUnit" class="form-control m-b" name="account">
                                                    <option value="件" selected="selected">件</option>
                                                    <option value="匹">匹</option>
                                                    <option value="个">个</option>
                                                    <option value="">张</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>是否上架</label>
                                                <select id="goodShelves" class="form-control m-b" name="account">
                                                    <option value="1" selected="selected">是</option>
                                                    <option value="0">否</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>是否上首页推荐</label>
                                                <select id="goodHome" class="form-control m-b" name="account">
                                                    <option value="1" selected="selected">是</option>
                                                    <option value="0">否</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="ladda-button ladda-button-demo btn btn-primary block full-width m-b"  data-style="zoom-in">提交</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <table class="table table-striped table-bordered table-hover " id="editable">
                                <thead>
                                <tr>
                                    <th>商品名称</th>
                                    <th>种类</th>
                                    <th>型号</th>
                                    <th>材质</th>
                                    <th>结构工艺</th>
                                    <th>风格</th>
                                    <th>用途</th>
                                    <th>售卖方式</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>商品名称</th>
                                    <th>种类</th>
                                    <th>型号</th>
                                    <th>材质</th>
                                    <th>结构工艺</th>
                                    <th>风格</th>
                                    <th>用途</th>
                                    <th>售卖方式</th>
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

<script>
    $(document).ready(function(){
        $("#commodity").trigger("click");
        $("#commodityRecord").addClass("active");

        /* Init DataTables */
        var oTable = $('#editable').DataTable({
            dom: '<"html5buttons"B>lTfgitp',
            buttons: [
                {extend: 'copy',
                    text: '复制',
                },
                {extend: 'csv',
                    text: '下载CSV',
                    title: '商品档案'},
                {extend: 'excel',
                    title: '商品档案',
                    text: '下载Excel'},
                {extend: 'pdf',
                    title: '商品档案',
                    text: '下载PDF'
                },
                {extend: 'print',
                    customize: function (win){
                        $(win.document.body).addClass('white-bg');
                        $(win.document.body).css('font-size', '10px');

                        $(win.document.body).find('table')
                            .addClass('compact')
                            .css('font-size', 'inherit');
                    }
                },
            ],
            ajax: {
                url: "<%=basePath%>/Admin/Commodity/CommodityList",
                method: "POST",
                dataType: "json",
                data: {},
            },
            deferRender: true,
            language : {
                processing : "载入中",//处理页面数据的时候的显示
                paginate : {//分页的样式文本内容。
                    previous : "上一页",
                    next : "下一页",
                    first : "第一页",
                    last : "最后一页"
                },
                search: "搜索",
                zeroRecords : "没有内容",//table tbody内容为空时，tbody的内容。
                //下面三者构成了总体的左下角的内容。
                info : "第 _PAGE_/_PAGES_页 共 _TOTAL_条记录",//左下角的信息显示，大写的词为关键字。
                infoEmpty : "第 _PAGE_/_PAGES_页 共 _TOTAL_条记录",//筛选为空时左下角的显示。
                infoFiltered : "",//筛选之后的左下角筛选提示(另一个是分页信息显示，在上面的info中已经设置，所以可以不显示)，
            },
            columns: [
                {
                    "data": "title",
                    "class": "text-center",
                },
                {
                    "data": "kindName",
                    "class" : "text-center",
                },
                {
                    "data": "model",
                    "class" : "text-center",
                },
                {
                    "data": "material",
                    "class" : "text-center",
                },
                {
                    "data": "structure",
                    "class" : "text-center",
                },
                {
                    "data": "gStyle",
                    "class" : "text-center",
                },
                {
                    "data" : "gUse",
                    "class" : "text-center",
                },
                {
                    "data" : "saleMethod",
                    "class" : "text-center",
                },
                {
                    "data" : "isShelves",
                    "class" : "text-center",
                    "render" : function(data, type, row) {
                        if(data==0){
                            return '已下架<i class="fa fa-check text-navy"></i>';
                        }else if(data==1){
                            return '上架中<i class="fa fa-times text-navy"></i>';
                        }
                        return "";
                    },
                },
                {
                    "data" : "id",
                    "class" : "text-center",
                    "render" : function(data, type, row) {
                        return '<span class="btn btn-primary btn-xs ml-5 js-edit" data-id="'+data+'">编辑</span> <span class="btn btn-danger btn-xs ml-5 js-delete" data-id="'+data+'">删除</span>';
                    },
                },
            ],
        });

        $('#editable').on('click','.js-delete',function(){
            var number =  $(this).attr('data-id');
            swal({
                title: "确定删除?",
                text: "你将永久性删除编码为 " + $(this).attr('data-id') + " 的商品！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "继续删除",
                cancelButtonText: "取消",
                closeOnConfirm: false
            }, function () {
                $.ajax({
                    method: "POST",
                    url: "<%=basePath%>/Admin/Commodity/DeleteCommodity",
                    dataType: "json",
                    data: {"id" : number},
                    success: function (data) {
                        if(data.flag == "1"){
                            swal({
                                title: "删除成功!",
                                text: "已经成功将编码为 " + number + " 的商品移除！",
                                type: "success",
                                confirmButtonText: "确定",
                            },function(){window.location.reload();});
                        }else{
                            swal({
                                title: "删除失败!",
                                text: "请重新刷新进行重试!",
                                type: "error",
                                confirmButtonText: "确定",
                            },function(){});
                        }
                    },
                    error: function(){
                        swal({
                            title: "出现错误!",
                            text: "网络参数出现错误!",
                            type: "error",
                            confirmButtonText: "确定",
                        },function(){});
                    }
                });
            });
        }).on('click','.js-edit',function(){
            /*var id = $(this).attr('data-id');
            location.href = '/edit?id='+id+'';*/
            $("#modify").click();
        });

        var infoSubmit = $( '.ladda-button-demo' ).ladda();
        infoSubmit.click(function () {
            var $goodTile = $("#goodTitle").val();
            var $goodAfterSale = $("#goodAfterSale").val();
            var $goodKindName = $("#goodKindName").val();
            var $goodModel = $("#goodModel").val();
            var $goodMaterial = $("#goodMaterial").val();
            var $goodStruct = $("#goodStructure").val();
            var $goodStyle = $("#goodStyle").val();
            var $goodUse = $("#goodUse").val();
            var $goodSaleMethod = $("#goodSaleMethod").val();
            var $goodUnit = $("#goodUnit").val();
            var $goodShelves = $("#goodShelves").val();
            var $goodHome = $("#goodHome").val();

            if($goodTile == "" || $goodAfterSale == "" || $goodKindName == "" || $goodModel == "" || $goodMaterial == "" ||
                $goodStruct == "" || $goodStyle =="" || $goodUse == "" || $goodSaleMethod == ""){
                swal({
                    title: "警告！",
                    text: "输入项各项不能为空",
                    type: "warning",
                    confirmButtonText: "确定",
                });
            }else{
                infoSubmit.ladda( 'start' );
                $.ajax({
                    method: "POST",
                    url: "<%=basePath%>/Admin/Commodity/AddCommodity",
                    dataType: "json",
                    data: {"title": $goodTile, "afterSale":$goodAfterSale, "kindName":$goodKindName, "model":$goodModel,
                    "material":$goodMaterial, "struct":$goodStruct, "style":$goodStyle, "use":$goodUse, "saleMethod":$goodSaleMethod,
                    "unit":$goodUnit, "shelves":$goodShelves, "home":$goodHome},
                    success: function (data) {
                        infoSubmit.ladda( 'stop' );
                        if(data.flag != "1"){
                            swal({
                                title: "添加失败！",
                                text: "商品名称已存在",
                                type: "error",
                                confirmButtonText: "确定",
                            });
                        }else{
                            swal({
                                title: "添加成功！",
                                text: "已为您同步至商品信息列表",
                                type: "success",
                                confirmButtonText: "确定",
                            },function () {
                                window.location.reload();
                                /*$('#editable').dataTable().fnAddData( [
                                    $goodTile,
                                    $goodKindName,
                                    $goodModel,
                                    $goodMaterial,
                                    $goodStruct,
                                    $goodStyle,
                                    $goodUse,
                                    $goodSaleMethod,
                                    data.shelves,
                                    '<span class="btn btn-primary btn-xs ml-5 js-edit" data-id="'+data.id+'">编辑</span> <span class="btn btn-danger btn-xs ml-5 js-delete" data-id="'+data.id+'">删除</span>',
                                ] );*/
                            });
                        }
                    },
                    error:function () {
                        swal({
                            title: "出现错误!",
                            text: "网络参数出现错误!",
                            type: "error",
                            confirmButtonText: "确定",
                        },function(){});
                    }
                });
            }
        });

    });

    function fnClickAddRow() {
        $('#editable').dataTable().fnAddData( [
            "Custom row",
            "New row",
            "New row",
            "New row",
            "New row" ] );

    }
</script>
</body>
</html>
