"use struct"
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
            url: "/Admin/Commodity/CommodityList",
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
                        return '已下架<i class="fa fa-times text-navy"></i>';
                    }else if(data==1){
                        return '上架中<i class="fa fa-check text-navy"></i>';
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
                url: "/Admin/Commodity/DeleteCommodity",
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
        var number =  $(this).attr('data-id');
        window.location.href = "/Admin/Commodity/GoodDetails/" + number;
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
                url: "/Admin/Commodity/AddCommodity",
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