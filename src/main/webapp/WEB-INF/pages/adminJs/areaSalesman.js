"use struct"
$(document).ready(function(){
    $("#area").trigger("click");
    $("#areaSalesman").addClass("active");

    //**************************省市选择框
    $("#salesmanProvince").change(function () {
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
                $("#salesmanCity").html(html);
            },
            error: function(){}
        });
    });

    //**************************片区级联
    $("#salesmanArea").change(function () {
        $.ajax({
            method: "POST",
            url: "/Admin/Area/ListSalesmanByAreaId",
            dataType: "json",
            data: {"areaId" : $(this).val()},
            success: function (data) {
                var html = '<option value="0" selected="selected">请选择上级业务员,若为顶级业务员可不选</option>';
                for(i=0;i<data.flag.length;i++){
                    if(data.flag.pid == 0)
                        html += '<option value="'+data.flag[i].id+'">'+data.flag[i].uName+'(顶级业务员)</option>';
                    else
                        html += '<option value="'+data.flag[i].id+'">'+data.flag[i].uName+'</option>';
                }
                $("#salesmanPid").html(html);
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
            url: "/Admin/Area/SalesmanUserList",
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
                "data": "uName",
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
                "data": "pid",
                "class" : "text-center",
            },
            {
                "data": "idCard",
                "class" : "text-center",
            },
            {
                "data": "lowerCount",
                "class" : "text-center",
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
                "data" : "kind",
                "class" : "text-center",
                "render" : function(data, type, row) {
                    if(data==1){
                        return '经销商业务员';
                    }else if(data==2){
                        return '厂商业务员';
                    }else{
                        return '顶级业务员';
                    }
                    return "";
                },
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
                    return '<span class="btn btn-primary btn-xs ml-5 js-edit" data-id="'+data+'">编辑</span> <span class="btn btn-danger btn-xs ml-5 js-delete" data-id="'+data+'">删除</span>';
                },
            },
        ],
    });

    $('#editable').on('click','.js-delete',function(){
        var number =  $(this).attr('data-id');
        swal({
            title: "确定删除?",
            text: "你将永久性删除编号为 " + $(this).attr('data-id') + " 的业务员！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "继续删除",
            cancelButtonText: "取消",
            closeOnConfirm: false
        }, function () {
            $.ajax({
                method: "POST",
                url: "/Admin/Area/DeleteSalesman",
                dataType: "json",
                data: {"salesmanId" : number},
                success: function (data) {
                    if(data.flag == "1"){
                        swal({
                            title: "删除成功!",
                            text: "已经成功将编号为 " + number + " 的业务员移除！",
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
        window.location.href = "/Admin/Area/SalesmanDetails/" + number;
    });

    var infoSubmit = $('#addSalesmanInfo').ladda();
    infoSubmit.click(function () {
        var $salesmanName = $("#salesmanName").val();
        var $salesmanMobile = $("#salesmanMobile").val();
        var $salesmanIdCard = $("#salesmanIdCard").val();
        var $salesmanProvince = $("#salesmanProvince option:selected").html();
        var $salesmanCity = $("#salesmanCity option:selected").html();
        var $salesmanArea = $("#salesmanArea").val();
        var $salesmanPid = $("#salesmanPid").val();
        var $salesmanKind = $("#salesmanKind").val();
        var $salesmanStatus = $("#salesmanStatus").val();

        if($salesmanName == "" || $salesmanMobile == "" || $salesmanIdCard == "" || $salesmanProvince == "" || $salesmanCity == "" ||
            $salesmanArea == "0"){
            swal({
                title: "警告！",
                text: "输入项各项不能为空",
                type: "warning",
                confirmButtonText: "确定",
            });
        }else if($salesmanMobile.length != 11){
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
                url: "/Admin/Area/AddSalesman",
                dataType: "json",
                data: {"name": $salesmanName, "mobile":$salesmanMobile, "idCard":$salesmanIdCard, "province":$salesmanProvince,
                    "city":$salesmanCity, "areaId":$salesmanArea, "pid":$salesmanPid, "kind":$salesmanKind, "status":$salesmanStatus},
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
                            text: "已为您同步至业务员信息列表，初始化密码为：123456",
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