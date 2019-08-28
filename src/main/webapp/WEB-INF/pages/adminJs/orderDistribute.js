"use struct"
$(document).ready(function(){
    $("#order").trigger("click");
    $("#orderDistribute").addClass("active");

    /* Init DataTables */
    var oTable = $('#editable').DataTable({
        dom: '<"html5buttons"B>lTfgitp',
        buttons: [
            {extend: 'copy',
                text: '复制',
            },
            {extend: 'csv',
                text: '下载CSV',
                title: '订单档案'},
            {extend: 'excel',
                title: '订单档案',
                text: '下载Excel'},
            {extend: 'pdf',
                title: '订单档案',
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
            url: "/Admin/Order/OrderDistributeList",
            method: "POST",
            dataType: "json",
            data: {"status":"2"},
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
                "data": "orderNo",
                "class": "text-center",
            },
            {
                "data" : "userId",
                "class" : "text-center",
                "render" : function(data, type, row) {
                    return '<span class="btn btn-primary btn-xs ml-5 js-user-id" data-id="'+data+'">查看买家</span>';
                },
            },
            {
                "data": "receiveName",
                "class" : "text-center",
            },
            {
                "data": "receiveTel",
                "class" : "text-center",
            },
            {
                "data": "receiveAddress",
                "class" : "text-center",
            },
            {
                "data" : "totalPrice",
                "class" : "text-center",
            },
            {
                "data" : "status",
                "class" : "text-center",
                "render" : function(data, type, row) {
                    if(data==0){
                        return '待确认';
                    }else if(data==1){
                        return '待支付';
                    }else if(data==2){
                        return '待派单';
                    }else if(data==3){
                        return '待接单';
                    }else if(data==4){
                        return '待发货';
                    }else if(data==5){
                        return '待收货';
                    }else if(data==6){
                        return '已收货';
                    }else if(data==7){
                        return '已取消';
                    }else if(data==8){
                        return '已关闭';
                    }
                    return "";
                },
            },
            {
                "data" : "payStatus",
                "class" : "text-center",
                "render" : function(data, type, row) {
                    if(data==0){
                        return '未支付';
                    }else if(data==1){
                        return '已支付';
                    }else if(data==2){
                        return '已退款';
                    }
                    return "";
                },
            },
            {
                "data" : "id",
                "class" : "text-center",
                "render" : function(data, type, row) {
                    return '<span class="btn btn-primary btn-xs ml-5 js-goodsList" data-id="'+data+'">货物</span><span class="btn btn-primary btn-xs ml-5 js-edit" data-id="'+data+'">派单</span>';
                },
            },
        ],
    });

    $('#editable').on('click','.js-edit',function(){
        var number =  $(this).attr('data-id');
        swal({
            title: "请填入厂商编码",
            type: "prompt",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "继续删除",
            cancelButtonText: "取消",
            closeOnConfirm: false
        }, function (data) {
            $.ajax({
                method: "POST",
                url: "/Admin/Commodity/DeleteCommodity",
                dataType: "json",
                data: {"id" : number, "factoryId": data},
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
    }).on('click','.js-goodsList',function(){

    });


    $('.footable').footable({

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