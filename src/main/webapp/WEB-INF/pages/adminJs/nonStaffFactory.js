"use struct"
$(document).ready(function(){
    $("#nonStaff").trigger("click");
    $("#nonStaffFactoryRecord").addClass("active");

    //**************************省市选择框
    $("#factoryProvince").change(function () {
        $.ajax({
            method: "POST",
            url: "/Admin/Area/ListCity",
            dataType: "json",
            data: {"pid" : $(this).val()},
            success: function (data) {
                var html = '<option value="0" selected="selected">请选择市</option>';
                for(i=0;i<data.flag.length;i++){
                    html += '<option value="'+data.flag[i].id+'">'+data.flag[i].name+'</option>';
                }
                $("#factoryCity").html(html);
            },
            error: function(){}
        });
    });

    //**************************片区级联
    $("#factoryArea").change(function () {
        $.ajax({
            method: "POST",
            url: "/Admin/Area/ListSalesmanByAreaIdKind",
            dataType: "json",
            data: {"kind":"2", "areaId":$(this).val()},
            success: function (data) {
                var html = '<option value="0" selected="selected">请选择上级业务员,可不选</option>';
                for(i=0;i<data.flag.length;i++){
                    if(data.flag.pid == 0)
                        html += '<option value="'+data.flag[i].id+'">'+data.flag[i].uName+'(顶级业务员)</option>';
                    else
                        html += '<option value="'+data.flag[i].id+'">'+data.flag[i].uName+'</option>';
                }
                $("#factoryPid").html(html);
            },
            error: function(){}
        });
    });

    //*********************列表
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
            url: "/Admin/NonStaff/FactoryUserList",
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
                "data": "name",
                "class": "text-center",
            },
            {
                "data": "mobile",
                "class" : "text-center",
            },
            {
                "data": "areaId",
                "class" : "text-center",
            },
            {
                "data" : "salesmanId",
                "class" : "text-center",
                "render" : function(data, type, row) {
                    if(data==0){
                        return '无所属业务员</i>';
                    }else if(data==1){
                        return data;
                    }
                    return "";
                },
            },
            {
                "data" : "province",
                "class" : "text-center",
            },
            {
                "data" : "city",
                "class" : "text-center",
            },
            {
                "data" : "orderCount",
                "class" : "text-center",
            },
            {
                "data" : "sellCount",
                "class" : "text-center",
            },
            {
                "data" : "status",
                "class" : "text-center",
                "render" : function(data, type, row) {
                    if(data==0){
                        return '禁止登陆<i class="fa fa-times text-navy"></i>';
                    }else if(data==1){
                        return '正常<i class="fa fa-check text-navy"></i>';
                    }
                    return "";
                },
            },
            {
                "data" : "id",
                "class" : "text-center",
                "render" : function(data, type, row) {
                    return '<span class="btn btn-primary btn-xs ml-5 js-edit" data-id="'+data+'">详情</span> <span class="btn btn-danger btn-xs ml-5 js-delete" data-id="'+data+'">删除</span>';
                },
            },
        ],
    });

    $('#editable').on('click','.js-delete',function(){
        var number =  $(this).attr('data-id');
        swal({
            title: "确定删除?",
            text: "你将永久性删除编号为 " + $(this).attr('data-id') + " 的厂商！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "继续删除",
            cancelButtonText: "取消",
            closeOnConfirm: false
        }, function () {
            $.ajax({
                method: "POST",
                url: "/Admin/NonStaff/DeleteFactoryUser",
                dataType: "json",
                data: {"salesmanId" : number},
                success: function (data) {
                    if(data.flag == "1"){
                        swal({
                            title: "删除成功!",
                            text: "已经成功将编号为 " + number + " 的厂商移除！",
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
        window.location.href = "/Admin/NonStaff/FactoryUserDetails/" + number;
    });

    var infoSubmit = $('#addUserInfo').ladda();
    infoSubmit.click(function () {
        var $factoryName = $("#factoryName").val();
        var $factoryMobile = $("#factoryMobile").val();
        var $factoryEmail = $("#factoryEmail").val();
        var $factoryAdress = $("#factoryAdress").val();
        var $factoryProvince = $("#factoryProvince option:selected").html();
        var $factoryCity = $("#factoryCity option:selected").html();
        var $factoryArea = $("#factoryArea").val();
        var $factoryPid = $("#factoryPid").val();
        var $factoryStatus = $("#factoryStatus").val();

        if($factoryName == "" || $factoryMobile == "" ||
            $factoryProvince == "" || $factoryCity == "" || $factoryArea == "0"){
            swal({
                title: "警告！",
                text: "输入项各项不能为空",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else if($factoryMobile.length != 11){
            swal({
                title: "警告！",
                text: "手机号必须为11位",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else{
            infoSubmit.ladda( 'start' );
            $.ajax({
                method: "POST",
                url: "/Admin/NonStaff/AddFactoryUser",
                dataType: "json",
                data: {"name": $factoryName, "mobile":$factoryMobile, "email":$factoryEmail, "address":$factoryAdress,
                    "province":$factoryProvince, "city":$factoryCity, "areaId":$factoryArea, "pid":$factoryPid, "status":$factoryStatus},
                success: function (data) {
                    infoSubmit.ladda( 'stop' );
                    if(data.flag != "1"){
                        swal({
                            title: "添加失败！",
                            text: data.error,
                            type: "error",
                            confirmButtonText: "确定",
                        });
                    }else{
                        swal({
                            title: "添加成功！",
                            text: "已为您同步至厂商信息列表，初始化密码为：123456",
                            type: "success",
                            confirmButtonText: "确定",
                        },function () {
                            window.location.reload();
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